package ir.kamalkarimi.warehousing.dto;

import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductTO productToDto(Product product);

    Product  productDtoToEntity(ProductTO productTO);

    ArticleTO articleToDto(Article article);

    Article   articleDtoToArticle(ArticleTO articleTO);

    List<Article> articleDtosToEntities(List<ArticleTO> articleTOS);

    List<ArticleTO> articlesToArticleDtos(List<Article> articles);
}
