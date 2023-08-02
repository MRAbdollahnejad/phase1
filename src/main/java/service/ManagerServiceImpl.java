package service;

import base.service.BaseUserServiceImpl;
import entity.Manager;
import entity.Service;
import repository.ManagerRepository;
import repository.ServiceRepository;

public class ManagerServiceImpl
        extends BaseUserServiceImpl<Manager, ManagerRepository>
        implements ManagerService {

    ServiceService serviceService;

    public ManagerServiceImpl(ManagerRepository repository, ServiceService serviceService) {
        super(repository);
        this.serviceService = serviceService;
    }

    @Override
    public void createService(String serviceName) {
        String lowerCaseServiceName = serviceName.toLowerCase().replaceAll("\\s", "");
        if (serviceService.existByServiceName(lowerCaseServiceName)) {
            System.out.println(" service " + serviceName + " is exist already");
        } else {
            Service service = new Service();
            service.setName(serviceName);
            service.setDatabaseName(lowerCaseServiceName);
            serviceService.save(service);
        }
    }
}
