package repository.Impl;

import base.repository.BaseRepositoryImpl;
import entity.Order;
import repository.OrderRepository;

import javax.persistence.EntityManager;

public class OrderRepositoryImpl extends BaseRepositoryImpl<Order,Long> implements OrderRepository {
    public OrderRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Order> getEntityClass() {
        return Order.class;
    }
}
