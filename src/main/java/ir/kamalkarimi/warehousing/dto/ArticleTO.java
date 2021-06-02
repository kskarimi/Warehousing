package ir.kamalkarimi.warehousing.dto;


public class ArticleTO {
    private Long id;
    private String name;
    private Integer stock;

    public ArticleTO() {
        this(null,null,null);
    }

    public ArticleTO(String name, Integer stock) {
        this(null,name,stock);
    }

    public ArticleTO(Long id, String name, Integer stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
