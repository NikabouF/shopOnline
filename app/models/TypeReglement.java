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
@Table(name = "typeReglement")
public class TypeReglement extends Model{
    
    @Column(nullable = false, unique = true, length = 30)
    public String libelleType;

    public String designation;

    public TypeReglement() {
    }

    public TypeReglement(String libelleType, String designation) {
        this.libelleType = libelleType;
        this.designation = designation;
    }

    public String getLibelleType() {
        return libelleType;
    }

    public void setLibelleType(String libelleType) {
        this.libelleType = libelleType;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    
}
