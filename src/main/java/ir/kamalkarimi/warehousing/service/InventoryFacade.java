package ir.kamalkarimi.warehousing.service;
import ir.kamalkarimi.warehousing.dto.ArticleDto;
import ir.kamalkarimi.warehousing.dto.InventoryDto;
import ir.kamalkarimi.warehousing.dto.ProductDto;
import ir.kamalkarimi.warehousing.dto.ProductsDto;
import ir.kamalkarimi.warehousing.model.Product;
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

    public InventoryDto index(InventoryDto inventoryDto) {
        if (inventoryDto == null)
            return null;
        ArticleDto []articleDtos = inventoryDto.getInventory();
        if (articleDtos == null){
            return null;
        }
        List<ArticleDto> articleDtoList = articleService.index(Arrays.asList(articleDtos));
        InventoryDto inventory = null;
        if (articleDtoList != null && !articleDtoList.isEmpty()){
            inventory = new InventoryDto();
            inventory.setInventory(articleDtoList.toArray(new ArticleDto[articleDtoList.size()]));
        }
        return inventory;
    }

    public  ProductsDto index(ProductsDto productsDto) {
        if (productsDto == null)
            return null;

        ProductDto[] productDtos = productsDto.getProducts();
        if (productDtos == null  || productDtos.length == 0)
            return null;

        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            if (productDto == null)
                continue;
            productDtoList.add(productService.index(productDto));
        }

        return new ProductsDto(productDtoList.toArray(new ProductDto[productDtoList.size()]));
    }
}
