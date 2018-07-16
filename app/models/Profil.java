/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import play.db.jpa.Model;

/**
 *
 * @author NIKABOU
 */
@Entity
@Table(name = "profil")
public class Profil extends Model{
    
    @Column(nullable = false, unique = true, length = 20)
    public String libelleProfil;

    public Profil() {
    }

    public Profil(String libelleProfil) {
        this.libelleProfil = libelleProfil;
    }

    public String getLibelleProfil() {
        return libelleProfil;
    }

    public void setLibelleProfil(String libelleProfil) {
        this.libelleProfil = libelleProfil;
    }

    
}
