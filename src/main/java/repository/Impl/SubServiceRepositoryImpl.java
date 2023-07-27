package repository.Impl;

import base.repository.BaseRepositoryImpl;
import entity.SubService;
import repository.SubServiceRepository;

import javax.persistence.EntityManager;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubService,Long> implements SubServiceRepository {
    public SubServiceRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }
}
