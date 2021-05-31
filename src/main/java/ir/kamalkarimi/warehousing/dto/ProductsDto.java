package ir.kamalkarimi.warehousing.dto;

import java.util.List;

public class ProductsDto {

    private List<ProductItemDto> products;

    public ProductsDto() {
    }

    public ProductsDto(List<ProductItemDto> products) {
        this.products = products;
    }

    public List<ProductItemDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductItemDto> products) {
        this.products = products;
    }
}
