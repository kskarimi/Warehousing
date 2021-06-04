package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface BaseManager <T extends Base>{

    T index(T base);

    List<T> index(List<T> base);

    T mount(T base);

    List<T> mount(List<T> base);

    T  saveAndFlush(T base);

    List<T> saveAllAndFlush(List<T> base);

    T getById(long id);

    T findOne(T example);

    List<T> findAll(T example);

    Page<T> findAll(T example, Pageable pageable);

    List<T> findAll();

    Page<T> findAll(Pageable pageable);

    void deleteById(long id);

    void delete(T example);

    long count(T example);

    long count();

}
