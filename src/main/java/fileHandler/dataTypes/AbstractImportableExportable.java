package fileHandler.dataTypes;

//TODO: add javadoc
public abstract class AbstractImportableExportable<T> implements ImportableExportableInterface {
    private String key;
    private T value;
    private T defaultValue;

    //override this to save value
    public AbstractImportableExportable(String key, T defaultValue) {
        setKey(key);
        setDefaultValue(defaultValue);
    }

    private void setKey(String key) {
        this.key = key;
    }

    public boolean compareKey(String key) {
        return this.key.equals(key);
    }

    private void setDefaultValue(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void importLine(String[] importableLine) {
        setKey(importableLine[0]);

        String[] values = new String[importableLine.length - 1];
        System.arraycopy(importableLine, 1, values, 0, values.length);

        importValueArray(values);
    }

    public String[] exportLine() {
        String[] values = exportValueArray();

        String[] exportable = new String[values.length + 1];
        exportable[0] = key;

        System.arraycopy(values, 0, exportable, 1, exportable.length);

        return exportable;
    }

    @Override
    public String[] exportValueArray() {
        return new String[] {String.valueOf(getValue())};
    }
}