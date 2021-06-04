package ir.kamalkarimi.warehousing.controller;

import ir.kamalkarimi.warehousing.service.RedirectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController extends BaseController{


    @GetMapping("/")
    public String homePage(HttpServletRequest request, HttpServletResponse response){
        super.initializer(request,response);
        return RedirectService.HOME_PAGE;
    }
}
