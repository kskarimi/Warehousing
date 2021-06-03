package ir.kamalkarimi.warehousing.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Service
public class RedirectService {

    public final static String MESSAGE        = "message";
    public final static String SUCCESS        = "success";
    public final static String ERROR          = "error";

    public final static String HOME_PAGE      = "home";
    public final static String INVENTORY_PAGE = "inventory";
    public final static String ARTICLE_PAGE   = "article";
    public final static String PRODUCT_PAGE   = "product";

    public final static String HOME_URL           = "/";
    public final static String INVENTORY_HOME_URL = "/inventory";
    public final static String PRODUCT_HOME_URL   = "/product";

    public String redirectTo(String path){
        if (!StringUtils.hasLength(path))
            path = HOME_URL;
        return "redirect:"+path;
    }
}
