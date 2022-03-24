import org.junit.jupiter.api.Test;

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
/*
    @Test
    void getSurplusDeficiency() {
        Nutrient nutrient = new Nutrient("protein", "g", 100);
        Entry entry = new Entry(1, nutrient, 90);

        //String expected = "You were deficient in protein by 10 units based on your target goal on day


        assertEquals(expected, entry.getSurplusDeficiency());
    }
*/
}