package com.humanbooster.services;

import com.humanbooster.model.entites.Utilisateur;
import java.util.ArrayList;
import java.util.List;

public class listeUser {
    List<Utilisateur> utilisateurs;
    
    public listeUser() {
        this.utilisateurs = new ArrayList<>();
    }

    public List<Utilisateur> getUtilisateur() {
        return this.utilisateurs;
    }

    public void adduser(Utilisateur user){
        this.utilisateurs.add(user);
    }
}
