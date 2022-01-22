package fileHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

//TODO: add javadoc
public class FileHandler extends FileHandlerSupplement{
    //TODO: add javadoc
    public static String path(String directory, String fileName) {
        String slash = "/";
        return directory + slash + fileName;
    }

    //TODO: add javadoc
    public static ArrayList<String> readLines(String filePath) {
        //TODO: Finish this
        return null;
    }

    //TODO: add javadoc
    public static ArrayList<String[]> readSeparatedLines(String filePath) {
        //TODO: Finish this
        return textReader.read(filePath);
    }

    //TODO: add javadoc
    public static HashMap<String, String[]> readStringArrayMap(String filePath) {
        //TODO: Finish this
        return null;
    }

    //TODO: add javadoc
    public static void writeText(String filePath, ArrayList<String[]> data) {
        //TODO: Finish this
        textWriter.writeToFile(filePath, data);
    }

    //TODO: add javadoc
    public static Image readImage(String filePath) {
        //TODO: Finish this
        return imageReader.readSingleImage(filePath);
    }
}