/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import controllers.Security;
import static controllers.portals.admin.Dashboard.actionsA;
import static controllers.portals.admin.Dashboard.enregDroitProfil;
import java.util.List;
import javax.persistence.PersistenceException;
import models.Droit;
import models.Profil;
import models.ProfilDroit;
import play.mvc.Controller;
import play.mvc.With;

/**
 *
 * @author NIKABOU
 */
@With(Security.class)
public class ProfilsDroits extends Controller{
    
     public static void saveProfilDroit(String libelleProfil,List<Long> choixDroit){
        try {
            Profil profils=new Profil();
            profils.libelleProfil=libelleProfil;
            profils.save();
            for(Long id : choixDroit){
            ProfilDroit profilsDroits=new ProfilDroit();
            profilsDroits.profil=profils;
            profilsDroits.droit= Droit.findById(id);
            profilsDroits.save();
            
            enregDroitProfil();
            }  
        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de l'enregistrement", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
    }
    
    public static void deleteProfilDroit(Long id){
        ProfilDroit prdr=Profil.findById(id);
        try {
            prdr.delete();
            
        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la suppression", new String[]{"errors"});
            params.flash();
            validation.keep();
        }
        
    }
    
    public static void editProfilDroit(Long id){
        ProfilDroit profilsDroits=ProfilDroit.findById(id);
        render(profilsDroits);
    }
    
    public static void saveEditProfilDroit(Profil profil, Droit droit){
        
        ProfilDroit profDr=ProfilDroit.findById(profil.id);
        profDr.profil=profil;
        profDr.droit=droit;
        
        try {
            profDr.save();
            flash("Success", "La modification a été faite avec succès");
        } catch (PersistenceException ex) {
            validation.addError("errors", "Une erreur s'est produite lors de la modification", new String[]{"errors"});
            params.flash();
            validation.keep();
        } finally {
        
        }
    }
}
