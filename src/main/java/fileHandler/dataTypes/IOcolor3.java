package fileHandler.dataTypes;

import java.awt.*;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOcolor3 extends AbstractImportableExportable{
    public Color value;

    public IOcolor3(String key) {
        super(key);
    }

    @Override
    public String[] valueArray() {
        return new String[] {
                String.valueOf(value.getRed()),
                String.valueOf(value.getGreen()),
                String.valueOf(value.getBlue())};
    }

    @Override
    public void setValue(String[] valueArray) {
        value = new Color(
                Integer.parseInt(valueArray[0]),
                Integer.parseInt(valueArray[1]),
                Integer.parseInt(valueArray[2]));
    }
}