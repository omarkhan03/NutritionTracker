public class Nutrient {

    private String name;
    private String unit;
    private double target;

    public Nutrient(String name, double target, String unit){
        this.name = name;
        this.target = target;
        this.unit = unit;
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
