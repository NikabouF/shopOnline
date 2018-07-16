/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import play.db.jpa.Model;

/**
 *
 * @author NIKABOU
 */
@Entity
@Table(name = "connexion")
public class Connexion extends Model {
    
    public Date dateDebut;
    public Date dateFin;
    public String activite;
    @ManyToOne
    public Compte utilisateur;

    public Connexion() {
    }

    public Connexion(Date dateDebut, Date dateFin, String activite, Compte utilisateur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.activite = activite;
        this.utilisateur = utilisateur;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }

    public Compte getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Compte utilisateur) {
        this.utilisateur = utilisateur;
    }
    
    
    
}
