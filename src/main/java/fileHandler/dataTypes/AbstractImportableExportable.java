package fileHandler.dataTypes;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

//TODO: add javadoc
public abstract class AbstractImportableExportable<T> implements ImportableExportableInterface {
    private String key;
    private T value;
    private T defaultValue;

    //override this to save value
    public AbstractImportableExportable(@NotNull String key, @NotNull T defaultValue) {
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

    public String[] exportLine() {
        String[] values = exportValueArray();

        String[] exportable = new String[values.length + 1];
        exportable[0] = key;

        System.arraycopy(values, 0, exportable, 1, exportable.length);

        return exportable;
    }

    @Override
    public String[] exportValueArray() {
        return new String[] {String.valueOf(getValue())};
    }
}