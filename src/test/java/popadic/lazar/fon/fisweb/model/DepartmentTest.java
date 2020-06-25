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
public class DepartmentTest {

    Department d;

    public DepartmentTest() {
    }

    @Before
    public void setUp() {
        d = new Department();
    }

    @After
    public void tearDown() {
        d = null;
    }

   
    @Test
    public void testSetId() {
        d.setId(1l);
        assertEquals(1l, d.getId());
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetIdNula() {
        d.setId(0l);
    }
    @Test(expected = java.lang.RuntimeException.class)
    public void testSetIdNegativan() {
        d.setId(-1l);
    }

    @Test
    public void testSetShortname() {
        d.setShortname("mmk");
        assertEquals("mmk", d.getShortname());
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetShortnameNull() {
        d.setShortname(null);
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetShortnamePrazanString() {
        d.setShortname("");
    }

    @Test
    public void testSetName() {
        d.setName("Katedra za is");
        assertEquals("Katedra za is", d.getName());
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetNameNull() {
        d.setName(null);
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void testSetNamePrazanString() {
        d.setName("");
    }

    @Test
    public void testEquals() {
        d.setId(1l);
        Department d1 = new Department();
        d1.setId(1l);
        assertTrue(d1.equals(d));
    }

    @Test
    public void testEqualsFalse() {
        d.setId(1l);
        Department d1 = new Department();
        d1.setId(2l);
        assertFalse(d1.equals(d));
    }

    @Test
    public void testEqualsDrugaKlasa() {
        assertFalse(d.equals(new Object()));
    }
    @Test
    public void testEqualsObjectNull(){
        assertFalse(d.equals(null));
    }

    @Test
    public void testToString() {
        d.setId(1l);
        d.setShortname("is");
        d.setName("Katedra za informacione sisteme");
        
        String s=d.toString();
        assertTrue(s.contains("1"));
        assertTrue(s.contains("is"));
        assertTrue(s.contains("Katedra za informacione sisteme"));
    }

}
