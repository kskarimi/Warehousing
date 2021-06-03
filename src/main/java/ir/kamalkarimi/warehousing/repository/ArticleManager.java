package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleManager extends BaseManagerImpl<Article> {

    private final ArticleRepository repository;
    private final BaseUtil baseUtil;

    @Autowired
    public ArticleManager(ArticleRepository repository, BaseUtil baseUtil) {
        this.repository = repository;
        this.baseUtil = baseUtil;
    }

    @Override
    protected BaseRepository<Article> getRepository() {
        return repository;
    }

    public Article findById(Long id) {
        if (baseUtil.isNull(id))
            return null;
        return repository.findById(id).orElse(null);
    }
}
