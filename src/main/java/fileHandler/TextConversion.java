package fileHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TextConversion {
    /**
     * Converts ArrayList of strings to ArrayList of string arrays.
     *
     * @param separator Separator for splitting lines.
     * @param lines     Lines of text as ArrayList of strings.
     *
     * @return ArrayList of string arrays separated by separator.
     */
    public static ArrayList<String[]> separateLines(String separator, ArrayList<String> lines) {
        if (separabilityCheck(separator, lines)) {
            ArrayList<String[]> returnableData = new ArrayList<>();

            for (String line : lines) {
                if (line == null || line.isEmpty()) {
                    emptyLineMessage();
                } else {
                    String[] splitLine = line.split(separator);
                    returnableData.add(splitLine);
                }
            }
            return returnableData;
        }
        return null;
    }

    private static boolean separabilityCheck(String separator, ArrayList<String> lines) {
        if (lines == null || lines.isEmpty()) {
            System.out.println("Null or empty lines provided. Nothing to separate.");
        } else if (separator == null) {
            System.out.println("Null separator provided. Unable to separate.");
        } else {
            return true;
        }

        return false;
    }

    private static void emptyLineMessage() {
        System.out.println("Empty line detected. Omitting line.");
    }

    //TODO: add javadoc
    public static HashMap<String, String[]> toStringMap(ArrayList<String[]> lines) {
        try {
            HashMap<String, String[]> stringMap = new HashMap<>();
            for (String[] line : lines) {
                if (line == null || line.length == 0) {
                    emptyLineMessage();
                } else {
                    String key = line[0];
                    String[] value;
                    if (line.length == 1) {
                        value = null;
                    } else {
                        value = Arrays.copyOfRange(line, 1, line.length - 1);
                    }
                    stringMap.put(key, value);
                }
            }
            return stringMap;
        } catch (NullPointerException e) {
            System.out.println("Null lines provided. Unable to convert to Map.");
            return null;
        }
    }
}