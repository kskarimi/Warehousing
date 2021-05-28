package ir.kamalkarimi.warehousing.domain.articles;

import ir.kamalkarimi.warehousing.domain.base.BaseManagerImpl;
import ir.kamalkarimi.warehousing.domain.base.BaseRepository;
import ir.kamalkarimi.warehousing.dto.ArticleDTO;
import ir.kamalkarimi.warehousing.mapper.ArticleMapper;
import ir.kamalkarimi.warehousing.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesManager extends BaseManagerImpl<Article> {

    private final ArticlesRepository repository;
    private final ArticleMapper articleMapper;
    private final BaseUtil baseUtil;

    @Autowired
    public ArticlesManager(ArticlesRepository repository, ArticleMapper articleMapper, BaseUtil baseUtil) {
        this.repository = repository;
        this.articleMapper = articleMapper;
        this.baseUtil = baseUtil;
    }

    @Override
    protected BaseRepository<Article> getRepository() {
        return repository;
    }

    public ArticleDTO index(ArticleDTO articleDTO){
        if (!baseUtil.isNullDTO(articleDTO)){
            return null;
        }
        return articleMapper.toDTO(this.index(articleMapper.toEntity(articleDTO)));
    }

    public List<ArticleDTO> index(List<ArticleDTO> articleDTOS) {
        if (baseUtil.isNullDTO(articleDTOS))
            return null;
        return articleMapper.toDTOS(this.index(articleMapper.toEntities(articleDTOS)));
    }
}
