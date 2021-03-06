/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.portals.admin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import play.Play;

/**
 *
 * @author NIKABOU
 */
public class Actions {
    
    //public static String dirCategories = "/data/Categories";
    public static String dirProduits = "/data/Produits";
    
    public static String enregImage(File image, TypeImage typeImage){
        //Initialaisation
                String error = "";
				
				//Dossier
                File nompCompletDossier = new File(Play.applicationPath, getDirImage(typeImage));
				
				//Créer le dossier s'il n'existe pas.
                if (!nompCompletDossier.exists()) {

                    if (!nompCompletDossier.mkdirs())
                        return "2";
                }

                String nomCompletFichier = new SimpleDateFormat("Yyyyddmm_hhmmss").format(new Date()) + "." + getFileExtension(image);

                try {
					//on crée un nouveau fichier qu'on ajoute au chemin du dossier
                    File nomComplet = new File(nompCompletDossier, nomCompletFichier);
					
					//on enrégistre le chemin absolu vers le fichier image dans error
                    error = dirProduits.concat("/"+nomCompletFichier);
					
					//déplace l'image vers le dossier nomCpmplet
                    FileUtils.moveFile(image, nomComplet); // (fichier de départ , fichier d'arrivé)
					
                } catch (IOException ioe) {
                    //error = "1";
                    
                }
                catch (Exception e)
                {
                    error = "-1";
                   
                }
                finally {
                    //TODO A retirer
                    return error;
                }

                //return error;
    }
    
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
    
    private static String getDirImage(TypeImage typeImage)
    {
        String dir = "";
                
        switch(typeImage)
        {
//            case CATEGORIE:
//              dir = dirCategories;
//              break;
            case PRODUITS:
                dir = dirProduits;
                break;
        }
        
        return dir;
        
    }
    

}
