package fileHandler.adapters;

import fileHandler.fileHandling.FileHandler;

import java.util.ArrayList;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public abstract class AbstractAdapter extends ChildDirectory implements AdapterInterface {
    private String fileName;

    public AbstractAdapter(@NotNull String directoryName, @NotNull String fileName) {
        super(directoryName);
        setFileName(fileName);
    }

    private void setFileName(@NotNull String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath(@Nullable String parentDirectory) {
        return getDirectory(parentDirectory) + fileName;
    }

    public ArrayList<String[]> importLines(@NotNull FileHandler fileHandler, @Nullable String parentDirectory) {
        return fileHandler.text.readSeparatedLines(getFilePath(parentDirectory), fileHandler);
    }

    public void exportData(@NotNull FileHandler fileHandler, @Nullable String parentDirectory) {
        fileHandler.text.writeSeparatedLines(getFilePath(parentDirectory), fileHandler, exportValues());
    }
}