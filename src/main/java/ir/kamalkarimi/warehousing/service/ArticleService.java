package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ArticleDto;
import ir.kamalkarimi.warehousing.dto.ArticleItemDto;
import ir.kamalkarimi.warehousing.dto.ArticleMapper;
import ir.kamalkarimi.warehousing.model.Article;
import ir.kamalkarimi.warehousing.repository.ArticlesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<ArticleDto> use(List<ArticleItemDto> articleItemDtos) {
        if (articleItemDtos == null || !articleItemDtos.isEmpty()){
            return null;
        }

        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (ArticleItemDto articleItemDto : articleItemDtos) {
            if (articleItemDto == null )
                continue;

            Long articleId = articleItemDto.getArticleId();
            Integer amount = Integer.valueOf(articleItemDto.getAmount());

            ArticleDto articleDto = articleMapper.articleToDto(articlesManager.use(articleId,amount));
            if (articleDto == null)
                continue;
            articleDtoList.add(articleDto);
        }
        return articleDtoList;
    }
}
