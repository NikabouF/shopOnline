/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import java.util.Date;
import javax.persistence.PersistenceException;
import models.Client;
import play.mvc.Controller;

/**
 *
 * @author NIKABOU
 */
public class Clients extends Controller{
    
        //Enrégistrement d'un client
    public static void saveClient(String nom, String prenom, String adresse, String sexe, String NumTel, String email, Long compteid) {
        try {
            Client clients=new Client();
            clients.nom = nom;
            clients.prenom = prenom;
            clients.adresse = adresse;
            clients.NumTel = NumTel;
            clients.sexe = sexe;
            clients.email = email;
            clients.compteid = compteid;
            clients.save();

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement de cet agent", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }
}
