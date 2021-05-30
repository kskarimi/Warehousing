package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Product;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManager extends BaseManagerImpl<Product> {

    private final ProductRepository repository;
    private final BaseUtil baseUtil;

    @Autowired
    public ProductManager(ProductRepository repository, BaseUtil baseUtil) {
        this.repository = repository;
        this.baseUtil = baseUtil;
    }

    @Override
    protected BaseRepository<Product> getRepository() {
        return repository;
    }

    public Product saveAndFlush(Product productDtoToEntity) {
        return repository.saveAndFlush(productDtoToEntity);
    }
}
