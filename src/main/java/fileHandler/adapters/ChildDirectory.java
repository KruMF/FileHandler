package fileHandler.adapters;

//TODO: add javadoc
public abstract class ChildDirectory {
    private String directory;

    public ChildDirectory(String directory) {
        setDirectory(directory);
    }

    private void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getDirectory(String parentDirectory) {
        return parentDirectory + directory;
    }
}