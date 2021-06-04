package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.*;
import ir.kamalkarimi.warehousing.dto.ProductTO;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class InventoryFacade {

    private final ArticleService articleService;
    private final ProductService productService;
    private final ProductArticleService productArticleService;
    private final BaseUtil baseUile;

    @Autowired
    public InventoryFacade(ArticleService articleService, ProductService productService, ProductArticleService productArticleService, BaseUtil baseUile) {
        this.articleService = articleService;
        this.productService = productService;
        this.productArticleService = productArticleService;
        this.baseUile = baseUile;
    }

    public ProductArticleTO loadingProduct(ProductArticleTO productArticleTO) {

        if (baseUile.isNull(productArticleTO))
            return null;

        ProductTO productTO = productArticleTO.getProduct();
        ArticleTO articleTO = productArticleTO.getArticle();
        Integer amount      = productArticleTO.getProductAmount();

        if (baseUile.isNull(productTO))
            return null;

        productTO = productService.index(productTO);

        if (!articleService.isExists(articleTO)) {
            return null;
        }else {
            articleTO = articleService.fndById(articleTO.getId());
        }

        if (baseUile.isNull(articleTO))
            return null;

        return productArticleService.index(new ProductArticleTO(null,productTO,articleTO,amount));
    }

    public Set<ProductTO> loadingProduct(List<ProductsTO> productsTOList) {
        if (baseUile.isNull(productsTOList))
            return null;

        Set<ProductTO> productTOS = new HashSet<>();
        for (ProductsTO productsTO : productsTOList) {
            if (baseUile.isNull(productsTO))
                continue;

            List<ArticleTO> articleTOS = Arrays.asList(productsTO.getArticles());
            if (baseUile.isNull(articleTOS))
                continue;

            ProductArticleTO productArticleTO = new ProductArticleTO();
            productArticleTO.setProduct(new ProductTO(productsTO.getName()));

            for (ArticleTO articleTO : articleTOS) {
                if (baseUile.isNull(articleTO))
                    continue;
                productArticleTO.setProductAmount(articleTO.getStock());
                productArticleTO.setArticle(articleTO);

                productArticleTO = this.loadingProduct(productArticleTO);
                productTOS.add(productArticleTO.getProduct());
            }
        }
        return productTOS;
    }
}
