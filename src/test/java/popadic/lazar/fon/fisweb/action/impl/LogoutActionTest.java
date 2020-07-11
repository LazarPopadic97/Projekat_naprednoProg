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
public class LogoutActionTest {

    LogoutAction la;
    HttpRequest request;

    public LogoutActionTest() {
    }

    @Before
    public void setUp() {
        la = new LogoutAction();
        request = new HttpRequest(null,null);

    }

    @After
    public void tearDown() {
        la = null;
        request = null;
    }

    @Test
    public void testExecute() {

        String viewPath = PageConstants.VIEW_LOGIN;
        assertEquals(la.execute(request), viewPath);
        assertNotNull(request.getAttribute("logoutMessage"));

    }

    @Test
    public void testExecuteFail() {

        String viewPath = PageConstants.VIEW_HOME;
        assertFalse(la.execute(request).equals(viewPath));

    }

}
