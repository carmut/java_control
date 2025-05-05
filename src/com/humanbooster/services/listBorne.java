package com.humanbooster.services;

import java.util.List;

import com.humanbooster.model.entites.BorneRecharge;

public class listBorne {
    List<BorneRecharge> bornes;

    public List<BorneRecharge> getBornes() {
        return this.bornes;
    }

    public void addborne(BorneRecharge borne){
        this.bornes.add(borne);
    }
}
