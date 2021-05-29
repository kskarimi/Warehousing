package ir.kamalkarimi.warehousing.controller;

import ir.kamalkarimi.warehousing.exception.BaseException;
import ir.kamalkarimi.warehousing.util.FileUtil;
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
    private final FileUtil fileUtil;

    @Autowired
    public InventoryController(InventoryFacade inventoryFacade, FileUtil fileUtil) {
        this.inventoryFacade = inventoryFacade;
        this.fileUtil = fileUtil;
    }

    @ResponseBody
    @RequestMapping(value = "/upload",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String handleFileUpload(HttpServletRequest request, HttpServletResponse response, ModelMap map, MultipartFile file){
        super.initializer(request,response,map);
        try {
            String filename = request.getParameter("filename");
            fileUtil.upload(file,filename);
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
