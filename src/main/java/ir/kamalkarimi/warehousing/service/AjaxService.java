package ir.kamalkarimi.warehousing.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AjaxService {

    private final Gson gson;

    public final static String RESULT   = "result";
    public final static String STATUS  = "status";
    public final static String MESSAGE  = "message";




    @Autowired
    public AjaxService(Gson gson) {
        this.gson = gson;
    }

    public String toJson(Object obj){
        return gson.toJson(obj);
    }
}
