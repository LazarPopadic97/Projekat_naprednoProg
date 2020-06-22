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
 * Akcija za prikaz pocetne strane, nasledjuje apstraktnu klasu AbstractAction
 * 
 * @author Lazar Popadic
 */
@Component
public class HomeAction extends AbstractAction{

    /**
     * Vraca izgled za pocetnu stranu
     * @param request http zahtev
     * @return izgled za pocetnu stranu kao string
     */
    @Override
    public String execute(HttpServletRequest request) {
        return PageConstants.VIEW_HOME;
    }
    
}
