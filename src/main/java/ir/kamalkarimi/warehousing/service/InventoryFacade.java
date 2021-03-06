package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.*;
import ir.kamalkarimi.warehousing.dto.ProductTO;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;


@Service
public class InventoryFacade {

    private final ArticleService articleService;
    private final ProductService productService;
    private final ProductArticleService productArticleService;
    private final BaseUtil baseUtil;

    private static  final Logger LOGGER = LoggerFactory.getLogger(InventoryFacade.class);

    @Autowired
    public InventoryFacade(ArticleService articleService, ProductService productService, ProductArticleService productArticleService, BaseUtil baseUtil) {
        this.articleService = articleService;
        this.productService = productService;
        this.productArticleService = productArticleService;
        this.baseUtil = baseUtil;
    }

    public ProductArticleTO loadingProduct(ProductArticleTO productArticleTO) {

        if (baseUtil.isNull(productArticleTO))
            return null;

        ProductTO productTO = productArticleTO.getProduct();
        ArticleTO articleTO = productArticleTO.getArticle();
        Integer amount      = productArticleTO.getProductAmount();

        if (baseUtil.isNull(productTO))
            return null;

        productTO = productService.index(productTO);

        if (!articleService.isExists(articleTO)) {
            return null;
        }else {
            articleTO = articleService.fndById(articleTO.getId());
        }

        if (baseUtil.isNull(articleTO))
            return null;

        return productArticleService.index(new ProductArticleTO(null,productTO,articleTO,amount));
    }

    public Set<ProductTO> loadingProduct(List<ProductsTO> productsTOList) {
        if (baseUtil.isNull(productsTOList))
            return null;

        Set<ProductTO> productTOS = new HashSet<>();
        for (ProductsTO productsTO : productsTOList) {
            if (baseUtil.isNull(productsTO))
                continue;

            List<ArticleTO> articleTOS = Arrays.asList(productsTO.getArticles());
            if (baseUtil.isNull(articleTOS))
                continue;

            ProductArticleTO productArticleTO = new ProductArticleTO();
            productArticleTO.setProduct(new ProductTO(productsTO.getName()));

            for (ArticleTO articleTO : articleTOS) {
                if (baseUtil.isNull(articleTO))
                    continue;
                productArticleTO.setProductAmount(articleTO.getStock());
                productArticleTO.setArticle(articleTO);

                productArticleTO = this.loadingProduct(productArticleTO);
                if (!baseUtil.isNull(productArticleTO)){
                    productTOS.add(productArticleTO.getProduct());
                }else{
                    LOGGER.info("Not fount products!");
                    break;
                }
            }
        }
        return productTOS;
    }

    public InventoryTO productInventory(ProductTO productTO){
        if (baseUtil.isNull(productTO)){
            return new InventoryTO();
        }

        List<ProductArticleTO> productArticleTOS = productArticleService.findByProduct(productTO);

        int inventory = Integer.MAX_VALUE;
        boolean isAvailable = false;
        ProductTO product = null;


        for (ProductArticleTO productArticleTO : productArticleTOS) {
            if (baseUtil.isNull(productArticleTO))
                continue;
            Integer amount  = productArticleTO.getProductAmount();
            ArticleTO articleTO = productArticleTO.getArticle();

            if (baseUtil.isNull(product)){
                product = productArticleTO.getProduct();
            }

            if (baseUtil.isNull(articleTO)){
                isAvailable = false;
                break;
            }

            Integer stock = articleTO.getStock();
            if (!baseUtil.isNull(stock) && !baseUtil.isNull(amount)){
                if (stock >= amount){
                    int count = stock/amount;
                    if (count <= inventory){
                        isAvailable = true;
                        inventory = count;
                    }
                }else {
                    inventory = 0;
                    isAvailable = false;
                }
            }

        }
        inventory = inventory == Integer.MAX_VALUE ? 0:inventory;
        String productName = product == null ? "":product.getName();
        return new InventoryTO(productName,inventory,isAvailable);
    }

    public InventoryTO buy(String productName, String orderCount) {
        if (!StringUtils.hasText(productName) || !StringUtils.hasText(orderCount))
            return null;
        int count = Integer.parseInt(orderCount);

        if(count <=0 )
            return null;

        ProductTO productTO = productService.findByName(productName);

        if (baseUtil.isNull(productTO))
            return null;

        InventoryTO inventoryTO = this.productInventory(productTO);
        if (baseUtil.isNull(inventoryTO) || !inventoryTO.isAvailable()){
            return null;
        }

        List<ProductArticleTO> productArticleTO = productArticleService.findByProduct(productTO);
        if (baseUtil.isNull(productArticleTO)){
            return null;
        }

        for (ProductArticleTO productArticle : productArticleTO) {
            if (baseUtil.isNull(productArticle)){
                return null;
            }
            ArticleTO articleTO = productArticle.getArticle();
            int amount = articleTO.getStock() - productArticle.getProductAmount()*count;
            if (amount < 0){
                return null;
            }
            articleTO.setStock(amount);
            articleService.index(articleTO);
        }

        return this.productInventory(productTO);
    }
}
