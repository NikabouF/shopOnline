/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import controllers.Security;
import static controllers.portals.admin.Dashboard.actionsA;
import java.util.Date;
import javax.persistence.PersistenceException;
import models.Compte;
import models.Livreur;
import models.Profil;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author NIKABOU
 */
@With(Security.class)
public class Livreurs extends Controller {

    //Enrégistrement d'un livreur
    public static void saveLivreur(String nom, String prenom, String adresse, String sexe, String NumTel, String designation, Date dateEmbauche, String login, String pwd, String profil) {

        Profil prof = Profil.find("libelleProfil", profil).first();
        if (prof == null) {
            flash.put("error", "Profil inexistant");
            controllers.portals.admin.Dashboard.actionsA();
        }
        Compte compte = Comptes.saveCompte(login, pwd, prof);
        try {
            Livreur livreurs = new Livreur();
            livreurs.nom = nom;
            livreurs.prenom = prenom;
            livreurs.adresse = adresse;
            livreurs.NumTel = NumTel;
            livreurs.sexe = sexe;
            livreurs.designation = designation;
            livreurs.dateEmbauche = dateEmbauche;
            livreurs.compteid = compte.id;
            livreurs.save();

            actionsA();

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement de ce livreur", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }

    //Supprimer un agent
    public static void suppLivreur(Long id) {
        Livreur li = Livreur.findById(id);
        try {
            if (li.delete() != null) {
                Compte compte = Compte.find("compteid", id).first();
                if (compte != null) {
                    compte.delete();
                } else {
                    li.create();
                }
            }

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la suppression de ce livreur", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }
    
        //supprimer un compte livreur
    public static void deleteLivreur(Long id) {

        try {
            Livreur livreur = Livreur.findById(id);
            if (livreur != null) {
                Compte compte = Compte.find("compteid",id).first();
                
                if(compte!=null){
                    compte.delete();
                    livreur.delete();
                    actionsA();
                }
            }

        } catch (Exception e) {
        }
    }


}
