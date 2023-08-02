package service;

import base.service.BaseUserService;
import dto.SubServiceDTO;
import entity.Manager;

public interface ManagerService extends BaseUserService<Manager> {
    void createService(String serviceName);
    void addSubServiceToService(String serviceName, SubServiceDTO subserviceDTO);
}
