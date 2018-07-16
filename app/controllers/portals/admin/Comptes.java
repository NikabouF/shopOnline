/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import controllers.Security;
import static controllers.portals.admin.Dashboard.actionsA;
import java.io.File;
import java.util.List;
import javax.persistence.PersistenceException;
import models.Compte;
import models.Profil;
import play.Logger;
import play.mvc.Controller;

/**
 *
 * @author NIKABOU
 */
public class Comptes extends Controller {

    public static void listCompte() {
        List<models.Compte> comptes = models.Compte.findAll();
        render(comptes);
    }

    public static Compte saveCompte(String login, String pwd, Profil profil) {

        try {
            Compte comptes = new Compte();
            comptes.username = login;
            comptes.password = Compte.setHashPassword(pwd);
            comptes.profil = profil;

            comptes.save();
            return comptes;   

        } catch (PersistenceException ex) {

            Logger.error("Le login " + login + " existe déjà");
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement", new String[]{"errors"});
            params.flash();
            validation.keep();
            return null;

        } finally {

        }

    }

    public static void deleteCompte(Long id) {
        Compte c = Compte.findById(id);
        try {
            c.delete();

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la suppression", new String[]{"errors"});
            params.flash();
            validation.keep();
        }

    }

    public static void editCompte(Long id) {
        Compte compte = Compte.findById(id);
        render(compte);
    }

    public static void saveEditCompte(Compte c,Profil profil) {

        Compte compte = Compte.findById(c.id);
        compte.username = c.username;
        compte.password=Security.setHashPassword(c.password);
        compte.profil = profil;

        try {
            compte.save();
            flash("Success", "La modification a été faite avec succès");
        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la modification", new String[]{"errors"});
            params.flash();
            validation.keep();
        } finally {

        }
    }

}
