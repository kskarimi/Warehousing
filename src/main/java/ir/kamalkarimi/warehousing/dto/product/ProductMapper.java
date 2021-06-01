package ir.kamalkarimi.warehousing.dto.product;

import ir.kamalkarimi.warehousing.dto.article.ArticleTO;
import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductTO productToDto(Product product);

    Product  productDtoToEntity(ProductTO productTO);

    List<ProductTO> productToDto(List<Product> products);

    List<Product>  productDtoToEntity(List<ProductTO> productTOS);

    ArticleTO articleToDto(Article article);

    Article   articleDtoToArticle(ArticleTO articleTO);

    Set<Article> articleDtosToEntities(Set<ArticleTO> articleTOS);

    Set<ArticleTO> articlesToArticleDtos(Set<Article> articles);
}
