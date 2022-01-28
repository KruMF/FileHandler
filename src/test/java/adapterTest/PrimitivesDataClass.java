package adapterTest;

import fileHandler.adapters.AbstractAdapter;
import fileHandler.dataTypes.primitives.IEBoolean;
import fileHandler.dataTypes.primitives.IEFloat;
import fileHandler.dataTypes.primitives.IEInteger;
import fileHandler.dataTypes.primitives.IEString;

public class PrimitivesDataClass extends AbstractAdapter {
    IEBoolean var_boolean = new IEBoolean("boolean", true);
    IEInteger var_integer = new IEInteger("integer", 123);
    IEFloat var_float = new IEFloat("float", 1.23f);
    IEString var_string = new IEString("string", "value");

    PrimitivesDataClass(String directory) {
        super(directory);
    }

    @Override
    public void resetValues() {
        var_boolean.resetValue();
        var_integer.resetValue();
        var_float.resetValue();
        var_string.resetValue();
    }
}