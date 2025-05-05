package com.humanbooster.ui;

import com.humanbooster.exceptions.CompteNonValideException;
import com.humanbooster.exceptions.IdentifiantsIncorrectsException;
import com.humanbooster.model.entites.BorneRecharge;
import com.humanbooster.model.entites.LieuRecharge;
import com.humanbooster.model.entites.Utilisateur;
import com.humanbooster.services.listBorne;
import com.humanbooster.services.listLieu;
import com.humanbooster.services.listeUser;
import java.util.List;
import java.util.Scanner;

public class menuConsole {

    static Utilisateur user = new Utilisateur();
    static listLieu listelieux = new listLieu();
    static listeUser listeUsers = new listeUser();
    static listBorne listBornes = new listBorne();

    /**
     * genere le String pour le menu principale pour afficher dans la console
     *
     * @return String du menue principale
     */
    public static String menuPrincipale() {

        StringBuilder mainmenu = new StringBuilder();
        mainmenu.append("=== Electricity Business ===\n")
                .append("1. S'inscrire\n")
                .append("2. Valider l'inscription\n")
                .append("3. Se connecter\n")
                .append("4. Rechercher & réserver une borne\n")
                .append("5. Gérer mes réservations\n")
                .append("6. Administration (lieux / bornes)\n")
                .append("0. Quitter\n");

        return mainmenu.toString();
    }

    public static void choixMenu(int choix) {
        switch (choix) {
            case 0 -> {

                break;
            }

            case 1 -> {
                register();
                break;
            }

            case 2 -> {
                validation();
                break;
            }

            case 3 -> {
                signIn();
                break;
            }

            case 4 -> {
                RechercherReserverBorne();
                break;
            }

            case 5 -> {
                gererReservation();
                break;
            }

            case 6 -> {
                AdministrationLieuBorne();
                break;
            }

            default ->
                throw new AssertionError();
            

        }
    }

    public static void register() {
        user.register();
        nav();       
    }

    public static void validation() {
        Scanner input = new Scanner(System.in);
        System.out.println("veuillez renseigner votre code de vérification :");
        user.validate(input.nextInt());
        nav();
    }

    public static void signIn() {
        Scanner input = new Scanner(System.in);
        System.out.println("veuillez renseigner votre email :");
        String mail = input.next();
        input.nextLine();
        System.out.println("veuillez renseigner votre mot de passe :");
        String password = input.next();
        input.nextLine();
        try {
            user.signin(mail, password);
        } catch (IdentifiantsIncorrectsException | CompteNonValideException e) {
            System.out.println(e.getMessage());
        }
        nav();
    }

    public static void RechercherReserverBorne() {
        Scanner input = new Scanner(System.in);
            
        nav();       
    }

    public static void gererReservation() {
        Scanner input = new Scanner(System.in);

        nav();       
    }

    public static void AdministrationLieuBorne() {
        Scanner input = new Scanner(System.in);
        int souschoix = -1;
        StringBuilder sousmenu = new StringBuilder();
            sousmenu.append("===== administration lieu et borne =====\n")
                    .append("0 : retour au menu principal \n")
                    .append("1 : ajouter un lieu\n")
                    .append("2 : ajouter une borne a un lieu\n")
                    .append("3 : creer une borne\n ");
        while(souschoix != 0){
            System.out.println(sousmenu.toString());
            souschoix = input.nextInt();
            switch (souschoix) {
                case 0 -> {
                    break;
                }
                case 1 -> {
                    System.out.println("quel est le nom du lieu : ");
                    String nom = input.next();
                    System.out.println("quel est l'adresse du lieu' : ");
                    String adresse = input.next();
                    LieuRecharge lieuRecharge = new LieuRecharge(nom, adresse);
                    listelieux.addlieu(lieuRecharge);
                }
                case 2 -> {
                    /**
                     * add borne to lieu
                     * 
                     * afficher liste borne : 
                     * selectioner avec ID 
                     * 
                     * afficher liste lieu :
                     * selectioner avec ID 
                     * 
                     * ajout 
                     */

                    List<BorneRecharge> listborne = listBornes.getBornes();
                    StringBuilder strborne = new StringBuilder();
                    for (BorneRecharge borne : listborne) {
                        strborne.append("id : ")
                                .append(borne.getId())
                                .append(" etat : ")
                                .append(borne.getEtat())
                                .append(" tarif horraire : ")
                                .append(borne.getTarifHoraire())
                                .append("\n");
                    }
                    System.out.println(strborne.toString());
                    System.out.println("vueillez choisir la borne a ajouter avec l'id : ");
                    int IDborne = input.nextInt();
                }
                case 3 -> {
                    System.out.println("quel est le tarif horaire de la borne : ");
                    Double tarifHoraire = input.nextDouble();
                    BorneRecharge borne = new BorneRecharge(tarifHoraire);
                    listBornes.addborne(borne);
                }
                default -> throw new AssertionError();
            }
        }

        nav();       
    }

    private static void nav(){
        System.out.println(menuPrincipale());
        Scanner inputnav = new Scanner(System.in);
        int choix = inputnav.nextInt();
        choixMenu(choix);
    }
}
