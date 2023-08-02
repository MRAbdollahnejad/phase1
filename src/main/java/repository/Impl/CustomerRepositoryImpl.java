package repository.Impl;

import base.repository.BaseUserRepositoryImpl;
import entity.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl
        extends BaseUserRepositoryImpl<Customer>
        implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
