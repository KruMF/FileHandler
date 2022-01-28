package adapterTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: finish this and add javadoc
public class AdapterTest {
    private static final String DIRECTORY = "src/test/resources/text/adapterTest";

    private static PrimitivesDataClass primitives;
    private static ArraysDataClass arrays;

    @BeforeAll
    public static void initialize() {
        initializePrimitives();
        initializeArrays();
    }

    private static void initializePrimitives() {
        primitives = new PrimitivesDataClass(DIRECTORY);
    }

    private static void initializeArrays() {
        arrays = new ArraysDataClass(DIRECTORY);
    }

    @Test
    void test1() {
        //TODO: finish this
        assertEquals(false, true, "test not ready yet");
    }
}