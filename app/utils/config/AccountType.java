/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.config;

/**
 *
 * @author NIKABOU
 */
import models.*;

/**
 * Created by yasser  
 */
public enum AccountType {

    AGENT(Agent.class.getSimpleName()),
    LIVREUR(Livreur.class.getSimpleName()),
    CLIENT(Client.class.getSimpleName()),
    ADMINISTRATEUR(Administrateur.class.getSimpleName());

    private String name;

    AccountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
