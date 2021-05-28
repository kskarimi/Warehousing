package ir.kamalkarimi.warehousing.domain.articles;

import ir.kamalkarimi.warehousing.domain.base.BaseManagerImpl;
import ir.kamalkarimi.warehousing.domain.base.BaseRepository;
import ir.kamalkarimi.warehousing.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesManager extends BaseManagerImpl<Article> {

    private final ArticlesRepository repository;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticlesManager(ArticlesRepository repository, ArticleMapper articleMapper) {
        this.repository = repository;
        this.articleMapper = articleMapper;
    }

    @Override
    protected BaseRepository<Article> getRepository() {
        return repository;
    }
}
