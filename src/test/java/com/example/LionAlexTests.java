package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionAlexTests {

    List<String> expectedLionAlexFriends = List.of(
            "зебра Марти",
            "бегемотиха Глория",
            "жираф Мелман");
    LionAlex lionAlex;

    @Mock
    Feline feline;

    @Before
    public void setUp() throws Exception {
        lionAlex = new LionAlex(feline);
    }

    @Test
    public void checkGetKittens(){
        assertEquals(0, lionAlex.getKittens());
    }

    @Test
    public void checkGetPlaceOfLiving(){
        assertEquals("Нью-Йоркский зоопарк", lionAlex.getPlaceOfLiving());
    }

    @Test
    public void checkGetFriends(){
        assertEquals(expectedLionAlexFriends, lionAlex.getFriends());
    }
}