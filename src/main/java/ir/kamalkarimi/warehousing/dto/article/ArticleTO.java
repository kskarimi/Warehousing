package ir.kamalkarimi.warehousing.dto.article;

import ir.kamalkarimi.warehousing.dto.product.ProductTO;

public class ArticleTO {
    private Long id;
    private String name;
    private Integer stock;
    private ProductTO product;

    public ArticleTO() {
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

    public ProductTO getProduct() {
        return product;
    }

    public void setProduct(ProductTO product) {
        this.product = product;
    }
}
