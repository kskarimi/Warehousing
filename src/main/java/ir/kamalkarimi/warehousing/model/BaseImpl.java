package ir.kamalkarimi.warehousing.model;

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
    protected Boolean disabled;

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
    public Boolean isDisabled() {
        return disabled;
    }

    @Override
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
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
