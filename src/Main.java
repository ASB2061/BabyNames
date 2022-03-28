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

        double totalMaleNames = 0;
        double totalFemaleNames = 0;
        int i = 0;

        DoublyLinkedList<NameData> theMaleNames = new DoublyLinkedList<>();
        DoublyLinkedList<NameData> theFemaleNames = new DoublyLinkedList<>();

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

        //System.out.println(fileNames);
        //System.out.println(femaleNames);
        //System.out.println(maleNames);

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


        // Testing Code
        for (String file : fileNames) {
            CSVReader reader = new CSVReader((new FileReader(file)));
            ArrayList<String[]> theNames = new ArrayList<String[]>(reader.readAll());

            for (String[] x : theNames) {
                NameData newMaleName = new NameData(x[1], Integer.parseInt(x[2]));
                NameData newFemaleName = new NameData(x[3], Integer.parseInt(x[4]));
                totalMaleNames += Integer.parseInt(x[2]);
                totalFemaleNames += Integer.parseInt(x[4]);
                if (theMaleNames.findPosition(x[1]) == -1 && theFemaleNames.findPosition(x[3]) == -1) {
                    theMaleNames.insertAlpha(newMaleName);
                    theFemaleNames.insertAlpha(newFemaleName);
                } else if (theMaleNames.findPosition(x[1]) == -1 && theFemaleNames.findPosition(x[3]) != -1) {
                    theMaleNames.insertAlpha(newMaleName);
                    theFemaleNames.fetch(x[3]).occurrenceIncrementUpdate(Integer.parseInt(x[4]));
                    //System.out.println("success");

                } else if (theFemaleNames.findPosition(x[3]) == -1 && theMaleNames.findPosition(x[1]) != -1) {
                    theMaleNames.fetch(x[1]).occurrenceIncrementUpdate(Integer.parseInt(x[2]));
                    theFemaleNames.insertAlpha(newFemaleName);

                } else if (theMaleNames.findPosition(x[1]) != -1 && theFemaleNames.findPosition(x[3]) != -1) {
                    //System.out.println(counter + ", " +  newMaleName.toString()+ ", " +  newFemaleName.toString());
                    theMaleNames.fetch(x[1]).occurrenceIncrementUpdate(Integer.parseInt(x[2]));
                    theFemaleNames.fetch(x[3]).occurrenceIncrementUpdate(Integer.parseInt(x[4]));
                }

            }
            reader.close();
        }

        //System.out.println(theMaleNames.toString() + "\n" + theFemaleNames.toString());

        //System.out.println(theMaleNames.findPosition("Adil"));
        //System.out.println(theMaleNames.fetch("Michael").getNameNumberNumber());
        //theMaleNames.fetch("Michael").occurrenceIncrementUpdate(1500);
        //System.out.println(theMaleNames.fetch("Michael").getNameNumberNumber());

        /*
        for (String file : fileNames){
            CSVReader reader = new CSVReader(new FileReader(file));
            ArrayList<String[]> theNames = new ArrayList<String[]>(reader.readAll());
            reader.close();
            //int counter = 0;
            for (String[] x : theNames) {
                NameData newMaleName = new NameData(x[1], Integer.parseInt(x[2]));
                NameData newFemaleName = new NameData(x[3], Integer.parseInt(x[4]));
                totalMaleNames+=Integer.parseInt(x[2]);
                totalFemaleNames+=Integer.parseInt(x[4]);
                if (theMaleNames.findPosition(x[1]) == -1 && theFemaleNames.findPosition(x[3]) == -1){
                    theMaleNames.insertAlpha(newMaleName);
                    theFemaleNames.insertAlpha(newFemaleName);
                }
                else if (theMaleNames.findPosition(x[1]) == -1 && theFemaleNames.findPosition(x[3]) != -1){
                    theMaleNames.insertAlpha(newMaleName);
                    theFemaleNames.fetch(x[3]).occurrenceIncrementUpdate(Integer.parseInt(x[4]));
                }
                else if (theFemaleNames.findPosition(x[3]) == -1 && theMaleNames.findPosition(x[1]) != -1){
                    theMaleNames.fetch(x[1]).occurrenceIncrementUpdate(Integer.parseInt(x[2]));
                    theFemaleNames.insertAlpha(newFemaleName);
                }
                else if (theMaleNames.findPosition(x[1]) != -1 && theFemaleNames.findPosition(x[3]) != -1) {
                    //System.out.println(counter + ", " +  newMaleName.toString()+ ", " +  newFemaleName.toString());
                    theMaleNames.fetch(x[1]).occurrenceIncrementUpdate(Integer.parseInt(x[2]));
                    theFemaleNames.fetch(x[3]).occurrenceIncrementUpdate(Integer.parseInt(x[4]));
                }
                //counter++;
            }
        }
         */

        // Output of Statistics
        try {
            for (String maleName : maleNames) {
                if (theMaleNames.fetch(maleName) == null){
                    System.out.println("Name " + maleName + " not found.");
                    continue;
                }
                System.out.println(maleName + ": " + theMaleNames.fetch(maleName).getNameNumberNumber() + " occurrences in " + totalMaleNames + " names (" + (theMaleNames.fetch(maleName).getNameNumberNumber() / totalMaleNames) + "%)");
                System.out.println("Position of " + maleName + " in the Linked List: " + theMaleNames.findPosition(maleName) + "\n");
            }

            for (String femaleName : femaleNames) {
                if (theFemaleNames.fetch(femaleName) == null){
                    System.out.println("Name " + femaleName + " not found.");
                    continue;
                }
                System.out.println(femaleName + ": " + theFemaleNames.fetch(femaleName).getNameNumberNumber() + " occurrences in " + totalFemaleNames + " names (" + (theFemaleNames.fetch(femaleName).getNameNumberNumber() / totalFemaleNames) + "%)");
                System.out.println("Position of " + femaleName + " in the Linked List: " + theFemaleNames.findPosition(femaleName) + "\n");
            }
        } catch (ArithmeticException e){
            System.out.println("Division by zero.");
        }



        //int counter = 0;
        /*for (String[] x : theNames) {
            NameData newMaleName = new NameData(x[1], Integer.parseInt(x[2]));
            NameData newFemaleName = new NameData(x[3], Integer.parseInt(x[4]));
            System.out.println(counter + ", " +  newMaleName.toString()+ ", " +  newFemaleName.toString());
            theMaleNames.insertAlpha(newMaleName);
            theFemaleNames.insertAlpha(newFemaleName);
            counter++;
        }*/
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
