package fileHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

//TODO: add javadoc
public class FileHandler {
    private static final TextFileReader textReader = new TextFileReader();
    private static final TextFileWriter textWriter = new TextFileWriter();
    private static final ImageReader imageReader = new ImageReader();

    private static final String DEFAULT_SEPARATOR = " : ";
    private String separator;
    private String directory;

    //TODO: add javadoc
    public FileHandler(String directory) {
        this.separator = nullSeparatorCheck(null);
        this.directory = nullDirectoryCheck(directory);
    }

    //TODO: add javadoc
    public FileHandler(String separator, String directory) {
        this.separator = nullSeparatorCheck(separator);
        this.directory = nullDirectoryCheck(directory);
    }

    //TODO: add javadoc
    private static String nullDirectoryCheck(String directory) {
        if (directory == null) {
            directory = "";
        }
        return directory;
    }

    //TODO: add javadoc
    private static String nullSeparatorCheck(String separator) {
        if (separator == null) {
            separator = DEFAULT_SEPARATOR;
        }
        return separator;
    }

    //TODO: add javadoc
    public void setSeparator(String separator) {
        this.separator = nullSeparatorCheck(separator);
    }

    //TODO: add javadoc
    public void setDirectory(String directory) {
        this.directory = nullDirectoryCheck(directory);
    }

    /**
     * Gets the current directory.
     * @return Current directory.
     */
    public String getDirectory() {
        return directory;
    }

    //TODO: add javadoc
    public static String path(String directory, String fileName) {
        String slash = "/";
        return directory + slash + fileName;
    }

    /**
     * Reads lines of text from a file to an ArrayList of strings.
     *
     * @param filePath Path of file to read
     *
     * @return Read lines as ArrayList of strings
     */
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