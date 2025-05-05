package com.humanbooster.ui;

import com.humanbooster.exceptions.CompteNonValideException;
import com.humanbooster.exceptions.IdentifiantsIncorrectsException;
import com.humanbooster.model.entites.BorneRecharge;
import com.humanbooster.model.entites.LieuRecharge;
import com.humanbooster.model.entites.Utilisateur;
import com.humanbooster.model.enumerations.EtatBorne;
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
    static Utilisateur userconnected;

    /**
     * Génère le menu principal pour l'application.
     *
     * @return Une chaîne de caractères représentant le menu principal.
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

    /**
     * Gère les choix du menu principal en fonction de l'entrée utilisateur.
     *
     * @param choix Le choix de l'utilisateur dans le menu principal.
     */
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

    /**
     * Permet à un utilisateur de s'inscrire.
     */
    public static void register() {
        user.register();
        nav();
    }

    /**
     * Permet à un utilisateur de valider son inscription avec un code de
     * vérification.
     */
    public static void validation() {
        Scanner input = new Scanner(System.in);
        System.out.println("veuillez renseigner votre code de vérification :");
        user.validate(input.nextInt());
        nav();
    }

    /**
     * Permet à un utilisateur de se connecter en fournissant un email et un mot
     * de passe.
     */
    public static void signIn() {
        Scanner input = new Scanner(System.in);
        System.out.println("veuillez renseigner votre email :");
        String mail = input.next();
        input.nextLine();
        System.out.println("veuillez renseigner votre mot de passe :");
        String password = input.next();
        input.nextLine();
        try {
            if(user.signin(mail, password)){
                userconnected = user;
            }
        } catch (IdentifiantsIncorrectsException | CompteNonValideException e) {
            System.out.println(e.getMessage());
        }
        nav();
    }

    /**
     * Permet à un utilisateur de rechercher et réserver une borne.
     */
    public static void RechercherReserverBorne() {
        Scanner input = new Scanner(System.in);
        List<BorneRecharge> listborne = listBornes.getBornes();
        StringBuilder strborne = new StringBuilder();

        for (BorneRecharge borne : listborne) {
            if (borne.getEtat() == EtatBorne.DISPONIBLE) {
                strborne.append("id : ")
                        .append(borne.getId())
                        .append(" etat : ")
                        .append(borne.getEtat())
                        .append(" tarif horraire : ")
                        .append(borne.getTarifHoraire())
                        .append("\n");
            }
        }
        System.out.println(strborne.toString());
        System.out.println("vueillez choisir la borne avec l'id : ");
        int IDborne = input.nextInt();
        nav();
    }

    /**
     * Permet à un utilisateur de gérer ses réservations.
     */
    public static void gererReservation() {
        Scanner input = new Scanner(System.in);
        nav();
    }

    /**
     * Gère les fonctionnalités d'administration pour les lieux et les bornes.
     * Permet d'ajouter, modifier ou supprimer des lieux et des bornes.
     */
    public static void AdministrationLieuBorne() {
        Scanner input = new Scanner(System.in);
        int souschoix = -1;
        StringBuilder sousmenu = new StringBuilder();
        sousmenu.append("===== administration lieu et borne =====\n")
                .append("0 : retour au menu principal \n")
                .append("1 : ajouter un lieu\n")
                .append("2 : ajouter une borne a un lieu\n")
                .append("3 : creer une borne\n ")
                .append("4 : modifier un lieu\n")
                .append("5 : modifier une borne\n")
                .append("6 : supprimer un lieu\n")
                .append("7 : supprimer une borne\n");

        while (souschoix != 0) {
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
                    adresse += input.nextLine();
                    LieuRecharge lieuRecharge = new LieuRecharge(nom, adresse);
                    listelieux.addlieu(lieuRecharge);
                }
                case 2 -> {
                    afficherListBorne();
                    System.out.println("vueillez choisir la borne a ajouter avec l'id : ");
                    int IDborne = input.nextInt();
                    afficherListLieu();
                    System.out.println("vueillez choisir le lieu avec l'id : ");
                    int IDlieu = input.nextInt();
                    List<BorneRecharge> listborne = listBornes.getBornes();
                    List<LieuRecharge> listlieu = listelieux.getListlieux();
                    LieuRecharge lieuchoisi = null;
                    for (LieuRecharge lieutemp : listlieu) {
                        if (lieutemp.getId() == IDlieu) {
                            lieuchoisi = lieutemp;
                            break;
                        }
                    }
                    BorneRecharge bornechoisi = null;
                    for (BorneRecharge bornetemp : listborne) {
                        if (bornetemp.getId() == IDborne) {
                            bornechoisi = bornetemp;
                            break;
                        }
                    }
                    if (bornechoisi != null && lieuchoisi != null) {
                        lieuchoisi.addBornes(bornechoisi);
                    } else {
                        System.out.println("Erreur : Borne ou lieu non valide.");
                    }
                }
                case 3 -> {
                    System.out.println("quel est le tarif horaire de la borne : ");
                    Double tarifHoraire = input.nextDouble();
                    BorneRecharge borne = new BorneRecharge(tarifHoraire);
                    listBornes.addborne(borne);
                }
                case 4 -> {
                    afficherListLieu();
                    System.out.println("vueillez choisir le lieu avec l'id : ");
                    int IDlieu = input.nextInt();
                    List<LieuRecharge> listlieu = listelieux.getListlieux();
                    StringBuilder strlistelieu = new StringBuilder();
                    LieuRecharge lieuchoisi = null;
                    for (LieuRecharge lieutemp : listlieu) {
                        if (lieutemp.getId() == IDlieu) {
                            lieuchoisi = lieutemp;
                            break;
                        }
                    }
                    strlistelieu.append("id : ")
                            .append(lieuchoisi.getId())
                            .append(" nom : ")
                            .append(lieuchoisi.getNom())
                            .append(" adresse : ")
                            .append(lieuchoisi.getAdresse())
                            .append("\n");
                    System.out.println(strlistelieu.toString());
                }
                case 5 -> {
                    afficherListBorne();
                    System.out.println("vueillez choisir la borne a ajouter avec l'id : ");
                    int IDborne = input.nextInt();
                    List<BorneRecharge> listborne = listBornes.getBornes();
                    StringBuilder strborne = new StringBuilder();
                    BorneRecharge bornechoisi = null;
                    for (BorneRecharge bornetemp : listborne) {
                        if (bornetemp.getId() == IDborne) {
                            bornechoisi = bornetemp;
                            break;
                        }
                    }
                    strborne.append("id : ")
                            .append(bornechoisi.getId())
                            .append(" etat : ")
                            .append(bornechoisi.getEtat())
                            .append(" tarif horraire : ")
                            .append(bornechoisi.getTarifHoraire())
                            .append("\n");
                    System.out.println(strborne.toString());
                }
                case 6 -> {
                }
                case 7 -> {
                }
                default ->
                    throw new AssertionError();
            }
        }
        nav();
    }

    /**
     * Affiche le menu principal et permet à l'utilisateur de naviguer dans les
     * options.
     */
    private static void nav() {
        System.out.println(menuPrincipale());
        Scanner inputnav = new Scanner(System.in);
        int choix = inputnav.nextInt();
        choixMenu(choix);
    }

    /**
     * Affiche la liste des lieux disponibles.
     */
    private static void afficherListLieu() {
        List<LieuRecharge> listlieu = listelieux.getListlieux();
        StringBuilder strlistelieu = new StringBuilder();
        for (LieuRecharge lieuRecharge : listlieu) {
            strlistelieu.append("id : ")
                    .append(lieuRecharge.getId())
                    .append(" nom : ")
                    .append(lieuRecharge.getNom())
                    .append(" adresse : ")
                    .append(lieuRecharge.getAdresse())
                    .append("\n");
        }
        System.out.println(strlistelieu.toString());
    }

    /**
     * Affiche la liste des bornes disponibles.
     */
    private static void afficherListBorne() {
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
    }
}
