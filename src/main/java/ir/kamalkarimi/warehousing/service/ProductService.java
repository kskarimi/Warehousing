package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ProductTO;
import ir.kamalkarimi.warehousing.dto.ProductMapper;
import ir.kamalkarimi.warehousing.model.Product;
import ir.kamalkarimi.warehousing.repository.ProductManager;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductService {

    private final ProductManager productManager;
    private final ProductMapper productMapper;
    private final BaseUtil baseUtil;

    @Autowired
    public ProductService(ProductManager productManager, ProductMapper productMapper, BaseUtil baseUtil) {
        this.productManager = productManager;
        this.productMapper = productMapper;
        this.baseUtil = baseUtil;
    }

    public ProductTO index(ProductTO productTO) {
        if (baseUtil.isNull(productTO))
            return null;

        Product product = productMapper.productTOToProduct(productTO);

        Product probe = productManager.findOne(product);

        if (baseUtil.isNull(probe)){
           probe =  productManager.index(product);
        }

        return productMapper.productToProductTO(probe);
    }

    public List<ProductTO> findAll() {
        return productMapper.productsToProductTOs(productManager.findAll());
    }

    public ProductTO findByName(String productName) {
        if (!StringUtils.hasText(productName))
            return null;
        ProductTO probe = new ProductTO();
        probe.setName(productName);
        return productMapper.productToProductTO(productManager.findOne(productMapper.productTOToProduct(probe)));
    }
}
