package fileHandler.dataTypes.primitives;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public class IEDouble extends IEPrimitive {
    private double defaultValue;
    private double value;

    public IEDouble(@NotNull String key, double defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(double defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable double value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public double getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(String[] valueArray) {
        setValue(Double.parseDouble(valueArray[0]));
    }

    @Override
    public String[] parseValueToStringArray() {
        return new String[] {String.valueOf(value)};
    }
}