package fileHandler.fileHandling.text;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;

import static java.nio.file.Files.readAllLines;

class TextReader {
    /**
     * Reads lines of text from a file to ArrayList of strings.
     *
     * @param filePath Path of the file.
     * @param encoding Encoding.
     *
     * @return ArrayList of read lines by order of read. Null, if not read.
     */
    protected ArrayList<String> readFile(String filePath, Charset encoding) {
        System.out.println("Reading file from: " + filePath);
        try {
            ArrayList<String> linesRead = (ArrayList<String>) readAllLines(Path.of(filePath), encoding);
            if (linesRead.size() < 1) {
                System.out.println("File empty or incorrect encoding.");
            } else {
                System.out.println("Number of lines read: " + linesRead.size() + ", encoding: " + encoding);
                return linesRead;
            }
        } catch (IOException e) {
            System.out.println("An I/O exception occurred while reading file");
            e.printStackTrace();
        }
        return null;
    }
}