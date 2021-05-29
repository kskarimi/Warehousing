package ir.kamalkarimi.warehousing.dto;

import java.util.List;

public class ProductTO {
    private String name;
    private List<ArticleTO> articleTOs;

    public ProductTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArticleTO> getArticleTOs() {
        return articleTOs;
    }

    public void setArticleTOs(List<ArticleTO> articleTOs) {
        this.articleTOs = articleTOs;
    }
}
