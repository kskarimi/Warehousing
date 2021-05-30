package ir.kamalkarimi.warehousing.controller;

import ir.kamalkarimi.warehousing.exception.BaseException;
import ir.kamalkarimi.warehousing.service.RedirectService;
import ir.kamalkarimi.warehousing.util.FileUtil;
import ir.kamalkarimi.warehousing.service.InventoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class InventoryController extends BaseController {

    private final InventoryFacade inventoryFacade;
    private final FileUtil fileUtil;
    private final RedirectService redirectService;

    @Autowired
    public InventoryController(InventoryFacade inventoryFacade, FileUtil fileUtil, RedirectService redirectService) {
        this.inventoryFacade = inventoryFacade;
        this.fileUtil = fileUtil;
        this.redirectService = redirectService;
    }

    @GetMapping("/")
    public String homePage(HttpServletRequest request,HttpServletResponse response, RedirectAttributes attributes){
        super.initializer(request,response,attributes);
        return RedirectService.HOME_PAGE;
    }

    @GetMapping(value = "/product")
    public String productPage(HttpServletRequest request,HttpServletResponse response, RedirectAttributes attributes){
        super.initializer(request,response,attributes);
        return RedirectService.PRODUCT_PAGE;
    }

    @GetMapping(value = "/inventory")
    public String inventoryPage(HttpServletRequest request,HttpServletResponse response, RedirectAttributes attributes){
        super.initializer(request,response,attributes);
        return RedirectService.INVENTORY_PAGE;
    }


    @PostMapping(value = "/upload")
    public String uploadFile(HttpServletRequest request, HttpServletResponse response,
                             @RequestParam("file") MultipartFile file,@RequestParam("fileType") String fileType,
                             RedirectAttributes attributes){
        super.initializer(request,response,attributes);
        try {
            if (file.isEmpty()){
                attributes.addFlashAttribute(RedirectService.ERROR,"Please select a file.");
            }
            if (StringUtils.hasLength(fileType)){
                if (fileType.equals("product") || fileType.equals("inventory")){
                    fileUtil.uploadFile(file);
                }
            }
        } catch (BaseException baseException) {
            attributes.addFlashAttribute(RedirectService.MESSAGE,"Failed upload "+fileUtil.getFileName(file));
        }

        String message = null;
        if (StringUtils.hasLength(fileType)){
            message = "You successfully upload "+ fileUtil.getFileName(file);
            if (fileType.equals("product")){
                attributes.addFlashAttribute(RedirectService.MESSAGE,message);
                return redirectService.redirectTo(RedirectService.PRODUCT_PAGE);
            }else if (fileType.equals("inventory")){
                attributes.addFlashAttribute(RedirectService.MESSAGE,message);
                return redirectService.redirectTo(RedirectService.INVENTORY_PAGE);
            }
        }
        attributes.addFlashAttribute(RedirectService.MESSAGE,message);
        return redirectService.redirectTo(redirectService.getReferer(this.getReferer()));
    }
}
