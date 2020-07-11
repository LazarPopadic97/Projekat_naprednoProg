/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.action.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import popadic.lazar.fon.fisweb.constants.PageConstants;
import popadic.lazar.fon.fisweb.http.HttpRequest;
import popadic.lazar.fon.fisweb.model.Department;

/**
 *
 * @author Lazar Popadic
 */
public class SaveDepartmentActionTest {

    public SaveDepartmentActionTest() {
    }
    SaveDepartmentAction sda;
    HttpRequest request;
    Department department;
    List<Department> departments;

    @Before
    public void setUp() {
        departments = new ArrayList<>();
        sda = new SaveDepartmentAction();
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("shortname", "aaaa");
        mapa.put("name", "bbbb");
        request = new HttpRequest(null, mapa);
        request.getServletContext().setAttribute("departments", createDepartments());
    }

    @After
    public void tearDown() {
        sda = null;
        request = null;
    }

    @Test
    public void testExecute() {
       String viewPath=PageConstants.VIEW_ADD_DEPARTMENT;
        assertEquals(sda.execute(request),viewPath);
        assertNotNull("messageSaved");
    }
    @Test
    public void testExecuteFail(){
        String viewPath=PageConstants.PAGE_DEFAULT_ERROR;
        assertFalse(sda.execute(request).equals(viewPath));
        assertNotNull("messageSaveX");
    }

    private Object createDepartments() {

        departments.add(new Department(1, "aa", "Aaaaaaaaaa"));
        departments.add(new Department(2, "bb", "Bbbbbbbbbbbb"));
        departments.add(new Department(3, "cc", "Ccccccc"));
        return departments;
    }

}
