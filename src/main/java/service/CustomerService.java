package service;

import dto.CustomerDTO;
import repository.CustomerRepository;
import repository.Impl.CustomerRepositoryImpl;

public interface CustomerService {

    void customerSignUp(CustomerDTO customerDTO);


}
