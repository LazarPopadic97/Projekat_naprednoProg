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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import popadic.lazar.fon.fisweb.constants.PageConstants;
import popadic.lazar.fon.fisweb.http.HttpRequest;
import popadic.lazar.fon.fisweb.model.Department;
import popadic.lazar.fon.fisweb.model.User;

/**
 *
 * @author Lazar Popadic
 */
public class LoginActionTest {

    LoginAction la;
    HttpRequest request;

    public LoginActionTest() {
    }

    @Before
    public void setUp() {
        la = new LoginAction();
        HashMap<String, String> mapa = new HashMap<>();
        mapa.put("email", "aaaa@a");
        mapa.put("password", "aaaa");
        request = new HttpRequest(null, mapa);
        request.getServletContext().setAttribute("users", createUsers());

    }

    @After
    public void tearDown() {
        la=null;
        request=null;
    }

    @Test
    public void testExecute() {
        String viewPath = PageConstants.VIEW_HOME;
        assertEquals(la.execute(request), viewPath);
        assertNotNull("loginUser");
    }
    
    public void testExecuteFail(){
        String viewPath = PageConstants.VIEW_DEFAULT_ERROR;
        assertEquals(la.execute(request), viewPath);
        assertNotNull("message");
    }
    
    

    private Object createUsers() {
        List<User> users=new ArrayList<>();
        users.add(new User("Pera", "Peric", "aaaa@a", "aaaa"));
        users.add(new User("Laza", "Lazic", "bbvvvb@a", "bbbbbb"));
        return users;
    }
}
