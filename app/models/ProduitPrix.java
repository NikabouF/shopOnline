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
@Table(name = "ProduitPrix")
public class ProduitPrix extends Model {

    @Column(nullable = false)
    public Date date_Prix;
    @ManyToOne
    public Prix prix;
    @ManyToOne
    public Produit produit;

    public ProduitPrix() {
    }

    public ProduitPrix(Date date_Prix, Prix prix, Produit produit) {
        this.date_Prix = date_Prix;
        this.prix = prix;
        this.produit = produit;
    }

    public Date getDate_Prix() {
        return date_Prix;
    }

    public void setDate_Prix(Date date_Prix) {
        this.date_Prix = date_Prix;
    }

    public Prix getPrix() {
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

}
