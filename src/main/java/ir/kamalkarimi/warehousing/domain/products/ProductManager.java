package ir.kamalkarimi.warehousing.domain.products;

import ir.kamalkarimi.warehousing.domain.base.BaseManagerImpl;
import ir.kamalkarimi.warehousing.domain.base.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductManager extends BaseManagerImpl<Product> {

    private final ProductRepository repository;

    @Autowired
    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Product> getRepository() {
        return this.repository;
    }
}
