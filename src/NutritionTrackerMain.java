/*
Course: CPSC 233
Names: Carter Tam and Omar Khan
Date: Feb 28, 2022
Tutorial: T06 (Amirhossein)

Description: This is a nutrition tracker. Users will be able to enter nutrients and their target consumption goals,
as well as enter the quantity of that nutrient consumed for any day (day 1, day 2, etc.). They will be able to view
stored data, as well as calculated data described in the menu and javadocs.
*/

import java.sql.Array;
import java.util.*;

import static java.lang.Integer.parseInt;

public class NutritionTrackerMain {
    public static String printMenu(){
        return "Select one of the following options:\n\n" +
                "Edit data\n" +
                "1)  Edit nutrient and daily target\n" +
                "2)  Enter or edit consumption for a nutrient to a day\n\n" +
                "View inputted data\n" +
                "3)  View nutrient consumption over time (table)\n" +
                "4)  View list of nutrients and goals\n\n" +
                "View calculated data\n" +
                "5)  View nutrient deficiencies or surpluses (based on target)\n" +
                "6)  View nutrients that are within daily target\n" +
                "7)  View average consumption of a nutrient for across selected days\n" +
                "8)  Compare nutrient consumption between two days\n\n" +
                "Save/Load Data\n" +
                "9)  Exit program";
    }

    public static void main (String[] args){
        System.out.println("----------------------------------------------------------");
        ArrayList<Nutrient> nutrients = new ArrayList<Nutrient>();
        ArrayList<Entry> entries = new ArrayList<Entry>();
        if (args.length == 1){

        }
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("9")){
            System.out.println(printMenu());
            input = scanner.nextLine();

            if (input.equals("1")){
                System.out.println("----------------------------------------------------------");
                System.out.println("Enter the name of the nutrient would you like to add (e.g. protein): ");
                String name = scanner.nextLine();

                System.out.println("Enter the unit you would like to measure the nutrient with (e.g. grams): ");
                String unit = scanner.nextLine();

                System.out.println(String.format("Enter the target for the nutrient %s", name));
                double target = Double.parseDouble(scanner.nextLine());

                Nutrient nutrient = new Nutrient(name, unit, target);
                nutrients.add(nutrient);

                System.out.println("Added nutrient " + name + " and assigned " + target + " as the target ");
                System.out.println("----------------------------------------------------------");
            }

            if (input.equals("2")){
                System.out.println("----------------------------------------------------------");
                System.out.println("Which day would you like to edit the nutrient consumption of? Enter a positive integer");
                int day = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter the nutrient you would like to enter a quantity for: ");
                String nutrient = scanner.nextLine();

                System.out.println(String.format("Enter the consumption value you would like to assign to %s, enter a positive integer: ", nutrient));
                double quantity = Double.parseDouble(scanner.nextLine());
                Entry entry = null;

                for(Nutrient n : nutrients){
                    if(n.getName().equals(nutrient)){
                        entry = new Entry(day, n, quantity);
                    }
                }

                entries.add(entry);
                System.out.println("----------------------------------------------------------");
            }

            if (input.equals("3")){
                EntryTable entryTable = new EntryTable(entries);
                System.out.println(entryTable.createTable());
            }

            if (input.equals("4")){
                NutrientTable nutrientTable = new NutrientTable(nutrients);
                System.out.println(nutrientTable.createTable());
            }

            if (input.equals("5")){
                System.out.println("----------------------------------------------------------");
                System.out.println("The following nutrient deficiencies and surpluses were found within your entries: ");
                for(Entry e : entries){
                    if(!e.getSurplusDeficiency().equals("")){
                        System.out.println(e.getSurplusDeficiency());
                    }
                }
                System.out.println("----------------------------------------------------------");
            }

            if (input.equals("6")){
                System.out.println("----------------------------------------------------------");
                System.out.println("The following nutrients matched with their corresponding targets on these days: ");
                for(Entry e : entries){
                    if(!e.getSuccessfulTargets().equals("")){
                        System.out.println(e.getSuccessfulTargets());
                    }
                }
                System.out.println("----------------------------------------------------------");
            }

            if (input.equals("7")){
                System.out.println("----------------------------------------------------------");
                System.out.println("Please enter the name of the nutrient you would like to view data for: ");
                String nutrient = scanner.nextLine();

                EntryTable entryTable = new EntryTable(entries);
                System.out.println(entryTable.getAverage(nutrient));

                System.out.println("----------------------------------------------------------");
            }

            if (input.equals("8")){
                System.out.println("----------------------------------------------------------");

                System.out.println("What is the first day you would like to compare? Enter a positive integer: ");
                int dayOne = Integer.parseInt(scanner.nextLine());

                System.out.println("What is the second day you would like to compare? Enter a positive integer: ");
                int dayTwo = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter the nutrient whose consumption you'd like to compare: ");
                String nutrient = scanner.nextLine();

                EntryTable entryTable = new EntryTable(entries);
                System.out.println(entryTable.compareTwoDays(nutrient, dayOne, dayTwo));
                System.out.println("----------------------------------------------------------");
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Exited, Thank you!");
    }
}