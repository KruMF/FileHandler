package dataTypeTest;

import fileHandler.dataTypes.IEPrimitive;
import fileHandler.dataTypes.arrays.*;
import general.TestSettings;

import org.jetbrains.annotations.NotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: add javadoc
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
    void defaultValuesTest() {
        assertArrayEquals(
                BOOLEANS_DEFAULT_VALUE, var_booleans.getValue(),
                DataTypeTestHelper.defaultValueTest_errorMessage("IEBooleanArray"));

        assertArrayEquals(
                INTEGERS_DEFAULT_VALUE, var_integers.getValue(),
                DataTypeTestHelper.defaultValueTest_errorMessage("IEIntegerArray"));

        assertArrayEquals(
                FLOATS_DEFAULT_VALUE, var_floats.getValue(),
                DataTypeTestHelper.defaultValueTest_errorMessage("IEFloatArray"));

        if (TestSettings.DO_DOUBLES) {
            assertArrayEquals(
                    DOUBLES_DEFAULT_VALUE, var_doubles.getValue(),
                    DataTypeTestHelper.defaultValueTest_errorMessage("IEDoubleArray"));
        }

        assertArrayEquals(
                STRINGS_DEFAULT_VALUE, var_strings.getValue(),
                DataTypeTestHelper.defaultValueTest_errorMessage("IEStringArray"));
    }

    @Test
    void valueParseTest() {
        assertTrue(
                checkValueParse(var_booleans, expectedStringArray_Boolean(BOOLEANS_TEST_VALUE)),
                DataTypeTestHelper.valueParseTest_errorMessage("IEBoolean"));

        assertTrue(
                checkValueParse(var_integers, expectedStringArray_Integer(INTEGERS_TEST_VALUE)),
                DataTypeTestHelper.valueParseTest_errorMessage("IEInteger"));

        assertTrue(
                checkValueParse(var_floats, expectedStringArray_Float(FLOATS_TEST_VALUE)),
                DataTypeTestHelper.valueParseTest_errorMessage("IEFloat"));

        if (TestSettings.DO_DOUBLES) {
            assertTrue(
                    checkValueParse(var_doubles, expectedStringArray_Double(DOUBLES_TEST_VALUE)),
                    DataTypeTestHelper.valueParseTest_errorMessage("IEDouble"));
        }

        assertTrue(
                checkValueParse(var_strings, expectedStringArray_String(STRINGS_TEST_VALUE)),
                DataTypeTestHelper.valueParseTest_errorMessage("IEString"));
    }

    private boolean checkValueParse(@NotNull IEPrimitive object, @NotNull String[] expectedStringArray) {
        object.parseStringArrayToValue(expectedStringArray);
        return DataTypeTestHelper.compareStringArrays(
                expectedStringArray,
                object.parseValueToStringArray());
    }

    private String[] expectedStringArray_Boolean(boolean[] booleanArray) {
        String[] returnable = new String[booleanArray.length];
        for (int i = 0; i < booleanArray.length; i++) {
            returnable[i] = String.valueOf(booleanArray[i]);
        }
        return returnable;
    }

    private String[] expectedStringArray_Integer(int[] integerArray) {
        String[] returnable = new String[integerArray.length];
        for (int i = 0; i < integerArray.length; i++) {
            returnable[i] = String.valueOf(integerArray[i]);
        }
        return returnable;
    }

    private String[] expectedStringArray_Float(float[] floatArray) {
        String[] returnable = new String[floatArray.length];
        for (int i = 0; i < floatArray.length; i++) {
            returnable[i] = String.valueOf(floatArray[i]);
        }
        return returnable;
    }

    private String[] expectedStringArray_Double(double[] doubleArray) {
        String[] returnable = new String[doubleArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            returnable[i] = String.valueOf(doubleArray[i]);
        }
        return returnable;
    }

    private String[] expectedStringArray_String(String[] stringArray) {
        return stringArray;
    }
}