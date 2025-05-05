package com.humanbooster.services;

import java.util.List;

import com.humanbooster.model.entites.LieuRecharge;

public class listLieu {
    List<LieuRecharge> listlieux; 

    public List<LieuRecharge> getListlieux() {
        return this.listlieux;
    }

    public void addlieu(LieuRecharge lieu){
        this.listlieux.add(lieu);
    }
}
