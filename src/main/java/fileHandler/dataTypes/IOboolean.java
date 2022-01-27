package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOboolean extends AbstractImportableExportable<Boolean> {

    public IOboolean(String key, boolean defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public void importValueArray(String[] valueArray) {
        setValue(Boolean.parseBoolean(valueArray[0]));
    }
}