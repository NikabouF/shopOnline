
import controllers.Security;
import static controllers.Security.setHashPassword;
import models.Administrateur;
import models.Compte;
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
public class TestAuthentificate extends UnitTest {
    
    @Test
    public void testAuthetificate()
    {
        //new Administrateur("des", "log", "pass").save();
        assertNotNull(Administrateur.find("loginUser", "login").first());
    }
    
}
