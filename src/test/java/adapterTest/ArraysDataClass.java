package adapterTest;

import com.google.inject.internal.Nullable;
import fileHandler.FileHandler;
import fileHandler.adapters.AbstractAdapter;
import fileHandler.dataTypes.arrays.IEBooleanArray;
import fileHandler.dataTypes.arrays.IEFloatArray;
import fileHandler.dataTypes.arrays.IEIntegerArray;
import fileHandler.dataTypes.arrays.IEStringArray;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ArraysDataClass extends AbstractAdapter {
    private static final String
            ADAPTER_DIRECTORY = "adapterTest",
            ADAPTER_FILE_NAME = "arrays";

    IEBooleanArray var_booleanArray = new IEBooleanArray("booleans", new boolean[] {false, true});
    IEIntegerArray var_integerArray = new IEIntegerArray("integers", new int[] {1, 2, 3});
    IEFloatArray var_floatArray = new IEFloatArray("floats", new float[] {1.2f, 3.4f});
    IEStringArray var_stringArray = new IEStringArray("strings", new String[] {"value1", "value2"});

    ArraysDataClass() {
        super(ADAPTER_DIRECTORY, ADAPTER_FILE_NAME);
    }

    @Override
    public void resetValues() {
        var_booleanArray.resetValue();
        var_integerArray.resetValue();
        var_floatArray.resetValue();
        var_stringArray.resetValue();
    }

    @Override
    public void importValues(@NotNull FileHandler fileHandler, @Nullable String parentDirectory) {
        ArrayList<String[]> lines = importLines(fileHandler, parentDirectory);
        for(String[] line : lines) {
            String key = line[0];

            if (var_booleanArray.compareKey(key)) {
                var_booleanArray.parseStringArrayToValue(var_booleanArray.separateValue(line));
            } else if (var_integerArray.compareKey(key)) {
                var_integerArray.parseStringArrayToValue(var_integerArray.separateValue(line));
            } else if (var_floatArray.compareKey(key)) {
                var_floatArray.parseStringArrayToValue(var_floatArray.separateValue(line));
            } else if (var_stringArray.compareKey(key)) {
                var_stringArray.parseStringArrayToValue(var_stringArray.separateValue(line));
            } else {
                //parameter with such key does not exist
            }
        }
    }

    @Override
    public ArrayList<String[]> exportValues() {
        return new ArrayList<>() {{
            add(var_booleanArray.combineKeyAndValue());
            add(var_integerArray.combineKeyAndValue());
            add(var_floatArray.combineKeyAndValue());
            add(var_stringArray.combineKeyAndValue());
        }};
    }
}