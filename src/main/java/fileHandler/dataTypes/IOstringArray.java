package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOstringArray extends AbstractImportableExportable {
    public String[] value;

    public IOstringArray(String key) {
        super(key);
    }

    @Override
    public String[] valueArray() {
        return value;
    }

    @Override
    public void setValue(String[] valueArray) {
        value = valueArray;
    }
}