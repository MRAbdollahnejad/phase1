package util;

import lombok.Getter;
import repository.CreditRepository;
import repository.CustomerRepository;
import repository.Impl.CreditRepositoryImpl;
import repository.Impl.CustomerRepositoryImpl;
import repository.Impl.SpecialistRepositoryImpl;
import repository.SpecialistRepository;
import service.CustomerService;
import service.CustomerServiceImpl;
import service.SpecialistService;
import service.SpecialistServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationContext {

    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory("default")
                    .createEntityManager();

    private  static CustomerRepository customerRepository;
    private static CreditRepository creditRepository;
    private  static CustomerService customerService;
    private static SpecialistRepository specialistRepository;
    private static SpecialistService specialistService;

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
    public static SpecialistRepository getSpecialistRepository() {
        if (specialistRepository == null) {
            specialistRepository = new SpecialistRepositoryImpl(entityManager);
        }
        return specialistRepository;
    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerServiceImpl(
                    getCustomerRepository(),getCreditRepository()
            );
        }
        return customerService;
    }
    public static SpecialistService getSpecialistService() {
        if (specialistService == null) {
            specialistService = new SpecialistServiceImpl(
                    getSpecialistRepository(),getCreditRepository()
            );
        }
        return specialistService;
    }

}
