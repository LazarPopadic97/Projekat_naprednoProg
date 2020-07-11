/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.action.impl;

import java.util.ArrayList;
import java.util.HashMap;
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
public class UpdateDepartmentActionTest {
    
    UpdateDepartmentAction uda;
    HttpRequest request;
    public UpdateDepartmentActionTest() {
    }
    
    @Before
    public void setUp() {
        uda=new UpdateDepartmentAction();
        HashMap<String,String>mapa=new HashMap<>();
        mapa.put("shortname", "aaa");
        mapa.put("name", "aaaaaaaaaaaaaa");
        request=new HttpRequest("aa/bb/12/1/3",mapa);
        request.getServletContext().setAttribute("departments", createDepartments());
    }
    
    @After
    public void tearDown() {
        uda=null;
        request=null;
                
    }

    @Test
    public void testExecute() {
        String viewPath=PageConstants.VIEW_ALL_DEPARTMENTS;
        assertEquals(uda.execute(request),viewPath);
        assertNotNull("messageUpdated");
    }
    
    @Test
    public void testExecuteFail() {
        String viewPath=PageConstants.PAGE_DEFAULT_ERROR;
        assertFalse(uda.execute(request).equals(viewPath));
        assertNotNull("messageFill");
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
