package util;

import lombok.Getter;
import repository.*;
import repository.Impl.*;
import service.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ApplicationContext {

    private static final EntityManager entityManager =
            Persistence.createEntityManagerFactory("default")
                    .createEntityManager();

    private  static CustomerRepository customerRepository;
    private static CreditRepository creditRepository;
    private static ManagerRepository managerRepository;
    private static ServiceRepository serviceRepository;
    private static SpecialistRepository specialistRepository;

    private  static CustomerService customerService;
    private static SpecialistService specialistService;
    private static ManagerService managerService;
    private static ServiceService serviceService;

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
    public static ManagerRepository getManagerRepository() {
        if (managerRepository == null) {
            managerRepository = new ManagerRepositoryImpl(entityManager);
        }
        return managerRepository;
    }
    public static ServiceRepository getServiceRepository() {
        if (serviceRepository == null) {
            serviceRepository = new ServiceRepositoryImpl(entityManager);
        }
        return serviceRepository;
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
    public static ManagerService getManagerService() {
        if (managerService == null) {
            managerService = new ManagerServiceImpl(
                    getManagerRepository(),getServiceService()
            );
        }
        return managerService;
    }
    public static ServiceService getServiceService() {
        if (serviceService == null) {
            serviceService = new ServiceServiceImpl(
                    getServiceRepository()
            );
        }
        return serviceService;
    }

}
