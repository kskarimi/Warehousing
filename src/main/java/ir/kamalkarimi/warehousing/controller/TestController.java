package ir.kamalkarimi.warehousing.controller;

import ir.kamalkarimi.warehousing.dto.*;
import ir.kamalkarimi.warehousing.service.AjaxService;
import ir.kamalkarimi.warehousing.service.ArticleService;
import ir.kamalkarimi.warehousing.service.InventoryFacade;
import ir.kamalkarimi.warehousing.service.ProductService;
import ir.kamalkarimi.warehousing.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController extends BaseController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ProductService productService;

    @Autowired
    AjaxService ajaxService;

    @Autowired
    InventoryFacade inventoryFacade;

    @Autowired
    FileUtil fileUtil;

    @ResponseBody
    @GetMapping(value = "/test/article")
    public String article() {

        ArticleTO articleTO = new ArticleTO();

        articleTO.setName("leg");
        articleTO.setStock(12);

        articleTO = articleService.index(articleTO);

        return ajaxService.toJson(articleTO);
    }

    @ResponseBody
    @GetMapping(value = "/test/product")
    public String product() {

        try {
            ProductTO productTO = new ProductTO();

            productTO.setName("table");

            productTO = productService.index(productTO);

            return ajaxService.toJson(productTO);
        } catch (Exception ex) {
            String message = ex.getMessage();
            if (message.contains("org.hibernate.exception.ConstraintViolationException: "))
                return message;
        }

        return "404";
    }


    @ResponseBody
    @GetMapping(value = "/test/productarticle")
    public String productArticle() {

        ProductTO productTO = new ProductTO("table");

        ArticleTO articles = new ArticleTO(1L, "leg", 3);

        ProductArticleTO productArticleTO = new ProductArticleTO();

        productArticleTO.setProduct(productTO);

        productArticleTO.setArticle(articles);

        productArticleTO.setProductAmount(2);

        return ajaxService.toJson(inventoryFacade.loadingProduct(productArticleTO));
    }


    @ResponseBody
    @GetMapping(value = "/test/upload")
    public String uploadFile(){
//       ReceivedProductsTO productsTOS =  fileUtil.readFile("products",ReceivedProductsTO.class);
       ReceivedArticleTO productsTOS =  fileUtil.readFile("inventory", ReceivedArticleTO.class);
       return ajaxService.toJson(productsTOS);
    }
}
