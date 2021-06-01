package ir.kamalkarimi.warehousing.dto;

import java.util.List;

public class ProductsTO {

    private List<ProductItemTO> products;

    public ProductsTO() {
    }

    public ProductsTO(List<ProductItemTO> products) {
        this.products = products;
    }

    public List<ProductItemTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductItemTO> products) {
        this.products = products;
    }
}
