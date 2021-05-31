package ir.kamalkarimi.warehousing.dto;

import java.util.List;

public class ProductItemDto {

    private String name;

    private List<ArticleItemDto> articles;


    public ProductItemDto() {
    }

    public ProductItemDto(String name, List<ArticleItemDto> articles) {
        this.name = name;
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArticleItemDto> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleItemDto> articles) {
        this.articles = articles;
    }
}
