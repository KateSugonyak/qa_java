package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class LionParamsTests {

    private final String sex;
    private final boolean hasMane;

    public LionParamsTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Lion, пол: {0}")
    public static Object[][] setSexForLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Mock
    Feline feline;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void checkDoesHaveMane() throws Exception {
        MatcherAssert.assertThat("Грива должна быть только у самца",
                new Lion(feline, this.sex).doesHaveMane(),
                equalTo(hasMane)
        );

    }

}