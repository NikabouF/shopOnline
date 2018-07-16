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
import models.Agent;
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
public class Agents extends Controller {

    //Enrégistrement d'un agent
    public static void saveAgent(String nom, String prenom, String adresse, String sexe, String NumTel, String designation, Date dateEmbauche, String login, String pwd, String profil) {

        Profil prof = Profil.find("libelleProfil", profil).first();
        if (prof == null) {
            flash.put("error", "Profil inexistant");
            controllers.portals.admin.Dashboard.actionsA();
        }
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
    }

    //Supprimer un agent
    public static void suppAgent(Long id) {
        Agent ag = Agent.findById(id);
        try {
            if (ag.delete() != null) {
                Compte compte = Compte.find("compteid", ag.compteid).first();
                if (compte != null) {
                    compte.delete();
                } else {
                    ag.create();
                }
            }

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la suppression de cet agent", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }
    
        //supprimer un compte admin
    public static void deleteAgent(Long id) {

        try {
            Agent agent = Agent.findById(id);
            if (agent != null) {
                Compte compte = Compte.findById(agent.compteid);
                if(compte!=null){
                    compte.delete();
                    agent.delete();
                    actionsA();
                }
            }
        } catch (Exception e) {
        }
    }

    

    //modifier un agent
    public static void editLivreur(Long id) {
        Livreur livreurs = Livreur.findById(id);
        render(livreurs);
    }

    public static void saveEditLivreur(Livreur livreur) {

        Livreur livreurs = Agent.findById(livreur.id);
        livreurs.nom = livreur.nom;
        livreurs.prenom = livreur.prenom;
        livreurs.adresse = livreur.adresse;
        livreurs.NumTel = livreur.NumTel;
        livreurs.designation = livreur.designation;
        livreurs.sexe = livreur.sexe;
        livreurs.dateEmbauche = livreur.dateEmbauche;

        try {
            livreurs.save();
            flash("Success", "La modification a été faite avec succès");
        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la modification", new String[]{"errors"});
            params.flash();
            validation.keep();
        } finally {

        }
    }

}
