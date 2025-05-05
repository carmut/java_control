package com.humanbooster.model.entites;

import com.humanbooster.model.enumerations.EtatBorne;

public class BorneRecharge {
    int id;
    private static int nextIDborne = 0;
    private EtatBorne etat; 
    Double tarifHoraire;

    public BorneRecharge(Double tarifHoraire) {
        this.etat = EtatBorne.DISPONIBLE;
        this.id = nextIDborne;
        this.tarifHoraire = tarifHoraire;
        nextIDborne++;
    }

    public Double getTarifHoraire() {
        return tarifHoraire;
    }

    public void setTarifHoraire(Double tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }

    public EtatBorne getEtat() {
        return etat;
    }

    public void setEtat(EtatBorne etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

}
