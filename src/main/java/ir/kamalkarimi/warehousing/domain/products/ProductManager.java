package ir.kamalkarimi.warehousing.domain.products;

import ir.kamalkarimi.warehousing.domain.base.BaseManagerImpl;
import ir.kamalkarimi.warehousing.domain.base.BaseRepository;
import ir.kamalkarimi.warehousing.dto.ProductDTO;
import ir.kamalkarimi.warehousing.mapper.ProductMapper;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager extends BaseManagerImpl<Product> {

    private final ProductRepository repository;
    private final ProductMapper productMapper;
    private final BaseUtil baseUtil;

    @Autowired
    public ProductManager(ProductRepository repository, ProductMapper productMapper,  BaseUtil baseUtil) {
        this.repository = repository;
        this.productMapper = productMapper;
        this.baseUtil = baseUtil;
    }

    @Override
    protected BaseRepository<Product> getRepository() {
        return this.repository;
    }

    public ProductDTO index(ProductDTO productDTO){
        if (baseUtil.isNullDTO(productDTO)){
            return null;
        }
        return productMapper.toDTO(this.index(productMapper.toEntity(productDTO)));
    }

    public List<ProductDTO> index(List<ProductDTO> productDTOS){
        if (baseUtil.isNullDTO(productDTOS))
            return null;
        return productMapper.toDTOS(this.index(productMapper.toEntities(productDTOS)));
    }
}
