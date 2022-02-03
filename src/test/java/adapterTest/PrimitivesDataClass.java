package adapterTest;

import fileHandler.fileHandling.FileHandler;
import fileHandler.dataTypes.primitives.*;
import fileHandler.adapters.AbstractAdapter;

import java.util.ArrayList;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

class PrimitivesDataClass extends AbstractAdapter {
    private static final String
            ADAPTER_DIRECTORY = "adapterTest",
            ADAPTER_FILE_NAME = "primitives";

    IEBoolean var_boolean = new IEBoolean("boolean", true);
    IEInteger var_integer = new IEInteger("integer", 123);
    IEFloat var_float = new IEFloat("float", 1.23f);
    IEString var_string = new IEString("string", "value");

    PrimitivesDataClass() {
        super(ADAPTER_DIRECTORY, ADAPTER_FILE_NAME);
    }

    @Override
    public void resetValues() {
        var_boolean.resetValue();
        var_integer.resetValue();
        var_float.resetValue();
        var_string.resetValue();
    }

    @Override
    public void importValues(@NotNull FileHandler fileHandler, @Nullable String parentDirectory) {
        ArrayList<String[]> lines = importLines(fileHandler, parentDirectory);
        for(String[] line : lines) {
            String key = line[0];

            if (var_boolean.compareKey(key)) {
                var_boolean.parseStringArrayToValue(var_boolean.separateValue(line));
            } else if (var_integer.compareKey(key)) {
                var_integer.parseStringArrayToValue(var_integer.separateValue(line));
            } else if (var_float.compareKey(key)) {
                var_float.parseStringArrayToValue(var_float.separateValue(line));
            } else if (var_string.compareKey(key)) {
                var_string.parseStringArrayToValue(var_string.separateValue(line));
            } else {
                //parameter with such key does not exist
            }
        }
    }

    @Override
    public ArrayList<String[]> exportValues() {
        return new ArrayList<>() {{
            add(var_boolean.combineKeyAndValue());
            add(var_integer.combineKeyAndValue());
            add(var_float.combineKeyAndValue());
            add(var_string.combineKeyAndValue());
        }};
    }
}