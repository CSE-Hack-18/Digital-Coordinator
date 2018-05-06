package com.example.dico2.digitalcoordinator;

import java.util.*;

public class Patient {
    private int ssn; // Personnummer, this has a lot of personal information
    private String name; // Patients' name
    private int burden; // Number of personnel units needed for the patient. 0 = no help needed
    private Diagnos diagnosis; // A persons diagnoses

    public Patient(int ssn, String patientName, int burden, Diagnos diagnosis) {
        // initialise instance variables
        this.ssn = ssn;
        this.name = patientName;
        this.burden = burden;
        this.diagnosis = diagnosis;
    }

    // if diagnosis removed/added and we need to update the care needed
    public void setburden(int burden) {
        this.burden = burden;
    }

    public void setDiagnosis(Diagnos diagnos) {
        this.diagnosis = diagnos;
    }

    public int getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public int getburden() {
        return burden;
    }

    public Diagnos getDiagnosis() {
        return diagnosis;
    }

}
