package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOfloat extends AbstractImportableExportable<Float> {

    public IOfloat(String key, float defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public void importValueArray(String[] valueArray) {
        setValue(Float.parseFloat(valueArray[0]));
    }
}