/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.action.impl;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import popadic.lazar.fon.fisweb.action.AbstractAction;
import popadic.lazar.fon.fisweb.constants.PageConstants;

/**
 * Akcija za odjavljivanje sa sistema, nasledjuje klasu AbstractAction
 * 
 * @author Lazar Popadic
 */
@Component
public class LogoutAction extends AbstractAction{

   /**
    * Vraca izgled stranice za logovanje nakon odjavljivanja sa sistema
    * @param request http zahtev
    * @return izgled stranice za logovanje kao string
    */
   @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        request.setAttribute("logoutMessage", "You logged out !");

        return PageConstants.VIEW_LOGIN;
    }

    
}
