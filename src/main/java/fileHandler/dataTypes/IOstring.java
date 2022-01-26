package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOstring extends AbstractImportableExportable {
    public String value;

    public IOstring(String key, String value) {
        super(key);
        this.value = value;
    }

    @Override
    public String[] valueArray() {
        return new String[] {value};
    }

    @Override
    public void setValue(String[] valueArray) {
        value = valueArray[0];
    }
}