package general;

/**
 * Utility class for containing common test methods.
 */
public class TestUtilities {

    /**
     * Prints a message to console, if console enabled.
     *
     * @param message Message to print.
     */
    public static void consolePrint(String message) {
        if (TestSettings.CONSOLE_OUT) {
            System.out.println(message);
        }
    }
}