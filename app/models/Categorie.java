/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import play.db.jpa.Model;

/**
 *
 * @author NIKABOU
 */
@Entity
@Table(name = "categorie")
public class Categorie extends Model{
    
    @Column(nullable = false, unique = true)
    public String libCategorie;
    
    @Column(nullable = false, unique = true)
    public  String description;
    
    public String couleur;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    public List<Produit> produits;

    public Categorie() {
    }

    public Categorie(String libCategorie, String description) {
        this.libCategorie = libCategorie;
        this.description = description;
    }

    public Categorie(String libCategorie, String description, String couleur, List<Produit> produits) {
        this.libCategorie = libCategorie;
        this.description = description;
        this.couleur = couleur;
        this.produits = produits;
    }

    
    public String getLibCategorie() {
        return libCategorie;
    }

    public void setLibCategorie(String libCategorie) {
        this.libCategorie = libCategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    

   public List<Produit> getProduits(){
       return Produit.find("categorie.id =?", this.id).fetch(); 
   }
    
   public List<Produit> getProdCat(String prod){
       return Produit.find("categorie.libCategorie =?", prod).fetch(); 
   }
}
