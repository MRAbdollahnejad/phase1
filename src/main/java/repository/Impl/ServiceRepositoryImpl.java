package repository.Impl;

import base.repository.BaseRepositoryImpl;
import entity.Service;
import repository.ServiceRepository;

import javax.persistence.EntityManager;

public class ServiceRepositoryImpl extends BaseRepositoryImpl<Service,Long> implements ServiceRepository {
    public ServiceRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Service> getEntityClass() {
        return Service.class;
    }
}
