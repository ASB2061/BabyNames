public class Graveyard {
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

    //String[] cars = {"BMW", "Mazda", "Mercedes", "Jaguar", "McLaren", "Ferrari", "Mini", "Nissan", "Infiniti", "Toyota", "Hyundai", "Ford", "GMC", "Chevy", "Honda", "Honda"};
        /*for (String car : cars){
            NameData newName = new NameData(car, 1000);
            newMaleNamesList.insertAlpha(newName);
        }
        System.out.println(newMaleNamesList.toString());

         */

    // System.out.println(newMaleNamesList.fetch("Lamborghini"));
    // System.out.println(newMaleNamesList.fetch("Ferrari"));

    //System.out.println(newMaleNamesList.fetch("McLarenet"));
        /*
        System.out.println(newNameYall.getBabyName() + " " + newNameYall.getNameNumberNumber());
        System.out.println(nothaNewNameYall.getBabyName() + " " + nothaNewNameYall.getNameNumberNumber());
        System.out.println(newNameYall.compareTo(nothaNewNameYall));
         */

    //nothaNewNameYall.occurrenceIncrementUpdate(2000);
    //System.out.println(nothaNewNameYall.getNameNumberNumber());
}
