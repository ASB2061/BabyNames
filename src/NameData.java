/***
 *
 */

public class NameData{
    // fields
    private int nameNumber;
    private String babyName;

    //getter methods
    public int getNameNumberNumber() {return nameNumber;}
    public String getBabyName() {return babyName;}

    //setter methods
    public void setNameNumber (int nameNumberInput) {nameNumber = nameNumberInput;}
    public void setBabyName(String babyNameInput) {babyName = babyNameInput;}

    // Constructor
    public NameData(String inputtedName, int numberOfNames){
        setBabyName(inputtedName);
        setNameNumber(numberOfNames);
    }

    public String toString(){
        //return //Integer.toString(rank) + "  " + babyName +  " " + Integer.toString(nameNumber);
        return getBabyName();
    }
    public int compareTo(NameData opposingNode){
        return this.getBabyName().compareTo(opposingNode.getBabyName());
    }

    public void occurrenceIncrementUpdate(int newOccurrenceData){
        nameNumber += newOccurrenceData;
    }
}
