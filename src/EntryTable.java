import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class EntryTable {
    private ArrayList<Entry> inputs;

    public EntryTable (ArrayList<Entry> inputs){
        this.inputs = inputs;
    }

    public String createTable(){
        String table = "----------------------------------------------------------\n";
        table = table + "DAY | NUTRIENT | QUANTITY\n";

        Collections.sort(this.inputs, new Comparator<Entry>(){ //compares day value of days to sort list of entries
            public int compare(Entry ent1, Entry ent2){
                return Integer.compare(ent1.getDay(), ent2.getDay());
            }
        });

        for (Entry entry: this.inputs){ //after sorting the list, it's contents are semi-organized and printed to the console using a for loop
            table = table + entry.getDay() + " | " + entry.getNutrientName() + " | " + entry.getConsumption() + " " + entry.getNutrientUnit() + "\n";
        }
        table = table + "----------------------------------------------------------";
        return table;
    }

    public double getAverage(Nutrient nutrient){
        int count = 0; double avg = 0;
        for(Entry entry : inputs){
            if(entry.getNutrientName().equals(nutrient.getName())){
                count++;
                avg = avg + entry.getConsumption();
            }
        }
        avg = avg/count;
        return avg;
    }

    public String compareTwoDays(Nutrient nutrient, int day1, int day2){
        for(Entry entry : inputs){
            if((entry.getDay() == day1) && (entry.getNutrientName().equals(nutrient))){
                for(Entry entry2 : inputs){
                    if((entry2.getDay() == day2) && (entry2.getNutrientName().equals(nutrient))){
                        if (entry.getConsumption() > entry2.getConsumption()) {
                            double consumptionDifference = entry.getConsumption() - entry2.getConsumption();
                            System.out.println("Day " + entry.getDay() + "'s " + nutrient + " consumption is greater than " +
                                    "that of day " + entry2.getDay() + " by " + consumptionDifference + " " + entry.getNutrientUnit());
                        } else if (entry.getConsumption() > entry2.getConsumption()) {
                            double consumptionDifference = entry2.getConsumption() - entry.getConsumption();
                            System.out.println("Day " + entry.getDay() + "'s " + nutrient + " consumption is less than " +
                                    "that of day " + entry2.getDay() + " by " + consumptionDifference + " units.");
                        } else {
                            System.out.println("Day " + entry.getDay() + "'s " + nutrient + " consumption is equal to " +
                                    "that of day " + entry2.getDay());
                        }
                    }
                }
            }
        }
        return null;
    }


}
