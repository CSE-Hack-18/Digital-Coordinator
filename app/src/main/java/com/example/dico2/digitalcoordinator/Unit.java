package com.example.dico2.digitalcoordinator;

import java.util.ArrayList;

public class Unit {
    private String unit;
    private ArrayList<Patient> patients;
    private ArrayList<Staff> employees;
    private int capacity;
    private String location;
    private String type;

    public Unit(String unit, int capacity, String location, String type) {
        this.unit = unit;
        this.capacity = capacity;
        this.location = location;
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public ArrayList<Staff> getEmployees() {
        return employees;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }
}
