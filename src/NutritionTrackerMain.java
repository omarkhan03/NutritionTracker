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

    /**
     * Coded by Omar
     * Allows user to add or change the daily target (hashmap) for a specific nutrient
     * @param nutrientTargets is a hashmap of all nutrients that the user has entered and their corresponding targets
     * @param scanner takes the Scanner object created in the launch function
     */
    public static void editNutrientAndTarget(HashMap<String, Integer> nutrientTargets, Scanner scanner){
        System.out.println("----------------------------------------------------------");
        System.out.println("What nutrient would you like to add? e.g. protein (g): ");
        String nutrient = scanner.nextLine();

        System.out.println(String.format("Enter the target for the nutrient %s", nutrient));
        int target = scanner.nextInt();
        nutrientTargets.put(nutrient, target);

        System.out.println("Added nutrient " + nutrient + " and assigned " + target + " as the target ");
        nutrientTargets.replace(nutrient, target);
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Coded by Omar
     * Allows user to enter a day, a nutrient and the quantity of nutrient consumed and enters that as an array to the
     * nutrientQuantities arrayList.
     * @param nutrientQuantities is an arrayList containing Arrays with String values for the day, nutrient, and quantity consumed
     * @param scanner takes the Scanner object created in the launch function
     */
    public static void enterValueToDay(ArrayList<String[]> nutrientQuantities, Scanner scanner){
        System.out.println("----------------------------------------------------------");
        System.out.println("Which day would you like to edit the nutrient consumption of? Enter a positive integer");
        String day = scanner.nextLine();

        System.out.println("Enter the nutrient you would like to enter a quantity for, e.g. protein (g): ");
        String nutrient = scanner.nextLine();

        System.out.println(String.format("Enter the consumption value you would like to assign to %s, enter a positive integer: ", nutrient));
        String quantity = scanner.nextLine();

        String[] consumption = {day, nutrient, quantity};

        nutrientQuantities.add(consumption);
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Coded by Carter
     * Takes an arrayList of the users tracked inputs and produces a sorted "Chart"
     * @param nutrientQuantities is an arrayList containing Arrays with String values for the day, nutrient, and quantity consumed
     */
    public static void viewTable(ArrayList<String[]> nutrientQuantities){//method for comparing String[] items taken from https://stackoverflow.com/questions/4699807/sort-arraylist-of-array-in-java
        System.out.println("----------------------------------------------------------");
        System.out.println("DAY | NUTRIENT | QUANTITY");

        Collections.sort(nutrientQuantities, new Comparator<String[]>(){ //compares the items at index 0, which holds the 'day' value, to sort a list of string arrays containing the day, nutrient, and consumption values
            public int compare(String[] string1, String[] string2){
                return string1[0].compareTo(string2[0]);
            }
        });

        for (String[] item: nutrientQuantities){ //after sorting the list, it's contents are semi-organized and printed to the console using a for loop
            System.out.println(item[0] + " | " + item[1] + " | " + item[2]);
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Coded by Omar
     * Prints each nutrient and their corresponding target consumption
     * @param nutrientTargets is a hashmap of all nutrients that the user has entered and their corresponding targets
     */
    public static void viewTargetList(HashMap<String, Integer> nutrientTargets){
        System.out.println("----------------------------------------------------------");
        for (String nutrient : nutrientTargets.keySet()){
            System.out.println(nutrient + ": target consumption is " + nutrientTargets.get(nutrient));
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Coded by Carter
     * Takes an ArrayList of the user's inputs and a HashMap of the user's inputted goals and prints a result of whether or not the
     * @param nutrientQuantities is an arrayList containing Arrays with String values for the day, nutrient, and quantity consumed
     * @param scanner takes the Scanner object created in the launch function
     * @param nutrientTargets is a hashmap of all nutrients that the user has entered and their corresponding targets
     */
    public static void viewAverageDeficienciesSurpluses(ArrayList<String[]> nutrientQuantities, Scanner scanner, HashMap<String, Integer> nutrientTargets){
        System.out.println("----------------------------------------------------------");
        System.out.println("Please enter a nutrient and measuring unit e.g. protein (g).");
        String nutrient = scanner.nextLine();
        int length = 0;
        int count = 0;

        for (String[] item : nutrientQuantities){ //finds the average consumption of specified nutrients
            if(item[1].equals(nutrient)){
                count += parseInt(item[2]);
                length++;
            }
        }
        double average = count/length;

        if(average > nutrientTargets.get(nutrient)){ //determines if a surplus or deficiency is present on average, or is the user has meets their targets on average
            System.out.println("On average, you consume a surplus of " + nutrient + " by " + (average - nutrientTargets.get(nutrient)) + " units based on your target goal.");
        }
        else if(average < nutrientTargets.get(nutrient)){
            System.out.println("On average, you are deficient in " + nutrient + " by " + (nutrientTargets.get(nutrient) - average) + " units based on your target goal.");
        }
        else if(average == nutrientTargets.get(nutrient)){
            System.out.println("On average, you consume an adequate amount of " + nutrient + " based on your target goal.");
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Coded by Omar
     * Prints every nutrient that matched with its target consumption value on any day
     * @param nutrientTargets is a hashmap of all nutrients that the user has entered and their corresponding targets
     * @param nutrientQuantities is an arrayList containing Arrays with String values for the day, nutrient, and quantity consumed
     */
    public static void viewSuccessfulTargets(HashMap<String, Integer> nutrientTargets, ArrayList<String[]> nutrientQuantities){
        System.out.println("----------------------------------------------------------");
        System.out.println("The following nutrients matched with their corresponding targets on these days: \n");

        for (String[] consumption : nutrientQuantities){
            if (parseInt(consumption[2]) == (nutrientTargets.get(consumption[1]))){
                System.out.println(consumption[1] + " matched with the target consumption on day " + consumption[0]);
            }
        }
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Coded by Carter
     * Prints the average values of consumption over a particular nutrient over a collection of days (entered manually by user)
     * @param scanner takes the Scanner object created in the launch function
     * @param nutrientQuantities is an arrayList containing Arrays with String values for the day, nutrient, and quantity consumed
     */
    public static void viewCustomAverage(Scanner scanner, ArrayList<String[]> nutrientQuantities){
        System.out.println("----------------------------------------------------------");
        ArrayList<String> checklist = new ArrayList<String>();
        System.out.println("Please enter a nutrient and measuring unit e.g. protein (g).");
        String inputNutrient = scanner.nextLine();
        System.out.println("Enter an positive integer value for the day or 'done' to stop adding days e.g. for day 1 enter '1'.");
        String inputDay = scanner.nextLine();

        int length = 0;
        int count = 0;

        while (!inputDay.equals("done")){ //takes day entries until user enters "done"
            if(!checklist.contains(inputDay)){
                checklist.add(inputDay);

                for(String[] item: nutrientQuantities){//adds any consumption entries for the specified nutrient on the entered day to the custom average
                    if(item[0].equals(inputDay)){
                        if(item[1].equals(inputNutrient)) {
                            length += parseInt(item[2]);
                            count++;
                        }
                    }
                }
            }
            System.out.println("Enter an positive integer value for the day or 'done' to stop adding days e.g. for day 1 enter '1'.");
            inputDay = scanner.nextLine();
        }

        double average = length/count;
        System.out.println("Your average consumption of " + inputNutrient + " is " + average + " units.");
        System.out.println("----------------------------------------------------------");
    }

    /**
     * Coded by Omar
     * Prompts the user for two days that they would like to compare the nutrient consumption between, then it calculates
     * and prints which of those days had the greater (or equal) nutrient consumption for each nutrient.
     * @param nutrientQuantities is an arrayList containing Arrays with String values for the day, nutrient, and quantity consumed
     * @param scanner takes the Scanner object created in the launch function
     */
    public static void compareCustomDays(ArrayList<String[]> nutrientQuantities, Scanner scanner){
        System.out.println("----------------------------------------------------------");
        System.out.println("What is the first day you would like to compare? Enter a positive integer: ");
        String dayOne = scanner.nextLine();

        System.out.println("What is the second day you would like to compare? Enter a positive integer: ");
        String dayTwo = scanner.nextLine();

        /*
        Loops through every instance of nutrient consumption twice, and checks whether the day and nutrient values match with
        the inputted values for days to be compared. If it does, then it compares the two nutrient consumption values
        and prints whichever one is larger, or whether they are equal.
         */
        for (String[] consumption : nutrientQuantities) {
            for (String[] comparator : nutrientQuantities) {
                if (consumption[0].equals(dayOne) && comparator[0].equals(dayTwo)) {
                    if (consumption[1].equals(comparator[1])) {
                        if (parseInt(consumption[2]) > parseInt(comparator[2])) {
                            int consumptionDifference = parseInt(consumption[2]) - parseInt(comparator[2]);
                            System.out.println("Day " + dayOne + "'s " + consumption[1] + " consumption is greater than " +
                                    "that of day " + dayTwo + " by " + consumptionDifference + " units.");
                        } else if (parseInt(consumption[2]) < parseInt(comparator[2])) {
                            int consumptionDifference = parseInt(comparator[2]) - parseInt(consumption[2]);
                            System.out.println("Day " + dayOne + "'s " + consumption[1] + " consumption is less than " +
                                    "that of day " + dayTwo + " by " + consumptionDifference + " units.");
                        } else {
                            System.out.println("Day " + dayOne + "'s " + consumption[1] + " consumption is equal to " +
                                    "that of day " + dayTwo);
                        }
                    }
                }
            }
        }
        System.out.println("----------------------------------------------------------");
    }

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
                "9)  Exit program";
    }

    /**
     * Coded by Omar and Carter
     * Initializes the data structures (HashMap for nutrients are their target consumption values, and ArrayList for
     * the quantity of nutrient consumed on each day)
     * Then it prints the menu and prompts the user for which option they would like to select.
     */
    public static void launch(){
        System.out.println("----------------------------------------------------------");
        HashMap<String, Integer> nutrientTargets = new HashMap<String, Integer>();
        ArrayList<String[]> nutrientQuantities = new ArrayList<String[]>();
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("9")){
            if (!input.equals("1")){
                System.out.println(printMenu());
            }
            input = scanner.nextLine();
            if (input.equals("1")){
                editNutrientAndTarget(nutrientTargets, scanner);
            }
            if (input.equals("2")){
                enterValueToDay(nutrientQuantities, scanner);
            }
            if (input.equals("3")){
                viewTable(nutrientQuantities);
            }
            if (input.equals("4")){
                viewTargetList(nutrientTargets);
            }
            if (input.equals("5")){
                viewAverageDeficienciesSurpluses(nutrientQuantities, scanner, nutrientTargets);
            }
            if (input.equals("6")){
                viewSuccessfulTargets(nutrientTargets, nutrientQuantities);
            }
            if (input.equals("7")){
                viewCustomAverage(scanner, nutrientQuantities);
            }
            if (input.equals("8")){
                compareCustomDays(nutrientQuantities, scanner);
            }
        }
        System.out.println("----------------------------------------------------------");
    }

    public static void main (String[] args){
        launch();
        System.out.println("Exited, Thank you!");
    }
}