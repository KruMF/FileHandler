package fileHandler.dataTypes;

import java.awt.*;

//TODO: add javadoc
public class IOcolor4 extends IOcolor3 {
    public IOcolor4(String key) {
        super(key);
    }

    @Override
    public String[] valueArray() {
        return new String[] {
                String.valueOf(value.getRed()),
                String.valueOf(value.getGreen()),
                String.valueOf(value.getBlue()),
                String.valueOf(value.getAlpha())};
    }

    @Override
    public void setValue(String[] valueArray) {
        value = new Color(
                Integer.parseInt(valueArray[0]),
                Integer.parseInt(valueArray[1]),
                Integer.parseInt(valueArray[2]),
                Integer.parseInt(valueArray[3]));
    }
}