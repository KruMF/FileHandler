package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOstring extends AbstractImportableExportable<String> {

    public IOstring(String key, String defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public void importValueArray(String[] valueArray) {
        setValue(valueArray[0]);
    }
}