import java.util.ArrayList;

public class NutrientTable {

    private ArrayList<Nutrient> inputs;

    public NutrientTable(ArrayList<Nutrient> inputs) {
        this.inputs = inputs;
    }

    public String createTable() {
        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append("----------------------------------------------------------\n");
        tableBuilder.append("NUTRIENT | UNIT | TARGET\n");

        for (Nutrient nutrient : inputs) {
            String nutrientName = nutrient.getName();
            String nutrientUnit = nutrient.getUnit();
            double nutrientTarget = nutrient.getTarget();
            tableBuilder.append(nutrientName + " | " + nutrientUnit + " | " + nutrientTarget + "\n");
        }
        tableBuilder.append("----------------------------------------------------------");
        return tableBuilder.toString();
    }

    @Override
    public String toString() {
        return createTable();
    }
}
