package com.humanbooster.model.entites;

import com.humanbooster.exceptions.CompteNonValideException;
import com.humanbooster.exceptions.IdentifiantsIncorrectsException;
import com.humanbooster.interfaces.AuthentificationService;
import java.util.Scanner;

public class Utilisateur implements AuthentificationService {
    int id;
    private static int nextIDuser = 0;
    String email;
    String motDePasse;
    int codeValidation;
    boolean estValide; 

    /**
     * génére un code a 4 chiffre pour la validation du compte
     * entre 1000 et 9999
     */
    public final int generateCode(){
        return (int) (Math.random() * 9000 + 1000);
    }

    @Override
    public void register() {
        Scanner inputregister = new Scanner(System.in);

        System.out.println("vueillez renseigner votre email : ");
        String mail = inputregister.next();
        inputregister.nextLine();
        this.email = mail;

        System.out.println("vueillez renseigner votre mot de passe : ");
        String password = inputregister.next();
        inputregister.nextLine();
        this.motDePasse = password;
        
        this.codeValidation = generateCode();
        this.estValide = false;
        this.id = nextIDuser;
        nextIDuser++;

        System.out.println("====== email simulé ======");
        System.out.println("votre de code de validation est le : ");
        System.out.println(getCodeValidation());

        
        
    }

    @Override
    public boolean signin(String email, String password) throws IdentifiantsIncorrectsException, CompteNonValideException{
        if(this.estValide){
            if(this.email.equals(email) && this.motDePasse.equals(password)){
                return true;
            }else{
                throw new IdentifiantsIncorrectsException("identifiant ou mot de passe incorect");
            }
            
        }else{
            throw new CompteNonValideException("compte non valide");
        }
    }

    @Override
    public void validate(int code) {
        if(this.codeValidation == code){
            setEstValide(true);
        }
    }



    // getter et setter
    public int getCodeValidation() {
        return codeValidation;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

}
