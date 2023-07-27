package base.repository;

import base.entity.BaseUserEntity;

import javax.persistence.EntityManager;

public abstract class BaseUserRepositoryImpl<E extends BaseUserEntity>
        extends BaseRepositoryImpl<E,Long>
        implements BaseUserRepository<E> {

    public BaseUserRepositoryImpl(EntityManager em) {
        super(em);
    }



}
