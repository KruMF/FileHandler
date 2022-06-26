package fileHandler.adapters;

import fileHandler.fileHandling.FileHandler;

import java.util.ArrayList;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;

public interface AdapterInterface {
    void resetValues();

    void importValues(@NotNull FileHandler fileHandler,
                      @Nullable String parentDirectory);

    ArrayList<String[]> exportValues();
}