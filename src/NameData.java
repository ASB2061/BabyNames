/***
 *
 */

public class NameData {
    // fields
    private int rank;
    private int maleNumber;
    private int femaleNumber;
    private String maleName;
    private String femaleName;

    //getter methods
    public int getRank(){ return rank;}
    public int getMaleNumber() {return maleNumber;}
    public int getFemaleNumber() {return femaleNumber;}
    public String getMaleName() {return maleName;}
    public String getFemaleName() {return femaleName;}

    //setter methods
    public void setRank(int rankInput){rank = rankInput;}
    public void setMaleNumber(int maleNumberInput) {maleNumber = maleNumberInput;}
    public void setFemaleNumber (int femaleNumberInput) {femaleNumber = femaleNumberInput;}
    public void setMaleName(String maleNameInput){maleName = maleNameInput;}
    public void setFemaleName(String femaleNameInput) {femaleName = femaleNameInput;}

    public String toString(){
        return "";
    }
    public int compareTo(){
        return 1;
    }
}
