package ir.kamalkarimi.warehousing.dto.product;

import java.util.List;

public class ProductsTO {

    private List<productItemTO> products;

    public ProductsTO() {
    }

    public ProductsTO(List<productItemTO> products) {
        this.products = products;
    }

    public List<productItemTO> getProducts() {
        return products;
    }

    public void setProducts(List<productItemTO> products) {
        this.products = products;
    }
}
