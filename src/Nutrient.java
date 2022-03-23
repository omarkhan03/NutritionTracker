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
