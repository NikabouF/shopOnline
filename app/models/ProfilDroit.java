/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import play.db.jpa.Model;

/**
 *
 * @author NIKABOU
 */
@Entity
@Table(name = "profilDroit")
public class ProfilDroit extends Model {

    @ManyToOne
    public Profil profil;
    @ManyToOne
    public Droit droit;

    public ProfilDroit() {
    }

    public ProfilDroit(Profil profil, Droit droit) {
        this.profil = profil;
        this.droit = droit;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Droit getDroit() {
        return droit;
    }

    public void setDroit(Droit droit) {
        this.droit = droit;
    }

}
