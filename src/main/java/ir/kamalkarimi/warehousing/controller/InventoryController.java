package ir.kamalkarimi.warehousing.controller;

import ir.kamalkarimi.warehousing.dto.*;
import ir.kamalkarimi.warehousing.exception.BaseException;
import ir.kamalkarimi.warehousing.service.AjaxService;
import ir.kamalkarimi.warehousing.service.InventoryFacade;
import ir.kamalkarimi.warehousing.service.ProductService;
import ir.kamalkarimi.warehousing.service.RedirectService;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import ir.kamalkarimi.warehousing.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class InventoryController extends BaseController {

    private final InventoryFacade inventoryFacade;
    private final ProductService productService;
    private final AjaxService ajaxService;
    private final BaseUtil baseUti;
    private final FileUtil fileUtil;
    private final RedirectService redirectService;

    @Autowired
    public InventoryController(InventoryFacade inventoryFacade, ProductService productService, AjaxService ajaxService,
                               BaseUtil baseUti, FileUtil fileUtil, RedirectService redirectService) {
        this.inventoryFacade = inventoryFacade;
        this.productService = productService;
        this.ajaxService = ajaxService;
        this.baseUti = baseUti;
        this.fileUtil = fileUtil;
        this.redirectService = redirectService;
    }

    @GetMapping(value = {"/inventory"})
    public String homePage(HttpServletRequest request, HttpServletResponse response, Model model) {
        super.initializer(request, response);
        List<ProductTO> productTOS = productService.findAll();

        if (baseUti.isNull(productTOS)) {
            model.addAttribute(AjaxService.STATUS, HttpStatus.NOT_FOUND.name());
            model.addAttribute(AjaxService.MESSAGE, "Not fount any products");
            model.addAttribute(AjaxService.RESULT, null);
        } else {
            List<InventoryTO> inventoryTOS = new ArrayList<>();
            for (ProductTO productTO : productTOS) {
                if (baseUti.isNull(productTO))
                    continue;
                inventoryTOS.add(inventoryFacade.productInventory(productTO));
            }
            model.addAttribute(AjaxService.STATUS, HttpStatus.OK.name());
            model.addAttribute(AjaxService.MESSAGE, null);
            model.addAttribute(AjaxService.RESULT, inventoryTOS);
        }
        return RedirectService.INVENTORY_PAGE;
    }

    @PostMapping(value = {"/inventory"})
    public String uploadProduct(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam("file") MultipartFile file, Model model) {
        super.initializer(request, response);
        if (file.isEmpty()) {
            model.addAttribute(AjaxService.STATUS, HttpStatus.NOT_FOUND.name());
            model.addAttribute(AjaxService.MESSAGE, "File is empty");
            model.addAttribute(AjaxService.RESULT, null);
        } else {
            String fileName = file.getOriginalFilename();
            if (StringUtils.hasLength(fileName) &&
                    fileName.equalsIgnoreCase("products.json")) {
                try {
                    fileUtil.uploadFile(file);
                    model.addAttribute(AjaxService.STATUS, HttpStatus.OK.name());
                    model.addAttribute(AjaxService.MESSAGE, "Finished uploading file " + fileName);
                    model.addAttribute(AjaxService.RESULT, null);
                } catch (BaseException exception) {
                    model.addAttribute(AjaxService.STATUS, HttpStatus.BAD_REQUEST.name());
                    model.addAttribute(AjaxService.MESSAGE, exception.getMessage());
                    model.addAttribute(AjaxService.RESULT, null);
                }
            } else {
                model.addAttribute(AjaxService.STATUS, HttpStatus.BAD_REQUEST.name());
                model.addAttribute(AjaxService.MESSAGE, "File name should be products !");
                model.addAttribute(AjaxService.RESULT, null);
            }
        }

        return RedirectService.INVENTORY_PAGE;
    }

    @ResponseBody
    @GetMapping("/inventory/loadingproducts")
    public String loadingProducts(HttpServletRequest request, HttpServletResponse response) {
        super.initializer(request, response);
        ReceivedProductsTO productsTOS = fileUtil.readFile("products", ReceivedProductsTO.class);

        if (baseUti.isNull(productsTOS)) {
            message.put(AjaxService.STATUS, HttpStatus.NOT_FOUND);
            message.put(AjaxService.RESULT, "Not found inventory.json file !");
        } else {
            List<ProductsTO> productsTOList = Arrays.asList(productsTOS.getProducts());
            if (baseUti.isNull(productsTOList)) {
                message.put(AjaxService.STATUS, HttpStatus.NOT_FOUND);
                message.put(AjaxService.RESULT, "Not found products.json file !");
            } else {
                Set<ProductTO> productTOS = inventoryFacade.loadingProduct(productsTOList);

                message.put(AjaxService.STATUS, HttpStatus.OK);
                message.put(AjaxService.RESULT, productTOS);
            }
        }
        return ajaxService.toJson(message);
    }

    @ResponseBody
    @PostMapping(value = "/inventory/buy")
    public String buy(HttpServletRequest request,HttpServletResponse response){
        super.initializer(request,response);

        String productName = request.getParameter("productName");
        String orderCount  = request.getParameter("orderCount");

        productName = productName == null ? "":productName.trim();
        orderCount  = orderCount  == null ? "":orderCount.trim();

        message.clear();

        if (!StringUtils.hasLength(productName) || !StringUtils.hasLength(orderCount)){
            message.put(AjaxService.STATUS,HttpStatus.BAD_REQUEST);
            message.put(AjaxService.RESULT,"Product name and number of order can not empty!");
        }else{
            InventoryTO inventoryTO = inventoryFacade.buy(productName,orderCount);
            message.put(AjaxService.STATUS,HttpStatus.OK);
            message.put(AjaxService.RESULT,inventoryTO);
        }

        return ajaxService.toJson(message);
    }


}
