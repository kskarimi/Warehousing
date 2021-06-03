package ir.kamalkarimi.warehousing.dto;

public class ProductArticleTO {

    private Long id;

    private ProductTO product;

    private ArticleTO article;

    private Integer productAmount;

    public ProductArticleTO() {
        this(null,null,null,null);
    }

    public ProductArticleTO(ProductTO product, ArticleTO article, Integer productAmount) {
        this(null, product, article, productAmount);
    }

    public ProductArticleTO(Long id, ProductTO product, ArticleTO article, Integer productAmount) {
        this.id = id;
        this.product = product;
        this.article = article;
        this.productAmount = productAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductTO getProduct() {
        return product;
    }

    public void setProduct(ProductTO product) {
        this.product = product;
    }

    public ArticleTO getArticle() {
        return article;
    }

    public void setArticle(ArticleTO article) {
        this.article = article;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }
}
