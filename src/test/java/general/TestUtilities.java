package general;

//TODO: add javadoc
public class TestUtilities {

    //TODO: add javadoc
    public static void consolePrint(String message) {
        if (TestSettings.CONSOLE_OUT) {
            System.out.println(message);
        }
    }
}