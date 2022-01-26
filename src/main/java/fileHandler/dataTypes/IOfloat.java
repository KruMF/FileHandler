package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOfloat extends AbstractImportableExportable {
    public float value;

    public IOfloat(String key, float value) {
        super(key);
        this.value = value;
    }

    @Override
    public String[] valueArray() {
        return new String[] {String.valueOf(value)};
    }

    @Override
    public void setValue(String[] valueArray) {
        value = Float.parseFloat(valueArray[0]);
    }
}