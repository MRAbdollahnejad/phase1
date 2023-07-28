import dto.CustomerDTO;
import repository.CustomerRepository;
import service.CustomerService;
import util.ApplicationContext;
import util.UserValidator;

public class Main {
    public static void main(String[] args) {

//        UserValidator userValidator=new UserValidator();
//        System.out.println(userValidator.passwordValidator("asdfQ1#23"));
//        System.out.println(userValidator.EmailValidator("Usasd2@gmail.com"));
        CustomerService customerService = ApplicationContext.getCustomerService();
        CustomerDTO customerDTO =new CustomerDTO();
        customerDTO.setFirstname("asdf");
        customerDTO.setLastname("asdf");
        customerDTO.setEmailAddress("usds2sd2@gmail.com");
        customerDTO.setPassword("asdfAuyf1#23");
        customerService.customerSignUp(customerDTO);

    }
}
