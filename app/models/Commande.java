/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

/**
 *
 * @author NIKABOU
 */
@Entity
@Table(name = "commande")
public class Commande extends Model{
    
    @Column(nullable = false, unique = true, length = 20)
    public String libCom;
    
    @Column(nullable = false)
    public Date dateCom;
    
    public boolean valide;
    
   @ManyToOne
   public Client client;
   @ManyToOne
   public Livraison livraison;

    public Commande() {
    }

    public Commande(String libCom, Date dateCom, boolean valide, Client client,Livraison livraison) {
        this.libCom = libCom;
        this.dateCom = dateCom;
        this.valide = valide;
        this.client = client;
        this.livraison = livraison;
    }

    public String getLibCom() {
        return libCom;
    }

    public void setLibCom(String libCom) {
        this.libCom = libCom;
    }

    public Date getDateCom() {
        return dateCom;
    }

    public void setDateCom(Date dateCom) {
        this.dateCom = dateCom;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
    }
   
    
   
}
