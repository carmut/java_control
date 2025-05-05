package com.humanbooster.model.entites;

import java.util.List;

public class LieuRecharge {
    int id; 
    private static int nextIDlieu = 0;
    String nom;
    String adresse;
    List<BorneRecharge> bornes;
    
    public LieuRecharge(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.id = nextIDlieu;
        nextIDlieu++;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<BorneRecharge> getBornes() {
        return bornes;
    }

    public void setBornes(BorneRecharge borne) {
        this.bornes.add(borne);
    }

    public void removeBorne(int borneid){
        bornes.removeIf(borne -> borne.getId() == borneid);
    }
}
