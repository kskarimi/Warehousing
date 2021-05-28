package ir.kamalkarimi.warehousing.dto;

import java.util.List;

public class ProductDTO extends BaseDTO {

    private String name;
    private List<ArticleDTO> articles;

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDTO> articles) {
        this.articles = articles;
    }
}
