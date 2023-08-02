package service;

import base.service.BaseUserServiceImpl;
import dto.UserDTO;
import entity.Credit;
import entity.Customer;
import repository.CreditRepository;
import repository.CustomerRepository;
import util.UserValidator;

public class CustomerServiceImpl
        extends BaseUserServiceImpl<Customer,CustomerRepository>
        implements CustomerService {

    CreditRepository creditRepository;
    UserValidator userValidator = new UserValidator();

    public CustomerServiceImpl(CustomerRepository repository, CreditRepository creditRepository) {
        super(repository);
        this.creditRepository = creditRepository;
    }

    @Override
    public void customerSignUp(UserDTO userDTO) {
        Customer customer = new Customer();
        if (userDTO.getFirstname() != null && userDTO.getLastname() != null) {
            customer.setFirstname(userDTO.getFirstname());
            customer.setLastname(userDTO.getLastname());
            if (userDTO.getEmailAddress() != null) {
                String emailAddress = userDTO.getEmailAddress().toLowerCase();
                if (userValidator.EmailPatternValidator(emailAddress)) {
                    if (repository.isEmailUnique(emailAddress)) {
                        customer.setEmailAddress(emailAddress);
                        if (userValidator.passwordValidator(userDTO.getPassword())) {
                            customer.setPassword(userDTO.getPassword());
                            Credit credit=new Credit();
                            credit.setCredit(0D);
                            creditRepository.beginTransaction();
                            creditRepository.save(credit);
                            creditRepository.commitTransaction();
                            customer.setCredit(credit);
                            repository.beginTransaction();
                            repository.save(customer);
                            repository.commitTransaction();
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
                    userValidator.EmailPatternValidator(userDTO.getEmailAddress());
                } catch (NullPointerException e) {
                    System.out.println("email is empty");
                }
            }
        } else System.out.println("firstname or lastname can't be empty");
    }
}
