package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.article.ArticleTO;
import ir.kamalkarimi.warehousing.dto.article.ArticleItemTO;
import ir.kamalkarimi.warehousing.dto.article.ArticleMapper;
import ir.kamalkarimi.warehousing.repository.ArticlesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final ArticlesManager articlesManager;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticlesManager articlesManager, ArticleMapper articleMapper) {
        this.articlesManager = articlesManager;
        this.articleMapper = articleMapper;
    }


    public ArticleTO index(ArticleTO articleTO){
        if (articleTO == null){
            return null;
        }
        return articleMapper.articleToDto(articlesManager.index(articleMapper.articleDtoToArticle(articleTO)));
    }

    public List<ArticleTO> index(List<ArticleTO> articleTOS){
        if (articleTOS == null || articleTOS.isEmpty()){
            return null;
        }

        List<ArticleTO> articleTOList = new ArrayList<>();
        for (ArticleTO articleTO : articleTOS) {
            if (articleTO == null)
                continue;
            articleTOList.add(this.index(articleTO));
        }

        return articleTOList;
    }

    public List<ArticleTO> use(List<ArticleItemTO> articleItemTOS) {
        if (articleItemTOS == null || !articleItemTOS.isEmpty()){
            return null;
        }

        List<ArticleTO> articleTOList = new ArrayList<>();
        for (ArticleItemTO articleItemTO : articleItemTOS) {
            if (articleItemTO == null )
                continue;

            Long articleId = articleItemTO.getArticleId();
            Integer amount = Integer.valueOf(articleItemTO.getAmount());

            ArticleTO articleTO = articleMapper.articleToDto(articlesManager.use(articleId,amount));
            if (articleTO == null)
                continue;
            articleTOList.add(articleTO);
        }
        return articleTOList;
    }
}
