/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.action.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import popadic.lazar.fon.fisweb.constants.PageConstants;
import popadic.lazar.fon.fisweb.http.HttpRequest;
import popadic.lazar.fon.fisweb.model.Department;

/**
 *
 * @author Lazar Popadic
 */
public class EditDepartmentActionTest {

    EditDepartmentAction eda;
    HttpRequest request;

    public EditDepartmentActionTest() {
    }

    @Before
    public void setUp() {
        eda = new EditDepartmentAction();
        request = new HttpRequest("aa/bb/1/2/d", null);
        request.getServletContext().setAttribute("departments", createDepartments());

    }

    @After
    public void tearDown() {
        eda=null;
        request=null;
    }

    @Test
    public void testExecute() {
        String viewPath=PageConstants.VIEW_EDIT_DEPARTMENT;
        assertEquals(eda.execute(request),viewPath);
    }
    
    @Test
    public void testExecuteFail() {
        String viewPath=PageConstants.VIEW_DEFAULT_ERROR;
        assertFalse(eda.execute(request).equals(viewPath));
    }

    private Object createDepartments() {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "aa", "Aaaaaaaaaa"));
        departments.add(new Department(2, "bb", "Bbbbbbbbbbbb"));
        departments.add(new Department(3, "cc", "Ccccccc"));
        departments.add(new Department(4, "ac", "Ccccccc"));
        departments.add(new Department(5, "gc", "Ccccccc"));
        departments.add(new Department(6, "dc", "Ccccccc"));

        return departments;
    }
}
