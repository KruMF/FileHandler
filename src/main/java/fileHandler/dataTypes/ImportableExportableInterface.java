package fileHandler.dataTypes;

//TODO: add javadoc
public interface ImportableExportableInterface {

    //override this to get actual value
    String[] valueArray();

    //override this to set actual value
    void setValue(String[] valueArray);
}