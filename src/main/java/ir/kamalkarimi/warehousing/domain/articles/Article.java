package ir.kamalkarimi.warehousing.domain.articles;

import ir.kamalkarimi.warehousing.domain.base.BaseImpl;
import ir.kamalkarimi.warehousing.domain.products.Product;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name = "id_gen", sequenceName = "article_seq", allocationSize = 1)
public class Article extends BaseImpl {

    @Column
    private String name;
    @Column
    private Integer stock;

    @ManyToOne
    private Product product;

    public Article() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}