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
@Table(name = "livraison")
public class Livraison extends Model{
    
    @Column(nullable = false, unique = true, length = 20)
    public String libLiv;
    
    @Column(nullable = false)
    public Date dateLiv;
    
    @Column(nullable = false, length=30)
    public String lieuLiv;
    public boolean livre;
    
    @ManyToOne
    public Agent agent;
    @ManyToOne
    public Livreur livreur;

    public Livraison() {
    }

    public Livraison(String libLiv, Date dateLiv, String lieuLiv, boolean livre, Agent agent, Livreur livreur) {
        this.libLiv = libLiv;
        this.dateLiv = dateLiv;
        this.lieuLiv = lieuLiv;
        this.livre = livre;
        this.agent = agent;
        this.livreur = livreur;
    }

    public String getLibLiv() {
        return libLiv;
    }

    public void setLibLiv(String libLiv) {
        this.libLiv = libLiv;
    }

    public Date getDateLiv() {
        return dateLiv;
    }

    public void setDateLiv(Date dateLiv) {
        this.dateLiv = dateLiv;
    }

    public String getLieuLiv() {
        return lieuLiv;
    }

    public void setLieuLiv(String lieuLiv) {
        this.lieuLiv = lieuLiv;
    }

    public boolean isLivre() {
        return livre;
    }

    public void setLivre(boolean livre) {
        this.livre = livre;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
    
    
}
