package com.example.dico2.digitalcoordinator;

import java.util.*;

public class Patient {
    private int ssn; // Personnummer, this has a lot of personal information
    private String name; // Patients' name
    private int specialNeeds; // Number of personnel units needed for the patient. 0 = no help needed
    private String unitNeeded; // Where to optimal place the patient
    private ArrayList<Diagnos> diagnosis; // A persons diagnoses

    public Patient(Human human) {
        this.ssn = human.getSsn();
        this.name = human.getName();
        this.specialNeeds = human.getSpecialNeeds();
    }

    public Patient(int ssn, String patientName, int specialNeeds, String unitNeeded, ArrayList<Diagnos> diagnosis) {
        // initialise instance variables
        this.ssn = ssn;
        this.name = patientName;
        this.specialNeeds = specialNeeds;
        this.unitNeeded = unitNeeded;
        this.diagnosis = diagnosis;
    }

    // if diagnosis removed/added and we need to update the care needed
    public void setSpecialNeeds(int specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public void addDiagnosis(Diagnos diagnos) {
        diagnosis.add(diagnos);
    }

    public void removeDiagnosis(Diagnos diagnos) {
        diagnosis.remove(diagnos);
    }

    public int getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public double getSpecialNeeds() {
        return specialNeeds;
    }

    public String getUnitNeeded() {
        return unitNeeded;
    }

    public ArrayList<Diagnos> getDiagnosis() {
        return diagnosis;
    }

}
