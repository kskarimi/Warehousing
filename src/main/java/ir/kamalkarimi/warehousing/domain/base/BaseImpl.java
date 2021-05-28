package ir.kamalkarimi.warehousing.domain.base;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseImpl implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    @Column(nullable = false,unique = true)
    protected Long id;

    @Basic(optional = false)
    @Column(insertable = false,updatable = false)
    @Temporal(TemporalType.DATE)
    protected Date createAt;

    @Column(columnDefinition = "boolean default false")
    protected Boolean deleted;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    @Override
    public Date getCreateAt() {
        return null;
    }

    @Override
    public void setCreateAt(Date createAt) {

    }

    @Override
    public Boolean isDeleted() {
        return null;
    }

    @Override
    public void setDeleted(Boolean deleted) {

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        Class objClass = Hibernate.getClass(obj);
        Class myClass  = Hibernate.getClass(this);

        if (objClass != myClass)
            return false;

        Base other = (Base) obj;

        return Objects.equals(getId(),other.getId());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
