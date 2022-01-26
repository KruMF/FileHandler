package fileHandler.dataTypes;

//TODO: add javadoc
public abstract class AbstractImportableExportable implements ImportableExportableInterface {
    private String key;

    //override this to save value
    public AbstractImportableExportable(String key) {
        setKey(key);
    }

    private void setKey(String key) {
        this.key = key;
    }

    public boolean compareKey(String key) {
        return this.key.equals(key);
    }

    public String[] exportLine() {
        String[] values = valueArray();
        String[] exportable = new String[values.length + 1];
        exportable[0] = key;
        System.arraycopy(values, 0, exportable, 1, exportable.length);
        return exportable;
    }

    public void importLine(String[] importableLine) {
        setKey(importableLine[0]);
        String[] values = new String[importableLine.length - 1];
        System.arraycopy(importableLine, 1, values, 0, values.length);
    }
}