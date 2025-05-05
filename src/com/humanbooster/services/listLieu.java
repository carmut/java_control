package com.humanbooster.services;

import com.humanbooster.model.entites.LieuRecharge;
import java.util.ArrayList;
import java.util.List;

public class listLieu {
    List<LieuRecharge> listlieux; 

    public listLieu() {
        this.listlieux = new ArrayList<>();
    }

    public List<LieuRecharge> getListlieux() {
        return this.listlieux;
    }

    public void addlieu(LieuRecharge lieu){
        this.listlieux.add(lieu);
    }
}
