package ir.kamalkarimi.warehousing.dto;

public class ArticleTO extends BaseTO {
    private String id;
    private String name;
    private String stock;

    public ArticleTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
