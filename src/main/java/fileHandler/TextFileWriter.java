package fileHandler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class TextFileWriter extends CommonFunctionality {

    void writeToFile(String filePath, ArrayList<String[]> writableData){
        try {
            System.out.println("Writing to file at " + filePath);

            File writableFile = new File(filePath);
            if (writableFile.delete()) System.out.println("Previous file deleted");
            if (writableFile.createNewFile()) System.out.println("New file created");

            List<String> writableLines = new ArrayList<>();

            for (String[] splitWritableLine : writableData) {
                StringBuilder writableLine = new StringBuilder();

                for (int j = 0; j < splitWritableLine.length; j++) {
                    if (j > 0) writableLine.append(valueSeparator);
                    writableLine.append(splitWritableLine[j]);
                }

                writableLines.add(writableLine.toString());
            }

            Files.write(Path.of(filePath), writableLines, encoding);

        } catch (IOException e) {
            System.err.println("An I/O exception occurred while creating file");
            e.printStackTrace();
        }
    }
}