package com.example.dico2.digitalcoordinator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by John on 2018-05-05.
 */

public class Hospital{
    private ArrayList<Unit> units= new ArrayList<Unit>(5);


    public void init(){
        //new Unit()
    }
    

    public ArrayList<Unit> suggestedUnits(Patient patient){
        Collections.sort(units); //sort units
        ArrayList<Unit> suggested = new ArrayList<Unit>(0);
            for (int i = 0; i < units.size(); i++){
                Unit currentunit = units.get(i);
                addUnitIfAvailable(currentunit, patient, suggested);
            }
        //filter suggested
        filterUnits(suggested, patient.getDiagnosis());
        return suggested;
    }

    private void filterUnits(ArrayList<Unit> suggested, Diagnos diagnosis){ //SUGGESTION OF HOW THE FILTERING SHOULD WORK
        for(int i = 0; i < suggested.size(); i++){
                if(!suggested.get(i).getType().equals(diagnosis.getRestrictedTo())){
                    suggested.remove(i);
                //ADD MORE FILTERS
            }
        }
    }

    private void addUnitIfAvailable(Unit unit, Patient patient, ArrayList<Unit> suggested){

        if (!(unit.getCapacity() > unit.getPatients().size())){//If no free beds return
            return;
        }
        if(unit.countPersonnelneeded(unit) >= unit.getEmployees().size()){//If Unit workload is too high return
            return;
        }
        if(patient.getDiagnosis().getRecommended().equals(unit.getType())){ //If same unitType as patient add it first
            suggested.add(0, unit);
        }else {
            suggested.add(unit);
        }
    }


}
