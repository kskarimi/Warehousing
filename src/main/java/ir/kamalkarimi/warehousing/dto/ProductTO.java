package ir.kamalkarimi.warehousing.dto;

import java.util.Objects;

public class ProductTO {
    private Long   id;
    private String name;

    public ProductTO() {
        this(null,null);
    }

    public ProductTO(String name) {
        this(null,name);
    }

    public ProductTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductTO)) return false;
        ProductTO productTO = (ProductTO) o;
        return getId().equals(productTO.getId()) && getName().equals(productTO.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
