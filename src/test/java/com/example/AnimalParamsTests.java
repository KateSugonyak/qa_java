package com.example;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class AnimalParamsTests {

    private final String animalKind;
    private final List<String> expectedFood;

    public AnimalParamsTests(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters(name = "Animal: {0}")
    public static Object[][] setParamsForTest() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };
    }

    @Test
    public void checkGetFood() throws Exception {
        MatcherAssert.assertThat("Неправильный список еды",
                new Animal().getFood(animalKind),
                CoreMatchers.equalTo(this.expectedFood)
        );
    }

}