/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import static controllers.portals.admin.Dashboard.actionsA;
import controllers.Security;
import static controllers.portals.admin.Dashboard.enregCat;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import models.Categorie;
import play.Logger;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author NIKABOU
 */
@With(Security.class)
public class Categories extends Controller {

    //Ceci est la liste de mes catégories de produits
    public static void listCategorie() {
        List<models.Categorie> categories = models.Categorie.findAll();
        render(categories);
    }

    //On enrégistre une catégorie
    public static void saveCategorie(String libCategorie, String description) {
        try {
            Categorie categorie = new Categorie();
            categorie.description = description;
            categorie.libCategorie = libCategorie;
            categorie.save();
            flash("success", "La categorie a été créee avec succès");
            enregCat();

        } catch (PersistenceException ex) {
            Logger.error("" + libCategorie + "existe déjà");
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }

    //On supprime une catégorie
    public static void deleteCat(Long id) {
        try {
            //String query = "DELETE FROM categorie where=" + id + ";";
            Categorie cat = Categorie.findById(id);
            if (cat != null) {
                cat.delete();
                enregCat();
            }
        } catch (Exception e) {

        }
    }

    //On modifie et on enrégistre la modification apportée
    public static void editCategorie(Long id) {
        Categorie categorie = Categorie.findById(id);
        render(categorie);
    }

    public static void saveEditCategorie(Categorie categorie) {

        Categorie cat = Categorie.findById(categorie.id);
        cat.libCategorie = categorie.libCategorie;
        cat.description = categorie.description;
        try {
            cat.save();
        } catch (PersistenceException ex) {

        }finally{
             enregCat();
        }

    }
}
