package service;

import base.service.BaseServiceImpl;
import entity.Service;
import repository.ServiceRepository;

import java.util.Optional;

public class ServiceServiceImpl extends BaseServiceImpl<Service,Long, ServiceRepository> implements ServiceService {


    public ServiceServiceImpl(ServiceRepository repository) {
        super(repository);
    }

    @Override
    public boolean existByServiceName(String serviceName) {
        return repository.existByServiceName(serviceName);
    }

    @Override
    public Optional<Service> findByServiceName(String serviceName) {
        return repository.findByServiceName(serviceName);
    }
}
