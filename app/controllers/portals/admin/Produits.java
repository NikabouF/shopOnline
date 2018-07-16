/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import controllers.Security;
import static controllers.portals.admin.Dashboard.actionsA;
import static controllers.portals.admin.Dashboard.enregProd;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import models.Categorie;
import models.Produit;
import play.Logger;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author NIKABOU
 */
@With(Security.class)
public class Produits extends Controller {

    public static void listProduit() {
        List<models.Produit> produits = models.Produit.findAll();
        render(produits);
    }

    //"""""""""""""Gérer les produits"""""""""""""""""""""""""""""""""""""""
    public static void saveProduit(String codeProduit, String libProduit, String description, File imageProd, String categorie) {

        Categorie cat = Categorie.findById(new Long(categorie));
        try {
            Produit produit = new Produit();
            produit.libProduit = libProduit;
            produit.description = description;
            produit.imageProd = Actions.enregImage(imageProd, TypeImage.PRODUITS);
            produit.categorie = cat;
            produit.save();
            flash("Success", "Le produit a été enrégistré avec succès");
            enregProd();

        } catch (PersistenceException ex) {

            Logger.error("Le produit " + libProduit + " existe déjà");
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement", new String[]{"errors"});
            params.flash();
            validation.keep();

        } finally {

        }

    }

    public static void deleteProduit(Long prod) {
        Produit p = Produit.findById(prod);
        try {
            p.delete();
        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la suppression de ce produit", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }

    //On supprime une catégorie
    public static void deleteProd(Long id) {
        try {
            Produit prod = Produit.findById(id);
            if (prod != null) {
                prod.delete();
                enregProd();
            }
        } catch (Exception e) {

        }
    }

    public static void editProduit(long id) {
        Produit produits = Produit.findById(id);
        render(produits);
    }

    public static void saveEditProduit(long id,String libelle,String des,File img, String categorie) {
       Categorie cat = Categorie.find("libCategorie",categorie).first();
        
        Produit prod = Produit.findById(id);
        prod.libProduit = libelle;
        prod.description = des;
        prod.categorie = cat;
        if(img != null){
          prod.imageProd = Actions.enregImage(img, TypeImage.PRODUITS);
        }
      
        try {
            prod.save();
            flash("Success", "Le produit a été modifié avec succès");
            enregProd();

        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la modification", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }

}
