package adapterTest;

import fileHandler.fileHandling.FileHandler;

import general.TestSettings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: finish this and add javadoc
public class AdapterTest {
    private static final String DIRECTORY_NAME = "adapterTest";
    private static FileHandler fileHandler;

    private static PrimitivesDataClass primitives;
    private static ArraysDataClass arrays;

    @BeforeAll
    public static void initialize() {
        fileHandler = new FileHandler(TestSettings.RESOURCE_LOCATION);

        primitives = new PrimitivesDataClass(DIRECTORY_NAME);
        arrays = new ArraysDataClass(DIRECTORY_NAME);

        exportDefaultValues();
    }

    private static void exportDefaultValues() {
        primitives.exportData(fileHandler, "");
        arrays.exportData(fileHandler, "");
    }

    @Test
    void test1() {
        //TODO: finish this
        assertEquals(false, true, "test not ready yet");
    }
}