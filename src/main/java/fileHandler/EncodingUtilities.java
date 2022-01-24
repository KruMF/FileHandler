package fileHandler;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class EncodingUtilities {
    private static final EncodingType DEFAULT_ENCODING = EncodingType.E_1257;

    public enum EncodingType {
        UTF_8,
        E_1257
        //add new encoding types here
    }

    protected static Charset encodingTypeToCharset(EncodingType encoding) {
        switch (encoding) {
            //check for other encoding types here
            case UTF_8 -> {
                return StandardCharsets.UTF_8;
            }
            case E_1257 -> {
                return Charset.forName("Cp1257");
            }
            default -> {
                return encodingTypeToCharset(DEFAULT_ENCODING);
            }
        }
    }
}