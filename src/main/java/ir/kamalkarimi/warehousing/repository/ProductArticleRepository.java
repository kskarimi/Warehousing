package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Product;
import ir.kamalkarimi.warehousing.model.ProductArticle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductArticleRepository extends BaseRepository<ProductArticle> {
    @Query(value = "select p from ProductArticle  p where p.product = :product")
    List<ProductArticle> findByProduct(@Param("product") Product product);
}
