package fileHandler.adapters;

import fileHandler.FileHandler;
import fileHandler.dataTypes.IOlist;

//TODO: add javadoc
public abstract class AbstractAdapter {
    private String directory;

    public AbstractAdapter(String directory) {
        setDirectory(directory);
    }

    private void setDirectory(String directory) {
        this.directory = directory;
    }

    public void importMembers(FileHandler fileHandler,
                              String parentDirectory, String fileName, IOlist members) {
        members.importLines(fileHandler.text.readSeparatedLines(
                parentDirectory + directory + fileName,
                fileHandler));
    }

    public void exportMembers(FileHandler fileHandler,
                              String parentDirectory, String fileName,
                              IOlist members) {
        fileHandler.text.writeSeparatedLines(
                parentDirectory + directory + fileName, fileHandler,
                members.exportLines());
    }
}