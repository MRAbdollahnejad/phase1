package repository.Impl;

import base.repository.BaseRepositoryImpl;
import entity.Credit;
import repository.CreditRepository;

import javax.persistence.EntityManager;

public class CreditRepositoryImpl extends BaseRepositoryImpl<Credit,Long> implements CreditRepository {
    public CreditRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Credit> getEntityClass() {
        return Credit.class;
    }
}
