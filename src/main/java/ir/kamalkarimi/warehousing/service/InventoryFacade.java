package ir.kamalkarimi.warehousing.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryFacade {

    private final ArticleService articleService;
    private final ProductService productService;

    @Autowired
    public InventoryFacade(ArticleService articleService, ProductService productService) {
        this.articleService = articleService;
        this.productService = productService;
    }
}
