package fileHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class ImageReader {
    Image readSingleImage(String filePath) {
        System.out.println("Loading image from " + filePath);
        if(FileHandler.checkFileStatus(filePath)) {
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