package fileHandler;

import java.io.File;

//TODO: add javadoc
public class FileHandler {
    protected String directory;

    public TextHandler text = new TextHandler();
    public ImageHandler images = new ImageHandler();

    /**
     * Default FileHandler constructor with empty string as directory.
     * Use this constructor with caution.
     */
    @SuppressWarnings("unused")
    public FileHandler() {
        this.directory = NullCheck.nullDirectoryCheck(null);
    }

    /**
     * Creates a FileHandler with specified directory.
     *
     * @param directory Directory for files. (Null - empty string)
     */
    public FileHandler(String directory) {
        this.directory = NullCheck.nullDirectoryCheck(directory);
    }

    /**
     * Sets the directory.
     *
     * @param directory New directory. (Null - empty string)
     */
    @SuppressWarnings("unused")
    public void setDirectory(String directory) {
        this.directory = NullCheck.nullDirectoryCheck(directory);
    }

    /**
     * Gets the current directory.
     *
     * @return Current directory.
     */
    @SuppressWarnings("unused")
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
                System.out.println("File not found");
            } else if (!file.canRead()) {
                System.out.println("File not readable");
            } else return true;
        }

        return false;
    }
}