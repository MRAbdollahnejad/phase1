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


}
