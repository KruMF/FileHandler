package dataTypeTest;

import fileHandler.dataTypes.IEPrimitive;
import fileHandler.dataTypes.primitives.*;

import com.google.inject.internal.Nullable;
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
                defaultValueTest_errorMessage("IEBoolean"));

        assertEquals(
                INTEGER_DEFAULT_VALUE, var_integer.getValue(),
                defaultValueTest_errorMessage("IEInteger"));

        assertEquals(
                FLOAT_DEFAULT_VALUE, var_float.getValue(),
                defaultValueTest_errorMessage("IEFloat"));

        assertEquals(
                DOUBLE_DEFAULT_VALUE, var_double.getValue(),
                defaultValueTest_errorMessage("IEDouble"));

        assertEquals(
                STRING_DEFAULT_VALUE, var_string.getValue(),
                defaultValueTest_errorMessage("IEString"));
    }

    private String defaultValueTest_errorMessage(@NotNull String typeName) {
        String prefix = "Problems with ";
        String appendix = " creation or default value assignment.";
        return prefix + typeName + appendix;
    }

    @Test
    void valueParseTest() {
        assertTrue(
                checkValueParse(var_boolean, String.valueOf(BOOLEAN_TEST_VALUE)),
                valueParseTest_errorMessage("IEBoolean"));

        assertTrue(
                checkValueParse(var_integer, String.valueOf(INTEGER_TEST_VALUE)),
                valueParseTest_errorMessage("IEInteger"));

        assertTrue(
                checkValueParse(var_float, String.valueOf(FLOAT_TEST_VALUE)),
                valueParseTest_errorMessage("IEFloat"));

        assertTrue(
                checkValueParse(var_double, String.valueOf(DOUBLE_TEST_VALUE)),
                valueParseTest_errorMessage("IEDouble"));

        assertTrue(
                checkValueParse(var_string, STRING_TEST_VALUE),
                valueParseTest_errorMessage("IEString"));
    }

    private String valueParseTest_errorMessage(@NotNull String typeName) {
        String prefix = "Problems with ";
        String appendix = " value import or export.";
        return prefix + typeName + appendix;
    }

    private boolean checkValueParse(@NotNull IEPrimitive object, @NotNull String expectedString) {
        String[] expected = new String[] {expectedString};
        object.parseStringArrayToValue(expected);
        String[] actual = object.parseValueToStringArray();

        return compareStringArrays(expected, actual);
    }

    private boolean compareStringArrays(@Nullable String[] expected, @Nullable String[] actual) {
        if (expected == null || actual == null
                || expected.length <= 0
                || actual.length != expected.length) {
            return false;
        }

        for (int i = 0; i < expected.length; i++) {
            if (!actual[i].equals(expected[i])) {
                return false;
            }
        }

        return true;
    }
}