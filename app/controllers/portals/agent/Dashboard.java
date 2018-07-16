/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.agent;

import java.util.List;
import play.mvc.Controller;

/**
 *
 * @author NIKABOU
 */
public class Dashboard extends Controller {
    public static void index(){
        render();
    }
    
    public static void enregCommande(){
        List<models.Commande> commandes = models.Commande.findAll();
        List<models.LigneCommande> ligneCommandes=models.LigneCommande.findAll();
        render(commandes,ligneCommandes);
    }
    
    public static void enregLivraison(){
        List<models.Livraison> livraisons = models.Livraison.findAll();
        render(livraisons);       
    }
    
    public static void enregReglement(){
        List<models.Reglement> reglements = models.Reglement.findAll();
        render(reglements);
    }
    
    public static void consultation(){
        render();
    }
}
