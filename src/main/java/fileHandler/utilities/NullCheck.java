package fileHandler.utilities;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

/**
 * Helper class for checking null directory and separator values.
 */
public class NullCheck {
    private static final String DEFAULT_DIRECTORY = "";
    private static final String DEFAULT_SEPARATOR = " : "; //mind the spaces around the colon

    /**
     * Checks if provided directory name is null.
     *
     * @param directory Name of the directory to check.
     * @return Directory name if non-null, default directory name if null.
     */
    public static String directoryCheck(@Nullable String directory) {
        return nullStringCheck(directory, DEFAULT_DIRECTORY);
    }

    /**
     * Checks if provided separator value is null.
     *
     * @param separator Value of the separator to check.
     * @return Separator value if non-null, default separator if null.
     */
    public static String separatorCheck(@Nullable String separator) {
        return nullStringCheck(separator, DEFAULT_SEPARATOR);
    }

    private static String nullStringCheck(@Nullable String stringToCheck, @NotNull String stringIfNull) {
        if (stringToCheck == null) {
            stringToCheck = stringIfNull;
        }
        return stringToCheck;
    }
}