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
    public static void main(String[] args) throws IOException, CsvException {
        // Your main code goes here. Remember to create the NameData, Node and DoublyLinkedList classes in separate files
        //if (args[0] == '-f'){

        //}
        CSVReaderHeaderAware reader = new CSVReaderHeaderAware(new FileReader("names1990.csv"));
        ArrayList<String[]> theNames = new ArrayList<String[]>(reader.readAll());
        reader.close();

       // DoublyLinkedList maleNames = new DoublyLinkedList();
    }
}
