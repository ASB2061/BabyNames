/***
 *
 */

public class NameData implements Comparable<NameData>{
    // fields
    private int nameNumber; // number of occurrences of the babyname
    private String babyName; // the actual name of the baby

    //getter methods
    public int getNameNumberNumber() {return nameNumber;} // returns the occurrences
    public String getBabyName() {return babyName;} // returns the name

    //setter methods
    public void setNameNumber (int nameNumberInput) {nameNumber = nameNumberInput;} // sets the occurrences
    public void setBabyName(String babyNameInput) {babyName = babyNameInput;} // sets the name

    // Constructor
    public NameData(String inputtedName, int numberOfNames){ // constructor method for Name Data. Requires a string and int
        setBabyName(inputtedName);
        setNameNumber(numberOfNames);
    }

    @Override
    public String toString(){ // simply returns the babyName for toString, since this is used for comparing
        return getBabyName();
    }

    @Override
    public int compareTo(NameData opposingNode){ // compares the babynames for ordering the names alphabetically.
        return this.getBabyName().compareTo(opposingNode.getBabyName());
        // return Integer.compare(this.getBabyName().compareTo(opposingNode.getBabyName()), 0);
    }

    public void occurrenceIncrementUpdate(int newOccurrenceData){ // For updating the occurrence count if there is new data
        nameNumber += newOccurrenceData;
    }
}
