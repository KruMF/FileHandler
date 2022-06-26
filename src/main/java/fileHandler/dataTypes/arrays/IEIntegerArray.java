package fileHandler.dataTypes.arrays;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public class IEIntegerArray extends IEPrimitive {
    private int[] defaultValue;
    private int[] value;

    public IEIntegerArray(@NotNull String key, @NotNull int[] defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(@NotNull int[] defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable int[] value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public int[] getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(String[] valueArray) {
        int[] returnable = new int[valueArray.length];
        for (int i = 0; i < valueArray.length; i++) {
            returnable[i] = Integer.parseInt(valueArray[i]);
        }
        setValue(returnable);
    }

    @Override
    public String[] parseValueToStringArray() {
        int[] value = getValue();
        String[] returnable = new String[value.length];

        for (int i = 0; i < value.length; i++) {
            returnable[i] = String.valueOf(value[i]);
        }
        return returnable;
    }
}