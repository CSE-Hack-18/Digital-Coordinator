package com.example.dico2.digitalcoordinator;

public class Unit {
    public enum Discipline {
        KIRURGI, ORTOPEDI, MEDICIN, GERIATRIK, UROLOGI
    }
    int currentWorkload;
    int capacity;
    Discipline discipline;
    int availableBeds;


    public Unit(int currentWorkload, int capacity, Discipline discipline, int availableBeds){
        this.discipline = discipline;
        this.currentWorkload = currentWorkload;
        this.capacity = capacity;
        this.availableBeds = availableBeds;
    }
}
