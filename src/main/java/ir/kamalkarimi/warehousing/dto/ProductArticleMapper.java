package ir.kamalkarimi.warehousing.dto;

import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.ProductArticle;
import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper
public interface ProductArticleMapper {

    ProductArticleMapper COMPONENT_MAPPER = Mappers.getMapper(ProductArticleMapper.class);

    ProductArticleTO productArticleToProductArticleTO(ProductArticle productArticle);

    ProductArticle productArticleTOToProductArticle(ProductArticleTO ProductArticleTO);

    List<ProductArticleTO> productArticlesToProductArticleTOs(List<ProductArticle> productArticles);

    List<ProductArticle> productArticleTOsToProductArticles(List<ProductArticleTO> productArticleTOS);

    ArticleTO articleToArticleTO(Article article);

    Article  articleTOToArticle(ArticleTO articleTO);

    ProductTO productToProductTO(Product product);

    Product  productTOToProduct(ProductTO productTO);

}
