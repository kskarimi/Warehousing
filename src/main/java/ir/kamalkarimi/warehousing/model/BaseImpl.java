package ir.kamalkarimi.warehousing.model;

import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseImpl implements Base {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_gen")
    @Column(nullable = false,unique = true)
    protected Long id;

    @Column(columnDefinition = "boolean default false")
    protected boolean disabled;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public void setDisabled(boolean disabled) {
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
