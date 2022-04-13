package com.example.cpsc233projectdemo3;

import org.testng.annotations.Test;
import utils.Entry;
import utils.EntryTable;
import utils.Nutrient;
import utils.NutrientTable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class NutritionTrackerTest {

    /**
     * The following 5 tests are for the getName function for the Nutrient class. The first test should return protein,
     * second should return calories, third should return fiber, fourth fat and last carbs.
     */
    @Test
    public void getNameProtein() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        String expected = "protein";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    public void getNameCalories() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2000);
        String expected = "calories";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    public void getNameFiber() {
        Nutrient nutrient = new Nutrient("fiber", "g", 10);
        String expected = "fiber";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    public void getNameFat() {
        Nutrient nutrient = new Nutrient("fat", "g", 50);
        String expected = "fat";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    public void getNameCarbs() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 0.01);
        String expected = "carbs";
        assertEquals(expected, nutrient.getName());
    }

    /**\
     * The following 5 tests are for the getUnit function for the Nutrient class. The first test should return grams,
     * the second kilograms, the third Kg (abbreviated form), the fourth lbs (abbreviated) and the last should return
     * pounds.
     */
    @Test
    public void getUnitGrams() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        String expected = "grams";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    public void getUnitKilograms() {
        Nutrient nutrient = new Nutrient("fat", "kilograms", 100);
        String expected = "kilograms";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    public void getUnitKg() {
        Nutrient nutrient = new Nutrient("fiber", "kg", 100);
        String expected = "kg";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    public void getUnitLbs() {
        Nutrient nutrient = new Nutrient("carbs", "lbs", 100);
        String expected = "lbs";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    public void getUnitPounds() {
        Nutrient nutrient = new Nutrient("protein", "pounds", 100);
        String expected = "pounds";
        assertEquals(expected, nutrient.getUnit());
    }

    /**
     * The following 5 tests are for the getTarget function in the Nutrient class. The first should return a double of
     * 100, the second 100.12345, the third 5, the fourth 3.4 and the last 2400.
     */
    @Test
    public void getTarget100() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 100);
        double expected = 100;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    public void getTarget100_decimal12345() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 100.12345);
        double expected = 100.12345;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    public void getTarget5() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 5);
        double expected = 5;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    public void getTarget3_decimal4() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 3.4);
        double expected = 3.4;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    public void getTarget2400() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 2400);
        double expected = 2400;
        assertEquals(expected, nutrient.getTarget());
    }

    /**\
     * The following 5 tests are for the getDay function in the Entry class. The first one should return int of 1, the
     * second 2, the third 13, the fourth 13 but with different nutrient parameters, the last 13 but with a different
     * consumption value.
     */
    @Test
    public void getDay1() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        Entry entry = new Entry(1, nutrient, 100);
        int expected = 1;
        assertEquals(expected, entry.getDay());
    }

    @Test
    public void getDay2() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        Entry entry = new Entry(2, nutrient, 100);
        int expected = 2;
        assertEquals(expected, entry.getDay());
    }

    @Test
    public void getDay13_1() {
        Nutrient nutrient = new Nutrient("fiber", "grams", 100);
        Entry entry = new Entry(13, nutrient, 100);
        int expected = 13;
        assertEquals(expected, entry.getDay());
    }

    @Test
    public void getDay13_2() {
        Nutrient nutrient = new Nutrient("protein", "lbs", 100);
        Entry entry = new Entry(13, nutrient, 100);
        int expected = 13;
        assertEquals(expected, entry.getDay());
    }

    @Test
    public void getDay13_3() {
        Nutrient nutrient = new Nutrient("protein", "grams", 50);
        Entry entry = new Entry(13, nutrient, 115);
        int expected = 13;
        assertEquals(expected, entry.getDay());
    }

    /**
     * The following 5 tests are for the getNutrientName function for the Entry class. The first should return protein,
     * the second calories, the third fiber, the fourth carbs and the last fat.
     */
    @Test
    public void getNutrientNameProtein() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "protein";
        assertEquals(expected, entry.getNutrientName());
    }

    @Test
    public void getNutrientNameCalories() {
        Nutrient nutrient = new Nutrient("calories", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "calories";
        assertEquals(expected, entry.getNutrientName());
    }

    @Test
    public void getNutrientNameFiber() {
        Nutrient nutrient = new Nutrient("fiber", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "fiber";
        assertEquals(expected, entry.getNutrientName());
    }

    @Test
    public void getNutrientNameCarbs() {
        Nutrient nutrient = new Nutrient("carbs", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "carbs";
        assertEquals(expected, entry.getNutrientName());
    }

    @Test
    public void getNutrientNameFat() {
        Nutrient nutrient = new Nutrient("fat", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "fat";
        assertEquals(expected, entry.getNutrientName());
    }

    /**
     * The following 5 tests are for the getNutrientUnit function in the Entry class, the first should return lbs, the
     * second pounds, the third kilograms, the fourth grams and the last just g.
     */
    @Test
    public void getNutrientUnitLbs() {
        Nutrient nutrient = new Nutrient("fat", "lbs", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "lbs";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    public void getNutrientUnitPounds() {
        Nutrient nutrient = new Nutrient("fat", "pounds", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "pounds";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    public void getNutrientUnitKilograms() {
        Nutrient nutrient = new Nutrient("fat", "kilograms", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "kilograms";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    public void getNutrientUnitGrams() {
        Nutrient nutrient = new Nutrient("fat", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "grams";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    public void getNutrientUnitG() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "g";
        assertEquals(expected, entry.getNutrientUnit());
    }

    /**
     * The following 5 tests are for the getConsumption method in the Entry class. The first should return double of
     * 100, the second 200, the third 200 but with different nutrient parameters, the fourth 30.5, the last 5.12345
     */
    @Test
    public void getConsumption100() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 100);
        double expected = 100;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    public void getConsumption200() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 200);
        double expected = 200;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    public void getConsumption10() {
        Nutrient nutrient = new Nutrient("fiber", "g", 10);
        Entry entry = new Entry(0, nutrient, 200);
        double expected = 200;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    public void getConsumption30_decimal5() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 5);
        double expected = 5;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    public void getConsumption5_decimal12345() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 5.12345);
        double expected = 5.12345;
        assertEquals(expected, entry.getConsumption());
    }

    /**
     * The following 5 functions test the getSurplusDeficiency method in the Entry class. The first test is for
     * deficiency in protein, the second is surplus of protein, the third is deficiency in calories, the fourth is
     * surplus of calories, the last is no deficiency or surplus.
     */
    @Test
    public void getSurplusDeficiencyDeficiency() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 90);

        String expected = "You were deficient in protein by 10.0 g based on your target goal on day 1";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    public void getSurplusDeficiencySurplus() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 110);

        String expected = "You consumed a surplus of protein by 10.0 g based on your target goal on day 1";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    public void getSurplusDeficiencyDeficiency_2() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2500);
        Entry entry = new Entry(2, nutrient, 2100);

        String expected = "You were deficient in calories by 400.0 kcal based on your target goal on day 2";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    public void getSurplusDeficiencySurplus_2() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2500);
        Entry entry = new Entry(2, nutrient, 2800);

        String expected = "You consumed a surplus of calories by 300.0 kcal based on your target goal on day 2";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    public void getSurplusDeficiencyNone() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 100);

        String expected = "";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    /**
     * The following 5 functions are for the getSuccessfulTargets function for the Entry class. The first test is for
     * success of protein intake, the second is for success of calories intake, the third is for failure of calorie
     * intake the fourth is failure for protein intake (deficiency), the last is failure of protein intake but with
     * a surplus rather than a deficiency.
     */
    @Test
    public void getSuccessfulTargets_Protein_Success() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 100);

        String expected = "You were successful in meeting your target for protein based on your target goal on day 1";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    public void getSuccessfulTargets_Calories_Success() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2500);
        Entry entry = new Entry(1, nutrient, 2500);

        String expected = "You were successful in meeting your target for calories based on your target goal on day 1";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    public void getSuccessfulTargets_Fail_1() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2500);
        Entry entry = new Entry(1, nutrient, 3000);

        String expected = "";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    public void getSuccessfulTargets_Fail_2() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 60);

        String expected = "";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    public void getSuccessfulTargets_Fail_3() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 110);

        String expected = "";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    /**
     * The following 5 functions are for the createTable method in the NutrientTable class. The first tests the output
     * for one nutrient, the second tests for 2 nutrients, the third tests 3, the fourth tests for a skipped nutrient
     * from the nutrientList, the fifth tests for no nutrients.
     */
    @Test
    public void createNutrientTable_1_Nutrient() {
        Nutrient fiber = new Nutrient("fiber", "g", 20);

        ArrayList<Nutrient> nutrientList;
        nutrientList = new ArrayList<Nutrient>();
        nutrientList.add(0,fiber);

        String expected =
                """
                 ----------------------------------------------------------
                 NUTRIENT | UNIT | TARGET
                 fiber | g | 20.0
                 ----------------------------------------------------------""";

        NutrientTable actualTable = new NutrientTable(nutrientList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void createNutrientTable_2_Nutrients() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        ArrayList<Nutrient> nutrientList;
        nutrientList = new ArrayList<Nutrient>();
        nutrientList.add(0,protein);
        nutrientList.add(1,calories);

        String expected =
                """
                 ----------------------------------------------------------
                 NUTRIENT | UNIT | TARGET
                 protein | g | 100.0
                 calories | kcal | 2500.0
                 ----------------------------------------------------------""";

        NutrientTable actualTable = new NutrientTable(nutrientList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void createNutrientTable_3_Nutrients() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);
        Nutrient fiber = new Nutrient("fiber", "g", 20);

        ArrayList<Nutrient> nutrientList;
        nutrientList = new ArrayList<Nutrient>();
        nutrientList.add(0,fiber);
        nutrientList.add(1,protein);
        nutrientList.add(2,calories);

        String expected =
                """
                 ----------------------------------------------------------
                 NUTRIENT | UNIT | TARGET
                 fiber | g | 20.0
                 protein | g | 100.0
                 calories | kcal | 2500.0
                 ----------------------------------------------------------""";

        NutrientTable actualTable = new NutrientTable(nutrientList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void createNutrientTable_Skipped_Nutrient() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);
        Nutrient fiber = new Nutrient("fiber", "g", 20);

        ArrayList<Nutrient> nutrientList;
        nutrientList = new ArrayList<Nutrient>();
        nutrientList.add(0,fiber);
        nutrientList.add(1,calories);

        String expected =
                """
                 ----------------------------------------------------------
                 NUTRIENT | UNIT | TARGET
                 fiber | g | 20.0
                 calories | kcal | 2500.0
                 ----------------------------------------------------------""";

        NutrientTable actualTable = new NutrientTable(nutrientList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void createNutrientTable_No_Nutrients() {

        ArrayList<Nutrient> nutrientList;
        nutrientList = new ArrayList<Nutrient>();

        String expected =
                """
                 ----------------------------------------------------------
                 NUTRIENT | UNIT | TARGET
                 ----------------------------------------------------------""";

        NutrientTable actualTable = new NutrientTable(nutrientList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    /**
     * The following 5 tests are for the getAverage function in the EntryTable class. The first test is for getting the
     * average protein intake over 2 days, the second does the same except calorie entries exists. The third test is
     * for finding the average calorie intake, the fourth is for average protein intake over 3 days, the last is same as
     * the fourth except calorie entry exists.
     */
    @Test
    public void getAverage_Protein() {
        Nutrient protein = new Nutrient("protein", "g", 100);

        Entry dayOne = new Entry(1, protein, 100);
        Entry dayTwo = new Entry(2, protein, 80);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOne);
        entryList.add(1,dayTwo);

        EntryTable table = new EntryTable(entryList);

        String expected = "Your average consumption of protein is 90.0 g";

        assertEquals(expected, table.getAverage("protein"));
    }

    @Test
    public void getAverage_Protein_Mixed() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 100);
        Entry dayOneCalories = new Entry(2, calories, 2000);
        Entry dayTwoProtein = new Entry(1, protein, 120);
        Entry dayTwoCalories = new Entry(2, calories, 3000);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayOneCalories);
        entryList.add(2,dayTwoProtein);
        entryList.add(3,dayTwoCalories);

        EntryTable table = new EntryTable(entryList);

        String expected = "Your average consumption of protein is 110.0 g";

        assertEquals(expected, table.getAverage("protein"));
    }

    @Test
    public void getAverage_Calories_Mixed() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 100);
        Entry dayOneCalories = new Entry(2, calories, 2000);
        Entry dayTwoProtein = new Entry(1, protein, 120);
        Entry dayTwoCalories = new Entry(2, calories, 3000);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayOneCalories);
        entryList.add(2,dayTwoProtein);
        entryList.add(3,dayTwoCalories);

        EntryTable table = new EntryTable(entryList);

        String expected = "Your average consumption of calories is 2500.0 kcal";

        assertEquals(expected, table.getAverage("calories"));
    }

    @Test
    public void getAverage_Protein_3Days() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 100);
        Entry dayTwoProtein = new Entry(2, protein, 120);
        Entry dayThreeProtein = new Entry(3, protein, 110);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayTwoProtein);
        entryList.add(2,dayThreeProtein);

        EntryTable table = new EntryTable(entryList);

        String expected = "Your average consumption of protein is 110.0 g";

        assertEquals(expected, table.getAverage("protein"));
    }

    @Test
    public void getAverage_Protein_3Days_Mixed() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 100);
        Entry dayTwoCalories = new Entry(2, calories, 2000);
        Entry dayTwoProtein = new Entry(2, protein, 120);
        Entry dayThreeProtein = new Entry(3, protein, 110);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayTwoCalories);
        entryList.add(1,dayTwoProtein);
        entryList.add(2,dayThreeProtein);

        EntryTable table = new EntryTable(entryList);

        String expected = "Your average consumption of protein is 110.0 g";

        assertEquals(expected, table.getAverage("protein"));
    }

    /**
     * The following 5 tests are for the createTable method in the Entry class, the first test is for creating a table
     * with 1 nutrient and 2 entries, the second is for 2 nutrients each with 2 entries, the third is for 3 nutrients
     * each with 1 entry, the fourth tests a skipped entry, the last has no entries and should return an empty table.
     */
    @Test
    public void createEntryTable_1_Nutrient() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);
        Nutrient fiber = new Nutrient("fiber", "g", 20);

        Entry dayOneProtein = new Entry(1, protein, 90);
        Entry dayTwoProtein = new Entry(2, protein, 110);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayTwoProtein);

        String expected =
                """
                 ----------------------------------------------------------
                 DAY | NUTRIENT | QUANTITY
                 1 | protein | 90.0 g
                 2 | protein | 110.0 g
                 ----------------------------------------------------------""";

        EntryTable actualTable = new EntryTable(entryList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void createEntryTable_2_Nutrients() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);
        Nutrient fiber = new Nutrient("fiber", "g", 20);

        Entry dayOneProtein = new Entry(1, protein, 90);
        Entry dayOneCalories = new Entry(1, calories, 2200);
        Entry dayTwoProtein = new Entry(2, protein, 110);
        Entry dayTwoCalories = new Entry(2, calories, 2300);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayOneCalories);
        entryList.add(2,dayTwoProtein);
        entryList.add(3,dayTwoCalories);

        String expected =
                """
                 ----------------------------------------------------------
                 DAY | NUTRIENT | QUANTITY
                 1 | protein | 90.0 g
                 1 | calories | 2200.0 kcal
                 2 | protein | 110.0 g
                 2 | calories | 2300.0 kcal
                 ----------------------------------------------------------""";

        EntryTable actualTable = new EntryTable(entryList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void createEntryTable_3_Nutrients() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);
        Nutrient fiber = new Nutrient("fiber", "g", 20);

        Entry dayOneProtein = new Entry(1, protein, 90);
        Entry dayTwoCalories = new Entry(2, calories, 2300);
        Entry dayThreeCalories = new Entry(3, fiber, 15);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayTwoCalories);
        entryList.add(2,dayThreeCalories);

        String expected =
                """
                 ----------------------------------------------------------
                 DAY | NUTRIENT | QUANTITY
                 1 | protein | 90.0 g
                 2 | calories | 2300.0 kcal
                 3 | fiber | 15.0 g
                 ----------------------------------------------------------""";

        EntryTable actualTable = new EntryTable(entryList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void createEntryTable_Skipped_Entry() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);
        Nutrient fiber = new Nutrient("fiber", "g", 20);

        Entry dayOneProtein = new Entry(1, protein, 90);
        Entry dayTwoCalories = new Entry(2, calories, 2300);
        Entry dayThreeCalories = new Entry(3, fiber, 15);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayThreeCalories);

        String expected =
                """
                 ----------------------------------------------------------
                 DAY | NUTRIENT | QUANTITY
                 1 | protein | 90.0 g
                 3 | fiber | 15.0 g
                 ----------------------------------------------------------""";

        EntryTable actualTable = new EntryTable(entryList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void createEntryTable_No_Entries() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);
        Nutrient fiber = new Nutrient("fiber", "g", 20);

        Entry dayOneProtein = new Entry(1, protein, 90);
        Entry dayTwoCalories = new Entry(2, calories, 2300);
        Entry dayThreeCalories = new Entry(3, fiber, 15);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();

        String expected =
                """
                 ----------------------------------------------------------
                 DAY | NUTRIENT | QUANTITY
                 ----------------------------------------------------------""";

        EntryTable actualTable = new EntryTable(entryList);
        String actual = actualTable.toString();

        assertEquals(expected, actual);
    }

    /**
     * The following 5 tests are for the compareTwoDays method in the EntryTable class. The first test is for comparing
     * protein intake, the second is for comparing calories intake, the third is for comparing calories in the reverse
     * order (day 2 first) the fourth is for comparing protein in the reverse order, the last is for comparing protein
     * intakes that are equal.
     */

    @Test
    public void compareTwoDays_Protein() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 110);
        Entry dayOneCalories = new Entry(1, calories, 2300);
        Entry dayTwoProtein = new Entry(2, protein, 90);
        Entry dayTwoCalories = new Entry(2, calories, 2200);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayOneCalories);
        entryList.add(2,dayTwoProtein);
        entryList.add(3,dayTwoCalories);

        EntryTable table = new EntryTable(entryList);

        String expected = "Day 1's protein consumption is greater than that of day 2 by 20.0 g";

        assertEquals(expected, table.compareTwoDays("protein",1,2));
    }

    @Test
    public void compareTwoDays_Calories() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 110);
        Entry dayOneCalories = new Entry(1, calories, 2200);
        Entry dayTwoProtein = new Entry(2, protein, 90);
        Entry dayTwoCalories = new Entry(2, calories, 2300);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayOneCalories);
        entryList.add(2,dayTwoProtein);
        entryList.add(3,dayTwoCalories);

        EntryTable table = new EntryTable(entryList);

        String expected = "Day 1's calories consumption is less than that of day 2 by 100.0 kcal";

        assertEquals(expected, table.compareTwoDays("calories",1,2));
    }

    @Test
    public void compareTwoDays_Calories_Reverse_Order() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 110);
        Entry dayOneCalories = new Entry(1, calories, 2200);
        Entry dayTwoProtein = new Entry(2, protein, 90);
        Entry dayTwoCalories = new Entry(2, calories, 2300);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayOneCalories);
        entryList.add(2,dayTwoProtein);
        entryList.add(3,dayTwoCalories);

        EntryTable table = new EntryTable(entryList);

        String expected = "Day 2's calories consumption is greater than that of day 1 by 100.0 kcal";

        assertEquals(expected, table.compareTwoDays("calories",2,1));
    }

    @Test
    public void compareTwoDays_Protein_Reverse_Order() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 110);
        Entry dayOneCalories = new Entry(1, calories, 2300);
        Entry dayTwoProtein = new Entry(2, protein, 90);
        Entry dayTwoCalories = new Entry(2, calories, 2200);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayOneCalories);
        entryList.add(2,dayTwoProtein);
        entryList.add(3,dayTwoCalories);

        EntryTable table = new EntryTable(entryList);

        String expected = "Day 2's protein consumption is less than that of day 1 by 20.0 g";

        assertEquals(expected, table.compareTwoDays("protein",2,1));
    }

    @Test
    public void compareTwoDays_Equal() {
        Nutrient protein = new Nutrient("protein", "g", 100);
        Nutrient calories = new Nutrient("calories", "kcal", 2500);

        Entry dayOneProtein = new Entry(1, protein, 110);
        Entry dayOneCalories = new Entry(1, calories, 2300);
        Entry dayTwoProtein = new Entry(2, protein, 110);
        Entry dayTwoCalories = new Entry(2, calories, 2200);

        ArrayList<Entry> entryList;
        entryList = new ArrayList<Entry>();
        entryList.add(0,dayOneProtein);
        entryList.add(1,dayOneCalories);
        entryList.add(2,dayTwoProtein);
        entryList.add(3,dayTwoCalories);

        EntryTable table = new EntryTable(entryList);

        String expected = "Day 1's protein consumption is equal to that of day 2";

        assertEquals(expected, table.compareTwoDays("protein",1,2));
    }
}