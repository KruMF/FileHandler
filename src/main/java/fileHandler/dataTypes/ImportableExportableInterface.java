package fileHandler.dataTypes;

//TODO: add javadoc
public interface ImportableExportableInterface {

    //override this to set actual value
    void importValueArray(String[] valueArray);

    //override this to get actual value
    String[] exportValueArray();
}