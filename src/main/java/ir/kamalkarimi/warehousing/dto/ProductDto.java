package ir.kamalkarimi.warehousing.dto;

import java.util.List;

public class ProductDto {
    private String name;
    private List<ArticleDto> articles;

    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArticleDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleDto> articles) {
        this.articles = articles;
    }
}
