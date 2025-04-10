package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    Cat cat;
    String expectedSound = "Мяу";
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    @Mock
    Feline feline;
    @Before
    public void setUp() {
        cat = new Cat(feline);
    }
    @Test
    public void checkGetSound() {

        MatcherAssert.assertThat("Кот должен говорить: \"Мяу\"",
               cat.getSound(),
                equalTo(expectedSound)
        );
    }

    @Test
    public void checkGetFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        MatcherAssert.assertThat("Некорректный список еды",
                cat.getFood(),
                equalTo(expectedFood)

        );

    }

}