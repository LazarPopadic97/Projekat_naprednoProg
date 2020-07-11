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
import popadic.lazar.fon.fisweb.model.Department;
import popadic.lazar.fon.fisweb.http.HttpRequest;

/**
 *
 * @author Lazar Popadic
 */
public class DeleteDepartmentActionTest {

    DeleteDepartmentAction dda;
    HttpRequest request;
    Department department;

    public DeleteDepartmentActionTest() {
    }

    @Before
    public void setUp() {
        dda = new DeleteDepartmentAction();
        department = new Department();
        request = new HttpRequest("aa/cc/aa/2/dd",null);
        request.getServletContext().setAttribute("departments", createDepartments());
    }

    @After
    public void tearDown() {
        dda = null;
        department = null;
        request = null;
    }

    @Test
    public void testExecute() {

        String viewPath = PageConstants.VIEW_ALL_DEPARTMENTS;
        assertEquals(dda.execute(request), viewPath);
        assertNotNull("messageDeleted");
    }
    

    @Test
    public void testExecuteFail() {
        

        String viewPath = PageConstants.VIEW_DEFAULT_ERROR;
        assertFalse(dda.execute(request).equals(viewPath));
        assertNotNull("messageDeleteX");

    }

    private Object createDepartments() {
        List<Department> departments=new ArrayList<>();
        departments.add(new Department(1, "aa", "Aaaaaaaaaa"));
        departments.add(new Department(2, "bb", "Bbbbbbbbbbbb"));
        departments.add(new Department(3, "cc", "Ccccccc"));
        departments.add(new Department(4, "ac", "Ccccccc"));
        departments.add(new Department(5, "gc", "Ccccccc"));
        departments.add(new Department(6, "dc", "Ccccccc"));
        
        return departments;
    }

}
