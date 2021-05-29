package ir.kamalkarimi.warehousing.config;

import ir.kamalkarimi.warehousing.dto.ArticleMapper;
import ir.kamalkarimi.warehousing.dto.ProductMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    ArticleMapper articleMapper(){
        return ArticleMapper.ARTICLE_MAPPER;
    }

    @Bean
    ProductMapper productMapper(){
        return ProductMapper.PRODUCT_MAPPER;
    }
}
