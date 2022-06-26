package fileHandler.dataTypes;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public abstract class IEPrimitive implements ImportableExportableInterface {
    private String key;

    //override this to save value
    public IEPrimitive(@NotNull String key) {
        setKey(key);
    }

    private void setKey(@NotNull String key) {
        this.key = key;
    }

    public boolean compareKey(@Nullable String key) {
        return this.key.equals(key);
    }

    public String[] combineKeyAndValue() {
        String[] value = parseValueToStringArray();
        String[] returnable = new String[value.length + 1];
        returnable[0] = key;
        System.arraycopy(value, 0, returnable, 1, value.length);
        return returnable;
    }

    public String[] separateValue(String[] line) {
        String[] returnable = new String[line.length - 1];
        System.arraycopy(line, 1, returnable, 0, returnable.length);
        return returnable;
    }
}