package com.humanbooster.services;

import com.humanbooster.model.entites.BorneRecharge;
import java.util.ArrayList;
import java.util.List;

public class listBorne {
    List<BorneRecharge> bornes;

    public listBorne() {
        this.bornes = new ArrayList<>();
    }

    public List<BorneRecharge> getBornes() {
        return this.bornes;
    }

    public void addborne(BorneRecharge borne){
        this.bornes.add(borne);
    }
}
