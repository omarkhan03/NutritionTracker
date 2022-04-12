package utils;

/**
 * Course: CPSC 233
 * Names: Carter Tam and Omar Khan
 * Date: Feb 28, 2022
 * Tutorial: T06 (Amirhossein)
 *
 * Nutrient object is used to store data for each nutrient that exists in the program, including its measuring unit
 * and target consumption value.
 */
public class Nutrient {

    private String name;
    private String unit;
    private double target;

    public Nutrient(String name, String unit, double target){
        this.name = name;
        this.unit = unit;
        this.target = target;
    }

    public String getName() {
        return this.name;
    }

    public String getUnit() {
        return this.unit;
    }

    public double getTarget() {
        return this.target;
    }
}
