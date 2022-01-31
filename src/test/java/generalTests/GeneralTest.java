package generalTests;

import fileHandler.FileHandler;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeneralTest {
    private static final String
            DIRECTORY = "src/test/resources/text";

    private static FileHandler fileHandler;

    @BeforeAll
    static void initialize() {
        fileHandler = new FileHandler(DIRECTORY);
    }

    /**
     * Tests file path creation.
     */
    @Test
    void pathTest() {
        String fileName = "file";
        String expected = DIRECTORY + "/" + fileName;
        String actual = fileHandler.path(fileName);
        assertEquals(expected, actual, "Not creating file path correctly.");
    }

    /**
     * Tests file existence check.
     */
    @Test
    void fileExistenceCheckTest() {
        String fileName = "emptyFile";
        assertTrue(
                fileHandler.checkFileStatus(fileName),
                "File existence check test not working.");
    }

    //TODO: empty directory test
}