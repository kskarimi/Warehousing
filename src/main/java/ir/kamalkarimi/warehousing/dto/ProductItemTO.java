package ir.kamalkarimi.warehousing.dto;

import java.util.List;

public class ProductItemTO {

    private String name;

    private List<ArticleItemTO> articles;


    public ProductItemTO() {
    }

    public ProductItemTO(String name, List<ArticleItemTO> articles) {
        this.name = name;
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArticleItemTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleItemTO> articles) {
        this.articles = articles;
    }
}
