package fileHandler.dataTypes;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;

//TODO: add javadoc
public class IEPrimitive<T> implements ImportableExportableInterface {
    private String key;

    private Class<T> type;

    private T value;
    private T defaultValue;

    //override this to save value
    public IEPrimitive(Class<T> type, @NotNull String key, @NotNull T defaultValue) {
        setKey(key);

        this.type = type;

        setDefaultValue(defaultValue);
        setValue(defaultValue);
    }

    private void setKey(@NotNull String key) {
        this.key = key;
    }

    public boolean compareKey(@Nullable String key) {
        return this.key.equals(key);
    }

    private Class<T> getParameterClass() {
        return type;
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
        Class<T> parameterClass = getParameterClass();


        ((ParameterizedType) T).getActualTypeArguments()

        var asd = ((ParameterizedType) value).getClass().getGenericSuperclass();

        T value = this.getValue();
        String className = value.getClass().getGenericSuperclass().getTypeName();
        switch (((ParameterizedType) value).getClass().getGenericSuperclass().getTypeName()) {
            case "boolean" -> {}
            default -> {}
        }
        if (parameterClass == Boolean.class) {
            setValue(Boolean.parseBoolean(valueArray[0]));

        } else if (parameterClass == Integer.class) {
            setValue(Integer.parseInt(valueArray[0]));

        } else if (parameterClass == Float.class) {
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