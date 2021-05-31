package ir.kamalkarimi.warehousing.service;
import ir.kamalkarimi.warehousing.dto.*;
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

    public  List<ProductDto> index(ProductsDto productsDto) {
        if (productsDto == null)
            return null;
        List<ProductItemDto> productItemDtos = productsDto.getProducts();
        if (productItemDtos == null || productItemDtos.isEmpty()){
            return null;
        }

        return use(productItemDtos);
    }

    public List<ProductDto> use(List<ProductItemDto> productItemDtos) {
        if (productItemDtos == null || productItemDtos.isEmpty()){
            return null;
        }
        List<ProductDto> productDtoList = new ArrayList<>();
        for (ProductItemDto productItemDto : productItemDtos) {
            if (productItemDto == null)
                continue;
            List<ArticleItemDto> articleItemDtos = productItemDto.getArticles();
            List<ArticleDto> articleDtoList = null;
            if (articleItemDtos != null && !articleItemDtos.isEmpty()){
                articleDtoList =  articleService.use(articleItemDtos);
            }
            ProductDto productDto = new ProductDto();
            productDto.setArticles(articleDtoList);
            productDto.setName(productItemDto.getName());

            productDtoList.add(productDto);
        }
        return productService.index(productDtoList);
    }
}
