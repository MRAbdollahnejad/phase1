package repository.Impl;

import base.repository.BaseRepositoryImpl;
import entity.Service;
import entity.SubService;
import repository.SubServiceRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

public class SubServiceRepositoryImpl extends BaseRepositoryImpl<SubService,Long> implements SubServiceRepository {
    public SubServiceRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }

    @Override
    public boolean existBySubServiceNameAndService(String subServiceName, Service service) {
        return em.createQuery("select s from SubService s where s.name=:subName and s.service=:service", getEntityClass())
                .setParameter("subName", subServiceName).setParameter("service", service).getResultList().size()!=0;
    }

}
