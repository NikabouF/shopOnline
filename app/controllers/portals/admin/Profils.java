/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import controllers.Security;
import static controllers.portals.admin.Dashboard.actionsA;
import java.util.List;
import javax.persistence.PersistenceException;
import models.Compte;
import models.Droit;
import models.Profil;
import models.ProfilDroit;
import play.Logger;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author NIKABOU
 */
@With(Security.class)
public class Profils extends Controller {

    public static void listProfil() {
        List<models.Profil> profils = models.Profil.findAll();
        render(profils);
    }

    public static void saveProfil(String libelleProfil) {
        try {
            Profil profils = new Profil();
            profils.libelleProfil = libelleProfil;
            profils.save();

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }

    public static void deleteProfil(Long id) {
        Profil p = Profil.findById(id);
        try {
            if (p != null) {
                ProfilDroit pr = ProfilDroit.findById(p.id);
                if (pr != null) {
                    Droit dr = Droit.findById(pr.droit.id);
                    if (dr != null) {
                        Compte compte = Compte.findById(p.id);
                        if (compte != null) {
                            dr.delete();
                            pr.delete();
                            compte.delete();
                            p.delete();

                            actionsA();
                        }
                    }
                }
            }

            p.delete();

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la suppression", new String[]{"errors"});
            params.flash();
            validation.keep();
        }

    }

    public static void editProfil(Long id) {
        Profil profils = Profil.findById(id);
        render(profils);
    }

    public static void saveEditProfil(Profil profil) {

        Profil prof = Profil.findById(profil.id);
        prof.libelleProfil = profil.libelleProfil;

        try {
            prof.save();
            flash("Success", "La modification a été faite avec succès");
        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la modification", new String[]{"errors"});
            params.flash();
            validation.keep();
        } finally {

        }
    }
}
