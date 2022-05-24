package PracticeWithFiles;
import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    static CSVReader reader;

    static {
        try {
            reader = new CSVReader("Test2.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
/*
        File myFile = new File("test.dat");
        if(!myFile.exists()) {
            myFile.createNewFile();
        }

        Formatter output = new Formatter(myFile);
        output.format("Hello\n");
        output.format("from the Java community");
        output.close();

        Scanner input = new Scanner(myFile);
        while(input.hasNext()) {
            String line = input.nextLine();
            System.out.println(line);
        }
        input.close();

        //File schoolData = new File("CSVTest.csv");
        //String path = schoolData.getPath();

 */

        /*System.out.println(navigateCSV(3,1));
        System.out.println(navigateCSV(4,1));*/
        //System.out.println(reader.getColumn(0));

        /*String[] first = {"Noah","Golder","4.0","11"};
        String[] second = {"Sam","Ng","5.0","11"};

        CSVWriter write = new CSVWriter("hello");
        write.addItemList(first);
        write.addItemList(second);
        write.closeWriter();*/

        String[][] heading = {
                {"Noah", "Golder", "4.6", "11"},
                {"Sam", "Ng", "4.0", "11"},
                {"Devin", "Alexandre", "4.3", "12"}
        };

        CSVWriter2 write = new CSVWriter2("hello");
        for (String[] list: heading) {
            for(String item: list) {
                write.addItem(item);
            }
            write.addRow();
        }
        write.saveCSV();

    }

    public static String navigateCSV(int a, int b) {
        for (int i = 0; i < a; i++) {
            reader.readNextLine();
        }
        return reader.getColumn(b);
    }
}
