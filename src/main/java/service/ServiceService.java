package service;

import base.service.BaseService;
import entity.Service;

import java.util.Optional;

public interface ServiceService extends BaseService<Service,Long> {
    boolean existByServiceName(String serviceName);
    Optional<Service> findByServiceName(String serviceName);

}
