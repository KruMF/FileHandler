package fileHandler;

import java.awt.*;
import java.util.ArrayList;

public class FileHandler extends FileHandlerSupplement{
    public static ArrayList<String[]> readText(String filePath){
        return textReader.read(addCommonPathPrefix(filePath));
    }

    public static void writeText(String filePath, ArrayList<String[]> data){
        textWriter.writeToFile(addCommonPathPrefix(filePath), data);
    }

    public static Image readImage(String filePath){
        return imageReader.readSingleImage(addCommonPathPrefix(filePath));
    }
}