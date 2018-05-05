package com.example.dico2.digitalcoordinator;

import java.util.ArrayList;

public class Diagnos {
    private String diagnos;
    private String recommended;
    private Unit.properties restrictedTo;

    public Unit.properties getRestrictedTo() {
        return restrictedTo;
    }

    public Diagnos(String diagnos, String recommended, Unit.properties restrictedTo) {
        this.diagnos = diagnos;
        this.recommended = recommended;
    }

    public void setRestrictedTo(Unit.properties restrictedTo) {
        this.restrictedTo = restrictedTo;
    }

    public void setRestriction(Unit.properties restriction){
        restrictedTo = restriction;
    }

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }
    public String getDiagnos() {
        return diagnos;
    }
}
