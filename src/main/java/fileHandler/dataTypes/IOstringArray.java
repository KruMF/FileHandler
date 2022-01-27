package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOstringArray extends AbstractImportableExportable<String[]> {

    public IOstringArray(String key, String[] defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public void importValueArray(String[] valueArray) {
        setValue(valueArray);
    }

    @Override
    public String[] exportValueArray() {
        return getValue();
    }
}