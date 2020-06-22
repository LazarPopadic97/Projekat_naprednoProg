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
 * Akcija za prikaz profila korisnika, nasledjuje apstraktnu klasu AbstractAction
 * 
 * @author Lazar Popadic
 */
@Component
public class MyProfileAction extends AbstractAction{

    /**
     * Vraca izgled stranice za prikaz informacija o korisniku
     * @param request http zahtev 
     * @return stranicu za prikaz korisnika kao string
     */
    @Override
    public String execute(HttpServletRequest request) {
        return PageConstants.VIEW_PROFILE;
    }
    
}
