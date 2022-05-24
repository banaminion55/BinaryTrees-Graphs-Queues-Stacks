package PracticeWithFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CSVReader {


    Scanner input;
    String currentLine;

    //path to the CSV file
    public CSVReader(String path) throws IOException {
        File myFile = new File(path);
        if(!myFile.exists())
            throw new IOException("Cannot find file");
        input = new Scanner(myFile);
    }

    //internally reads in next line
    public void readNextLine() {
        currentLine = input.nextLine();
    }

    //throws IllegalArgumentExcept if no nth column exists
    //throws illegalstateexcep if readnextline was not previously called
    public String getColumn(int n) {
        String[] row = currentLine.split(","); //limit??
        return row[n];
    }

    //Private helper methods as well

}
