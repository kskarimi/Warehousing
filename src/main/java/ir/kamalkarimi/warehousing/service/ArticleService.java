package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ArticleDto;
import ir.kamalkarimi.warehousing.dto.ArticleMapper;
import ir.kamalkarimi.warehousing.repository.ArticlesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final ArticlesManager articlesManager;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticlesManager articlesManager, ArticleMapper articleMapper) {
        this.articlesManager = articlesManager;
        this.articleMapper = articleMapper;
    }


    public ArticleDto index(ArticleDto articleDto){
        if (articleDto == null){
            return null;
        }
        return articleMapper.articleToDto(articlesManager.index(articleMapper.articleDtoToArticle(articleDto)));
    }

    public List<ArticleDto> index(List<ArticleDto> articleDtos){
        if (articleDtos == null || articleDtos.isEmpty()){
            return null;
        }

        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (ArticleDto articleDto : articleDtos) {
            if (articleDto == null)
                continue;
            articleDtoList.add(this.index(articleDto));
        }

        return articleDtoList;
    }
}
