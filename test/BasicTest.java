import controllers.portals.admin.Actions;
import controllers.portals.admin.TypeImage;
import java.io.File;
import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }
    
    @Test
    public void testFile()
    {
        File file = new File("E:\\1.jpg");
        
        assertEquals(2, Actions.enregImage(file, TypeImage.PRODUITS));
    }

}
