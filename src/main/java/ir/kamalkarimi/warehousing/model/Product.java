package ir.kamalkarimi.warehousing.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@SequenceGenerator(name = "id_gen", sequenceName = "product_seq", allocationSize = 1)
public class Product extends BaseImpl {

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "product")
    private List<Article> articles;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
