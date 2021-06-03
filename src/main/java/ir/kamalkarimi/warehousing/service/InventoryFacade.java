package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.*;
import ir.kamalkarimi.warehousing.dto.ProductTO;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

        if (baseUile.isNull(productTO))
            return null;

        productTO = productService.index(productTO);

        if (!articleService.isExists(articleTO)) {
            return null;
        }

        productArticleTO.setProduct(productTO);

        return productArticleService.index(productArticleTO);
    }
}
