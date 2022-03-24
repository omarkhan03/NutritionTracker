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
}