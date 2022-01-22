package fileHandler;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.readAllLines;

class TextFileReader extends CommonFunctionality {

    /**
     * Reads a text file.
     * @param filePath Path for file to read.
     * @return Array of key-value pairs by order of read, if read. Null, if any problems.
     */
    ArrayList<String[]> read(String filePath){
        if (filePath == null) {
            System.out.println("Null filepath provided.");
        } else {
            String[] readLines = readFile(filePath);
            if (readLines != null) return prepareReturnableData(readLines);
        }
        return null;
    }

    /**
     * Reads a file.
     * @param filePath Path for file to read.
     * @return Array of read lines by order of read. Null, if not read.
     */
    private String[] readFile(String filePath){
        System.out.println("Reading file from " + filePath);
        if (checkFileStatus(filePath)) {
            try {
                List<String> linesRead = readAllLines(Path.of(filePath), encoding);
                if (linesRead.size() < 1) System.out.println("File empty or incorrect encoding");
                else {
                    System.out.println("Number of lines read: " + linesRead.size() + ", encoding: " + encoding);
                    return linesRead.toArray(new String[0]);
                }
            } catch (IOException e) {
                System.out.println("An I/O exception occurred while reading file");
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Prepares read lines for further use.
     * @param readLines Lines read from file.
     * @return Array of key-value pairs by order of read.
     */
    private ArrayList<String[]> prepareReturnableData(String[] readLines){
        ArrayList<String[]> returnableData = new ArrayList<>();
        for (String readLine : readLines) {
            String[] splitString = readLine.split(valueSeparator);
            returnableData.add(splitString);
        }
        return returnableData;
    }
}