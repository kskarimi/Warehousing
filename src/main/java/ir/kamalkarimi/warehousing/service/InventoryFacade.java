package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.*;
import ir.kamalkarimi.warehousing.dto.article.ArticleItemTO;
import ir.kamalkarimi.warehousing.dto.article.ArticleTO;
import ir.kamalkarimi.warehousing.dto.product.ProductTO;
import ir.kamalkarimi.warehousing.dto.product.ProductsTO;
import ir.kamalkarimi.warehousing.dto.product.productItemTO;
import ir.kamalkarimi.warehousing.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class InventoryFacade {

    private final ArticleService articleService;
    private final ProductService productService;

    @Autowired
    public InventoryFacade(ArticleService articleService, ProductService productService) {
        this.articleService = articleService;
        this.productService = productService;
    }

    public InventoryTO index(InventoryTO inventoryTO) {
        if (inventoryTO == null)
            return null;
        ArticleTO[] articleTOS = inventoryTO.getInventory();
        if (articleTOS == null) {
            return null;
        }
        List<ArticleTO> articleTOList = articleService.index(Arrays.asList(articleTOS));
        InventoryTO inventory = null;
        if (articleTOList != null && !articleTOList.isEmpty()) {
            inventory = new InventoryTO();
            inventory.setInventory(articleTOList.toArray(new ArticleTO[articleTOList.size()]));
        }
        return inventory;
    }

    public List<ProductTO> index(ProductsTO productsTO) {
        if (productsTO == null)
            return null;
        List<productItemTO> productItemTOS = productsTO.getProducts();
        if (productItemTOS == null || productItemTOS.isEmpty()) {
            return null;
        }

        return use(productItemTOS);
    }

    public List<ProductTO> use(List<productItemTO> productItemTOS) {
        if (productItemTOS == null || productItemTOS.isEmpty()) {
            return null;
        }
        List<ProductTO> productTOList = new ArrayList<>();
        for (productItemTO productItemTO : productItemTOS) {
            if (productItemTO == null)
                continue;
            List<ArticleItemTO> articleItemTOS = productItemTO.getArticles();
            List<ArticleTO> articleTOList = null;
            if (articleItemTOS != null && !articleItemTOS.isEmpty()) {
                articleTOList = articleService.use(articleItemTOS);
            }
            ProductTO productTO = new ProductTO();
            productTO.setArticles(articleTOList);
            productTO.setName(productItemTO.getName());

            productTOList.add(productTO);
        }
        return productService.index(productTOList);
    }
}
