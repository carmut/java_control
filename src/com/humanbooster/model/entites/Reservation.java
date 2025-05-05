package com.humanbooster.model.entites;

import com.humanbooster.model.enumerations.StatutReservation;
import java.util.Date;

public class Reservation {
    int id; 
    static int nextid = 0;
    int idutilisateur;
    int idborne;
    Date datedebut;
    Date datefin;
    StatutReservation statut;

    public Reservation(Date datedebut, Date datefin, int idborne, int idutilisateur, StatutReservation statut) {
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.idborne = idborne;
        this.idutilisateur = idutilisateur;
        this.id = nextid;
        nextid++;
        this.statut = statut;
    }

    public StatutReservation getStatut() {
        return statut;
    }

    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public int getIdborne() {
        return idborne;
    }

    public void setIdborne(int idborne) {
        this.idborne = idborne;
    }

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public int getId() {
        return id;
    }


}
