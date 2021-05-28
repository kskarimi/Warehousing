package ir.kamalkarimi.warehousing.domain;

import ir.kamalkarimi.warehousing.domain.base.Base;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BaseUtil {

    public  <T extends Base> Boolean isNull(T entity){
        return entity == null || entity.getId() == null;
    }

    public <T extends Base> Boolean isNull(List<T> entities){
        return entities == null || entities.isEmpty();
    }
}
