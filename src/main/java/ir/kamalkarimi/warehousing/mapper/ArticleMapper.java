package ir.kamalkarimi.warehousing.mapper;

import ir.kamalkarimi.warehousing.domain.articles.Article;
import ir.kamalkarimi.warehousing.dto.ArticleTO;
import ir.kamalkarimi.warehousing.dto.BaseTO;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleMapper implements Mapper<ArticleTO, Article> {

    private final BaseUtil baseUtil;
    @Autowired
    public ArticleMapper(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Override
    public ArticleTO toDTO(Article entity) {
        if (baseUtil.isNullEntity(entity))
            return null;
        ArticleTO articleTO = new ArticleTO();
        articleTO.setId(String.valueOf(entity.getId()));
        articleTO.setName(entity.getName());
        articleTO.setStock(String.valueOf(entity.getStock()));
        return articleTO;
    }

    @Override
    public List<ArticleTO> toDTOS(List<Article> entities) {
        if (baseUtil.isNullEntity(entities))
            return null;
        List<ArticleTO> articleTOS = new ArrayList<>();
        entities.forEach(e->articleTOS.add(this.toDTO(e)));
        return articleTOS;
    }

    @Override
    public Article toEntity(ArticleTO dto) {
        if (baseUtil.isNullDTO(dto))
            return null;
        Article article = new Article();
        article.setName(dto.getName());
        article.setId(Long.valueOf(dto.getId()));
        article.setStock(Integer.valueOf(dto.getStock()));
        return article;
    }

    @Override
    public List<Article> toEntities(List<ArticleTO> dtos) {
        if (baseUtil.isNullDTO(dtos))
            return null;
        List<Article> articles = new ArrayList<>();
        dtos.forEach(t-> {
            if (!baseUtil.isNullDTO(t)){
                articles.add(this.toEntity(t));
            }
        });
        return articles;
    }
}
