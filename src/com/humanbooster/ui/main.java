package com.humanbooster.ui;

import com.humanbooster.model.entites.Utilisateur;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner inputmain = new Scanner(System.in);
        Utilisateur user = new Utilisateur();

        System.out.println(menuConsole.menuPrincipale());
        menuConsole.choixMenu(inputmain.nextInt());
        


        inputmain.close();
        
    }
}
