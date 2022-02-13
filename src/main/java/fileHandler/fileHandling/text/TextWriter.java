package fileHandler.fileHandling.text;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

class TextWriter {
    protected void writeToFile(String filePath, Charset encoding, ArrayList<String> writableLines){
        try {
            System.out.println("Writing to file at " + filePath);
            File writableFile = new File(filePath);

            writableFile.mkdirs(); //missing directory creation
            if (writableFile.delete()) System.out.println("Previous file deleted");
            if (writableFile.createNewFile()) System.out.println("New file created");

            Files.write(Path.of(filePath), writableLines, encoding);

        } catch (IOException e) {
            System.err.println("An I/O exception occurred while creating file");
            e.printStackTrace();
        }
    }
}