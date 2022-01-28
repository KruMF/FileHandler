package fileHandler.dataTypes.arrays;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

public class IEBooleanArray extends IEPrimitive {
    private boolean[] defaultValue;
    private boolean[] value;

    public IEBooleanArray(@NotNull String key, @NotNull boolean[] defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(@NotNull boolean[] defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable boolean[] value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public boolean[] getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(String[] valueArray) {
        boolean[] returnable = new boolean[valueArray.length];
        for (int i = 0; i < valueArray.length; i++) {
            returnable[i] = Boolean.parseBoolean(valueArray[i]);
        }
        setValue(returnable);
    }

    @Override
    public String[] parseValueToStringArray() {
        boolean[] value = getValue();
        String[] returnable = new String[value.length];

        for (int i = 0; i < value.length; i++) {
            returnable[i] = String.valueOf(value[i]);
        }
        return returnable;
    }
}