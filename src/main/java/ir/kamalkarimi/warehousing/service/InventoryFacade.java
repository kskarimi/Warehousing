package ir.kamalkarimi.warehousing.service;
import ir.kamalkarimi.warehousing.dto.ArticleDto;
import ir.kamalkarimi.warehousing.dto.InventoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            inventoryDto.setInventory(articleDtoList.toArray(new ArticleDto[articleDtoList.size()]));
        }
        return inventory;
    }
}
