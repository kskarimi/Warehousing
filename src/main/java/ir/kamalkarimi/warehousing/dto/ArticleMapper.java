package ir.kamalkarimi.warehousing.dto;

import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ArticleMapper {

    ArticleMapper ARTICLE_MAPPER = Mappers.getMapper(ArticleMapper.class);

    ArticleTO articleToArticleTO(Article article);

    Article  articleTOToArticle(ArticleTO articleTO);

    List<ArticleTO> articlesToArticleTOs(List<Article> article);

    List<Article>   articleTOsToArticles(List<ArticleTO> articleTO);
}
