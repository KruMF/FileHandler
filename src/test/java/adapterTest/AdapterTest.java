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

    /*
     * TODO: primitive adapter tests to add:
     *      initialize - default values and file saving
     *      1. value setting
     *      2. loading values from file
     *      3. getting values
     */
    @Test
    void primitiveAdapterTest() {
        //TODO: finish this
        assertEquals(true, true, "primitive adapter test not ready yet");
    }

    /*
     * TODO: array adapter tests to add:
     *      initialize - default values and file saving
     *      1. value setting
     *      2. loading values from file
     *      3. getting values
     */
    @Test
    void arrayAdapterTest() {
        //TODO: finish this
        assertEquals(true, true, "array adapter test not ready yet");
    }
}