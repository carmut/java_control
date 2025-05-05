package com.humanbooster.services;

import java.util.ArrayList;
import java.util.List;

import com.humanbooster.model.entites.Reservation;

public class listReservation {
    List<Reservation> listReservation;

    public listReservation(){
        this.listReservation = new ArrayList<>();
    }

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void addReservation(Reservation Reservation) {
        this.listReservation.add(Reservation);
    }

    
}
