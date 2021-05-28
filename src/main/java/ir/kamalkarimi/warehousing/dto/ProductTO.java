package ir.kamalkarimi.warehousing.dto;

import ir.kamalkarimi.warehousing.dto.BaseTO;
import ir.kamalkarimi.warehousing.dto.ArticleTO;

import java.util.List;

public class ProductTO extends BaseTO {

    private String name;
    private List<ArticleTO> articles;

    public ProductTO() {
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
