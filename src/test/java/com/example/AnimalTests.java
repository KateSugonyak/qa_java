package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class AnimalTests {

    Animal animal;
    @Before
    public void setUp() {
        animal = new Animal();
    }
    @Test
    public void checkGetFamily() {
        String expectedFamilies = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        MatcherAssert.assertThat("Некорректный список семейств",
               animal.getFamily(),
                equalTo(expectedFamilies)
        );
    }

    @Test
    public void checkGetFoodException() throws Exception {
        try {
            animal.getFood("Всеядное");
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    exception.getMessage());
        }
    }
}