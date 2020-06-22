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
 * Akcija za dodavanje katedre, nasledjuje apstraktnu klasu AbstractAction
 * 
 * @author Lazar Popadic
 */
@Component
public class AddDepartmentAction extends AbstractAction{
    /**
     * Vraca izgled stranice za dodavanje
     * @param request http zahtev 
     * @return vraca izgled stranice za dodavanje katedre kao string 
     */
    @Override
    public String execute(HttpServletRequest request) {
        //vrati stranicu za dodavanje
        return PageConstants.VIEW_ADD_DEPARTMENT;
    }
}
