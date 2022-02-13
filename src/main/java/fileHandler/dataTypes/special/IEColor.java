package fileHandler.dataTypes.special;

import fileHandler.dataTypes.IEPrimitive;

import java.awt.Color;
import java.util.Objects;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

/**
 * TODO:
 *  1. add tests and remove warning suppression
 *  2. add javadoc
 */
@SuppressWarnings("unused")
public class IEColor extends IEPrimitive {
    private Color defaultValue;
    private Color value;

    public IEColor(@NotNull String key, @NotNull Color defaultValue) {
        super(key);
        setDefaultValue(defaultValue);
        resetValue();
    }

    private void setDefaultValue(@NotNull Color defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public void resetValue() {
        setValue(defaultValue);
    }

    public void setValue(@Nullable Color value) {
        this.value = Objects.requireNonNullElse(value, defaultValue);
    }

    public Color getValue() {
        return value;
    }

    @Override
    public void parseStringArrayToValue(@Nullable String[] valueArray) {
        if (valueArray == null) {
            printErrorMessage("Null value array provided - unable to create color.");
            return;
        }

        try {
            switch (valueArray.length) {
                case 0, 1, 2 -> printErrorMessage("Too few arguments - unable to create color.");
                case 3 -> setColor3(valueArray);
                case 4 -> setColor4(valueArray);
                default -> {
                    printErrorMessage("Too many arguments - using first 4 for creating color.");
                    setColor4(valueArray);
                }
            }
        } catch (IllegalArgumentException e) {
            printErrorMessage("Illegal argument exception - unable to create color.");
        }
    }

    private void setColor3(@NotNull String[] valueArray) throws IllegalArgumentException {
        Color color = new Color(
                stringToInteger(valueArray[0]),
                stringToInteger(valueArray[1]),
                stringToInteger(valueArray[2]),
                255); // fully opaque by default

        setValue(color);
    }

    private void setColor4(@NotNull String[] valueArray) throws IllegalArgumentException {
        Color color = new Color(
                stringToInteger(valueArray[0]),
                stringToInteger(valueArray[1]),
                stringToInteger(valueArray[2]),
                stringToInteger(valueArray[3]));

        setValue(color);
    }

    private int stringToInteger(@Nullable String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            printErrorMessage(
                    "Number format exception while parsing string to integer during color creation.");
            return 0;
        }
    }

    private void printErrorMessage(@NotNull String message) {
        System.out.println(message);
    }

    @Override
    public String[] parseValueToStringArray() {
        Color color = getValue();

        int     red = color.getRed(),
                green = color.getGreen(),
                blue = color.getBlue(),
                alpha = color.getAlpha();

        return new String[] {
                String.valueOf(red),
                String.valueOf(green),
                String.valueOf(blue),
                String.valueOf(alpha)};
    }
}