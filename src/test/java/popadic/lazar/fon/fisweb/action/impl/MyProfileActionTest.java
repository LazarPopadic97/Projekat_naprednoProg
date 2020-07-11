/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.action.impl;

import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import popadic.lazar.fon.fisweb.constants.PageConstants;
import popadic.lazar.fon.fisweb.http.HttpRequest;

/**
 *
 * @author Lazar Popadic
 */
public class MyProfileActionTest {
    
    MyProfileAction mpa;
    HttpRequest request;
    public MyProfileActionTest() {
    }
    
    
    @Before
    public void setUp() {
        mpa=new MyProfileAction();
    }
    
    @After
    public void tearDown() {
        mpa=null;
    }

    @Test
    public void testExecute() {
        String viewPath=PageConstants.VIEW_PROFILE;
        assertEquals(mpa.execute(request), viewPath);
    }
    @Test
    public void testExecuteFail(){
        String viewPath=PageConstants.PAGE_LOGIN;
        assertFalse(mpa.execute(request).equals(viewPath));
    }
    
}
