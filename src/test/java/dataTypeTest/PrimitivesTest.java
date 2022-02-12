package dataTypeTest;

import fileHandler.dataTypes.IEPrimitive;
import fileHandler.dataTypes.primitives.*;

import general.TestSettings;
import org.jetbrains.annotations.NotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: add javadoc
public class PrimitivesTest {
    private static final String
            BOOLEAN_KEY = "Boolean",
            INTEGER_KEY = "Integer",
            FLOAT_KEY = "Float",
            DOUBLE_KEY = "Double",
            STRING_KEY = "String";

    private static final boolean BOOLEAN_DEFAULT_VALUE = false;
    private static final int INTEGER_DEFAULT_VALUE = 100;
    private static final float FLOAT_DEFAULT_VALUE = 10.5f;
    private static final double DOUBLE_DEFAULT_VALUE = 12.5;
    private static final String STRING_DEFAULT_VALUE = "A string of text";

    private static final boolean BOOLEAN_TEST_VALUE = true;
    private static final int INTEGER_TEST_VALUE = 123;
    private static final float FLOAT_TEST_VALUE = 22.345f;
    private static final double DOUBLE_TEST_VALUE = 123.45;
    private static final String STRING_TEST_VALUE = "A changed string of text";

    static IEBoolean var_boolean;
    static IEInteger var_integer;
    static IEFloat var_float;
    static IEDouble var_double;
    static IEString var_string;

    @BeforeEach
    void initialize() {
        var_boolean = new IEBoolean(BOOLEAN_KEY, BOOLEAN_DEFAULT_VALUE);
        var_integer = new IEInteger(INTEGER_KEY, INTEGER_DEFAULT_VALUE);
        var_float = new IEFloat(FLOAT_KEY, FLOAT_DEFAULT_VALUE);
        var_double = new IEDouble(DOUBLE_KEY, DOUBLE_DEFAULT_VALUE);
        var_string = new IEString(STRING_KEY, STRING_DEFAULT_VALUE);
    }

    @Test
    void defaultValuesTest() {
        assertEquals(
                BOOLEAN_DEFAULT_VALUE, var_boolean.getValue(),
                DataTypeTestHelper.defaultValueTest_errorMessage("IEBoolean"));

        assertEquals(
                INTEGER_DEFAULT_VALUE, var_integer.getValue(),
                DataTypeTestHelper.defaultValueTest_errorMessage("IEInteger"));

        assertEquals(
                FLOAT_DEFAULT_VALUE, var_float.getValue(),
                DataTypeTestHelper.defaultValueTest_errorMessage("IEFloat"));

        if (TestSettings.DO_DOUBLES) {
            assertEquals(
                    DOUBLE_DEFAULT_VALUE, var_double.getValue(),
                    DataTypeTestHelper.defaultValueTest_errorMessage("IEDouble"));
        }

        assertEquals(
                STRING_DEFAULT_VALUE, var_string.getValue(),
                DataTypeTestHelper.defaultValueTest_errorMessage("IEString"));
    }

    @Test
    void valueParseTest() {
        assertTrue(
                checkValueParse(var_boolean, String.valueOf(BOOLEAN_TEST_VALUE)),
                DataTypeTestHelper.valueParseTest_errorMessage("IEBoolean"));

        assertTrue(
                checkValueParse(var_integer, String.valueOf(INTEGER_TEST_VALUE)),
                DataTypeTestHelper.valueParseTest_errorMessage("IEInteger"));

        assertTrue(
                checkValueParse(var_float, String.valueOf(FLOAT_TEST_VALUE)),
                DataTypeTestHelper.valueParseTest_errorMessage("IEFloat"));

        if (TestSettings.DO_DOUBLES) {
            assertTrue(
                    checkValueParse(var_double, String.valueOf(DOUBLE_TEST_VALUE)),
                    DataTypeTestHelper.valueParseTest_errorMessage("IEDouble"));
        }

        assertTrue(
                checkValueParse(var_string, STRING_TEST_VALUE),
                DataTypeTestHelper.valueParseTest_errorMessage("IEString"));
    }

    private boolean checkValueParse(@NotNull IEPrimitive object, @NotNull String expectedString) {
        String[] expected = new String[] {expectedString};
        object.parseStringArrayToValue(expected);

        return DataTypeTestHelper.compareStringArrays(
                expected,
                object.parseValueToStringArray());
    }
}