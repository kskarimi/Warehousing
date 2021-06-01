package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.product.ProductTO;
import ir.kamalkarimi.warehousing.dto.product.ProductMapper;
import ir.kamalkarimi.warehousing.model.Product;
import ir.kamalkarimi.warehousing.repository.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductManager productManager;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductManager productManager, ProductMapper productMapper) {
        this.productManager = productManager;
        this.productMapper = productMapper;
    }

    public List<ProductTO> index(List<ProductTO> productTOS){
        if (productTOS == null || productTOS.isEmpty()){
            return null;
        }

        List<Product> probes = productMapper.productDtoToEntity(productTOS);
        probes = productManager.index(probes);

        return productMapper.productToDto(probes);
    }

}
