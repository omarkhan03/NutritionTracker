import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EntryTable {
    private ArrayList<Entry> inputs;

    public EntryTable (ArrayList<Entry> inputs){
        this.inputs = inputs;
    }

    public String createTable(){
        String table = "----------------------------------------------------------\n";
        table = table + "DAY | NUTRIENT | QUANTITY\n";

        Collections.sort(this.inputs, new Comparator<Entry>(){ //compares the items at index 0, which holds the 'day' value, to sort a list of string arrays containing the day, nutrient, and consumption values
            public int compare(Entry ent1, Entry ent2){
                return Integer.compare(ent1.getDay(), ent2.getDay());
            }
        });

        for (Entry entry: this.inputs){ //after sorting the list, it's contents are semi-organized and printed to the console using a for loop
            table = table + entry.getDay() + " | " + entry.getNutrientName() + " | " + entry.getConsumption() + " " + entry.getNutrientUnit() + "\n";
        }
        table = table + "----------------------------------------------------------";
        return table;
    }

}
