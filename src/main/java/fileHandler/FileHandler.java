package fileHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

//TODO: add javadoc
public class FileHandler {
    private static final TextFileReader textReader = new TextFileReader();
    private static final TextFileWriter textWriter = new TextFileWriter();
    private static final ImageReader imageReader = new ImageReader();

    private String separator;
    private String directory;

    /**
     * Creates a FileHandler with specified directory and default separator.
     *
     * @param directory Directory for files.
     */
    public FileHandler(String directory) {
        this.separator = NullCheck.nullSeparatorCheck(null);
        this.directory = NullCheck.nullDirectoryCheck(directory);
    }

    /**
     * Creates a FileHandler with specified parameters.
     *
     * @param separator Value separator for text files.
     * @param directory Directory for files.
     */
    public FileHandler(String separator, String directory) {
        this.separator = NullCheck.nullSeparatorCheck(separator);
        this.directory = NullCheck.nullDirectoryCheck(directory);
    }

    /**
     * Sets the separator.
     *
     * @param separator New separator.
     */
    public void setSeparator(String separator) {
        this.separator = NullCheck.nullSeparatorCheck(separator);
    }

    /**
     * Sets the directory.
     *
     * @param directory New directory.
     */
    public void setDirectory(String directory) {
        this.directory = NullCheck.nullDirectoryCheck(directory);
    }

    /**
     * Gets the current directory.
     *
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