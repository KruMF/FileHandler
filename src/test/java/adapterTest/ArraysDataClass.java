package adapterTest;

import fileHandler.fileHandling.FileHandler;
import fileHandler.dataTypes.arrays.*;
import fileHandler.adapters.AbstractAdapter;
import general.TestSettings;

import java.util.ArrayList;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

class ArraysDataClass extends AbstractAdapter {
    private static final String ADAPTER_FILE_NAME = "arrays";

    IEBooleanArray var_booleanArray = new IEBooleanArray("booleans", new boolean[] {false, true});
    IEIntegerArray var_integerArray = new IEIntegerArray("integers", new int[] {1, 2, 3});
    IEFloatArray var_floatArray = new IEFloatArray("floats", new float[] {1.2f, 3.4f});
    IEDoubleArray var_doubleArray = new IEDoubleArray("doubles", new double[] {1.2, 3.4});
    IEStringArray var_stringArray = new IEStringArray("strings", new String[] {"value1", "value2"});

    ArraysDataClass(String directory) {
        super(directory, ADAPTER_FILE_NAME);
    }

    @Override
    public void resetValues() {
        var_booleanArray.resetValue();
        var_integerArray.resetValue();
        var_floatArray.resetValue();
        var_doubleArray.resetValue();
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
            } else if (var_doubleArray.compareKey(key) && TestSettings.DO_DOUBLES) {
                var_doubleArray.parseStringArrayToValue(var_doubleArray.separateValue(line));
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
            if (TestSettings.DO_DOUBLES) {
                add(var_doubleArray.combineKeyAndValue());
            }
            add(var_stringArray.combineKeyAndValue());
        }};
    }
}