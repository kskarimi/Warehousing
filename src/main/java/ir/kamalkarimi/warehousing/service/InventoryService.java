package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.util.BaseUtil;
import ir.kamalkarimi.warehousing.repository.ArticlesManager;
import ir.kamalkarimi.warehousing.repository.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryService {

    private final BaseUtil baseUtil;
    private final ArticlesManager articlesManager;
    private final ProductManager productManager;

    @Autowired
    public InventoryService(BaseUtil baseUtil, ArticlesManager articlesManager, ProductManager productManager) {
        this.baseUtil = baseUtil;
        this.articlesManager = articlesManager;
        this.productManager = productManager;
    }
}
