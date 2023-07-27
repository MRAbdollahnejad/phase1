package repository.Impl;

import base.repository.BaseRepositoryImpl;
import entity.Offer;
import repository.OfferRepository;

import javax.persistence.EntityManager;

public class OfferRepositoryImpl extends BaseRepositoryImpl<Offer,Long> implements OfferRepository {
    public OfferRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Offer> getEntityClass() {
        return Offer.class;
    }
}
