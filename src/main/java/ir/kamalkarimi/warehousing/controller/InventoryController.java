package ir.kamalkarimi.warehousing.controller;

import ir.kamalkarimi.warehousing.exception.BaseException;
import ir.kamalkarimi.warehousing.util.FileService;
import ir.kamalkarimi.warehousing.service.InventoryFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class InventoryController extends BaseController {

    private final InventoryFacade inventoryFacade;
    private final FileService fileService;

    @Autowired
    public InventoryController(InventoryFacade inventoryFacade, FileService fileService) {
        this.inventoryFacade = inventoryFacade;
        this.fileService = fileService;
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String handleFileUpload(HttpServletRequest request, HttpServletResponse response, ModelMap map, MultipartFile file){
        super.initializer(request,response,map);
        try {
            String filename = request.getParameter("filename");
            fileService.upload(file,filename);
        } catch (BaseException e) {
            System.out.println(e.getMessage());
        }
        return "ok";
    }

    @ResponseBody
    @RequestMapping(value = "/products",method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    public String getAllProductsAndAvailableQuantity(HttpServletRequest request,HttpServletResponse response,ModelMap map){
        super.initializer(request,response,map);
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/sell",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String sellProduct(HttpServletRequest request,HttpServletResponse response,ModelMap map){
        super.initializer(request,response,map);
        return null;
    }
}
