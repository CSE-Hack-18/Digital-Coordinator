package com.example.dico2.digitalcoordinator;

import java.util.ArrayList;

public class Diagnos {
    private String diagnos;
    private int burdening;
    private ArrayList<Unit> restrictedTo;

    public Diagnos(String diagnos, int burdening) {
        this.diagnos = diagnos;
        this.burdening = burdening;
    }

    public void addRestriction(Unit unit){
        restrictedTo.add(unit);
    }
}
