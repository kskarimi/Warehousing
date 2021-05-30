package ir.kamalkarimi.warehousing.dto;

public class ProductsDto {

    private ProductDto []products;

    public ProductsDto(ProductDto[] products) {
        this.products = products;
    }

    public ProductDto[] getProducts() {
        return products;
    }

    public void setProducts(ProductDto[] products) {
        this.products = products;
    }
}
