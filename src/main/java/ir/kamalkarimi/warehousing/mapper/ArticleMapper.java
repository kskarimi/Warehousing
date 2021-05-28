package ir.kamalkarimi.warehousing.mapper;

import ir.kamalkarimi.warehousing.domain.articles.Article;
import ir.kamalkarimi.warehousing.dto.ArticleDTO;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleMapper implements Mapper<ArticleDTO, Article> {

    private final BaseUtil baseUtil;
    @Autowired
    public ArticleMapper(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Override
    public ArticleDTO toDTO(Article entity) {
        if (baseUtil.isNullEntity(entity))
            return null;
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setId(String.valueOf(entity.getId()));
        articleDTO.setName(entity.getName());
        articleDTO.setStock(String.valueOf(entity.getStock()));
        return articleDTO;
    }

    @Override
    public List<ArticleDTO> toDTOS(List<Article> entities) {
        if (baseUtil.isNullEntity(entities))
            return null;
        List<ArticleDTO> articleDTOS = new ArrayList<>();
        entities.forEach(e-> articleDTOS.add(this.toDTO(e)));
        return articleDTOS;
    }

    @Override
    public Article toEntity(ArticleDTO dto) {
        if (baseUtil.isNullDTO(dto))
            return null;
        Article article = new Article();
        article.setName(dto.getName());
        article.setId(Long.valueOf(dto.getId()));
        article.setStock(Integer.valueOf(dto.getStock()));
        return article;
    }

    @Override
    public List<Article> toEntities(List<ArticleDTO> dtos) {
        if (baseUtil.isNullDTO(dtos))
            return null;
        List<Article> articles = new ArrayList<>();
        dtos.forEach(t-> {
            if (!baseUtil.isNullDTO(t)){
                articles.add(this.toEntity(t));
            }
        });
        return articles;
    }
}
