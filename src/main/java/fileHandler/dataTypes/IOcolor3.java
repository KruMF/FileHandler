package fileHandler.dataTypes;

import java.awt.*;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOcolor3 extends AbstractImportableExportable<Color> {

    public IOcolor3(String key, Color defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public void importValueArray(String[] valueArray) {
        setValue(new Color(
                Integer.parseInt(valueArray[0]),
                Integer.parseInt(valueArray[1]),
                Integer.parseInt(valueArray[2])));
    }

    @Override
    public String[] exportValueArray() {
        Color color = getValue();
        return new String[] {
                String.valueOf(color.getRed()),
                String.valueOf(color.getGreen()),
                String.valueOf(color.getBlue())};
    }
}