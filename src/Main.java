/***
 *
 */

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/***
 *
 */
public class Main {
    public static ArrayList<String> maleNames;
    public static ArrayList<String> femaleNames;
    public static ArrayList<String> fileNames;

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException, CsvException {
        // Your main code goes here. Remember to create the NameData, Node and DoublyLinkedList classes in separate files
        int i = 0;
        while (i < args.length)  {
            if (args[i].equals("-f") && (!args[i+1].equals("-f") && !args[i+1].equals("-m"))){
                femaleNames.add(args[i+1]);
                if (args[i + 2].contains("names")){
                    fileNames.add(args[i + 2]);
                    i += 2;
                }


            }
            else if (args[i].equals("-m") && (!args[i+1].equals("-f") && !args[i+1].equals("-m")) && !args[i + 2].contains("names")){
                maleNames.add(args[i+1]);
            }

        }
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("names1990.csv"));
        ArrayList<String[]> theNames = new ArrayList<String[]>(reader.readAll());
        reader.close();

       // DoublyLinkedList maleNames = new DoublyLinkedList();
    }
}
