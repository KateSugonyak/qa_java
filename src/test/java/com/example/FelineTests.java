package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;

public class FelineTests {


    Feline feline;
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

    @Before
    public void setUp() {
        feline = new Feline();
    }
    @Test
    public void checkGetFamily() {
        String expectedFamily = "Кошачьи";
        MatcherAssert.assertThat("Некорректное семейство",
                feline.getFamily(),
                equalTo(expectedFamily)
        );
    }

    @Test
    public void getKittensInputCountIsCorrect() {
        MatcherAssert.assertThat("Некорректное количество котят",
                feline.getKittens(3),
                equalTo(3)
        );
    }

    @Test
    public void getKittensDefaultIsCorrect() {
        MatcherAssert.assertThat("Некорректное количество котят",
                feline.getKittens(),
                equalTo(1)
        );
    }

    @Test
    public void eatMeatIsCorrect() throws Exception {
        MatcherAssert.assertThat("Неправильный список еды",
                feline.eatMeat(),
                equalTo(expectedFood)
        );
    }
}