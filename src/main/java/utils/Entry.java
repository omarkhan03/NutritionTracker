package utils;

import java.util.Comparator;

/**
 * Course: CPSC 233
 * Names: Carter Tam and Omar Khan
 * Date: Feb 28, 2022
 * Tutorial: T06 (Amirhossein)
 *
 * Entry object is used to store data for each entry that exists in the program. An entry is a record of a specified
 * quantity of a particular nutrient consumed on a particular day.
 */
public class Entry implements Comparable<Entry>{
    private int day;
    private Nutrient nutrient;
    private double consumption;

    public Entry(int day, Nutrient nutrient, double consumption){
        this.day = day;
        this.nutrient = nutrient;
        this.consumption = consumption;
    }

    public int getDay(){
        return this.day;
    }

    public String getNutrientName(){//gets nutrient name for entry
        return this.nutrient.getName();
    }

    public String getNutrientUnit(){
        return this.nutrient.getUnit();//gets nutrient target for entry
    }

    public Double getNutrientTarget(){
        return this.nutrient.getTarget();
    }

    public double getConsumption(){
        return this.consumption;
    }

    /**
     * Compares an entries consumption to a nutrient target consumption
     * @return either a string stating a surplus or deficiency if one is present, or an empty string if one is not present
     */
    public String getSurplusDeficiency() {
        if(this.consumption > this.nutrient.getTarget()){ //determines if a surplus or deficiency is present on average, or is the user has meets their daily target on a given day
            return ("You consumed a surplus of " + this.nutrient.getName() + " by " + (this.consumption - this.nutrient.getTarget()) + " " + this.nutrient.getUnit() + " based on your target goal on day " + this.day);
        }
        else if(this.consumption < this.nutrient.getTarget()){
            return ("You were deficient in " + this.nutrient.getName() + " by " + (this.nutrient.getTarget() - this.consumption) + " " + this.nutrient.getUnit() + " based on your target goal on day " + this.day);
        }
        return "";
    }

    /**
     * Checks if a target consumption for a nutrient has been met
     * @return a string if a target consumption is met, or nothing if not
     */
    public String getSuccessfulTargets(){
        if(this.consumption == this.nutrient.getTarget()){
            return ("You were successful in meeting your target for " + this.nutrient.getName() + " based on your target goal on day " + this.day);
        }
        return "";
    }

    @Override
    public int compareTo(Entry other) {//sorts by day, coded with help from https://www.baeldung.com/java-comparator-comparable and https://www.infoworld.com/article/3323403/java-challengers-5-sorting-with-comparable-and-comparator-in-java.html
        return Integer.compare(this.getDay(), other.getDay());
    }
}
