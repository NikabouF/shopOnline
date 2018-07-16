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
@Table(name = "facture")
public class Facture extends Model{
    
    @Column(nullable = false, unique = true, length = 20)
    public String libFac;
    
    @Column(nullable = false)
    public Date dateFac;
    
    @Column(nullable = false)
    public Date dateRegle;

    public Facture() {
    }

    public Facture(String libFac, Date dateFac, Date dateRegle) {
        this.libFac = libFac;
        this.dateFac = dateFac;
        this.dateRegle = dateRegle;
    }

    public String getLibFac() {
        return libFac;
    }

    public void setLibFac(String libFac) {
        this.libFac = libFac;
    }

    public Date getDateFac() {
        return dateFac;
    }

    public void setDateFac(Date dateFac) {
        this.dateFac = dateFac;
    }

    public Date getDateRegle() {
        return dateRegle;
    }

    public void setDateRegle(Date dateRegle) {
        this.dateRegle = dateRegle;
    }
    
    
}
