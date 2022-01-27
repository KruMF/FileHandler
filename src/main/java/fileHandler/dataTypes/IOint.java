package fileHandler.dataTypes;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOint extends AbstractImportableExportable<Integer> {

    public IOint(String key, int defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public void importValueArray(String[] valueArray) {
        setValue(Integer.parseInt(valueArray[0]));
    }
}