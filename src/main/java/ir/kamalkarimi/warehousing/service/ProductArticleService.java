package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.aop.ExceptionLoggerAop;
import ir.kamalkarimi.warehousing.dto.ProductArticleMapper;
import ir.kamalkarimi.warehousing.dto.ProductArticleTO;
import ir.kamalkarimi.warehousing.dto.ProductTO;
import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.model.Product;
import ir.kamalkarimi.warehousing.model.ProductArticle;
import ir.kamalkarimi.warehousing.repository.ProductArticleManager;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductArticleService {


    private final ProductArticleManager productArticleManager;

    private final ProductArticleMapper productArticleMapper;

    private final BaseUtil baseUtil;

    private static  final Logger LOGGER = LoggerFactory.getLogger(ProductArticleService.class);

    @Autowired
    public ProductArticleService(ProductArticleManager productArticleManager, ProductArticleMapper productArticleMapper, BaseUtil baseUtil) {
        this.productArticleManager = productArticleManager;
        this.productArticleMapper = productArticleMapper;
        this.baseUtil = baseUtil;
    }

    public ProductArticleTO index(ProductArticleTO productArticleTO) {
        if (baseUtil.isNull(productArticleTO))
            return null;
        ProductArticle probe = productArticleMapper.productArticleTOToProductArticle(productArticleTO);
        probe = productArticleManager.mount(probe);
        productArticleTO = productArticleMapper.productArticleToProductArticleTO(probe);

        return productArticleTO;

    }


    public boolean isExist(ProductArticleTO productArticleTO){
        if (baseUtil.isNull(productArticleTO))
            return false;
        ProductArticle probe = productArticleMapper.productArticleTOToProductArticle(productArticleTO);
        return !baseUtil.isNull(productArticleManager.findOne(probe));
    }

    public List<ProductArticleTO> findByProduct(ProductTO productTO) {
        if (baseUtil.isNull(productTO))
            return null;

       List<ProductArticle> productArticles = productArticleManager.findByProduct(productArticleMapper.productTOToProduct(productTO));

       return productArticleMapper.productArticlesToProductArticleTOs(productArticles);
    }
}
