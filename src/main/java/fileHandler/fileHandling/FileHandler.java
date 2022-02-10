package fileHandler.fileHandling;

import fileHandler.fileHandling.text.TextHandler;
import fileHandler.utilities.NullCheck;

import java.io.File;

/**
 * Main class of the file handler.
 */
@SuppressWarnings("unused")
public class FileHandler {
    protected String directory;

    public TextHandler text;
    public ImageHandler images;

    /**
     * Default FileHandler constructor with empty string as directory.
     * Use this constructor with caution.
     */
    public FileHandler() {
        this(null);
    }

    /**
     * Creates a FileHandler with specified directory.
     *
     * @param directory Directory for files. (Null - empty string)
     */
    public FileHandler(String directory) {
        setDirectory(directory);

        text = new TextHandler();
        images = new ImageHandler();
    }

    /**
     * Sets the directory of the file handler.
     *
     * @param directory New directory. (Null - empty string)
     */
    public void setDirectory(String directory) {
        this.directory = NullCheck.directoryCheck(directory);
    }

    /**
     * Gets the current directory of the file handler.
     *
     * @return Current directory.
     */
    public String getDirectory() {
        return directory;
    }

    /**
     * Prefixes directory to the file name for complete path.
     *
     * @param fileName Name of the file.
     *
     * @return Path of the file.
     */
    public String path(String fileName) {
        String slash = "/";
        return directory + slash + fileName;
    }

    /**
     * Check existence and readability of a file.
     *
     * @param fileName Name of file to check.
     *
     * @return True, if OK. False, if file not found or non-readable.
     */
    public boolean checkFileStatus(String fileName) {
        if (fileName == null) {
            System.out.println("Null fileName provided.");
        } else {
            File file = new File(path(fileName));

            if (!file.exists()) {
                System.out.println("File not found.");
            } else if (!file.canRead()) {
                System.out.println("File not readable.");
            } else return true;
        }

        return false;
    }
}