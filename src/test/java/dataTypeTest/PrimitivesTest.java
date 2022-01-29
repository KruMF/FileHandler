package dataTypeTest;

import fileHandler.dataTypes.primitives.IEBoolean;
import fileHandler.dataTypes.primitives.IEInteger;
import fileHandler.dataTypes.primitives.IEFloat;
import fileHandler.dataTypes.primitives.IEString;

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
            STRING_KEY = "String";

    private static final boolean BOOLEAN_DEFAULT_VALUE = false;
    private static final int INTEGER_DEFAULT_VALUE = 100;
    private static final float FLOAT_DEFAULT_VALUE = 10.5f;
    private static final String STRING_DEFAULT_VALUE = "A string of text";

    private static final boolean BOOLEAN_TEST_VALUE = true;
    private static final int INTEGER_TEST_VALUE = 123;
    private static final float FLOAT_TEST_VALUE = 22.345f;
    private static final String STRING_TEST_VALUE = "A changed string of text";

    static IEBoolean var_boolean;
    static IEInteger var_integer;
    static IEFloat var_float;
    static IEString var_string;

    @BeforeEach
    void initialize() {
        var_boolean = new IEBoolean(BOOLEAN_KEY, BOOLEAN_DEFAULT_VALUE);
        var_integer = new IEInteger(INTEGER_KEY, INTEGER_DEFAULT_VALUE);
        var_float = new IEFloat(FLOAT_KEY, FLOAT_DEFAULT_VALUE);
        var_string = new IEString(STRING_KEY, STRING_DEFAULT_VALUE);
    }

    @Test
    void defaultValuesTest() {
        assertTrue(compareDefaultValue_Boolean(), defaultValueTest_errorMessage("IEBoolean"));
        assertTrue(compareDefaultValue_Integer(), defaultValueTest_errorMessage("IEInteger"));
        assertTrue(compareDefaultValue_Float(), defaultValueTest_errorMessage("IEFloat"));
        assertTrue(compareDefaultValue_String(), defaultValueTest_errorMessage("IEString"));
    }

    private String defaultValueTest_errorMessage(@NotNull String typeName) {
        String prefix = "Problems with ";
        String appendix = " creation or default value assignment.";
        return prefix + typeName + appendix;
    }

    private boolean compareDefaultValue_Boolean() {
        return var_boolean.getValue() == BOOLEAN_DEFAULT_VALUE;
    }

    private boolean compareDefaultValue_Integer() {
        return var_integer.getValue() == INTEGER_DEFAULT_VALUE;
    }

    private boolean compareDefaultValue_Float() {
        return var_float.getValue() == FLOAT_DEFAULT_VALUE;
    }

    private boolean compareDefaultValue_String() {
        return var_string.getValue().equals(STRING_DEFAULT_VALUE);
    }

    @Test
    void valueParseTest() {
        assertTrue(checkValueParse_Boolean(), valueParseTest_errorMessage("IEBoolean"));
        assertTrue(checkValueParse_Integer(), valueParseTest_errorMessage("IEInteger"));
        assertTrue(checkValueParse_Float(), valueParseTest_errorMessage("IEFloat"));
        assertTrue(checkValueParse_String(), valueParseTest_errorMessage("IEString"));
    }

    private String valueParseTest_errorMessage(@NotNull String typeName) {
        String prefix = "Problems with ";
        String appendix = " value import or export.";
        return prefix + typeName + appendix;
    }

    private String[] prepareExpectedValueArray_Boolean() {
        return new String[] {String.valueOf(BOOLEAN_TEST_VALUE)};
    }

    private String[] prepareExpectedValueArray_Integer() {
        return new String[] {String.valueOf(INTEGER_TEST_VALUE)};
    }

    private String[] prepareExpectedValueArray_Float() {
        return new String[] {String.valueOf(FLOAT_TEST_VALUE)};
    }

    private String[] prepareExpectedValueArray_String() {
        return new String[] {STRING_TEST_VALUE};
    }

    private boolean checkValueParse(@Nullable String[] expected, @Nullable String[] actual) {
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

    private boolean checkValueParse_Boolean() {
        String[] expected = prepareExpectedValueArray_Boolean();
        var_boolean.parseStringArrayToValue(expected);
        String[] actual = var_boolean.parseValueToStringArray();

        return checkValueParse(expected, actual);
    }

    private boolean checkValueParse_Integer() {
        String[] expected = prepareExpectedValueArray_Integer();
        var_integer.parseStringArrayToValue(expected);
        String[] actual = var_integer.parseValueToStringArray();

        return checkValueParse(expected, actual);
    }

    private boolean checkValueParse_Float() {
        String[] expected = prepareExpectedValueArray_Float();
        var_float.parseStringArrayToValue(expected);
        String[] actual = var_float.parseValueToStringArray();

        return checkValueParse(expected, actual);
    }

    private boolean checkValueParse_String() {
        String[] expected = prepareExpectedValueArray_String();
        var_string.parseStringArrayToValue(expected);
        String[] actual = var_string.parseValueToStringArray();

        return checkValueParse(expected, actual);
    }
}