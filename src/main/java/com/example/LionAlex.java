package com.example;

import java.util.List;

public class LionAlex extends Lion {

    private List<String> lionAlexFriends = List.of(
            "зебра Марти",
            "бегемотиха Глория",
            "жираф Мелман");
    public LionAlex(Feline feline) throws Exception {
        super(feline, "Самец");
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return lionAlexFriends;
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}