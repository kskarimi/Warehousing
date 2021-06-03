package ir.kamalkarimi.warehousing.dto;


public class ProductsTO {

    private String name;

    private ArticleTO []articles;

    public ProductsTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArticleTO[] getArticles() {
        return articles;
    }

    public void setArticles(ArticleTO[] articles) {
        this.articles = articles;
    }
}
