package ir.kamalkarimi.warehousing.util;

import ir.kamalkarimi.warehousing.model.Base;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;


@Component
public class BaseUtil {

    public  <T extends Base> Boolean isNull(T entity){
        return entity == null || entity.getId() == null;
    }

    public <T extends Base> Boolean isNull(List<T> entities){
        return entities == null || entities.isEmpty();
    }

    public Boolean isNull(Object o){
        return Objects.isNull(o);
    }
}
