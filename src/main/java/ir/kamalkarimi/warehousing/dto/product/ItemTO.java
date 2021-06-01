package ir.kamalkarimi.warehousing.dto.product;

import java.util.List;

public class ItemTO {

    private String name;

    private List<ir.kamalkarimi.warehousing.dto.article.ItemTO> articles;


    public ItemTO() {
    }

    public ItemTO(String name, List<ir.kamalkarimi.warehousing.dto.article.ItemTO> articles) {
        this.name = name;
        this.articles = articles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ir.kamalkarimi.warehousing.dto.article.ItemTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ir.kamalkarimi.warehousing.dto.article.ItemTO> articles) {
        this.articles = articles;
    }
}
