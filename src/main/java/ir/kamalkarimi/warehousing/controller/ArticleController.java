package ir.kamalkarimi.warehousing.controller;

import ir.kamalkarimi.warehousing.dto.ArticleTO;
import ir.kamalkarimi.warehousing.dto.ReceivedArticleTO;
import ir.kamalkarimi.warehousing.exception.BaseException;
import ir.kamalkarimi.warehousing.service.AjaxService;
import ir.kamalkarimi.warehousing.service.ArticleService;
import ir.kamalkarimi.warehousing.service.RedirectService;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import ir.kamalkarimi.warehousing.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ArticleController extends BaseController {

    private final ArticleService articleService;
    private final AjaxService ajaxService;
    private final BaseUtil baseUti;
    private final FileUtil fileUtil;
    private final RedirectService redirectService;

    @Autowired
    public ArticleController(ArticleService articleService, AjaxService ajaxService, BaseUtil baseUti,
                             FileUtil fileUtil,RedirectService redirectService) {
        this.articleService = articleService;
        this.ajaxService = ajaxService;
        this.baseUti = baseUti;
        this.fileUtil = fileUtil;
        this.redirectService = redirectService;


    }

    @GetMapping(value = {"/article"})
    public String homePage(HttpServletRequest request, HttpServletResponse response,Model  model){
        super.initializer(request,response);

        List<ArticleTO> articleTOS = articleService.findAll();

        if (baseUti.isNull(articleTOS)){
            model.addAttribute(AjaxService.STATUS, HttpStatus.NOT_FOUND.name());
            model.addAttribute(AjaxService.MESSAGE, "Not fount any articles");
            model.addAttribute(AjaxService.RESULT, null);
        }else{
            model.addAttribute(AjaxService.STATUS, HttpStatus.OK.name());
            model.addAttribute(AjaxService.MESSAGE,null);
            model.addAttribute(AjaxService.RESULT, articleTOS);
        }
        return RedirectService.ARTICLE_PAGE;
    }

    @PostMapping("/article")
    public String uploadArticles(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file,Model model){
        super.initializer(request,response);

        message.clear();

        if (file.isEmpty()){
            model.addAttribute(AjaxService.STATUS,HttpStatus.NOT_FOUND.name());
            model.addAttribute(AjaxService.MESSAGE,"File is empty");
            model.addAttribute(AjaxService.RESULT,null);
        }else{
            String fileName  = file.getOriginalFilename();
            String fileFormat = file.getContentType();

            if (StringUtils.hasLength(fileName) &&
                    fileName.equalsIgnoreCase("inventory.json")){
                if (StringUtils.hasLength(fileFormat) && fileFormat.equalsIgnoreCase("application/json")){
                    try {
                        fileUtil.uploadFile(file);
                        model.addAttribute(AjaxService.STATUS,HttpStatus.OK.name());
                        model.addAttribute(AjaxService.MESSAGE,"Finished uploading file "+fileName);
                        model.addAttribute(AjaxService.RESULT,null);
                    } catch (BaseException exception) {
                        model.addAttribute(AjaxService.STATUS,HttpStatus.BAD_REQUEST.name());
                        model.addAttribute(AjaxService.MESSAGE,exception.getMessage());
                        model.addAttribute(AjaxService.RESULT,null);
                    }
                }else{
                    model.addAttribute(AjaxService.STATUS,HttpStatus.BAD_REQUEST.name());
                    model.addAttribute(AjaxService.MESSAGE,"File name should be formats should be  json !");
                    model.addAttribute(AjaxService.RESULT,null);
                }
            }else{
                model.addAttribute(AjaxService.STATUS,HttpStatus.BAD_REQUEST.name());
                model.addAttribute(AjaxService.MESSAGE,"File name should be inventory !");
                model.addAttribute(AjaxService.RESULT,null);
            }
        }

        return RedirectService.ARTICLE_PAGE;
    }


    @ResponseBody
    @GetMapping("/article/loadingarticles")
    public String loadingProducts(HttpServletRequest request,HttpServletResponse response){
        super.initializer(request,response);
        ReceivedArticleTO productsTOS =  fileUtil.readFile("inventory", ReceivedArticleTO.class);

        if (baseUti.isNull(productsTOS)){
            message.put(AjaxService.STATUS,HttpStatus.NOT_FOUND);
            message.put(AjaxService.RESULT,"Not found inventory.json file !");
        }else{
            List<ArticleTO> articleTOS = productsTOS.getInventory();
            if (baseUti.isNull(articleTOS)){
                message.put(AjaxService.STATUS,HttpStatus.NOT_FOUND);
                message.put(AjaxService.RESULT,"Not found inventory.json file !");
            }else{
               articleTOS = articleService.index(articleTOS);
                message.put(AjaxService.STATUS,HttpStatus.OK);
                message.put(AjaxService.RESULT,articleTOS);
            }
        }
        return ajaxService.toJson(message);
    }
}
