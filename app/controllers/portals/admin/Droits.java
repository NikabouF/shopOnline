/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import controllers.Security;
import static controllers.portals.admin.Dashboard.actionsA;
import static controllers.portals.admin.Dashboard.consultations;
import static controllers.portals.admin.Dashboard.enregDroitProfil;
import java.util.List;
import javax.persistence.PersistenceException;
import models.Droit;
import models.ProfilDroit;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author NIKABOU
 */
@With(Security.class)
public class Droits extends Controller {

    public static void listDroit() {
        List<models.Droit> droits = models.Droit.findAll();
        render(droits);
    }

    public static void saveDroit(String libelleDroit) {
        try {
            Droit droits = new Droit();
            droits.libelleDroit = libelleDroit;
            droits.save();

            enregDroitProfil();

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }

    public static void deleteDroit(Long id) {
        Droit d = Droit.findById(id);
        try {
            if (d != null) {
                ProfilDroit pro = ProfilDroit.findById(d.id);
                if (pro != null) {
                    pro.delete();
                }
                d.delete();
                consultations();
            }

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la suppression", new String[]{"errors"});
            params.flash();
            validation.keep();
        }

    }

    public static void editDroit(Long id) {
        Droit droits = Droit.findById(id);
        render(droits);
    }

    public static void saveEditDroit(long id, String libelleDroit) {

        Droit droits = Droit.findById(id);
        try {
            droits.libelleDroit = libelleDroit;
            droits.save();
            consultations();

            flash("Success", "La modification a été faite avec succès");
        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la modification", new String[]{"errors"});
            params.flash();
            validation.keep();
        } finally {

        }
    }
}
