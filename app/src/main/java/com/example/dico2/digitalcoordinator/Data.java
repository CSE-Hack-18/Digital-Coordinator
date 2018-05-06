package com.example.dico2.digitalcoordinator;

import java.util.ArrayList;

import dalvik.annotation.TestTarget;

public class Data {
    private static Data single_instance = null;

    private ArrayList<Unit> units = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private Hospital hospital = new Hospital();

    private ArrayList<Diagnos> diagnosis = new ArrayList<>();

    private Data() {
        initDiags();
        initUnits();
        loadTestData();
        hospital.setUnits(this.units);
    }

    public static Data getInstance(){
        if(single_instance == null){
            single_instance = new Data();
        }
        return single_instance;
    }

    public Patient getPatient(int ssn){
        for(Patient patient:patients){
            if(patient.getSsn() == ssn){
                return patient;
            }
        }

        return null;
    }

    public ArrayList<Diagnos> getDiagnosis() {
        return diagnosis;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }



    public void initDiags()
    {
        diagnosis.add(new Diagnos("Infection", "Medicine", Unit.properties.NONE));
        diagnosis.add(new Diagnos("Stroke", "Surgery", Unit.properties.NONE));
        diagnosis.add(new Diagnos("Heart Attack", "Surgery", Unit.properties.NONE));
        diagnosis.add(new Diagnos("Kidney Stones", "Urology", Unit.properties.NONE));
        diagnosis.add(new Diagnos("Back Pain", "Orthopedics", Unit.properties.NONE));

    }


    public void initUnits(){
        units.add(new Unit("Surgery", 5, "Building 1, Floor 1", R.drawable.surgery));
        units.add(new Unit("Medicine", 5, "Building 2, Floor 2",R.drawable.flower));
        units.add(new Unit("Orthopedics", 5, "Building 1, Floor 2", R.drawable.skeleton));
        units.add(new Unit("Geriatrics", 3, "Building 2, Floor 3", R.drawable.geriatrics));
        units.add(new Unit("Urology", 3, "Building 2, Floor 1", R.drawable.urology));
        units.add(new Unit("Quarantine", 3, "Building X, Floor -7", Unit.properties.CONTAGIOUS, R.drawable.zombie));
        initStaffMembers();

    }

    public void loadTestData(){
        patients.add(new Patient(0, "Jim", 1, new Diagnos("Kidney Stone","Urology", Unit.properties.NONE)));
        patients.add(new Patient(1, "Jimmy Lundqvis", 5, new Diagnos("Old and Senile","Geriatrics", Unit.properties.NONE)));
        patients.add(new Patient(2, "Jimmy Lundq", 1, new Diagnos("Back Pain","Ortophedics", Unit.properties.NONE)));
        patients.add(new Patient(3, "Jimmy Lund", 1, new Diagnos("Swine Flu","Quarantine", Unit.properties.CONTAGIOUS)));
        patients.add(new Patient(4, "Jimmy Lundqvi", 1, new Diagnos("Stroke","Surgery", Unit.properties.NONE)));
        patients.add(new Patient(5, "Jimmy Lun", 5,new Diagnos("Heart Attack","Surgery", Unit.properties.NONE)));
        patients.add(new Patient(6, "Jimmy Lu", 3, new Diagnos("Heart Attack","Surgery", Unit.properties.NONE)));
        patients.add(new Patient(7, "Jimmy ", 1, new Diagnos("Heart Attack","Surgery", Unit.properties.NONE)));
        patients.add(new Patient(8, "Jimmy", 4, new Diagnos("Heart Attack","Surgery", Unit.properties.NONE)));
        patients.add(new Patient(9, "Jimm", 1, new Diagnos("Heart Disease","Medicine", Unit.properties.NONE)));


        units.get(0).getPatients().add(patients.get(0));
        units.get(0).getPatients().add(patients.get(1));
        units.get(1).getPatients().add(patients.get(2));
        units.get(2).getPatients().add(patients.get(3));
        units.get(3).getPatients().add(patients.get(4));
        units.get(3).getPatients().add(patients.get(5));
        units.get(4).getPatients().add(patients.get(6));
        units.get(4).getPatients().add(patients.get(7));

    }

    private void initStaffMembers(){
        units.get(0).getEmployees().add(new Staff(99, "a", "scrub"));
        units.get(0).getEmployees().add(new Staff(98, "b", "scrub"));
        units.get(1).getEmployees().add(new Staff(97, "c", "scrub"));
        units.get(1).getEmployees().add(new Staff(96, "d", "scrub"));
        units.get(2).getEmployees().add(new Staff(95, "e", "scrub"));
        units.get(2).getEmployees().add(new Staff(94, "f", "scrub"));
        units.get(3).getEmployees().add(new Staff(93, "g", "scrub"));
        units.get(3).getEmployees().add(new Staff(92, "h", "scrub"));
        units.get(4).getEmployees().add(new Staff(91, "i", "scrub"));
        units.get(5).getEmployees().add(new Staff(90, "j", "scrub"));
        //units.get(5).getEmployees().add(new Staff(89, "k", "scrub"));
    }

}
