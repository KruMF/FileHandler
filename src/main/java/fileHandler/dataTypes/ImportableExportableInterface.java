package fileHandler.dataTypes;

//TODO: add javadoc
public interface ImportableExportableInterface {

    void resetValue();

    //override this to set actual value
    void parseStringArrayToValue(String[] valueArray);

    //override this to get actual value
    String[] parseValueToStringArray();

    // for colors in future
    /*
    if (valueArray.length == 3) {
        setValue(new Color(
                Integer.parseInt(valueArray[0]),
                Integer.parseInt(valueArray[1]),
                Integer.parseInt(valueArray[2])));

    } else if (valueArray.length == 4) {
        setValue(new Color(
                Integer.parseInt(valueArray[0]),
                Integer.parseInt(valueArray[1]),
                Integer.parseInt(valueArray[2]),
                Integer.parseInt(valueArray[3])));
    }

    return new String[] {
                    String.valueOf(color.getRed()),
                    String.valueOf(color.getGreen()),
                    String.valueOf(color.getBlue()),
                    String.valueOf(color.getAlpha())};
    */
}