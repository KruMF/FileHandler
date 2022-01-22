package fileHandler;

import java.io.File;
import java.nio.charset.Charset;

class CommonFunctionality {
    static final Charset encoding = Charset.forName("Cp1257");
    static final String valueSeparator = " : "; //mind the spaces around the colon

    /**
     * Check readability of a file.
     * @param filePath Path for file to read
     * @return True, if ok. False, if file not found or non-readable.
     */
    static boolean checkFileStatus(String filePath){
        File fileToCheck = new File(filePath);

        if (!fileToCheck.exists()) System.out.println("File not found");
        else if (!fileToCheck.canRead()) System.out.println("File not readable");
        else return true;

        return false;
    }
}