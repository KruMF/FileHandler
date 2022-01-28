package adapterTest;

import fileHandler.adapters.AbstractAdapter;
import fileHandler.dataTypes.arrays.IEBooleanArray;
import fileHandler.dataTypes.arrays.IEFloatArray;
import fileHandler.dataTypes.arrays.IEIntegerArray;
import fileHandler.dataTypes.arrays.IEStringArray;

public class ArraysDataClass extends AbstractAdapter {
    IEBooleanArray var_booleanArray = new IEBooleanArray("booleans", new boolean[] {false, true});
    IEIntegerArray var_integerArray = new IEIntegerArray("integers", new int[] {1, 2, 3});
    IEFloatArray var_floatArray = new IEFloatArray("floats", new float[] {1.2f, 3.4f});
    IEStringArray var_stringArray = new IEStringArray("strings", new String[] {"value1", "value2"});

    ArraysDataClass(String directory) {
        super(directory);
    }

    @Override
    public void resetValues() {
        var_booleanArray.resetValue();
        var_integerArray.resetValue();
        var_floatArray.resetValue();
        var_stringArray.resetValue();
    }
}