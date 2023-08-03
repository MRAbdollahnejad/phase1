package service;

import base.service.BaseUserService;
import dto.SubServiceDTO;
import entity.Manager;
import entity.SubService;

public interface ManagerService extends BaseUserService<Manager> {
    void createService(String serviceName);
    void addSubServiceToService(String serviceName, SubServiceDTO subserviceDTO);
    void addSpecialToSubService(String email, SubService SubService);
    void removeSpecialistFromSubService(String email,SubService subService);
    void confirmSpecialist(String email);
}
