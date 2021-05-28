package ir.kamalkarimi.warehousing.util;

import ir.kamalkarimi.warehousing.domain.base.Base;
import ir.kamalkarimi.warehousing.dto.BaseTO;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BaseUtil {

    public  <T extends Base> Boolean isNullEntity(T entity){
        return entity == null || entity.getId() == null;
    }

    public <T extends Base> Boolean isNullEntity(List<T> entities){
        return entities == null || entities.isEmpty();
    }
    
    public <T extends BaseTO> Boolean isNullDTO(T dto){
        return dto == null ;
    }
    
    public <T extends  BaseTO> Boolean isNullDTO(List<T> dtos){
        return dtos == null || dtos.isEmpty();
    }
}
