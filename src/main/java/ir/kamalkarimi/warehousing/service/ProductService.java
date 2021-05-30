package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ProductDto;
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


    public ProductDto index(ProductDto productDto){
        if (productDto == null)
            return null;
        return productMapper.productToDto(productManager.saveAndFlush(productMapper.productDtoToEntity(productDto)));
    }

    public List<ProductDto> index(List<ProductDto> productDtos){
        if (productDtos == null || productDtos.isEmpty()){
            return null;
        }

        List<ProductDto> productDtoList = new ArrayList<>();

        for (ProductDto productDto : productDtos) {
            if (productDto == null)
                continue;
            productDtoList.add(this.index(productDto));
        }

        return productDtoList;
    }

}
