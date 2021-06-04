package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Product;
import ir.kamalkarimi.warehousing.model.ProductArticle;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductArticleManager extends BaseManagerImpl<ProductArticle>{

    private final ProductArticleRepository repository;
    private final BaseUtil baseUtil;

    @Autowired
    public ProductArticleManager(ProductArticleRepository repository, BaseUtil baseUtil) {
        this.repository = repository;
        this.baseUtil = baseUtil;
    }

    @Override
    protected BaseRepository<ProductArticle> getRepository() {
        return repository;
    }

    public List<ProductArticle> findByProduct(Product product) {
        if (baseUtil.isNull(product))
            return null;
        return repository.findByProduct(product);
    }
}
