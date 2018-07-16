
import controllers.portals.admin.Categories;
import static controllers.portals.admin.Dashboard.enregCat;
import models.Categorie;
import models.Compte;
import org.junit.Assert;
import org.junit.Test;
import play.test.UnitTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NIKABOU
 */
public class TestRequest extends UnitTest{
    
//    
//    public void basicQueryTest()
//    {
//        new Categorie("libi", "desi", "afile").save();
//        Categorie cat = Categorie.find("image", "file").first();
//    }
//    
   
    public void basicLogin()
    {
        Assert.assertNotNull(Compte.find("username", "log").first());
    }
    
//    @Test
//    public void testSupp(){
//        Categorie cat = Categorie.findById(3L);
//            if (cat != null) {
//                cat.delete();
//            }
//    }
    
    @Test
    public void testModif(){
        //Categories.saveEditCategorie(4L, "Mode et beauté", "Produits de mode et de beauté");

         Categorie cat = Categorie.findById(3);
            if (cat != null) {
                cat.libCategorie = "CATEGORIE";
                cat.description = "Une catégorie";
                cat.save();}
    }
}
