package PracticeWithFiles;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.File;
import java.io.IOException;

public class CSVWriter2 {
    Formatter output;
    ArrayList<ArrayList<String>> CSV = new ArrayList();
    int currentRow = 0;

    public CSVWriter2(String path) throws IOException {
        File myFile = new File(path);
        CSV.add(currentRow, new ArrayList<>());
        if(!myFile.exists()) {
            myFile.createNewFile();
        }
        output = new Formatter(myFile);
    }

    public void addItem(String item) {
        CSV.get(currentRow).add(item);
    }

    public void addRow() {
        currentRow++;
        CSV.add(currentRow, new ArrayList<>());
    }

    public void saveCSV() {
        for(int i = 0; i < CSV.size(); i++) {
            for(int j = 0; j < CSV.get(i).size(); j++) {
                output.format(CSV.get(i).get(j));
                if(j < CSV.get(i).size()-1) {
                    output.format(",");
                }
            }
            output.format("\n");
        }
        output.close();
    }

}
