package ir.kamalkarimi.warehousing.dto.product;

import java.util.List;

public class ProductsTO {

    private List<ItemTO> products;

    public ProductsTO() {
    }

    public ProductsTO(List<ItemTO> products) {
        this.products = products;
    }

    public List<ItemTO> getProducts() {
        return products;
    }

    public void setProducts(List<ItemTO> products) {
        this.products = products;
    }
}
