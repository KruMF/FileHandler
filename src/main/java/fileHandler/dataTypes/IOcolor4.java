package fileHandler.dataTypes;

import java.awt.*;

//TODO: add javadoc
public class IOcolor4 extends IOcolor3 {
    public IOcolor4(String key, Color defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public void importValueArray(String[] valueArray) {
        setValue(new Color(
                Integer.parseInt(valueArray[0]),
                Integer.parseInt(valueArray[1]),
                Integer.parseInt(valueArray[2]),
                Integer.parseInt(valueArray[3])));
    }

    @Override
    public String[] exportValueArray() {
        Color color = getValue();
        return new String[] {
                String.valueOf(color.getRed()),
                String.valueOf(color.getGreen()),
                String.valueOf(color.getBlue()),
                String.valueOf(color.getAlpha())};
    }
}