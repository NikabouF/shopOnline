/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.agent;

import java.util.Date;
import java.util.List;
import javax.persistence.PersistenceException;
import models.Client;
import models.Commande;
import models.Livraison;
import play.mvc.Controller;

/**
 *
 * @author NIKABOU
 */
public class Commandes extends Controller{
    
    public static void listCommande() {
        List<models.Commande> commandes = models.Commande.findAll();
        render(commandes);
    }
    
    
    public static void saveCommande(String libCom, Date dateCom, boolean valide, String client,String livraison){
    
        Client cli = Client.findById(new Long(client));
        Livraison liv = Livraison.findById(new Long(livraison));
        try {
            Commande commandes=new Commande();
            commandes.libCom=libCom;
            commandes.dateCom=dateCom;
            commandes.client=cli;
            commandes.livraison=liv;
            commandes.valide=valide;
            
            commandes.save();
            
         } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement de cette commande", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }
}
