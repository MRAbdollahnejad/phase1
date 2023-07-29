package base.service;

import base.entity.BaseEntity;
import base.repository.BaseRepository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T save(T t) {
        repository.beginTransaction();
        T save = repository.save(t);
        repository.commitTransaction();
        return save;
    }

    @Override
    public List<T> saveALl(Collection<T> ts) {
        repository.beginTransaction();
        List<T> ts1 = repository.saveALl(ts);
        repository.commitTransaction();
        return ts1;
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }


    @Override
    public void deleteById(ID id) {
        repository.beginTransaction();
        repository.deleteById(id);
        repository.commitTransaction();
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }


}
