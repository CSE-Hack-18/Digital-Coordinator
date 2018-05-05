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
}
