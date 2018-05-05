package com.example.dico2.digitalcoordinator;

public class Human {
    private int ssn;
    private String name;
    private int specialNeeds;

    public Human(int ssn, String name, int specialNeeds) {
        this.ssn = ssn;
        this.name = name;
        this.specialNeeds = specialNeeds;
    }

    public int getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public int getSpecialNeeds() {
        return specialNeeds;
    }
}
