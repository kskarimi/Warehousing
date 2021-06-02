package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ProductTO;
import ir.kamalkarimi.warehousing.dto.ProductMapper;
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
}
