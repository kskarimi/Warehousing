package ir.kamalkarimi.warehousing.mapper;

import ir.kamalkarimi.warehousing.util.BaseUtil;
import ir.kamalkarimi.warehousing.domain.products.Product;
import ir.kamalkarimi.warehousing.dto.ProductTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapper implements Mapper<ProductTO, Product> {

    private final ArticleMapper articleMapper;
    private final BaseUtil baseUtil;

    @Autowired
    public ProductMapper(ArticleMapper articleMapper,BaseUtil baseUtil) {
        this.articleMapper = articleMapper;
        this.baseUtil = baseUtil;
    }

    @Override
    public ProductTO toDTO(Product entity) {
        if (baseUtil.isNullEntity(entity))
            return null;
        ProductTO productTO = new ProductTO();
        productTO.setName(entity.getName());
        productTO.setArticles(articleMapper.toDTOS(entity.getArticles()));
        return productTO;
    }

    @Override
    public List<ProductTO> toDTOS(List<Product> entities) {
        if (baseUtil.isNullEntity(entities))
            return null;
        List<ProductTO> productTOS = new ArrayList<>();
        entities.forEach(e->productTOS.add(this.toDTO(e)));
        return productTOS;
    }

    @Override
    public Product toEntity(ProductTO dto) {
        if (baseUtil.isNullDTO(dto))
            return null;
        Product product = new Product();
        product.setName(dto.getName());
        product.setArticles(articleMapper.toEntities(dto.getArticles()));
        return product;
    }

    @Override
    public List<Product> toEntities(List<ProductTO> dtos) {
        if (baseUtil.isNullDTO(dtos))
            return null;
        List<Product> products = new ArrayList<>();
        dtos.forEach(t-> {
            if (!baseUtil.isNullDTO(t)){
                products.add(this.toEntity(t));
            }
        });
        return products;
    }
}
