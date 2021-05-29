package ir.kamalkarimi.warehousing.dto;

import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {

    ArticleMapper ARTICLE_MAPPER = Mappers.getMapper(ArticleMapper.class);

    ArticleDto articleToDto(Article article);

    Article   articleDtoToArticle(ArticleDto articleDto);

    ProductDto productToDto(Product product);

    Product  productDtoToEntity(ProductDto productDto);

}
