package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends Base> extends JpaRepository<T,Long> {
}
