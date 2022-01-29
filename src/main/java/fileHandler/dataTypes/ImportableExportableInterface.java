package fileHandler.dataTypes;

//TODO: add javadoc
public interface ImportableExportableInterface {

    void resetValue();

    //override this to set actual value
    void parseStringArrayToValue(String[] valueArray);

    //override this to get actual value
    String[] parseValueToStringArray();
}