package service;

import dto.CustomerDTO;
import entity.Credit;
import entity.Customer;
import repository.CreditRepository;
import repository.CustomerRepository;
import util.UserValidator;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    CreditRepository creditRepository;
    UserValidator userValidator = new UserValidator();

    public CustomerServiceImpl(CustomerRepository customerRepository, CreditRepository creditRepository) {
        this.customerRepository = customerRepository;
        this.creditRepository = creditRepository;
    }

    @Override
    public void customerSignUp(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        if (customerDTO.getFirstname() != null && customerDTO.getLastname() != null) {
            customer.setFirstname(customerDTO.getFirstname());
            customer.setLastname(customerDTO.getLastname());
            if (customerDTO.getEmailAddress() != null) {
                String emailAddress = customerDTO.getEmailAddress().toLowerCase();
                if (userValidator.EmailPatternValidator(emailAddress)) {
                    if (customerRepository.isEmailUnique(emailAddress)) {
                        customer.setEmailAddress(emailAddress);
                        if (userValidator.passwordValidator(customerDTO.getPassword())) {
                            customer.setPassword(customerDTO.getPassword());
                            Credit credit=new Credit();
                            credit.setCredit(0D);
                            creditRepository.beginTransaction();
                            creditRepository.save(credit);
                            creditRepository.commitTransaction();
                            customer.setCredit(credit);
                            customerRepository.beginTransaction();
                            customerRepository.save(customer);
                            customerRepository.commitTransaction();
                        } else {
                            System.out.println("Minimum eight characters, at least one uppercase letter," +
                                    " one lowercase letter, one number and one special character");
                        }
                    } else {
                        System.out.println("email exist already");
                    }
                } else {
                    System.out.println("email pattern is not correct");
                }
            } else {
                try {
                    userValidator.EmailPatternValidator(customerDTO.getEmailAddress());
                } catch (NullPointerException e) {
                    System.out.println("email is empty");
                }
            }
        } else System.out.println("firstname and lastname can't be empty");
    }
}
