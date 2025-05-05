package com.humanbooster.services;

import java.util.List;

import com.humanbooster.model.entites.Utilisateur;

public class listeUser {
    List<Utilisateur> utilisateurs;

    public List<Utilisateur> getUtilisateur() {
        return this.utilisateurs;
    }

    public void adduser(Utilisateur user){
        this.utilisateurs.add(user);
    }
}
