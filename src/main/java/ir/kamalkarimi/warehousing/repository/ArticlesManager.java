package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.exception.BaseException;
import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

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


    public Article use(Long articleId, Integer amount)  {
        if (articleId == null)
            return null;
        Optional<Article> optionalArticle = repository.findById(articleId);
        if (!optionalArticle.isPresent()){
            return null;
        }

        Article article = optionalArticle.get();
        Integer stock = article.getStock() == null ? 0: article.getStock();
        int remind = stock - amount;

        if (remind < 0){
            return null;
        }
            article.setStock(amount);
        return repository.save(article);
    }
}
