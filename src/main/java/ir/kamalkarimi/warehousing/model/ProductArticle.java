package ir.kamalkarimi.warehousing.model;

import javax.persistence.*;

@Entity
@Table
@SequenceGenerator(name = "id_gen",sequenceName = "product_article_seq",allocationSize = 1)
public class ProductArticle extends BaseImpl {

    @ManyToOne
    private Product product;

    @ManyToOne
    private Article article;

    @Column
    private int productAmount;

    public ProductArticle() {
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
