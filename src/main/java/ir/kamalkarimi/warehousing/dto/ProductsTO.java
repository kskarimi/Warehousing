package ir.kamalkarimi.warehousing.dto;


import java.util.List;

public class ProductsTO {

    private String name;

    private List<ArticleTO> articles;

    public ProductsTO() {
    }

    public ProductsTO(String name, List<ArticleTO> articles) {
        this.name = name;
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArticleTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleTO> articles) {
        this.articles = articles;
    }
}
