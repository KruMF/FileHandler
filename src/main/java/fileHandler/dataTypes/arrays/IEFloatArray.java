package fileHandler.dataTypes.arrays;

import fileHandler.dataTypes.IEPrimitive;

import java.util.Objects;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

public class IEFloatArray extends IEPrimitive {
    private float[] defaultValue;
    private float[] value;

    public IEFloatArray(@NotNull String key, @NotNull float[] defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(@NotNull float[] defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable float[] value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public float[] getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(String[] valueArray) {
        float[] returnable = new float[valueArray.length];
        for (int i = 0; i < valueArray.length; i++) {
            returnable[i] = Float.parseFloat(valueArray[i]);
        }
        setValue(returnable);
    }

    @Override
    public String[] parseValueToStringArray() {
        float[] value = getValue();
        String[] returnable = new String[value.length];

        for (int i = 0; i < value.length; i++) {
            returnable[i] = String.valueOf(value[i]);
        }
        return returnable;
    }
}