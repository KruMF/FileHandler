package fileHandler.adapters;

import fileHandler.FileHandler;
import fileHandler.dataTypes.IOlist;

import java.util.HashMap;

//TODO: needs more work and javadoc
public abstract class AdapterContainer extends AbstractAdapter {
    public AdapterContainer(String directory) {
        super(directory);
    }

    public void importMembers(FileHandler fileHandler,
                              String parentDirectory, String fileName,
                              HashMap<AbstractAdapter, IOlist> adapterMap) {
        for (AbstractAdapter adapter : adapterMap.keySet()) {
            if (adapter instanceof AdapterContainer) {
                /*((AdapterContainer) adapter).importMembers(
                        fileHandler,
                        parentDirectory, fileName,
                        );*/
            } else {
                adapter.importMembers(
                        fileHandler,
                        getDirectory(parentDirectory), fileName,
                        adapterMap.get(adapter));
            }
        }
    }

    public void exportMembers(FileHandler fileHandler,
                              String parentDirectory, String fileName,
                              IOlist members) {
        //TODO: needs rework - copy-paste from AbstractAdapter
        fileHandler.text.writeSeparatedLines(
                getDirectory(fileName), fileHandler,
                members.exportLines());
    }
}