import java.util.ArrayList;

public class NutrientTable {

    private ArrayList<String> inputs;

    public NutrientTable(ArrayList<String> inputs) {
        this.inputs = inputs;
    }

    public String createTable() {
        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append("NUTRIENT" + "\t" + "UNIT" + "\t" + "TARGET");

        for (String nutrient : inputs) {
            tableBuilder.append(nutrient + "\n");
        }

        return tableBuilder.toString();
    }
}
