package ir.kamalkarimi.warehousing.model;

import java.util.Date;

public interface Base {

    Long  getId();

    void  setId(Long id);

    Date  getCreateAt();

    void  setCreateAt(Date createAt);

    Boolean isDisabled();

    void setDisabled(Boolean disabled);
}
