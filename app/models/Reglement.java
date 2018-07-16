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
@Table(name = "reglement")
public class Reglement extends Model{
 
    @Column(nullable = false)
    public Date dateReg;
    @ManyToOne
    public Commande commande;
    @ManyToOne
    public TypeReglement typereglement;

    public Reglement() {
    }

    public Reglement(Date dateReg, Commande commande, TypeReglement typereglement) {
        this.dateReg = dateReg;
        this.commande = commande;
        this.typereglement = typereglement;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public TypeReglement getTypereglement() {
        return typereglement;
    }

    public void setTypereglement(TypeReglement typereglement) {
        this.typereglement = typereglement;
    }
    
    
}
