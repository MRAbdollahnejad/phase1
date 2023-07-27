package repository.Impl;

import base.repository.BaseRepositoryImpl;
import entity.CustomerOpinion;
import repository.CustomerOpinionRepository;
import repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerOpinionRepositoryImpl extends BaseRepositoryImpl<CustomerOpinion,Long>
        implements CustomerOpinionRepository {
    public CustomerOpinionRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<CustomerOpinion> getEntityClass() {
        return CustomerOpinion.class;
    }
}
