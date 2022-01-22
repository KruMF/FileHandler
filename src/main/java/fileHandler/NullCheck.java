package fileHandler;

/**
 * Helper class for checking null values.
 */
public class NullCheck {
    private static final String DEFAULT_SEPARATOR = " : ";

    protected static String nullDirectoryCheck(String directory) {
        return nullStringCheck(directory, "");
    }

    protected static String nullSeparatorCheck(String separator) {
        return nullStringCheck(separator, DEFAULT_SEPARATOR);
    }

    private static String nullStringCheck(String stringToCheck, String stringIfNull) {
        if (stringToCheck == null) {
            stringToCheck = stringIfNull;
        }
        return stringToCheck;
    }
}