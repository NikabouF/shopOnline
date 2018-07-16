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
@Table(name = "droit")
public class Droit extends Model {
    
    @Column(nullable = false, unique = true)
    public String libelleDroit;

    public Droit() {
    }

    public Droit(String libelleDroit) {
        this.libelleDroit = libelleDroit;
    }

    public String getLibelleDroit() {
        return libelleDroit;
    }

    public void setLibelleDroit(String libelleDroit) {
        this.libelleDroit = libelleDroit;
    }
    
    
}
