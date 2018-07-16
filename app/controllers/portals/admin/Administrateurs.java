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
import models.Administrateur;
import models.Agent;
import models.Compte;
import models.Livreur;
import models.Profil;
import play.db.jpa.GenericModel;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author NIKABOU
 */
@With(Security.class)
public class Administrateurs extends Controller {

//    //Enrégistrement d'un administrateur
    public static void saveAdmin(String nom, String prenom, String adresse, String sexe, String NumTel, String designation, Date dateEmbauche, String login, String pwd, String profil) {

        Profil prof = Profil.find("libelleProfil", profil).first();


        if (prof == null) {
            flash.put("error", "Profil inexistant");
            controllers.portals.admin.Dashboard.actionsA();
            
        } else if (prof.libelleProfil.toUpperCase().equals("AGENT")) {
            Compte compte = Comptes.saveCompte(login, pwd, prof);
            try {
                Agent agents = new Agent();
                agents.nom = nom;
                agents.prenom = prenom;
                agents.adresse = adresse;
                agents.NumTel = NumTel;
                agents.sexe = sexe;
                agents.designation = designation;
                agents.dateEmbauche = dateEmbauche;
                agents.compteid = compte.id;
                agents.save();

                actionsA();
            } catch (PersistenceException ex) {
                validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement de cet agent", new String[]{"errors"});
                params.flash();
                validation.keep();
            }

        } else if (prof.libelleProfil.toUpperCase().equals("LIVREUR") ) {
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

        } else if (prof.libelleProfil.toUpperCase().equals("ADMINISTRATEUR")) {
            Compte compte = Comptes.saveCompte(login, pwd, prof);
            try {
                Administrateur admin = new Administrateur();
                admin.nom = nom;
                admin.prenom = prenom;
                admin.adresse = adresse;
                admin.NumTel = NumTel;
                admin.sexe = sexe;
                admin.designation = designation;
                admin.compteid = compte.id;
                admin.save();
                flash("Success", "Le compte a été enrégistré avec succès");
                actionsA();

            } catch (PersistenceException ex) {
                validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement de cet administrateur", new String[]{"errors"});
                params.flash();
                validation.keep();
            }

        }

    }

    //supprimer un compte admin
    public static void deleteAdmin(Long id) {

        try {
            Administrateur admin = Administrateur.findById(id);
            if (admin != null) {
                Compte compte = Compte.findById(admin.compteid);
                if (compte != null) {
                    compte.delete();
                    admin.delete();
                    actionsA();
                }
            }

        } catch (Exception e) {
        }
    }

}
