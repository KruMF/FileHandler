package fileHandler.adapters;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

//TODO: add javadoc
public abstract class ChildDirectory {
    private String directory;

    public ChildDirectory(@NotNull String directory) {
        setDirectory(directory);
    }

    private void setDirectory(@NotNull String directory) {
        this.directory = directory;
    }

    public String getDirectory(@Nullable String parentDirectory) {
        String slash = "/";
        if (parentDirectory == null || parentDirectory.equals("")) {
            return directory + slash;
        } else {
            return parentDirectory + slash + directory + slash;
        }
    }
}