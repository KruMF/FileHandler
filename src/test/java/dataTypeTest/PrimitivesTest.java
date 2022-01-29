package dataTypeTest;

import fileHandler.dataTypes.primitives.IEBoolean;
import fileHandler.dataTypes.primitives.IEInteger;
import fileHandler.dataTypes.primitives.IEFloat;
import fileHandler.dataTypes.primitives.IEString;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: finish this and add javadoc
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

    static IEBoolean var_boolean;
    static IEInteger var_integer;
    static IEFloat var_float;
    static IEString var_string;

    @BeforeAll
    static void initialize() {
        var_boolean = new IEBoolean(BOOLEAN_KEY, BOOLEAN_DEFAULT_VALUE);
        var_integer = new IEInteger(INTEGER_KEY, INTEGER_DEFAULT_VALUE);
        var_float = new IEFloat(FLOAT_KEY, FLOAT_DEFAULT_VALUE);
        var_string = new IEString(STRING_KEY, STRING_DEFAULT_VALUE);
    }

    @Test
    void defaultValuesTest() {
        boolean works = compareDefaultValue_Boolean()
                && compareDefaultValue_Integer()
                && compareDefaultValue_Float()
                && compareDefaultValue_String();
        assertTrue(works, "Problems with primitive data type creation or default value assignment.");
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
    void testPrimitives() {
        //TODO: finish this
        assertEquals(true, false, "primitive dataType test not finished yet");
    }
}