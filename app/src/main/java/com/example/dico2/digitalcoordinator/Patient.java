package com.example.dico2.digitalcoordinator;

import java.util.*;

public class Patient {
    private int patientID; // Personnummer, this has a lot of personal information
    private String patientName; // Patients' name
    private int personnelUnits; // Number of personnel units needed for the patient. 0 = no help needed
    private String unitNeeded; // Where to optimal place the patient
    private ArrayList<Diagnos> diagnosis; // A persons diagnoses

    public Patient(int patientID, String patientName, int personnelUnits, String unitNeeded, ArrayList<Diagnos> diagnosis) {
        // initialise instance variables
        this.patientID = patientID;
        this.patientName = patientName;
        this.personnelUnits = personnelUnits;
        this.unitNeeded = unitNeeded;
        this.diagnosis = diagnosis;
    }

    public void setID(int patientId) {
        this.patientID = patientId;
    }

    public void setName(String patientName){
        this.patientName = patientName;
    }

    public void setPersonnelUnits(int personnelUnits) {
        this.personnelUnits = personnelUnits;
    }

    public void addDiagnosis(Diagnos diagnos) {
        diagnosis.add(diagnos);
    }

    public void removeDiagnosis(Diagnos diagnos) {
        diagnosis.remove(diagnos);
    }

    public int getID() {
        return patientID;
    }

    public String getName() {
        return patientName;
    }

    public int getPersonnelUnits() {
        return personnelUnits;
    }

    public String getUnitNeeded() {
        return unitNeeded;
    }

    public ArrayList<Diagnos> getDiagnosis() {
        return diagnosis;
    }
}
