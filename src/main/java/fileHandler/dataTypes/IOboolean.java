package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOboolean extends AbstractImportableExportable {
    public boolean value;

    public IOboolean(String key, boolean value) {
        super(key);
        this.value = value;
    }

    @Override
    public String[] valueArray() {
        return new String[] {String.valueOf(value)};
    }

    @Override
    public void setValue(String[] valueArray) {
        value = Boolean.parseBoolean(valueArray[0]);
    }
}