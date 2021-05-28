package ir.kamalkarimi.warehousing.domain.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface BaseManager <T extends Base>{

    T index(T base);

    List<T> index(Iterable<T> base);

    T getById(long id);

    Optional<T> findOne(T example);

    List<T> findAll(T example);

    Page<T> findAll(T example, Pageable pageable);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    void deleteById(long id);

    void delete(T example);

    long count(T example);

    long count();

}
