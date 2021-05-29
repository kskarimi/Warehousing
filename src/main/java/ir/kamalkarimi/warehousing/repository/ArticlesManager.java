package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesManager extends BaseManagerImpl<Article> {

    private final ArticlesRepository repository;
    private final BaseUtil baseUtil;

    @Autowired
    public ArticlesManager(ArticlesRepository repository, BaseUtil baseUtil) {
        this.repository = repository;
        this.baseUtil = baseUtil;
    }

    @Override
    protected BaseRepository<Article> getRepository() {
        return repository;
    }
}
