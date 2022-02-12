package generalTests;

import fileHandler.fileHandling.FileHandler;

import general.TestSettings;

import general.TestUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: add javadoc
public class GeneralTest {
    private static final String
            DIRECTORY = TestSettings.RESOURCE_LOCATION,
            NON_EXISTENT_DIRECTORY = "nonExistentDirectory",
            EXISTING_DIRECTORY = "directoryTest",
            EMPTY_FILE_NAME = "emptyFile";

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

    @Test
    void directoryExistenceTest() {
        String testName = "Directory existence test";
        String testFailMessage = testName + " not working.";

        TestUtilities.consolePrint(testName);

        assertFalse(
                checkDirectory(NON_EXISTENT_DIRECTORY),
                testFailMessage);

        assertTrue(
                checkDirectory(EXISTING_DIRECTORY),
                testFailMessage);
    }

    private boolean checkDirectory(String directoryName) {
        if (fileHandler.checkFileStatus(directoryName)) {
            TestUtilities.consolePrint("Directory found at: " + fileHandler.path(directoryName));
            return true;
        } else {
            TestUtilities.consolePrint("Directory not found at: " + fileHandler.path(directoryName));
            return false;
        }
    }

    /**
     * Tests file existence check.
     */
    @Test
    void fileExistenceCheckTest() {
        String fileName = EXISTING_DIRECTORY + "/" + EMPTY_FILE_NAME;
        assertTrue(
                fileHandler.checkFileStatus(fileName),
                "File existence check test not working.");
    }
}