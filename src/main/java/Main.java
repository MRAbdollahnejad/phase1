import dto.SpecialistDTO;
import service.ManagerService;
import service.SpecialistService;
import util.ApplicationContext;

public class Main {
    public static void main(String[] args)  {

//        UserValidator userValidator=new UserValidator();
//        System.out.println(userValidator.passwordValidator("asdfQ1#23"));
//        System.out.println(userValidator.EmailValidator("Usasd2@gmail.com"));
//        CustomerService customerService = ApplicationContext.getCustomerService();
//        UserDTO userDTO =new UserDTO();
//        userDTO.setFirstname("asdf");
//        userDTO.setLastname("asdf");
//        userDTO.setEmailAddress("usdhs2sd2@gmail.com");
//        userDTO.setPassword("asdfAuyf1#23");
//        customerService.customerSignUp(userDTO);

//        SpecialistService specialistService=ApplicationContext.getSpecialistService();
//        SpecialistDTO specialistDTO =new SpecialistDTO();
//
//
//        specialistService.changeUserPassword(specialistService.findById(12L)
//                .get(),"asdfasdfq");


//        specialistDTO.setFirstname("wer");
//        specialistDTO.setLastname("asd");
//        specialistDTO.setEmailAddress("as82df3gs@gmail.com");
//        specialistDTO.setPassword("ASddf23@#");
//        specialistDTO.setImagePath("src/image/download4.png");
//        specialistService.signupSpecialist(specialistDTO);

        ManagerService managerService=ApplicationContext.getManagerService();
        managerService.createService("buiLDing decoration ");



//        File file = new File("src/image/download.jpg");
//        System.out.println(FilenameUtils.getExtension(file.getName()));
//        System.out.println(sizeInKiloBytes(file));
//        BufferedImage bImage = ImageIO.read(file);
//
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ImageIO.write(bImage, "jpg", bos );
//        byte [] data = bos.toByteArray();
//        System.out.println(Arrays.toString(data));

//        BufferedImage bImage2 = ImageIO.read(new File("sample.jpg"));
//        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
//        ImageIO.write(bImage2, "jpg", bos2 );
//        byte [] data2 = bos2.toByteArray();
//        ByteArrayInputStream bis2 = new ByteArrayInputStream(data);
//        BufferedImage bImage3 = ImageIO.read(bis2);
//        ImageIO.write(bImage3, "jpg", new File("src/image/download2.jpg") );
//        System.out.println("image created");

    }
}
