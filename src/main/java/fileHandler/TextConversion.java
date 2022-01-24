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
        separator = NullCheck.nullSeparatorCheck(separator);
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
    public static HashMap<String, String[]> stringMapFromArrayList(ArrayList<String[]> lines) {
        try {
            HashMap<String, String[]> stringMap = new HashMap<>();
            for (String[] line : lines) {
                if (line == null || line.length == 0) {
                    emptyLineMessage();
                } else {
                    String key = line[0];
                    String[] value;
                    if (line.length == 1) {
                        // if line contains only key and no value
                        value = null;
                    } else {
                        value = Arrays.copyOfRange(line, 1, line.length);
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

    //TODO: add javadoc
    public static ArrayList<String> combineLines(String separator, ArrayList<String[]> separatedLines) {
        try {
            separator = NullCheck.nullSeparatorCheck(separator);
            ArrayList<String> combinedLines = new ArrayList<>();

            for (String[] splitLine : separatedLines) {
                combinedLines.add(combineLine(separator, splitLine));
            }

            return combinedLines;
        } catch (NullPointerException e) {
            System.out.println("Null ArrayList provided. Unable to combine.");
            return null;
        }
    }

    private static String combineLine(String separator, String[] combinable) {
        StringBuilder combinedLine = new StringBuilder();

        for (int i = 0; i < combinable.length; i++) {
            if (i > 0) {
                //prefixes separator if not first string
                combinedLine.append(separator);
            }
            combinedLine.append(combinable[i]);
        }

        return combinedLine.toString();
    }

    //TODO: add javadoc
    public static ArrayList<String[]> arrayListFromStringMap(HashMap<String, String[]> stringMap) {
        try {
            ArrayList<String[]> lines = new ArrayList<>();
            for (String key : stringMap.keySet()) {
                String[] value = stringMap.get(key);
                lines.add(prefixValueWithKey(key, value));
            }
            return lines;
        } catch (NullPointerException e) {
            System.out.println("Null map provided. Unable to convert.");
            return null;
        }
    }

    private static String[] prefixValueWithKey(String key, String[] value) {
        String[] line = new String[value.length + 1];
        line[0] = key;
        if (value.length > 0) {
            System.arraycopy(value, 0, line, 1, value.length);
        }
        return line;
    }
}