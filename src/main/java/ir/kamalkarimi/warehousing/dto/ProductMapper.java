package ir.kamalkarimi.warehousing.dto;

import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto productToDto(Product product);

    Product  productDtoToEntity(ProductDto productDto);

    ArticleDto articleToDto(Article article);

    Article   articleDtoToArticle(ArticleDto articleDto);

    List<Article> articleDtosToEntities(List<ArticleDto> articleDtos);

    List<ArticleDto> articlesToArticleDtos(List<Article> articles);
}
