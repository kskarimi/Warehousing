package ir.kamalkarimi.warehousing.controller;

import ir.kamalkarimi.warehousing.dto.ArticleTO;
import ir.kamalkarimi.warehousing.dto.ProductTO;
import ir.kamalkarimi.warehousing.service.AjaxService;
import ir.kamalkarimi.warehousing.service.ArticleService;
import ir.kamalkarimi.warehousing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController extends BaseController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ProductService productService;

    @Autowired
    AjaxService ajaxService;

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
    @GetMapping(value = "/test/component")
    public String component() {

        ProductTO productTO = new ProductTO("table");

        List<ArticleTO> articles = new ArrayList<>();
        articles.add(new ArticleTO(1L, "leg", 3));

        return null;
    }
}
