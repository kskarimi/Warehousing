package ir.kamalkarimi.warehousing.dto;

import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.Component;
import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper
public interface ComponentMapper {

    ComponentMapper COMPONENT_MAPPER = Mappers.getMapper(ComponentMapper.class);

    ComponentTO componentToComponentTO(Component component);

    Component  componentTOToComponent(ComponentTO ComponentTO);

    List<ComponentTO> componentsToComponentTOs(List<Component> components);

    List<Component>  componentTOsToComponents(List<ComponentTO> ComponentTOs);

    ArticleTO articleToArticleTO(Article article);

    Article  articleTOToArticle(ArticleTO articleTO);

    List<ArticleTO> articlesToArticleTOs(List<Article> article);

    List<Article>   articleTOsToArticles(List<ArticleTO> articleTO);

    ProductTO productToProductTO(Product product);

    Product  productTOToProduct(ProductTO productTO);

    List<ProductTO> productsToProductTOs(List<Product> products);

    List<Product> productTOsToProduct(List<ProductTO> productTOs);

}
