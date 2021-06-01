package ir.kamalkarimi.warehousing.service;
import ir.kamalkarimi.warehousing.dto.*;
import ir.kamalkarimi.warehousing.dto.article.ItemTO;
import ir.kamalkarimi.warehousing.dto.article.ArticleTO;
import ir.kamalkarimi.warehousing.dto.product.ProductTO;
import ir.kamalkarimi.warehousing.dto.product.ProductsTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (articleTOS == null){
            return null;
        }
        List<ArticleTO> articleTOList = articleService.index(Arrays.asList(articleTOS));
        InventoryTO inventory = null;
        if (articleTOList != null && !articleTOList.isEmpty()){
            inventory = new InventoryTO();
            inventory.setInventory(articleTOList.toArray(new ArticleTO[articleTOList.size()]));
        }
        return inventory;
    }

    public  List<ProductTO> index(ProductsTO productsTO) {
        if (productsTO == null)
            return null;
        List<ir.kamalkarimi.warehousing.dto.product.ItemTO> itemTOS = productsTO.getProducts();
        if (itemTOS == null || itemTOS.isEmpty()){
            return null;
        }

        return use(itemTOS);
    }

    public List<ProductTO> use(List<ir.kamalkarimi.warehousing.dto.product.ItemTO> itemTOS) {
        if (itemTOS == null || itemTOS.isEmpty()){
            return null;
        }
        List<ProductTO> productTOList = new ArrayList<>();
        for (ir.kamalkarimi.warehousing.dto.product.ItemTO itemTO : itemTOS) {
            if (itemTO == null)
                continue;
            List<ItemTO> articleItemTOS = itemTO.getArticles();
            List<ArticleTO> articleTOList = null;
            if (articleItemTOS != null && !articleItemTOS.isEmpty()){
                articleTOList =  articleService.use(articleItemTOS);
            }
            ProductTO productTO = new ProductTO();
            productTO.setArticles(articleTOList);
            productTO.setName(itemTO.getName());

            productTOList.add(productTO);
        }
        return productService.index(productTOList);
    }
}
