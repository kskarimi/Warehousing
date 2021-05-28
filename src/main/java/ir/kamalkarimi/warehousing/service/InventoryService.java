package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.util.BaseUtil;
import ir.kamalkarimi.warehousing.domain.articles.ArticlesManager;
import ir.kamalkarimi.warehousing.domain.products.ProductManager;
import ir.kamalkarimi.warehousing.dto.BaseTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;


@Service
public class InventoryService implements BaseService {

    private final BaseUtil baseUtil;
    private final ArticlesManager articlesManager;
    private final ProductManager productManager;

    @Autowired
    public InventoryService(BaseUtil baseUtil, ArticlesManager articlesManager, ProductManager productManager) {
        this.baseUtil = baseUtil;
        this.articlesManager = articlesManager;
        this.productManager = productManager;
    }

    public void index(Map<String , List<BaseTO>> baseToMaps){
        if (baseToMaps == null){
            return ;
        }
        if (baseToMaps.isEmpty()){
            return;
        }
        baseToMaps.keySet().forEach(key->{
            if (StringUtils.hasLength(key)){
                this.index(baseToMaps.get(key));
            }
        });
    }

    public List<BaseTO> index(List<BaseTO> baseTOS){
        return null;
    }
}
