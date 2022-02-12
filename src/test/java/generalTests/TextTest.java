package generalTests;

import fileHandler.fileHandling.FileHandler;
import fileHandler.utilities.TextConversion;

import java.util.ArrayList;
import java.util.HashMap;

import general.TestSettings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for text reading and writing.
 */
public class TextTest {
    private static final String
            DIRECTORY = TestSettings.RESOURCE_LOCATION + "/text",
            READ_TEST_FILE_NAME = "textReadTest",
            WRITE_TEST_FILE_NAME = "textWriteTest";

    private static FileHandler fileHandler;

    @BeforeAll
    static void initialize() {
        fileHandler = new FileHandler(DIRECTORY);
    }

    /**
     * Tests reading of lines.
     */
    @Test
    void readLines() {
        String
                line1 = "row1 : data1",
                line2 = "row2 : data2",
                line3 = "row3 : data3a : data3b : data3c";

        ArrayList<String> expected = new ArrayList<>() {{
            add(line1);
            add(line2);
            add(line3);
        }};

        //read text lines from preprepared file
        ArrayList<String> actual = fileHandler.text.readLines(READ_TEST_FILE_NAME, fileHandler);

        assertLinesMatch(expected, actual,"Not reading lines of text.");
    }

    /**
     * Tests converting read lines from ArrayList of String to ArrayList of String[].
     */
    @Test
    void stringArrayArrayListTest() {
        String[]
                line1 = new String[] {"row1", "data1"},
                line2 = new String[] {"row2", "data2"},
                line3 = new String[] {"row3", "data3a", "data3b", "data3c"};

        ArrayList<String> expected = TextConversion.combineLines(null, new ArrayList<>() {{
            add(line1);
            add(line2);
            add(line3);
        }});

        //convert read text lines to arrays of strings
        ArrayList<String> actual = TextConversion.combineLines(
                null,
                fileHandler.text.readSeparatedLines(READ_TEST_FILE_NAME, fileHandler));

        assertLinesMatch(expected, actual, "Not converting read lines to string arrays.");
    }

    /**
     * Tests converting read lines from ArrayList<String[]> to HashMap<String, String[]>.
     */
    @Test
    void stringArrayMapTest() {
        String
                key1 = "row1",
                key2 = "row2",
                key3 = "row3";

        String[]
                value1 = new String[] {"data1"},
                value2 = new String[] {"data2"},
                value3 = new String[] {"data3a", "data3b", "data3c"};

        ArrayList<String> expected = TextConversion.combineLines(
                null,
                TextConversion.arrayListFromStringMap(new HashMap<>() {{
                    put(key1, value1);
                    put(key2, value2);
                    put(key3, value3);
                }}));

        //convert read text lines to map of string arrays
        ArrayList<String> actual = TextConversion.combineLines(
                null,
                TextConversion.arrayListFromStringMap(
                        fileHandler.text.readStringMap(READ_TEST_FILE_NAME, fileHandler)));

        assertLinesMatch(expected, actual, "Not converting read lines to map of string arrays.");
    }

    /**
     * Tests writing text to file.
     */
    @Test
    void writeTest() {
        String
                key = "working",
                value = "true";

        ArrayList<String> expected = TextConversion.combineLines(null, new ArrayList<>() {{
            add(new String[] {key, value});
        }});

        //generate file and write text
        fileHandler.text.writeLines(WRITE_TEST_FILE_NAME, fileHandler, expected);

        //read written file
        ArrayList<String> actual = fileHandler.text.readLines(WRITE_TEST_FILE_NAME, fileHandler);

        assertLinesMatch(expected, actual, "Write test not working.");
    }
}