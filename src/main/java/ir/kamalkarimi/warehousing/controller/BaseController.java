package ir.kamalkarimi.warehousing.controller;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

public abstract class BaseController {

    private String referer ;

    public void initializer(HttpServletRequest request, HttpServletResponse response){
        this.initializer(request,response,null);
    }

    public void initializer(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes){
        this.initializer(request,response,attributes,null);
    }

    public void initializer(HttpServletRequest request, HttpServletResponse response, RedirectAttributes attributes, Model model){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            referer = request.getHeader("referer");
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getReferer() {
        return referer;
    }
}
