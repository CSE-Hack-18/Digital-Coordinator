package com.example.dico2.digitalcoordinator;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class Unit implements Comparable<Unit>{
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

    public int comparableWorkLoad(){
        return countPersonnelneeded(this) - employees.size() * 15;
    }

    public int countPersonnelneeded(Unit unit){ //returns the value of all patients needs
        ArrayList<Patient> patients = unit.getPatients();
        int count = 0;
        for(int i = 0; i < patients.size(); i++ ){
            count += patients.get(i).getPersonnelUnits();
        }
        return count;
    }


    @Override
    public int compareTo(@NonNull Unit unit) {
        if(this.comparableWorkLoad() > unit.comparableWorkLoad()){
            return 1;
        }else if(this.comparableWorkLoad() < unit.comparableWorkLoad()) {
            return -1;
        }else{
            return 0;
        }
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
