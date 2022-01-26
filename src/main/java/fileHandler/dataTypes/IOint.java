package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOint extends AbstractImportableExportable {
    public int value;

    public IOint(String key, int value) {
        super(key);
        this.value = value;
    }

    @Override
    public String[] valueArray() {
        return new String[] {String.valueOf(value)};
    }

    @Override
    public void setValue(String[] valueArray) {
        value = Integer.parseInt(valueArray[0]);
    }
}