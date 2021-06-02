package ir.kamalkarimi.warehousing.dto;

import ir.kamalkarimi.warehousing.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductTO productToProductTO(Product product);

    Product  productTOToProduct(ProductTO productTO);

    List<ProductTO> productsToProductTOs(List<Product> products);

    List<Product> productTOsToProduct(List<ProductTO> productTOs);
}
