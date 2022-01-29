package fileHandler.dataTypes.arrays;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public class IEStringArray extends IEPrimitive {
    private String[] defaultValue;
    private String[] value;

    public IEStringArray(@NotNull String key, @NotNull String[] defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(@NotNull String[] defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable String[] value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public String[] getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(String[] valueArray) {
        setValue(valueArray);
    }

    @Override
    public String[] parseValueToStringArray() {
        return getValue();
    }
}