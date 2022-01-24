package fileHandler;

import java.nio.charset.Charset;

public class EncodingUtilities {
    private static final EncodingType DEFAULT_ENCODING = EncodingType.E_1257;

    public enum EncodingType {
        E_1257
        //add new encoding types here
    }

    protected static Charset encodingTypeToCharset(EncodingType encoding) {
        switch (encoding) {
            //check for other encoding types here
            case E_1257 -> {
                return Charset.forName("Cp1257");
            }
            default -> {
                return encodingTypeToCharset(DEFAULT_ENCODING);
            }
        }
    }
}