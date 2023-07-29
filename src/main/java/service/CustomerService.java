package service;

import base.service.BaseUserService;
import dto.UserDTO;
import entity.Customer;

public interface CustomerService extends BaseUserService<Customer> {

    void customerSignUp(UserDTO userDTO);


}
