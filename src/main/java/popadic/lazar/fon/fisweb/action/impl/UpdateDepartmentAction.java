/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.action.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import popadic.lazar.fon.fisweb.action.AbstractAction;
import popadic.lazar.fon.fisweb.constants.PageConstants;
import popadic.lazar.fon.fisweb.model.Department;

/**
 * Akcija za prihvatanje izmena izvrsenih nad katedrom, nasledjuje apstraktnu klasu AbstractAction
 * 
 * @author Lazar Popadic
 */
@Component
public class UpdateDepartmentAction extends AbstractAction {

    /**
     * Neparametrizovani konstruktor
     */
    public UpdateDepartmentAction() {
    }

    /**
     * Omogocuva izmenu nad katedrom i vraca stranicu u zavisnosti da li su izmene uspele
     * @param request http zahtev
     * @return vraca izgled stranice za izmenu katedre ili stranicu za prikaz svih katedri
     */
    @Override
    public String execute(HttpServletRequest request) {
        long id = Long.valueOf(request.getPathInfo().split("/")[3]);
        String shortName = request.getParameter("shortname");
        String name = request.getParameter("name");
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("shortname", shortName);
        if (shortName.isEmpty() || name.isEmpty()) {
            request.setAttribute("messageFill", "You must fill all the fields !");
            return PageConstants.VIEW_EDIT_DEPARTMENT;
        }
        List<Department> departments = (List<Department>) request.getServletContext().getAttribute("departments");
        Department department = new Department(shortName, name);
        department.setId(id);
        Department d = departments.get(departments.indexOf(department));
        d.setName(name);
        d.setShortname(shortName);
        request.setAttribute("messageUpdated", "Department "+shortName +" has been updated.");

        return PageConstants.VIEW_ALL_DEPARTMENTS;

    }

}
