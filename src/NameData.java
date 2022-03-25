/***
 *
 */

public class NameData {
    // fields
    private int rank;
    private int nameNumber;
    private String babyName;

    //getter methods
    public int getRank(){ return rank;}
    public int getNameNumberNumber() {return nameNumber;}
    public String getBabyName() {return babyName;}

    //setter methods
    public void setRank(int rankInput){rank = rankInput;}
    public void setNameNumber (int nameNumberInput) {nameNumber = nameNumberInput;}
    public void setBabyName(String babyNameInput) {babyName = babyNameInput;}

    public String toString(){
        return Integer.toString(rank) + "  " + babyName +  " " + Integer.toString(nameNumber);
    }
    public boolean compareTo(NameData opposingNode){
        return (this.equals(opposingNode));
    }

    public void occurenceIncrementUpdate(int newOccurenceData){
        nameNumber += newOccurenceData;
    }
}
