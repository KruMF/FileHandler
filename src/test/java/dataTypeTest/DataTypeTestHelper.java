package dataTypeTest;

import java.util.Objects;

import org.jetbrains.annotations.Nullable;

/**
 * A helper class for data type tests.
 */
abstract class DataTypeTestHelper {

    /**
     * Adds a prefix and appendix for a string.
     *
     * @param prefix Prefix. (Null - empty)
     * @param main Main string. (Null - empty)
     * @param appendix Appendix. (Null - empty)
     * @return String with prefix and appendix attached.
     */
    private static String addIxes(@Nullable String prefix,
                                  @Nullable String main,
                                  @Nullable String appendix) {
        return Objects.requireNonNullElse(prefix, "")
                + Objects.requireNonNullElse(main, "")
                + Objects.requireNonNullElse(appendix, "");
    }

    /**
     * Prepares the error message for default value test upon test failure.
     *
     * @param typeName Name of the type. (Null - empty)
     * @return Error message.
     */
    static String defaultValueTest_errorMessage(@Nullable String typeName) {
        return addIxes(
                "Problems with ",
                typeName,
                " creation or default value assignment.");
    }

    /**
     * Prepares the error message for value parse test upon test failure.
     *
     * @param typeName Name of the type.
     * @return Error message.
     */
    static String valueParseTest_errorMessage(@Nullable String typeName) {
        return addIxes(
                "Problems with ",
                typeName,
                " value import or export.");
    }

    /**
     * Compares two string arrays.
     *
     * @param expected Expected string array.
     * @param actual Actual string array.
     *
     * @return True, if both arrays have equal contents; false, if not.
     */
    static boolean compareStringArrays(@Nullable String[] expected, @Nullable String[] actual) {
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