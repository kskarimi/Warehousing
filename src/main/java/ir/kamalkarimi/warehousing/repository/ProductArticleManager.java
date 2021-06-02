package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.ProductArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductArticleManager extends BaseManagerImpl<ProductArticle>{

    private final ProductArticleRepository repository;

    @Autowired
    public ProductArticleManager(ProductArticleRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<ProductArticle> getRepository() {
        return repository;
    }
}
