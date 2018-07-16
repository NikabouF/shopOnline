/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

//import models.Account;
import models.Administrateur;
import models.Agent;
import models.Compte;
import models.Profil;
import play.libs.Codec;
import utils.config.AccountType;

/**
 *
 * @author NIKABOU
 */
public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
        // Compte user = Compte.find("byUsername", username).first();
        // System.out.println("*************Solution   :" +user != null && user.password.equals(password));
        // return user != null && user.password.equals(password);
        return Compte.isValidLogin(username, password);
    }

    public static String setHashPassword(String password) {
        return Codec.hexSHA1(password);
    }

    static boolean check(String profile) {

        Compte user = Compte.find("byUsername", connected()).first();

        String accountType = ((Profil) Profil.findById(user.profil.id)).libelleProfil;

        switch (AccountType.valueOf(accountType.toUpperCase())) {

            case AGENT:
                return (accountType.equals(profile));

            case ADMINISTRATEUR:
                return (accountType.equals(profile));

            case CLIENT:
                return (accountType.equals(profile));

            case LIVREUR:
                return (accountType.equals(profile));

            default:
                return false;
        }
    }

    static void onAuthenticated() {

        Compte user = getUser();
        String url = session.get("url");
        if (url != null) {
            session.remove("url");
            redirect(url);
        }
        // if agent
        if (Security.check("Agent")) {
            controllers.portals.agent.Dashboard.index();
        }

        // if admin
        if (Security.check("Administrateur")) {
            controllers.portals.admin.Dashboard.index();
        }
        // if livreur
        if (Security.check("Livreur")) {
            controllers.portals.livreur.Dashboard.index();
        }
        // if client
        if (Security.check("Client")) {
            controllers.portals.client.Dashboard.index();
        }
    }

    public static Compte getUser() {
        Compte user = Compte.find("byUsername", Security.connected()).first();
        return user;
    }

//    public static Account getAccount() {
//        return (getUser() == null) ? null : getUser().account;
//    }
    public static void logout() {
        Security.logout();
    }
}
