/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import play.data.validation.Check;
import play.data.validation.CheckWith;
import play.data.validation.Password;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Codec;

/**
 *
 * @author NIKABOU
 */
@Entity
@Table(name = "compte")
public class Compte extends Model {

    /**
     *
     */
    public String username;

    /**
     *
     */
    @Required
    @CheckWith(PasswordStrengthCheck.class)
    public String password;

    @ManyToOne
    public Profil profil;

    
    public Compte() {
    }

    public Compte(String username, String password, Profil profil) {
        this.username = username;
        this.password = password;
        this.profil = profil;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null && !password.isEmpty()) {
            this.password = password;
        }
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }


    public static String setHashPassword(String password) {
       return   Codec.hexSHA1(password);
     //  return Codec.hexStringToByte(password).toString();
    }

    static class PasswordStrengthCheck extends Check {

        @Override
        public boolean isSatisfied(Object user, Object password) {
            return true;//containsLettersAndNumbers(password);
        }
    }

    public static boolean isValidLogin(String username, String password) {
        // return TRUE if there is a single matching username/passwordHash
        System.err.println("*****Password :"+setHashPassword(password));
        System.err.println(count("username=?1 AND password=?2", username,setHashPassword(password)));
        return (count("username=?1 AND password=?2", username,
                setHashPassword(password)) == 1);
    }

    public static boolean isValidPwdById(Long id, String password) {
        // return TRUE if there is a single matching username/passwordHash
        return (count("id=?1 AND password=?2", id,
                setHashPassword(password)) == 1);
    }
}
