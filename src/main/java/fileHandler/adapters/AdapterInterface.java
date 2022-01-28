package fileHandler.adapters;

import fileHandler.FileHandler;

import java.util.ArrayList;

import com.google.inject.internal.Nullable;
import org.jetbrains.annotations.NotNull;

public interface AdapterInterface {
    void resetValues();

    void importValues(@NotNull FileHandler fileHandler,
                      @Nullable String parentDirectory);

    ArrayList<String[]> exportValues();
}