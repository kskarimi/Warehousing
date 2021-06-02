package ir.kamalkarimi.warehousing.service;

import ir.kamalkarimi.warehousing.dto.ArticleTO;
import ir.kamalkarimi.warehousing.dto.ArticleMapper;
import ir.kamalkarimi.warehousing.repository.ArticleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleManager articleManager;
    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleService(ArticleManager articleManager, ArticleMapper articleMapper) {
        this.articleManager = articleManager;
        this.articleMapper = articleMapper;
    }
}
