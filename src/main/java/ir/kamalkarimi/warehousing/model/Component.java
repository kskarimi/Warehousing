package ir.kamalkarimi.warehousing.model;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name = "id_gen",sequenceName = "component_seq",allocationSize = 1)
public class Component extends BaseImpl {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Article article;

    @Column
    private int productAmount;

    public Component() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int amount) {
        this.productAmount = amount;
    }
}
