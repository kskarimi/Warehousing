package ir.kamalkarimi.warehousing.domain.base;

import java.util.Date;

interface Base {

    Long  getId();

    void  setId(Long id);

    Date  getCreateAt();

    void  setCreateAt(Date createAt);

    Boolean isDeleted();

    void setDeleted(Boolean deleted);
}
