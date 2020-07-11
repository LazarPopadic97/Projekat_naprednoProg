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
public class HomeActionTest {

    HomeAction ha;
    HttpRequest request;
    public HomeActionTest() {
    }
    @Before
    public void setUp() {
        ha=new HomeAction();
    }
    
    @After
    public void tearDown() {
        ha=null;
    }

    @Test
    public void testExecute() {
        String viewPath=PageConstants.VIEW_HOME;
        assertEquals(ha.execute(request), viewPath);
    }
    @Test
    public void testExecuteFail(){
        String viewPath=PageConstants.VIEW_LOGIN;
        assertFalse(ha.execute(request).equals(viewPath));
    }
    
}
