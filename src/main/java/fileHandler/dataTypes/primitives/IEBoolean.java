package fileHandler.dataTypes.primitives;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public class IEBoolean extends IEPrimitive {
    private boolean defaultValue;
    private boolean value;

    public IEBoolean(@NotNull String key, boolean defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable boolean value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public boolean getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(String[] valueArray) {
        setValue(Boolean.parseBoolean(valueArray[0]));
    }

    @Override
    public String[] parseValueToStringArray() {
        return new String[] {String.valueOf(getValue())};
    }
}