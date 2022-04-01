/***
 * Lab 3 BabyNames: This lab allows users to search for the occurrence of baby names between 1990 and 2017. Multiple
 * data types are used including ArrayLists, doubles, ints and doubly linked lists to make all the calculations. The user
 * can input into the code using the terminal or for intellij, by modifying the run configuration for Main.java since it
 * would take too long to compile every file needed to run this program.
 *
 * NOTE: There may be some false positive errors in Main.java or DoublyLinkedList.java.
 * These can be ignored.
 *
 * @Author: Adiel Benisty
 * @version: April 1, 2022
 * */

// We import the necessary methods to read .csv files.
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/***
 * The main class runs the code of DoublyLinkedList, Node and NameData through the main method. It receives array args
 * which it iterates through. Then it reads through any files that were named in args, adding every name to either the
 * male or female doubly linked lists. Finally, it prints statistics of the names. Like how many occurrences there were
 * of the name in the years provided and the percentage of the occurrence of names with respect to the gender.
 */
public class Main {

    /***
     * The main method runs everything detailed in the description of the class Main. First, array lists for the inputs
     * are created. So maleNames, femaleNames and fileNames store the data given in parameter args. Next, doubles that
     * track the total male and female names are initialized and doublylinkedlists are created to store all the male
     * and female names. Next, a while loop is used to iterate through the array for args. Names are added to maleNames
     * and femaleNames and file names are added to fileNames. If fileNames or maleNames and femaleNames are empty then
     * the code throws an illegalArgument Exception, since there are either no names to use for searching or no years to
     * search through. Next the year csv files are iterated through by for loop. In this file, nodes are added to the
     * doubly linked lists each storing a name and the number of occurrences of that name. If a name comes up more than
     * once, then the number of occurrences is updated for that Node. Once all of the files are read, the statistics for
     * the names in args are printed by fetching the node storing that data in a print statement. If there is no data
     * for the name, then we return that the name could not be retrieved.
     * @param args
     * @throws IOException
     * @throws CsvException
     */
    public static void main(String[] args) throws IOException, CsvException {
        // Your main code goes here. Remember to create the NameData, Node and DoublyLinkedList classes in separate files

        // ArrayLists are created which will store the names given by args and fileNames given by args.
        ArrayList<String> maleNames = new ArrayList<>();
        ArrayList<String> femaleNames = new ArrayList<>();
        ArrayList<String> fileNames = new ArrayList<>();

        // tracks total names for calculating statistics
        double totalMaleNames = 0;
        double totalFemaleNames = 0;

        int i = 0; // for iterating through args

        // stores all the names searched through.
        DoublyLinkedList<NameData> theMaleNames = new DoublyLinkedList<>();
        DoublyLinkedList<NameData> theFemaleNames = new DoublyLinkedList<>();


        while (i < args.length)  { // we iterate through args
            if (args[i].equals("-f")){ // if it is '-f' then we can add the next element in args to female names
                try {
                    femaleNames.add(args[i + 1]);
                    i+=2;
                } catch (ArrayIndexOutOfBoundsException e){ // if args[i + 1] is out of bounds then we throw an exception
                    System.out.println("No more names in the command line argument.");
                }
            }
            else if (args[i].equals("-m")){ // if it is '-m' then we can add the next element in args to male names
                try {
                    maleNames.add(args[i + 1]);
                    i += 2;
                } catch (ArrayIndexOutOfBoundsException e){ // if args[i + 1] is out of bounds then we throw an exception
                    System.out.println("No names left in the command line argument.");
                }
            }
            else if (args[i].contains("names")){ // if args[i] contains the substring "names" then it will store a year
                // file since they have the format namesXXXX.csv
                fileNames.add(args[i]);
                i+=1;
            }
        }

        // These if-else statements verify that there are names and years to search through. Otherwise there is no reason
        // for the code to run.
        if (fileNames.isEmpty()){ throw new IllegalArgumentException ("No data set to search on!"); }
        else if (maleNames.isEmpty() && femaleNames.isEmpty()) {throw new IllegalArgumentException("No names to analyze!");}


        // This for loop iterates through all the fileNames given in args.
        for (String file : fileNames) {
            CSVReader reader = new CSVReader((new FileReader(file))); // each time we create a new arraylist to temporarily
            // store the data held in the .csv files.
            ArrayList<String[]> theNames = new ArrayList<String[]>(reader.readAll());

            for (String[] x : theNames) { // Next we iterate through the .csv file by the arraylist.
                // We create a new NameData for the male and female Names to prepare to add them to the doublyLinkedLists
                // holding maleNames and femaleNames.
                NameData newMaleName = new NameData(x[1], Integer.parseInt(x[2]));
                NameData newFemaleName = new NameData(x[3], Integer.parseInt(x[4]));

                // We increase the total names for male and female names for the calculations at the end.
                totalMaleNames += Integer.parseInt(x[2]);
                totalFemaleNames += Integer.parseInt(x[4]);

                // Finally, we have four if-else statements, since there are four cases.
                if (theMaleNames.findPosition(x[1]) == -1 && theFemaleNames.findPosition(x[3]) == -1) { // the first case
                    // is that the new names are new for both linkedlists
                    theMaleNames.insertAlpha(newMaleName);
                    theFemaleNames.insertAlpha(newFemaleName);
                } else if (theMaleNames.findPosition(x[1]) == -1 && theFemaleNames.findPosition(x[3]) != -1) { // the second
                    // case is that the male name is new, but the female name is not, then we update the female name node
                    // and we add the new male nae.
                    theMaleNames.insertAlpha(newMaleName);
                    theFemaleNames.fetch(x[3]).occurrenceIncrementUpdate(Integer.parseInt(x[4]));
                    //System.out.println("success");

                } else if (theFemaleNames.findPosition(x[3]) == -1 && theMaleNames.findPosition(x[1]) != -1) { // the third
                    // case is that the female name is new, but the male name is not. Then we update the male name node
                    // and add a new female name node.
                    theMaleNames.fetch(x[1]).occurrenceIncrementUpdate(Integer.parseInt(x[2]));
                    theFemaleNames.insertAlpha(newFemaleName);

                } else if (theMaleNames.findPosition(x[1]) != -1 && theFemaleNames.findPosition(x[3]) != -1) {
                    // The fourth case is that both names are not new to the doublylinkedlists. Then we just update the
                    // occurrences for both of them.
                    theMaleNames.fetch(x[1]).occurrenceIncrementUpdate(Integer.parseInt(x[2]));
                    theFemaleNames.fetch(x[3]).occurrenceIncrementUpdate(Integer.parseInt(x[4]));
                }

            }
            reader.close();
        }

        //System.out.println(System.out.println(String.format("%.6g%n", fraction));


        // Output of Statistics
        try {
            for (String maleName : maleNames) { // first we iterate through the male names inputted through the args array.
                if (theMaleNames.fetch(maleName) == null){ // if the name is not found
                    System.out.println("Name " + maleName + " not found. \n");
                    continue; // skip to the next iteration
                }
                // Otherwise, we print the name and its number of occurrences and its position in the linked list.
                String statisticMaleNames = String.format("%.6g%n",(theMaleNames.fetch(maleName).getNameNumberNumber() / totalMaleNames)); // used to get rid of a new line character
                // in string.format

                System.out.println(maleName + ": " + theMaleNames.fetch(maleName).getNameNumberNumber() + " occurrences in " + totalMaleNames + " names (" + statisticMaleNames.substring(0,statisticMaleNames.length() - 2) + "%)");
                System.out.println("Position of " + maleName + " in the Linked List: " + theMaleNames.findPosition(maleName) + "\n");
            }

            for (String femaleName : femaleNames) { // we iterate through the female names inputted through the args array
                if (theFemaleNames.fetch(femaleName) == null){ // if the name is not found.
                    System.out.println("Name " + femaleName + " not found. \n");
                    continue;
                }
                // Otherwise, we print the name and its number of occurrences and its position in the linked list.
                String statisticFemaleNames = String.format("%.6g%n",theFemaleNames.fetch(femaleName).getNameNumberNumber() / totalFemaleNames);
                // also used to get rid of a new line character in string.format

                System.out.println(femaleName + ": " + theFemaleNames.fetch(femaleName).getNameNumberNumber() + " occurrences in " + totalFemaleNames + " names (" + statisticFemaleNames.substring(0, statisticFemaleNames.length()-2) + "%)");
                System.out.println("Position of " + femaleName + " in the Linked List: " + theFemaleNames.findPosition(femaleName) + "\n");
            }
        } catch (ArithmeticException e){ // if somehow there is an issue where total occurrences is 0.
            System.out.println("Division by zero.");
        }

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

        // Some Testing
       /* maleNames.add("Michael");
        maleNames.add("Benjamin");
        maleNames.add("Matthew");
        maleNames.add("Adiel");

        femaleNames.add("Catherine");
        femaleNames.add("Elizabeth");
        femaleNames.add("Sarah");

        fileNames.add("names1995.csv");
        fileNames.add("names1996.csv");
        fileNames.add("names2007.csv");
        fileNames.add("test.csv"); */

        //System.out.println(fileNames);
        //System.out.println(femaleNames);
        //System.out.println(maleNames);

        //System.out.println(theMaleNames.toString() + "\n" + theFemaleNames.toString());

        //System.out.println(theMaleNames.findPosition("Adil"));
        //System.out.println(theMaleNames.fetch("Michael").getNameNumberNumber());
        //theMaleNames.fetch("Michael").occurrenceIncrementUpdate(1500);
        //System.out.println(theMaleNames.fetch("Michael").getNameNumberNumber());


    }
}
