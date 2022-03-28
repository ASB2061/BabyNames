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
        ArrayList<String> maleNames = new ArrayList<>();
        ArrayList<String> femaleNames = new ArrayList<>();
        ArrayList<String> fileNames = new ArrayList<>();
        // Some Testing
        maleNames.add("Michael");
        maleNames.add("Benjamin");
        maleNames.add("Matthew");

        femaleNames.add("Catherine");
        femaleNames.add("Elizabeth");
        femaleNames.add("Sarah");

        fileNames.add("names1995.csv");
        fileNames.add("names1996.csv");
        fileNames.add("names2007.csv");
        fileNames.add("test.csv");

        /*System.out.println(fileNames);
        System.out.println(femaleNames);
        System.out.println(maleNames);*/
        int i = 0;
        while (i < args.length)  {
            if (args[i].equals("-f")){
                try {
                    femaleNames.add(args[i + 1]);
                    i+=2;
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("No more names in the command line argument.");
                }
            }
            else if (args[i].equals("-m")){
                try {
                    maleNames.add(args[i + 1]);
                    i += 2;
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("No names left in the command line argument.");
                }
            }
            else if (args[i].contains("names")){
                fileNames.add(args[i]);
                i+=1;
            }
        }
        DoublyLinkedList<NameData> theMaleNames = new DoublyLinkedList<>();
        DoublyLinkedList<NameData> theFemaleNames = new DoublyLinkedList<>();


       CSVReader reader = new CSVReader(new FileReader("test.csv"));
       ArrayList<String[]> theNames = new ArrayList<String[]>(reader.readAll());
       int counter = 0;
        for (String[] x : theNames) {
            NameData newMaleName = new NameData(x[1], Integer.parseInt(x[2]));
            System.out.println(counter + ", " +  newMaleName.toString());
            theMaleNames.insertAlpha(newMaleName);
            counter++;
        }

        System.out.println(theMaleNames.toString());

        /*for (String n : fileNames){
            CSVReader reader = new CSVReader(new FileReader(n));
            ArrayList<String[]> theNames = new ArrayList<String[]>(reader.readAll());
            for (String[] x : theNames){
                NameData newMaleName = new NameData(x[1],Integer.parseInt(x[2]));
                System.out.println(newMaleName.toString());
                NameData newFemaleName = new NameData(x[3],Integer.parseInt(x[4]));
                theMaleNames.insertAlpha(newMaleName);
                theFemaleNames.insertAlpha(newFemaleName);
            }

            reader.close();
        }*/






       // DoublyLinkedList maleNames = new DoublyLinkedList();
    }
}
