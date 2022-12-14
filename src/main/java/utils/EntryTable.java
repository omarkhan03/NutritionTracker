package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Double.isNaN;
import static java.lang.Integer.parseInt;

/**
 * Course: CPSC 233
 * Names: Carter Tam and Omar Khan
 * Date: Feb 28, 2022
 * Tutorial: T06 (Amirhossein)
 *
 * EntryTable object is a table containing information for each entry that exists in the program. An entry is a record
 * of a specified quantity of a particular nutrient consumed on a particular day.
 */
public class EntryTable {
    private ArrayList<Entry> inputs;

    public EntryTable (ArrayList<Entry> inputs){
        this.inputs = inputs;
    }

    /**
     * creates a string representation of a sorted list of entries
     * @return the table representation as a string
     */
    public String createTable(){
        String table = "----------------------------------------------------------\n";
        table = table + "DAY | NUTRIENT | QUANTITY\n";

        Collections.sort(this.inputs);

        for (Entry entry: this.inputs){ //after sorting the list, it's contents are semi-organized and printed to the console using a for loop
            table = table + entry.getDay() + " | " + entry.getNutrientName() + " | " + entry.getConsumption() + " " + entry.getNutrientUnit() + "\n";
        }

        table = table + "----------------------------------------------------------";
        return table;
    }

    /**
     * Gets the average consumption of a specified nutrient  from an arrayList of user entries
     * @param nutrient is the speicifed nutrient to find an average consumption for
     * @return the average consumption in a string
     */
    public String getAverage(String nutrient){
        int count = 0; double avg = 0; String unit = "";
        for(Entry entry : inputs){
            if(entry.getNutrientName().equals(nutrient)){
                count++;
                avg = avg + entry.getConsumption();
                unit = entry.getNutrientUnit();
            }
        }
        avg = avg/count;

        if (isNaN(avg)) {
            return null;
        } else {
            return "Your average consumption of " + nutrient + " is " + avg + " " + unit;
        }
    }

    /**
     * Compares the consumption of a nutrient on one day to a consumption of the same nutrient on another day
     * @param nutrient is a specified nutrient consumption to compare
     * @param day1 is one of the two days to compare
     * @param day2 is the other day to compare
     * @return a string that explains how the two consumptions
     */
    public String compareTwoDays(String nutrient, int day1, int day2){
        for(Entry entry : inputs){
            if((entry.getDay() == day1) && (entry.getNutrientName().equals(nutrient))){
                for(Entry entry2 : inputs){
                    if((entry2.getDay() == day2) && (entry2.getNutrientName().equals(nutrient))){//result is different depending on the comparison (ie. less than, greater than, or equal to)
                        if (entry.getConsumption() > entry2.getConsumption()) {
                            double consumptionDifference = entry.getConsumption() - entry2.getConsumption();
                            return "Day " + entry.getDay() + "'s " + nutrient + " consumption is greater than " + "that of day " + entry2.getDay() + " by " + consumptionDifference + " " + entry.getNutrientUnit();
                        } else if (entry.getConsumption() < entry2.getConsumption()) {
                            double consumptionDifference = entry2.getConsumption() - entry.getConsumption();
                            return "Day " + entry.getDay() + "'s " + nutrient + " consumption is less than " + "that of day " + entry2.getDay() + " by " + consumptionDifference + " " + entry.getNutrientUnit();
                        } else {
                            return "Day " + entry.getDay() + "'s " + nutrient + " consumption is equal to " + "that of day " + entry2.getDay();
                        }
                    }
                }
            }
        }
        return "No comparison can be made for the given days!";
    }

    @Override
    public String toString() {
        return createTable();
    }
}
