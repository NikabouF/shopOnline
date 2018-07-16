/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.CascadeType;
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
@Table(name = "produit")
public class Produit extends Model {

    @Column(nullable = false, unique = true)
    public String libProduit;
    
    @Column(nullable = false, unique = true)
    public String description;
    
    @Column(nullable = false)
    public String imageProd;
    
    @ManyToOne
    public Categorie categorie;

    public Produit() {
    }

    public Produit(String libProduit, String description,String imageProd, Categorie categorie) {
        this.libProduit = libProduit;
        this.description = description;
        this.imageProd=imageProd;
        this.categorie = categorie;
    }

    public String getLibProduit() {
        return libProduit;
    }

    public void setLibProduit(String libProduit) {
        this.libProduit = libProduit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageProd() {
        return imageProd;
    }

    public void setImageProd(String imageProd) {
        this.imageProd = imageProd;
    }
    

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getNomCatByIdCat(){
        Categorie categorie = models.Categorie.findById(this.id);
        return categorie.getLibCategorie();
    }
    
}
