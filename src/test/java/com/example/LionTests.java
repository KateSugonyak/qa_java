package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    int kittensCount = 3;
    @Mock
    Feline feline;

    @Test
    public void checkCreateLionException() {
        try {
            Lion lion =  new Lion(feline, "Бесполый");
        } catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage());
        }
    }

    @Test
    public void checkGetKittens() throws Exception{
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        MatcherAssert.assertThat("Некорректное количество котят",
                lion.getKittens(),
                equalTo(kittensCount)
        );
    }

    @Test
    public void checkGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        MatcherAssert.assertThat("Некорректный список еды",
                lion.getFood(),
                equalTo(expectedFood)
        );
    }
}