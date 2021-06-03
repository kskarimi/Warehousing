package ir.kamalkarimi.warehousing.repository;

import ir.kamalkarimi.warehousing.model.Base;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public abstract class BaseManagerImpl<T extends Base> implements BaseManager<T> {

    protected abstract BaseRepository<T> getRepository();

    @Override
    @Transactional
    public T index(T base) {
        return getRepository().save(base);
    }

    @Override
    @Transactional
    public List<T> index(List<T> base) {
        return getRepository().saveAll(base);
    }

    @Override
    public T saveAndFlush(T base) {
        return getRepository().saveAndFlush(base);
    }

    @Override
    public List<T> saveAllAndFlush(List<T> base) {
        return getRepository().saveAllAndFlush(base);
    }

    @Override
    public T getById(long id) {
        return getRepository().getById(id);
    }

    @Override
    public T  findOne(T example) {
        Example<T> probe = Example.of(example);
        Optional<T> one = getRepository().findOne(probe);
        return one.orElse(null);
    }

    @Override
    public List<T> findAll(T example) {
        return getRepository().findAll(Example.of(example));
    }

    @Override
    public Page<T> findAll(T example, Pageable pageable) {
        return getRepository().findAll(Example.of(example),pageable);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public void deleteById(long id) {
        T probe = getById(id);
        this.delete(probe);
    }

    @Override
    public void delete(T example) {
        if (example == null)
            return;
        T probe = this.findOne(example);
        if (probe == null)
            return;
        getRepository().delete(probe);
    }

    @Override
    public long count(T example) {
        return getRepository().count(Example.of(example));
    }

    @Override
    public long count() {
        return getRepository().count();
    }
}
