import java.util.ArrayList;

public class NutrientTable {

    private ArrayList<Nutrient> inputs;

    public NutrientTable(ArrayList<Nutrient> inputs) {
        this.inputs = inputs;
    }

    /**
     * Creates the nutrient table with an entry for each Nutrient object in the "inputs" Arraylist
     * @return the nutrient table in String form
     */
    public String createTable() {
        // an object which is used to construct a String
        StringBuilder tableBuilder = new StringBuilder();

        tableBuilder.append("----------------------------------------------------------\n");
        tableBuilder.append("NUTRIENT | UNIT | TARGET\n");

        // loops each Nutrient object in the inputs Arraylist and adds the data to the StringBuilder
        for (Nutrient nutrient : inputs) {
            String nutrientName = nutrient.getName();
            String nutrientUnit = nutrient.getUnit();
            double nutrientTarget = nutrient.getTarget();
            tableBuilder.append(nutrientName + " | " + nutrientUnit + " | " + nutrientTarget + "\n");
        }
        tableBuilder.append("----------------------------------------------------------");
        return tableBuilder.toString();
    }

    // replaces the output of the default toString() function with the nutrient table
    @Override
    public String toString() {
        return createTable();
    }
}
