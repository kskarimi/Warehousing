package ir.kamalkarimi.warehousing.dto.article;

import ir.kamalkarimi.warehousing.dto.product.ProductTO;
import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {

    ArticleMapper ARTICLE_MAPPER = Mappers.getMapper(ArticleMapper.class);

    ArticleTO articleToDto(Article article);

    Article   articleDtoToArticle(ArticleTO articleTO);

    ProductTO productToDto(Product product);

    Product  productDtoToEntity(ProductTO productTO);

}
