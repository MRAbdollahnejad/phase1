package util;

import exception.ImageException;
import org.apache.commons.io.FilenameUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ImageConvertToByte {

    public byte[] imageConvertToByte(String imagePath) throws FileNotFoundException {
        File file = new File(imagePath);
        if(!file.exists()){
            throw new FileNotFoundException("file not exist");
        }
        if (!formatOfFile(file).equals("jpg")){
            throw new ImageException("wrong format");
        }
        if (sizeInKiloBytes(file)>300.0D){
            throw new ImageException("file size is more than 300KB ");
        }
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, "jpg", bos );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }

    private static String formatOfFile(File file){
        return FilenameUtils.getExtension(file.getName().toLowerCase());
    }

    private static double sizeInKiloBytes(File file) {
        return (double) file.length() / 1024 ;
    }

}
