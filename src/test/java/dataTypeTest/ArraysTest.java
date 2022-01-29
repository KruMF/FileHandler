package dataTypeTest;

import fileHandler.dataTypes.arrays.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: finish this and add javadoc
public class ArraysTest {
    private static final String
            BOOLEANS_KEY = "Booleans",
            INTEGERS_KEY = "Integers",
            FLOATS_KEY = "Floats",
            DOUBLES_KEY = "Doubles",
            STRINGS_KEY = "Strings";

    private static final boolean[] BOOLEANS_DEFAULT_VALUE = new boolean[] {false, true, false};
    private static final int[] INTEGERS_DEFAULT_VALUE = new int[] {1, 2, 3};
    private static final float[] FLOATS_DEFAULT_VALUE = new float[] {1.1f, 2.2f, 3.3f};
    private static final double[] DOUBLES_DEFAULT_VALUE = new double[] {1.11, 2.22, 3.33};
    private static final String[] STRINGS_DEFAULT_VALUE = new String[] {"One", "Two", "Three"};

    private static final boolean[] BOOLEANS_TEST_VALUE = new boolean[] {true, false, true};
    private static final int[] INTEGERS_TEST_VALUE = new int[] {4, 5, 6};
    private static final float[] FLOATS_TEST_VALUE = new float[] {4.4f, 5.5f, 6.6f};
    private static final double[] DOUBLES_TEST_VALUE = new double[] {4.44, 5.55, 6.66};
    private static final String[] STRINGS_TEST_VALUE = new String[] {"Four", "Five", "Six"};

    static IEBooleanArray var_booleans;
    static IEIntegerArray var_integers;
    static IEFloatArray var_floats;
    static IEDoubleArray var_doubles;
    static IEStringArray var_strings;

    @BeforeEach
    void initialize() {
        var_booleans = new IEBooleanArray(BOOLEANS_KEY, BOOLEANS_DEFAULT_VALUE);
        var_integers = new IEIntegerArray(INTEGERS_KEY, INTEGERS_DEFAULT_VALUE);
        var_floats = new IEFloatArray(FLOATS_KEY, FLOATS_DEFAULT_VALUE);
        var_doubles = new IEDoubleArray(DOUBLES_KEY, DOUBLES_DEFAULT_VALUE);
        var_strings = new IEStringArray(STRINGS_KEY, STRINGS_DEFAULT_VALUE);
    }

    @Test
    void testArrays() {
        //TODO: finish this
        assertEquals(true, false, "dataType arrays test not finished yet");
    }
}