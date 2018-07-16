/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import play.db.jpa.Model;

/**
 *
 * @author NIKABOU
 */
@Entity
@Table(name = "livreur")
public class Livreur extends Model {

    @Column(nullable = false, unique = true, length = 20)
    public String nom;

    @Column(nullable = false, unique = true, length = 40)
    public String prenom;

    @Column(nullable = false, length = 30)
    public String adresse;

    @Column(nullable = false, length = 8)
    public String sexe;

    @Column(nullable = false, unique = true, length = 15)
    public String NumTel;

    public String designation;

    @Column(nullable = false)
    public Date dateEmbauche;
    
    @Column(nullable = false,unique=true, length=20)
    public Long compteid;

    public Livreur() {
    }

    public Livreur(String nom, String prenom, String adresse, String sexe, String NumTel, String designation, Date dateEmbauche, Long compteid) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.sexe = sexe;
        this.NumTel = NumTel;
        this.designation = designation;
        this.dateEmbauche = dateEmbauche;
        this.compteid = compteid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumTel() {
        return NumTel;
    }

    public void setNumTel(String NumTel) {
        this.NumTel = NumTel;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public Long getCompteid() {
        return compteid;
    }

    public void setCompteid(Long compteid) {
        this.compteid = compteid;
    }

    
}
