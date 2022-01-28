package adapterTest;

import fileHandler.FileHandler;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: finish this and add javadoc
public class AdapterTest {
    private static final String DIRECTORY = "src/test/resources/text";
    private static FileHandler fileHandler;

    private static PrimitivesDataClass primitives;
    private static ArraysDataClass arrays;

    @BeforeAll
    public static void initialize() {
        fileHandler = new FileHandler(DIRECTORY);
        primitives = new PrimitivesDataClass();
        arrays = new ArraysDataClass();
        exportDefaultValues();
    }

    private static void exportDefaultValues() {
        primitives.exportData(fileHandler, DIRECTORY);
        arrays.exportData(fileHandler, DIRECTORY);
    }

    @Test
    void test1() {
        //TODO: finish this
        assertEquals(false, true, "test not ready yet");
    }
}