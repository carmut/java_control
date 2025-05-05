package com.humanbooster.interfaces;

import com.humanbooster.exceptions.CompteNonValideException;
import com.humanbooster.exceptions.IdentifiantsIncorrectsException;

public interface AuthentificationService {

    /**
     * création d'un compte
     */
    public void register();

    /**
     * connexion a un compte 
     * @param email email du compte
     * @param password mot de passe du compte
     */
    public boolean signin(String email, String password) throws IdentifiantsIncorrectsException, CompteNonValideException;

    /**
     * vérifie si le code donnée est bon et passe le compte en valide si c'est le cas 
     * @param code code de validation du compte
     */
    public void validate(int code);

}
