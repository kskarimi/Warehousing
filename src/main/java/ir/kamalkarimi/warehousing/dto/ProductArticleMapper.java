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

    ProductArticleTO componentToComponentTO(ProductArticle productArticle);

    ProductArticle componentTOToComponent(ProductArticleTO ProductArticleTO);

    List<ProductArticleTO> componentsToComponentTOs(List<ProductArticle> productArticles);

    List<ProductArticle>  componentTOsToComponents(List<ProductArticleTO> productArticleTOS);

    ArticleTO articleToArticleTO(Article article);

    Article  articleTOToArticle(ArticleTO articleTO);

    List<ArticleTO> articlesToArticleTOs(List<Article> article);

    List<Article>   articleTOsToArticles(List<ArticleTO> articleTO);

    ProductTO productToProductTO(Product product);

    Product  productTOToProduct(ProductTO productTO);

    List<ProductTO> productsToProductTOs(List<Product> products);

    List<Product> productTOsToProduct(List<ProductTO> productTOs);

}
