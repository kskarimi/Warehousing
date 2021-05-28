package ir.kamalkarimi.warehousing.domain.products;

import ir.kamalkarimi.warehousing.domain.base.BaseManagerImpl;
import ir.kamalkarimi.warehousing.domain.base.BaseRepository;
import ir.kamalkarimi.warehousing.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManager extends BaseManagerImpl<Product> {

    private final ProductRepository repository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductManager(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    @Override
    protected BaseRepository<Product> getRepository() {
        return this.repository;
    }
}
