import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextTest {

    @BeforeAll
    static void initialize() {
        //set common variables
    }

    /**
     * Tests reading of lines.
     */
    @Test
    void readLines() {
        String
                line1 = "row1 : data1",
                line2 = "row2 : data2",
                line3 = "row3 : data3a data3b data3c";

        ArrayList<String> expected = new ArrayList<>() {{
            add(line1);
            add(line2);
            add(line3);
        }};

        //read text lines from preprepared file
        //TODO: get lines from method
        ArrayList<String> actual = null;

        assertEquals(expected, actual,"Not reading lines of text.");
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

        ArrayList<String[]> expected = new ArrayList<>() {{
            add(line1);
            add(line2);
            add(line3);
        }};

        //convert read text lines to arrays of strings
        //TODO: get from method
        ArrayList<String[]> actual = null;

        assertEquals(expected, actual, "Not converting read lines to string arrays.");
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

        HashMap<String, String[]> expected = new HashMap<>() {{
            put(key1, value1);
            put(key2, value2);
            put(key3, value3);
        }};

        //convert read text lines to map of string arrays
        //TODO: get from method
        HashMap<String, String[]> actual = null;

        assertEquals(expected, actual, "Not converting read lines to map of string arrays.");
    }

    @Test
    void writeTest() {
        //generate file and write text
    }

    @Test
    void rereadTest() {
        //read text from generated file
    }
}