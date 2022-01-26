package fileHandler.dataTypes;

import java.util.ArrayList;

//TODO: add javadoc
@SuppressWarnings("unused")
public class IOlist {
    public ArrayList<AbstractImportableExportable> list;

    public IOlist() {
        list = new ArrayList<>();
    }

    public void add(AbstractImportableExportable object) {
        list.add(object);
    }

    public void importLines(ArrayList<String[]> importableLines) {
        for (String[] line : importableLines) {
            importLine(line);
        }
    }

    private void importLine(String[] line) {
        for (AbstractImportableExportable member : list) {
            String key = line[0];
            if (member.compareKey(key)) {
                member.importLine(line);
                break;
            }
        }
    }

    public ArrayList<String[]> exportLines() {
        ArrayList<String[]> exportable = new ArrayList<>();
        for (AbstractImportableExportable member : list) {
            exportable.add(member.exportLine());
        }
        return exportable;
    }
}