package ir.kamalkarimi.warehousing.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RedirectService {

    public final static String MESSAGE = "message";

    public String redirectTo(String path){
        if (!StringUtils.hasLength(path))
            path = "/";
        return "redirect:"+path;
    }
}
