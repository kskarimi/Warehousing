package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ProductArticleMapper;
import ir.kamalkarimi.warehousing.repository.ProductArticleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentService {

    private final ProductArticleMapper productArticleMapper;

    private final ProductArticleManager productArticleManager;

    @Autowired
    public ComponentService(ProductArticleMapper productArticleMapper, ProductArticleManager productArticleManager) {
        this.productArticleMapper = productArticleMapper;
        this.productArticleManager = productArticleManager;
    }

}
