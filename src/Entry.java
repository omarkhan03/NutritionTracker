import java.util.Comparator;

public class Entry {
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

    public String getNutrientName(){
        return this.nutrient.getName();
    }

    public String getNutrientUnit(){
        return this.nutrient.getUnit();
    }

    public double getConsumption(){
        return this.consumption;
    }

    public String getSurplusDeficiency() {
        if(this.consumption > this.nutrient.getTarget()){ //determines if a surplus or deficiency is present on average, or is the user has meets their daily target on a given day
            return ("You consumed a surplus of " + this.nutrient.getName() + " by " + (this.consumption - this.nutrient.getTarget()) + " units based on your target goal on day " + this.day);
        }
        else if(this.consumption < this.nutrient.getTarget()){
            return ("You were deficient in " + this.nutrient.getName() + " by " + (this.nutrient.getTarget() - this.consumption) + " " + this.nutrient.getUnit() + " based on your target goal on day " + this.day);
        }
        return null;
    }

    public String getSuccessfulTargets(){
        if(this.consumption == this.nutrient.getTarget()){
            return ("You were successful in meeting your target for " + this.nutrient.getName() + " based on your target goal on day " + this.day);
        }
        return null;
    }
}
