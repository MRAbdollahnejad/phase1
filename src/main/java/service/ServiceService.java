package service;

import base.service.BaseService;
import entity.Service;

public interface ServiceService extends BaseService<Service,Long> {
    boolean existByServiceName(String serviceName);

}