package fileHandler;

class FileHandlerSupplement {
    static final TextFileReader textReader = new TextFileReader();
    static final TextFileWriter textWriter = new TextFileWriter();
    static final ImageReader imageReader = new ImageReader();

    static final String commonFileLocation = "resources/";

    static String addCommonPathPrefix(String relativeFilePath){
        return commonFileLocation + relativeFilePath;
    }
}