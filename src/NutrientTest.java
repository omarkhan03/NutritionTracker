import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NutrientTest {

    @Test
    void getNameProtein() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        String expected = "protein";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    void getNameCalories() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2000);
        String expected = "calories";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    void getNameFiber() {
        Nutrient nutrient = new Nutrient("fiber", "g", 10);
        String expected = "fiber";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    void getNameFat() {
        Nutrient nutrient = new Nutrient("fat", "g", 50);
        String expected = "fat";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    void getNameCarbs() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 0.01);
        String expected = "carbs";
        assertEquals(expected, nutrient.getName());
    }

    @Test
    void getUnitGrams() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        String expected = "grams";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    void getUnitKilograms() {
        Nutrient nutrient = new Nutrient("fat", "kilograms", 100);
        String expected = "kilograms";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    void getUnitKg() {
        Nutrient nutrient = new Nutrient("fiber", "kg", 100);
        String expected = "kg";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    void getUnitLbs() {
        Nutrient nutrient = new Nutrient("carbs", "lbs", 100);
        String expected = "lbs";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    void getUnitPounds() {
        Nutrient nutrient = new Nutrient("protein", "pounds", 100);
        String expected = "pounds";
        assertEquals(expected, nutrient.getUnit());
    }

    @Test
    void getTarget100() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 100);
        double expected = 100;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    void getTarget100_decimal12345() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 100.12345);
        double expected = 100.12345;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    void getTarget5() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 5);
        double expected = 5;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    void getTarget3_decimal4() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 3.4);
        double expected = 3.4;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    void getTarget2400() {
        Nutrient nutrient = new Nutrient("carbs", "pounds", 2400);
        double expected = 2400;
        assertEquals(expected, nutrient.getTarget());
    }

    @Test
    void getDay1() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        Entry entry = new Entry(1, nutrient, 100);
        int expected = 1;
        assertEquals(expected, entry.getDay());
    }

    @Test
    void getDay2() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        Entry entry = new Entry(2, nutrient, 100);
        int expected = 2;
        assertEquals(expected, entry.getDay());
    }

    @Test
    void getDay3() {
        Nutrient nutrient = new Nutrient("fiber", "grams", 100);
        Entry entry = new Entry(3, nutrient, 100);
        int expected = 3;
        assertEquals(expected, entry.getDay());
    }

    @Test
    void getDay13() {
        Nutrient nutrient = new Nutrient("protein", "lbs", 100);
        Entry entry = new Entry(13, nutrient, 100);
        int expected = 13;
        assertEquals(expected, entry.getDay());
    }

    @Test
    void getDay24() {
        Nutrient nutrient = new Nutrient("protein", "grams", 50);
        Entry entry = new Entry(24, nutrient, 100);
        int expected = 24;
        assertEquals(expected, entry.getDay());
    }

    @Test
    void getDay0() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        int expected = 0;
        assertEquals(expected, entry.getDay());
    }

    @Test
    void getNutrientNameProtein() {
        Nutrient nutrient = new Nutrient("protein", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "protein";
        assertEquals(expected, entry.getNutrientName());
    }

    @Test
    void getNutrientNameCalories() {
        Nutrient nutrient = new Nutrient("calories", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "calories";
        assertEquals(expected, entry.getNutrientName());
    }

    @Test
    void getNutrientNameFiber() {
        Nutrient nutrient = new Nutrient("fiber", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "fiber";
        assertEquals(expected, entry.getNutrientName());
    }

    @Test
    void getNutrientNameCarbs() {
        Nutrient nutrient = new Nutrient("carbs", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "carbs";
        assertEquals(expected, entry.getNutrientName());
    }

    @Test
    void getNutrientUnitLbs() {
        Nutrient nutrient = new Nutrient("fat", "lbs", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "lbs";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    void getNutrientUnitPounds() {
        Nutrient nutrient = new Nutrient("fat", "pounds", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "pounds";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    void getNutrientUnitKilograms() {
        Nutrient nutrient = new Nutrient("fat", "kilograms", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "kilograms";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    void getNutrientUnitGrams() {
        Nutrient nutrient = new Nutrient("fat", "grams", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "grams";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    void getNutrientUnitG() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 100);
        String expected = "g";
        assertEquals(expected, entry.getNutrientUnit());
    }

    @Test
    void getConsumption100() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 100);
        double expected = 100;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    void getConsumption200() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 200);
        double expected = 200;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    void getConsumption10() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 10);
        double expected = 10;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    void getConsumption30_decimal5() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 5);
        double expected = 5;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    void getConsumption5_decimal12345() {
        Nutrient nutrient = new Nutrient("fat", "g", 100);
        Entry entry = new Entry(0, nutrient, 5.12345);
        double expected = 5.12345;
        assertEquals(expected, entry.getConsumption());
    }

    @Test
    void getSurplusDeficiencyDeficiency() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 90);

        String expected = "You were deficient in protein by 10.0 g based on your target goal on day 1";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    void getSurplusDeficiencySurplus() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 110);

        String expected = "You consumed a surplus of protein by 10.0 g based on your target goal on day 1";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    void getSurplusDeficiencyDeficiency_2() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2500);
        Entry entry = new Entry(2, nutrient, 2100);

        String expected = "You were deficient in calories by 400.0 kcal based on your target goal on day 2";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    void getSurplusDeficiencySurplus_2() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2500);
        Entry entry = new Entry(2, nutrient, 2800);

        String expected = "You consumed a surplus of calories by 300.0 kcal based on your target goal on day 2";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    void getSurplusDeficiencyNone() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 100);

        String expected = "";

        assertEquals(expected, entry.getSurplusDeficiency());
    }

    @Test
    void getSuccessfulTargets_Protein_Success() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 100);

        String expected = "You were successful in meeting your target for protein based on your target goal on day 1";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    void getSuccessfulTargets_Calories_Success() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2500);
        Entry entry = new Entry(1, nutrient, 2500);

        String expected = "You were successful in meeting your target for calories based on your target goal on day 1";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    void getSuccessfulTargets_Fail_1() {
        Nutrient nutrient = new Nutrient("calories", "kcal", 2500);
        Entry entry = new Entry(1, nutrient, 3000);

        String expected = "";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    void getSuccessfulTargets_Fail_2() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 60);

        String expected = "";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    void getSuccessfulTargets_Fail_3() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 110);

        String expected = "";

        assertEquals(expected, entry.getSuccessfulTargets());
    }

    @Test
    void createNutrientTable_1_Nutrient() {
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
    void createNutrientTable_2_Nutrients() {
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
    void createNutrientTable_3_Nutrients() {
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
    void createNutrientTable_Skipped_Nutrient() {
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
    void createNutrientTable_No_Nutrients() {

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

    @Test
    void getAverage_Protein() {
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
    void getAverage_Protein_Mixed() {
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
    void getAverage_Calories_Mixed() {
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
    void createEntryTable_1_Nutrient() {
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
    void createEntryTable_2_Nutrients() {
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
    void createEntryTable_3_Nutrients() {
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
    void createEntryTable_Skipped_Entry() {
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
    void createEntryTable_No_Entries() {
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

    @Test
    void compareTwoDays() {
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
    void compareTwoDays_Protein() {
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
    void compareTwoDays_Calories() {
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
    void compareTwoDays_Calories_Reverse_Order() {
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
    void compareTwoDays_Protein_Reverse_Order() {
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
    void compareTwoDays_Equal() {
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