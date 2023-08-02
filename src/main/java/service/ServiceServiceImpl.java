package service;

import base.service.BaseServiceImpl;
import base.service.BaseUserServiceImpl;
import entity.Service;
import repository.ServiceRepository;

public class ServiceServiceImpl extends BaseServiceImpl<Service,Long, ServiceRepository> implements ServiceService {


    public ServiceServiceImpl(ServiceRepository repository) {
        super(repository);
    }

    @Override
    public boolean existByServiceName(String serviceName) {
        return repository.existByServiceName(serviceName);
    }
}
