package fileHandler.adapters;

import com.google.inject.internal.Nullable;
import fileHandler.FileHandler;
import fileHandler.dataTypes.IEList;

//TODO: add javadoc
public abstract class AbstractAdapter extends ChildDirectory {

    public AbstractAdapter(String directory) {
        super(directory);
    }

    public void importMembers(FileHandler fileHandler,
                              String parentDirectory, String fileName,
                              IEList members) {
        members.importLines(fileHandler.text.readSeparatedLines(
                parentDirectory + directory + fileName,
                fileHandler));
    }

    public void exportMembers(FileHandler fileHandler,
                              String parentDirectory, String fileName,
                              IEList members) {
        fileHandler.text.writeSeparatedLines(
                parentDirectory + directory + fileName, fileHandler,
                members.exportLines());
    }

    public void importLine(@Nullable String[] importableLine) {
        if (importableLine != null) {
            String key = importableLine[0];
            if (compareKey(key)) {
                String[] values = new String[importableLine.length - 1];
                System.arraycopy(importableLine, 1, values, 0, values.length);

                importValueArray(values);
            }
        }
    }
}