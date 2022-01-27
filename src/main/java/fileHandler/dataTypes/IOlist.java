package fileHandler.dataTypes;

import java.util.ArrayList;

import com.google.inject.internal.Nullable;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOlist {
    public ArrayList<AbstractImportableExportable<?>> list;

    public IOlist() {
        list = new ArrayList<>();
    }

    public AbstractImportableExportable<?> get(@Nullable String key) {
        if (key != null) {
            for (AbstractImportableExportable<?> member : list) {
                if (member.compareKey(key)) {
                    return member;
                }
            }
        }
        return null;
    }

    public void add(AbstractImportableExportable<?> object) {
        list.add(object);
    }

    public void importLines(ArrayList<String[]> importableLines) {
        for (String[] line : importableLines) {
            importLine(line);
        }
    }

    private void importLine(@Nullable String[] line) {
        if (line != null && line.length > 0) {
            get(line[0]).importLine(line);
        }
    }

    public ArrayList<String[]> exportLines() {
        ArrayList<String[]> exportable = new ArrayList<>();
        for (AbstractImportableExportable<?> member : list) {
            exportable.add(member.exportLine());
        }
        return exportable;
    }
}