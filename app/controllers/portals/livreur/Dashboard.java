/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.livreur;

import java.util.List;
import play.mvc.Controller;

/**
 *
 * @author NIKABOU
 */
public class Dashboard extends Controller{
    public static void index(){
        render();
    }
    
        public static void consultation() {
        List<models.Categorie> categories = models.Categorie.findAll();
        List<models.Produit> produits = models.Produit.findAll();
        List<models.Droit> droits = models.Droit.findAll();
        List<models.Profil> profils = models.Profil.findAll();

        render(categories, produits, droits, profils);
    }
        
        public static void validerLivraison(){
            render();
        }
}
