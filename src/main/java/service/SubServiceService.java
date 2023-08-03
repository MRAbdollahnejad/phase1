package service;

import base.service.BaseService;
import entity.Service;
import entity.SubService;

import java.util.Optional;

public interface SubServiceService extends BaseService<SubService,Long> {
    boolean existBySubServiceNameAndService(String subServiceName, Service service);

}
