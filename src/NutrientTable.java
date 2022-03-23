import java.util.ArrayList;

public class NutrientTable {

    private ArrayList<Nutrient> inputs;

    public NutrientTable(ArrayList<Nutrient> inputs) {
        this.inputs = inputs;
    }

    public String createTable() {
        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append("NUTRIENT" + "\t" + "UNIT" + "\t" + "TARGET");

        for (Nutrient nutrient : inputs) {
            String nutrientName = nutrient.getName();
            String nutrientUnit = nutrient.getUnit();
            double nutrientTarget = nutrient.getTarget();
            tableBuilder.append(nutrientName + "\t" + nutrientUnit + "\t" + nutrientTarget + "\n");
        }

        return tableBuilder.toString();
    }
}
