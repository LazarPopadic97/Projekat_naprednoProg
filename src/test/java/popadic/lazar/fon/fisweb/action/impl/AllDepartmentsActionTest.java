/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.action.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import popadic.lazar.fon.fisweb.constants.PageConstants;
import popadic.lazar.fon.fisweb.http.HttpRequest;

/**
 *
 * @author Lazar Popadic
 */
public class AllDepartmentsActionTest {

    AllDepartmentsAction ada;
    HttpRequest request;

    public AllDepartmentsActionTest() {
    }

    @Before
    public void setUp() {
        ada = new AllDepartmentsAction();
    }

    @After
    public void tearDown() {
        ada = null;
    }

    @Test
    public void testExecute() {
        String viewPath=PageConstants.VIEW_ALL_DEPARTMENTS;
        assertEquals(ada.execute(request),viewPath);
    }

    @Test
    public void testExecuteFail(){
        String viewPath=PageConstants.VIEW_HOME;
        assertFalse(ada.execute(request).equals(viewPath));
    }
}
