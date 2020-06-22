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
 * Akcija za cuvanje nove katedre u sistemu, nasledjuje aspstraktnu klasu AbstractAction
 * 
 * @author Lazar Popadic
 */
@Component
public class SaveDepartmentAction extends AbstractAction{
    /**
     * Vrsi cuvanje nove katedre i vraca prikaz stranice za dodavanje katedre
     * @param request http zahtev
     * @return prikaz stranice za dodavanje katedre
     */
    @Override
    public String execute(HttpServletRequest request) {
        long max = 0;
        List<Department> departments
                = (List<Department>) request.getServletContext().getAttribute("departments");
        for (Department department1 : departments) {
            if (department1.getId() > max) {
                max = department1.getId();
            }
        }
        long max1=max+1;
        request.setAttribute("id", max1);
        String shortname = request.getParameter("shortname");
        String name = request.getParameter("name");
        Department department = new Department(max1, shortname, name);

        if (departments.contains(department)) {
            request.setAttribute("message", "Department already exist with that id!");
        }else if(request.getParameter("shortname").isEmpty()
                ||request.getParameter("name").isEmpty()){
            request.setAttribute("messageSaveX", "You must fill all the fields");
        } else {
            departments.add(department);
            request.setAttribute("messageSaved", "Department has been saved!");
        }
        return PageConstants.VIEW_ADD_DEPARTMENT;
    }

}
