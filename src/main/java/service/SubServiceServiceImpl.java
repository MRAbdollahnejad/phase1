package service;

import base.service.BaseServiceImpl;
import entity.Service;
import entity.SubService;
import repository.SubServiceRepository;

import java.util.Optional;

public class SubServiceServiceImpl
        extends BaseServiceImpl<SubService, Long, SubServiceRepository>
        implements SubServiceService {

    public SubServiceServiceImpl(SubServiceRepository repository) {
        super(repository);
    }

    @Override
    public boolean existBySubServiceNameAndService(String subServiceName, Service service) {
        return repository.existBySubServiceNameAndService(subServiceName,service);
    }
}
