package ir.kamalkarimi.warehousing.mapper;

import ir.kamalkarimi.warehousing.domain.base.BaseImpl;
import ir.kamalkarimi.warehousing.dto.BaseTO;
import java.util.List;


public interface Mapper<T extends BaseTO,S extends BaseImpl> {

    T  toDTO(S entity);

    List<T> toDTOS(List<S> entities);

    S toEntity(T dto);

    List<S> toEntities(List<T> dtos);
}
