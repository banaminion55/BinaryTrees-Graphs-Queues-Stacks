package PracticeWithFiles;
import java.util.Formatter;
import java.io.File;
import java.io.IOException;

//Create new file
//2D ArrayList
//Users can add specific elements into that arrayList
//Users add line by line

public class CSVWriter {

    Formatter output;

    public CSVWriter(String path) throws IOException {
        File myFile = new File(path);
        if(!myFile.exists()) {
            myFile.createNewFile();
        }
        output = new Formatter(myFile);
    }

    public void addItemList(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            output.format(arr[i]);
            if (i < arr.length-1) {
                output.format(",");
            }
        }
        output.format("\n");
    }

    public void addItem(String item, int row, int col) {

    }

    public void closeWriter() {
        output.close();
    }




}
