/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.client;

import java.util.List;
import play.mvc.Controller;

/**
 *
 * @author NIKABOU
 */
public class Dashboard extends Controller{
    
    public static void index(){
        List<models.Categorie> categories = models.Categorie.findAll();
        List<models.Produit> produits = models.Produit.findAll();
        render(categories, produits);
    }
    
    public static void pageCategorie(){
        List<models.Categorie> categories = models.Categorie.findAll();
        List<models.Produit> produits = models.Produit.findAll();
        render(categories, produits);
    }
    
    public static void compteClient(){
        render();
     }
    
    public static void achatClient(){
        render();
    }
    
    public static void pageModeLiv(){
        render();
    }
    
    public static void pageModePaie(){
        render();
    }
    
    public static void pageConfirmCom(){
        render();
    }
    
    public static void pageFin(){
        render();
    }
    
    public static void panier(){
        render();
    }
}
