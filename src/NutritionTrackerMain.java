/*
Course: CPSC 233
Names: Carter Tam and Omar Khan
Date: Feb 28, 2022
Tutorial: T06 (Amirhossein)

Description: This is a nutrition tracker. Users will be able to enter nutrients and their target consumption goals,
as well as enter the quantity of that nutrient consumed for any day (day 1, day 2, etc.). They will be able to view
stored data, as well as calculated data described in the menu and javadocs.
*/

import javax.imageio.IIOException;
import java.io.*;
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
                "9)  Save data to file\n" +
                "10) Load Data from file\n\n" +
                "11) Exit program";
    }

    public static void main (String[] args){
        System.out.println("----------------------------------------------------------");
        ArrayList<Nutrient> nutrients = new ArrayList<Nutrient>();
        ArrayList<Entry> entries = new ArrayList<Entry>();
        if (args.length == 1){
            try {
                File file = new File(args[0]);
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()){
                    String fileIn = scanner.nextLine();
                    String[] in = fileIn.split(",");
                    if (in.length == 5){
                        Nutrient nutrient = new Nutrient(in[1], in[2], Double.parseDouble(in[3]));
                        Entry entry = new Entry(Integer.parseInt(in[0]), nutrient, Double.parseDouble(in[4]));
                        entries.add(entry);
                    }
                    else if(in.length == 3){
                        Nutrient nutrient = new Nutrient(in[0], in[1], Double.parseDouble(in[2]));
                        nutrients.add(nutrient);
                    }
                }
            }
            catch (FileNotFoundException e){
                System.err.println("File could not be found: " + args[0]);
                System.exit(1);
            }
        }
        else if(args.length > 1){
            System.err.println("Invalid Arguments");
            System.exit(1);
        }

        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equals("11")){
            System.out.println(printMenu());
            input = scanner.nextLine();

            if (input.equals("1")){//prompts user for inputs to create nutrient and add it to an array list
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

            if (input.equals("9")){
                System.out.println("Give a .csv file name to create or overwrite: ");
                String f = scanner.nextLine();
                File file = new File(f);
                if(!file.exists()){
                    try{
                        file.createNewFile();
                    }
                    catch(IOException e){
                        System.err.println("File could not be created: " + f);
                        System.exit(1);
                    }
                }

                if(file.isFile() && file.exists() && file.canWrite()){//Checking file existence, as per instructions from lecture
                    try{
                        FileWriter fw = new FileWriter(file);
                        PrintWriter printWriter = new PrintWriter(fw);

                        for(Entry e : entries){
                            printWriter.println(e.getDay() + "," + e.getNutrientName() + "," + e.getNutrientUnit() + "," + e.getNutrientTarget() + "," + e.getConsumption());
                        }

                        for(Nutrient n : nutrients){
                            printWriter.println(n.getName() + "," + n.getUnit() + "," + n.getTarget());
                        }
                        printWriter.flush();

                        System.out.println("Save successful!");
                    }
                    catch(IOException e){
                        System.err.println("File could not be found: " + f);
                        System.exit(1);
                    }
                }
                else{
                    System.out.println("Cannot write to file!");
                }
            }

            if (input.equals("10")){
                entries.clear();
                nutrients.clear();
                System.out.println("Enter the name of the file to load from:");
                String f = scanner.nextLine();
                try {
                    File file = new File(f);
                    Scanner scan = new Scanner(file);

                    while(scan.hasNextLine()){
                        String fileIn = scan.nextLine();
                        String[] in = fileIn.split(",");
                        if (in.length == 5){
                            Nutrient nutrient = new Nutrient(in[1], in[2], Double.parseDouble(in[3]));
                            Entry entry = new Entry(Integer.parseInt(in[0]), nutrient, Double.parseDouble(in[4]));
                            entries.add(entry);
                        }
                        else if(in.length == 3){
                            Nutrient nutrient = new Nutrient(in[0], in[1], Double.parseDouble(in[2]));
                            nutrients.add(nutrient);
                        }
                    }

                    System.out.println("Load successful!");
                }
                catch (FileNotFoundException e){
                    System.err.println("File could not be found: " + f);
                    System.exit(1);
                }
            }
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Exited, Thank you!");
    }
}