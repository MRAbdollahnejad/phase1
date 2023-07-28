package util;

import lombok.Getter;
import repository.CreditRepository;
import repository.CustomerRepository;
import repository.Impl.CreditRepositoryImpl;
import repository.Impl.CustomerRepositoryImpl;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationContext {

    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory("default")
                    .createEntityManager();

    private  static CustomerRepository customerRepository;
    private static CreditRepository creditRepository;
    private  static CustomerService customerService;

    public static CustomerRepository getCustomerRepository() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepositoryImpl(entityManager);
        }
        return customerRepository;
    }
    public static CreditRepository getCreditRepository() {
        if (creditRepository == null) {
            creditRepository = new CreditRepositoryImpl(entityManager);
        }
        return creditRepository;
    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl(
                    getCustomerRepository(),getCreditRepository()
            );
        }
        return customerService;
    }

}
