/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import play.Logger;
import play.mvc.Before;
import play.mvc.Controller;

/**
 *
 * @author NIKABOU
 */
public class SessionHandler extends Controller {

    /*@Before
    static void setConnectedUser() {
        if (Security.isConnected()) {
            Logger.info("HANDLER SESSION");
            renderArgs.put("user", Security.getUser());

            Logger.info("..........." + Security.getUser().account.getClass().getSimpleName());
        }
        String url = request.url;
        Logger.info("URL " + url);
        if ((Security.isConnected() && url.contains("portals/admin") && !Security.check("Administrateur"))
                || Security.isConnected() && url.contains("portals.admin") && !Security.check("Administrateur")) {
            forbidden("Bad account, restricted zone, admin only");
        }
        if ((Security.isConnected() && url.contains("portals/partner") && !Security.check("Partner"))
                || Security.isConnected() && url.contains("portals.partner") && !Security.check("Partner")) {
            forbidden("Bad account, restricted zone, partners only");
        }
    }*/
}
