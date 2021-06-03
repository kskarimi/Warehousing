package ir.kamalkarimi.warehousing.dto;

public class ReceivedProductsTO {

    private ProductsTO[] products;

    public ReceivedProductsTO() {
    }

    public ProductsTO[] getProducts() {
        return products;
    }

    public void setProducts(ProductsTO[] products) {
        this.products = products;
    }
}
