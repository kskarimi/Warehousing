package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ProductTO;
import ir.kamalkarimi.warehousing.dto.ProductMapper;
import ir.kamalkarimi.warehousing.repository.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public ProductTO index(ProductTO productTO){
        if (productTO == null)
            return null;
        return productMapper.productToDto(productManager.saveAndFlush(productMapper.productDtoToEntity(productTO)));
    }

    public List<ProductTO> index(List<ProductTO> productTOS){
        if (productTOS == null || productTOS.isEmpty()){
            return null;
        }

        List<ProductTO> productTOList = new ArrayList<>();

        for (ProductTO productTO : productTOS) {
            if (productTO == null)
                continue;
            productTOList.add(this.index(productTO));
        }

        return productTOList;
    }

}
