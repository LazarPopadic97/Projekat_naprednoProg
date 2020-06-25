/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popadic.lazar.fon.fisweb.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lazar Popadic
 */
public class UserTest {

    User u;

    public UserTest() {
    }

    @Before
    public void setUp() {
        u = new User();
    }

    @After
    public void tearDown() {
        u = null;
    }

    @Test
    public void testSetFirstname() {
        u.setFirstname("Lazar");
        assertEquals("Lazar", u.getFirstname());

    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetFirstnameNull() {
        u.setFirstname(null);
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetFirstnamePrazanString() {
        u.setFirstname("");
    }

    @Test
    public void testSetLastname() {
        u.setLastname("Popadic");
        assertEquals("Popadic", u.getLastname());

    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetLastnameNull() {
        u.setLastname(null);
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetLastnamePrazanString() {
        u.setLastname("");
    }

    @Test
    public void testSetEmail() {
        u.setEmail("lazar@gmail");
        assertEquals("lazar@gmail", u.getEmail());

    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetEmailNull() {
        u.setEmail(null);
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetEmailPrazanString() {
        u.setEmail("");
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetEmailNemaAt() {
        u.setEmail("lazar.popadic");
        assertFalse(u.getEmail().contains("@"));
    }

    @Test
    public void testSetPassword() {
        u.setPassword("laza123");
        assertEquals("laza123", u.getPassword());

    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetPasswordNull() {
        u.setPassword(null);
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetPasswordPrazanString() {
        u.setPassword("");
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetPasswordKraciOd6() {
        u.setPassword("123");
        assertFalse(u.getPassword().length() < 6);
    }

    @Test
    public void testEquals() {
        u.setEmail("laza@gmail");
        u.setPassword("laza123");

        User u1 = new User();
        u1.setEmail("laza@gmail");
        u1.setPassword("laza123");

        assertTrue(u1.equals(u));
    }

    @Test
    public void testEqualsEmailFalse() {
        u.setEmail("pera@gmail");
        u.setPassword("laza123");

        User u1 = new User();
        u1.setEmail("laza@gmail");
        u1.setPassword("laza123");

        assertFalse(u1.equals(u));
    }

    @Test
    public void testEqualsPasswordFalse() {
        u.setEmail("laza@gmail");
        u.setPassword("laza12345");

        User u1 = new User();
        u1.setEmail("laza@gmail");
        u1.setPassword("laza123");

        assertFalse(u1.equals(u));
    }

    @Test
    public void testEqualsObjectFalse() {
        assertFalse(u.equals(new Object()));
    }

    @Test
    public void testEqualsObjectNull() {
        assertFalse(u.equals(null));
    }

    @Test
    public void testEqualsFalse() {
        u.setEmail("mika@gmail");
        u.setPassword("mika123");

        User u1 = new User();
        u1.setEmail("laza@gmail");
        u1.setPassword("laza123");

        assertFalse(u1.equals(u));
    }

    @Test
    public void testToString() {
        u.setFirstname("Lazar");
        u.setLastname("Popadic");
        u.setEmail("lazar@gmail.com");
        u.setPassword("lazar123");
        
        String s=u.toString();
        assertTrue(s.contains("Lazar"));
        assertTrue(s.contains("Popadic"));
        assertTrue(s.contains("lazar@gmail.com"));
        assertTrue(s.contains("lazar123"));
    }

}
