package ir.kamalkarimi.warehousing.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.kamalkarimi.warehousing.dto.ArticleMapper;
import ir.kamalkarimi.warehousing.dto.ProductArticleMapper;
import ir.kamalkarimi.warehousing.dto.ProductMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    ArticleMapper articleMapper() {
        return ArticleMapper.ARTICLE_MAPPER;
    }

    @Bean
    ProductMapper productMapper() {
        return ProductMapper.PRODUCT_MAPPER;
    }

    @Bean
    ProductArticleMapper componentMapper() {
        return ProductArticleMapper.COMPONENT_MAPPER;}

    @Bean
    Gson gson() {
        return new GsonBuilder().create();
    }
}
