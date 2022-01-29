package fileHandler.dataTypes.arrays;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public class IEDoubleArray extends IEPrimitive {
    private double[] defaultValue;
    private double[] value;

    public IEDoubleArray(@NotNull String key, double[] defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(double[] defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable double[] value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(String[] valueArray) {
        double[] returnable = new double[valueArray.length];
        for (int i = 0; i < valueArray.length; i++) {
            returnable[i] = Float.parseFloat(valueArray[i]);
        }
        setValue(returnable);
    }

    @Override
    public String[] parseValueToStringArray() {
        double[] value = getValue();
        String[] returnable = new String[value.length];

        for (int i = 0; i < value.length; i++) {
            returnable[i] = String.valueOf(value[i]);
        }
        return returnable;
    }
}