package fileHandler.dataTypes.primitives;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public class IEInteger extends IEPrimitive {
    private int defaultValue;
    private int value;

    public IEInteger(@NotNull String key, int defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
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