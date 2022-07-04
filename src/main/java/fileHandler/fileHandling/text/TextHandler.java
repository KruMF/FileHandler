package fileHandler.fileHandling.text;

import fileHandler.fileHandling.FileHandler;
import fileHandler.utilities.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A helper class for FileHandler for reading and writing text from and to files.
 */
public class TextHandler {
    private Charset encoding;
    private String separator;

    private final TextReader textReader = new TextReader();
    private final TextWriter textWriter = new TextWriter();

    /**
     * Creates a text handler with default parameters.
     */
    public TextHandler() {
        encoding = EncodingUtilities.encodingTypeToCharset();
        separator = NullCheck.separatorCheck(null);
    }

    /**
     * Sets the separator.
     *
     * @param separator New separator. (Null - default separator)
     */
    @SuppressWarnings("unused")
    public void setSeparator(String separator) {
        this.separator = NullCheck.separatorCheck(separator);
    }

    /**
     * Sets encoding.
     *
     * @param encoding New encoding type. (Null - default encoding)
     */
    @SuppressWarnings("unused")
    public void setEncoding(EncodingUtilities.EncodingType encoding) {
        this.encoding = EncodingUtilities.encodingTypeToCharset(encoding);
    }

    /**
     * Reads lines of text from a file to an ArrayList of strings.
     *
     * @param fileName      Name of the file to read.
     * @param fileHandler   Parent FileHandler for file status check and directory info.
     *
     * @return Read lines as ArrayList of strings. Null if not read.
     */
    public ArrayList<String> readLines(String fileName, FileHandler fileHandler) {
        if (fileHandler.checkFileStatus(fileName)) {
            String filePath = fileHandler.path(fileName);
            return textReader.readFile(filePath, encoding);
        }
        return null;
    }

    /**
     * Reads lines of text from a file separated by separator to an ArrayList of string arrays.
     *
     * @param fileName      Name of the file to read.
     * @param fileHandler   Parent FileHandler for file status check and directory info.
     *
     * @return Read lines as ArrayList of string arrays. Null if not read.
     */
    public ArrayList<String[]> readSeparatedLines(String fileName, FileHandler fileHandler) {
        return TextConversion.separateLines(separator, readLines(fileName, fileHandler));
    }

    /**
     * Reads lines of text from a file separated by separator to a string HashMap.
     *
     * @param fileName      Name of the file to read.
     * @param fileHandler   Parent FileHandler for file status check and directory info.
     *
     * @return Read lines as string HashMap. Null if not read.
     */
    public HashMap<String, String[]> readStringMap(String fileName, FileHandler fileHandler) {
        return TextConversion.stringMapFromArrayList(readSeparatedLines(fileName, fileHandler));
    }

    //TODO: add javadoc
    public void writeLines(String fileName, FileHandler fileHandler, ArrayList<String> writableLines) {
        String filePath = fileHandler.path(fileName);
        textWriter.writeToFile(filePath, encoding, writableLines);
    }

    //TODO: add javadoc
    public void writeSeparatedLines(String fileName, FileHandler fileHandler, ArrayList<String[]> writableLines) {
        writeLines(fileName, fileHandler, TextConversion.combineLines(separator, writableLines));
    }

    //TODO: add javadoc
    @SuppressWarnings("unused")
    public void writeStringMap(String fileName, FileHandler fileHandler, HashMap<String, String[]> writableData) {
        writeSeparatedLines(fileName, fileHandler, TextConversion.arrayListFromStringMap(writableData));
    }
}