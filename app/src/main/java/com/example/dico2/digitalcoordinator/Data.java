package com.example.dico2.digitalcoordinator;

import java.util.ArrayList;

public class Data {
    private Data single_instance = null;

    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private Hospital hospital = new Hospital();

    private Data() {
    }

    public Data getInstance(){
        if(single_instance == null){
            single_instance = new Data();
        }
        return single_instance;
    }

    public void initUnits(){
        units.add(new Unit("Surgery", 20, "Building 1, Floor 1"));
        units.add(new Unit("Medicine", 50, "Building 2, Floor 2"));
        units.add(new Unit("Orthopedics", 50, "Building 1, Floor 2"));
        units.add(new Unit("Geriatrics", 50, "Building 2, Floor 3"));
        units.add(new Unit("Urology", 50, "Building 2, Floor 1"));
        units.add(new Unit("Quarantine", 10, "Building X, Floor -7", Unit.properties.CONTAGIOUS));
    }

    public void loadTestData(){
        patients.add(new Patient(1, "Jimmy Lundqvist", 0, "Surgery",null));
    }
}
