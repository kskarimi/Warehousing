package ir.kamalkarimi.warehousing.mapper;

import ir.kamalkarimi.warehousing.util.BaseUtil;
import ir.kamalkarimi.warehousing.domain.products.Product;
import ir.kamalkarimi.warehousing.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMapper implements Mapper<ProductDTO, Product> {

    private final ArticleMapper articleMapper;
    private final BaseUtil baseUtil;

    @Autowired
    public ProductMapper(ArticleMapper articleMapper,BaseUtil baseUtil) {
        this.articleMapper = articleMapper;
        this.baseUtil = baseUtil;
    }

    @Override
    public ProductDTO toDTO(Product entity) {
        if (baseUtil.isNullEntity(entity))
            return null;
        ProductDTO productTO = new ProductDTO();
        productTO.setName(entity.getName());
        productTO.setArticles(articleMapper.toDTOS(entity.getArticles()));
        return productTO;
    }

    @Override
    public List<ProductDTO> toDTOS(List<Product> entities) {
        if (baseUtil.isNullEntity(entities))
            return null;
        List<ProductDTO> productTOS = new ArrayList<>();
        entities.forEach(e->productTOS.add(this.toDTO(e)));
        return productTOS;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        if (baseUtil.isNullDTO(dto))
            return null;
        Product product = new Product();
        product.setName(dto.getName());
        product.setArticles(articleMapper.toEntities(dto.getArticles()));
        return product;
    }

    @Override
    public List<Product> toEntities(List<ProductDTO> dtos) {
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
