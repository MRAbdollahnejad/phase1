package repository.Impl;

import base.repository.BaseUserRepositoryImpl;
import entity.Manager;
import repository.ManagerRepository;

import javax.persistence.EntityManager;

public class ManagerRepositoryImpl extends BaseUserRepositoryImpl<Manager> implements ManagerRepository {
    public ManagerRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Manager> getEntityClass() {
        return Manager.class;
    }
}
