package ir.kamalkarimi.warehousing.domain.articles;

import ir.kamalkarimi.warehousing.domain.base.BaseManagerImpl;
import ir.kamalkarimi.warehousing.domain.base.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesManager extends BaseManagerImpl<Article> {

    private final ArticlesRepository repository;

    @Autowired
    public ArticlesManager(ArticlesRepository repository) {
        this.repository = repository;
    }

    @Override
    protected BaseRepository<Article> getRepository() {
        return repository;
    }
}
