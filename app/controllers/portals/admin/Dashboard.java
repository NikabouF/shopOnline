/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import controllers.Security;
import java.util.List;
import models.Produit;
import models.Profil;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author NIKABOU
 */
@With(Security.class)
public class Dashboard extends Controller {

    public static void index() {
        render();
    }

    public static void actionsA() {
        List<models.Categorie> categories = models.Categorie.findAll();
        List<models.Produit> produits = models.Produit.findAll();
        List<models.Droit> droits = models.Droit.findAll();
        List<models.Profil> profils = models.Profil.findAll();
        List<models.Compte> comptes = models.Compte.findAll();
        render(categories, produits, droits, profils, comptes);
    }

    public static void enregCat() {
        List<models.Categorie> categories = models.Categorie.findAll();
        render(categories);
    }

    public static void enregProd() {
        List<models.Produit> produits = models.Produit.findAll();
        List<models.Categorie> categories = models.Categorie.findAll();
        render(produits, categories);
    }

    public static void enregDroitProfil() {

        List<models.Droit> droits = models.Droit.findAll();
        List<models.Profil> profils = models.Profil.findAll();
        List<models.ProfilDroit> profDroits = models.ProfilDroit.findAll();

        render(droits, profils, profDroits);
    }

    public static void consultations() {
        List<models.Categorie> categories = models.Categorie.findAll();
        List<models.Produit> produits = models.Produit.findAll();
        List<models.Droit> droits = models.Droit.findAll();
        List<models.Profil> profils = models.Profil.findAll();
        List<models.Client> clients = models.Client.findAll();
        List<models.Commande> commandes = models.Compte.findAll();
        List<models.Compte> comptes = models.Compte.findAll();
        List<models.Livraison> livraisons = models.Livraison.findAll();
        List<models.ProfilDroit> profDroits = models.ProfilDroit.findAll();
        List<models.Agent> agents = models.Agent.findAll();
        List<models.Livreur> livreurs = models.Livreur.findAll();
        List<models.Administrateur> administrateurs = models.Administrateur.findAll();

        render(categories, produits, droits, profils, clients, commandes, comptes, livraisons, profDroits, agents, livreurs,administrateurs);
    }
}
