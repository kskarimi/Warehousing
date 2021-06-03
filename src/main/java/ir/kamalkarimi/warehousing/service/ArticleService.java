package ir.kamalkarimi.warehousing.service;


import ir.kamalkarimi.warehousing.dto.ArticleMapper;
import ir.kamalkarimi.warehousing.dto.ArticleTO;
import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.repository.ArticleManager;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleManager articleManager;
    private final ArticleMapper articleMapper;
    private final BaseUtil baseUtil;

    @Autowired
    public ArticleService(ArticleManager articleManager, ArticleMapper articleMapper, BaseUtil baseUtil) {
        this.articleManager = articleManager;
        this.articleMapper = articleMapper;
        this.baseUtil = baseUtil;
    }

    public ArticleTO index(ArticleTO articleTO) {

        if (baseUtil.isNull(articleTO))
            return null;

        Article article = articleMapper.articleTOToArticle(articleTO);
        article = articleManager.index(article);

        return articleMapper.articleToArticleTO(article);
    }

    public List<ArticleTO> index(List<ArticleTO> articleTOS) {

        if (baseUtil.isNull(articleTOS))
            return null;

        List<Article> articles = articleMapper.articleTOsToArticles(articleTOS);
        articles = articleManager.index(articles);

        return articleMapper.articlesToArticleTOs(articles);
    }

    public boolean isExists(ArticleTO articleTO) {
        if (baseUtil.isNull(articleTO))
            return false;
        Article article = articleMapper.articleTOToArticle(articleTO);
        Article probe = articleManager.findById(article.getId());

        return !baseUtil.isNull(probe);
    }

    public List<ArticleTO> findAll() {
        return articleMapper.articlesToArticleTOs(articleManager.findAll());
    }
}
