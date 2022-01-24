package fileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//TODO: add javadoc
public class ImageHandler {
    protected ImageHandler() {}

    //TODO: add javadoc
    @SuppressWarnings("unused")
    public Image readSingleImage(String fileName, FileHandler fileHandler) {
        String filePath = fileHandler.path(fileName);
        System.out.println("Loading image from " + filePath);
        if(fileHandler.checkFileStatus(filePath)) {
            File imageFile = new File(filePath);
            try {
                return ImageIO.read(imageFile);
            } catch (IOException e) {
                System.out.println("An I/O exception occurred while loading image");
                e.printStackTrace();
            }
        }
        return null;
    }
}