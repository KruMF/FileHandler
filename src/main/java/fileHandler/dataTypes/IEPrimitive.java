package fileHandler.dataTypes;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Objects;

//TODO: add javadoc
public class IEPrimitive<T> implements ImportableExportableInterface {
    private String key;
    private T value;
    private T defaultValue;

    //override this to save value
    public IEPrimitive(@NotNull String key, @NotNull T defaultValue) {
        setKey(key);
        setDefaultValue(defaultValue);
        setValue(defaultValue);
    }

    private void setKey(@NotNull String key) {
        this.key = key;
    }

    public boolean compareKey(@Nullable String key) {
        return this.key.equals(key);
    }

    private void setDefaultValue(@NotNull T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setValue(@Nullable T value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public T getValue() {
        return value;
    }

    public void importLine(@Nullable String[] importableLine) {
        if (importableLine != null) {
            String key = importableLine[0];
            if (compareKey(key)) {
                String[] values = new String[importableLine.length - 1];
                System.arraycopy(importableLine, 1, values, 0, values.length);

                importValueArray(values);
            }
        }
    }

    @Override
    public void importValueArray(String[] valueArray) {
        T value = getValue();
        if (value instanceof Boolean) {
            setValue(Boolean.parseBoolean(valueArray[0]));

        } else if (value instanceof Integer) {
            setValue(Integer.parseInt(valueArray[0]));

        } else if (value instanceof Float) {
            setValue(Float.parseFloat(valueArray[0]));

        } else if (value instanceof String) {
            setValue(valueArray[0]);

        } else if (value instanceof String[]) {
            setValue(valueArray);

        } else if (value instanceof Color) {
            if (valueArray.length == 3) {
                setValue(new Color(
                        Integer.parseInt(valueArray[0]),
                        Integer.parseInt(valueArray[1]),
                        Integer.parseInt(valueArray[2])));

            } else if (valueArray.length == 4) {
                setValue(new Color(
                        Integer.parseInt(valueArray[0]),
                        Integer.parseInt(valueArray[1]),
                        Integer.parseInt(valueArray[2]),
                        Integer.parseInt(valueArray[3])));
            }
        }
    }

    public String[] exportLine() {
        String[] values = exportValueArray();

        String[] exportable = new String[values.length + 1];
        exportable[0] = key;

        System.arraycopy(values, 0, exportable, 1, exportable.length);

        return exportable;
    }

    @Override
    public String[] exportValueArray() {
        T value = getValue();
        if (value instanceof Boolean
                || value instanceof Integer
                || value instanceof Float
                || value instanceof String) {
            return new String[] {String.valueOf(getValue())};

        } else if (value instanceof String[]) {
            return (String[]) getValue();

        } else if (value instanceof Color) {
            Color color = (Color) value;
            return new String[] {
                    String.valueOf(color.getRed()),
                    String.valueOf(color.getGreen()),
                    String.valueOf(color.getBlue()),
                    String.valueOf(color.getAlpha())};
        } else {
            return new String[] {};
        }
    }
}