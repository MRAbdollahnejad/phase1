package service;

import base.service.BaseUserServiceImpl;
import dto.SpecialistDTO;
import entity.Credit;
import entity.Specialist;
import exception.ImageException;
import repository.CreditRepository;
import repository.SpecialistRepository;
import util.ImageConvertToByte;
import util.UserValidator;

import java.io.FileNotFoundException;


public class SpecialistServiceImpl extends
        BaseUserServiceImpl<Specialist, SpecialistRepository>
        implements SpecialistService {

    CreditRepository creditRepository;
    UserValidator userValidator = new UserValidator();

    public SpecialistServiceImpl(SpecialistRepository repository, CreditRepository creditRepository) {
        super(repository);
        this.creditRepository = creditRepository;
    }

    @Override
    public void signupSpecialist(SpecialistDTO specialistDTO) {
        Specialist specialist = new Specialist();
        if (specialistDTO.getFirstname() != null && specialistDTO.getLastname() != null) {
            specialist.setFirstname(specialistDTO.getFirstname());
            specialist.setLastname(specialistDTO.getLastname());
            if (specialistDTO.getEmailAddress() != null) {
                String emailAddress = specialistDTO.getEmailAddress().toLowerCase();
                if (userValidator.EmailPatternValidator(emailAddress)) {
                    if (repository.isEmailUnique(emailAddress)) {
                        specialist.setEmailAddress(emailAddress);
                        if (userValidator.passwordValidator(specialistDTO.getPassword())) {
                            specialist.setPassword(specialistDTO.getPassword());
                            specialist.setScore(specialistDTO.getScore());
                            specialist.setStatus(specialistDTO.getStatus());

                            ImageConvertToByte imageConvertToByte = new ImageConvertToByte();
                            try {
                            byte[] bytes = imageConvertToByte.imageConvertToByte(specialistDTO.getImagePath());
                            specialist.setImage(bytes);
                            }catch (ImageException | FileNotFoundException e){
                                System.out.println(e.getMessage());
                            }
                            if (specialist.getImage()==null){
                                return;
                            }
                            Credit credit = new Credit();
                            credit.setCredit(0D);
                            creditRepository.save(credit);
                            specialist.setCredit(credit);
                            repository.save(specialist);
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
                    userValidator.EmailPatternValidator(specialistDTO.getEmailAddress());
                } catch (NullPointerException e) {
                    System.out.println("email is empty");
                }
            }
        } else System.out.println("firstname or lastname can't be empty");
    }

}
