package fileHandler.dataTypes.primitives;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

public class IEInteger extends IEPrimitive {
    private int defaultValue;
    private int value;

    public IEInteger(@NotNull String key, @NotNull int defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(@NotNull int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable int value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public int getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(String[] valueArray) {
        setValue(Integer.parseInt(valueArray[0]));
    }

    @Override
    public String[] parseValueToStringArray() {
        return new String[] {String.valueOf(value)};
    }
}