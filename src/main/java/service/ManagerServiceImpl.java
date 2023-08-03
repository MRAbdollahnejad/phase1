package service;

import base.service.BaseUserServiceImpl;
import dto.SubServiceDTO;
import entity.Manager;
import entity.Service;
import entity.SubService;
import exception.ServiceNotFoundException;
import exception.SubServiceException;
import repository.ManagerRepository;
import java.util.Optional;


public class ManagerServiceImpl
        extends BaseUserServiceImpl<Manager, ManagerRepository>
        implements ManagerService {

    ServiceService serviceService;
    SubServiceService subServiceService;

    public ManagerServiceImpl(ManagerRepository repository, ServiceService serviceService,
                              SubServiceService subServiceService) {
        super(repository);
        this.serviceService = serviceService;
        this.subServiceService=subServiceService;
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

    @Override
    public void addSubServiceToService(String serviceName, SubServiceDTO subserviceDTO) {
        if (serviceService.existByServiceName(serviceName.toLowerCase().replaceAll("\\s", ""))){
            SubService subService=new SubService();
            String subServiceDTOName = subserviceDTO.getName();
            Optional<Service> byServiceName = serviceService.findByServiceName(serviceName.toLowerCase().replaceAll("\\s", ""));
            boolean present = byServiceName.isPresent();
            if (present){
                Service service = byServiceName.get();
                subService.setService(service);
                if (subServiceService.existBySubServiceNameAndService(subServiceDTOName,service)){
                    throw new SubServiceException("sub service with this name is exist already");
                }
                subService.setName(subServiceDTOName);
                subService.setDescription(subserviceDTO.getDescription());
                subService.setPrice(subserviceDTO.getPrice());
                subServiceService.save(subService);
            }
        }else {
            throw new ServiceNotFoundException("service with this name not found ");
        }
    }

}
