package ir.kamalkarimi.warehousing.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@SequenceGenerator(name = "id_gen", sequenceName = "product_seq", allocationSize = 1)
public class Product extends BaseImpl {

    @Column(unique = true)
    private String name;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
