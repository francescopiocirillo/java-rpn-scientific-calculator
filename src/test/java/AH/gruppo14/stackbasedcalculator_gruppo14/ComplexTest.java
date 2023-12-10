/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gruppo14
 */
public class ComplexTest {
    
    public ComplexTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of somma method, of class Complex.
     */
    @Test
    public void testSomma() {
        System.out.println("somma");
        Complex a = null;
        Complex b = null;
        Complex expResult = null;
        Complex result = Complex.somma(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sottrazione method, of class Complex.
     */
    @Test
    public void testSottrazione() {
        System.out.println("sottrazione");
        Complex a = null;
        Complex b = null;
        Complex expResult = null;
        Complex result = Complex.sottrazione(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prodotto method, of class Complex.
     */
    @Test
    public void testProdotto() {
        System.out.println("prodotto");
        Complex a = null;
        Complex b = null;
        Complex expResult = null;
        Complex result = Complex.prodotto(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divisione method, of class Complex.
     */
    @Test
    public void testDivisione() {
        System.out.println("divisione");
        Complex a = null;
        Complex b = null;
        Complex expResult = null;
        Complex result = Complex.divisione(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of radice method, of class Complex.
     */
    @Test
    public void testRadice() {
        System.out.println("radice");
        Complex c = null;
        Complex expResult = null;
        Complex result = Complex.radice(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invertiSegno method, of class Complex.
     */
    @Test
    public void testInvertiSegno() {
        System.out.println("invertiSegno");
        Complex c = null;
        Complex expResult = null;
        Complex result = Complex.invertiSegno(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Complex instance = new Complex();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of parseComplex method, of class Complex.
     */
    @Test
    public void testParseComplex() {
        System.out.println("parseComplex");
        String c = "";
        Complex expResult = null;
        Complex result = Complex.parseComplex(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRe method, of class Complex.
     */
    @Test
    public void testGetRe() {
        System.out.println("getRe");
        Complex instance = new Complex();
        double expResult = 0.0;
        double result = instance.getRe();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImm method, of class Complex.
     */
    @Test
    public void testGetImm() {
        System.out.println("getImm");
        Complex instance = new Complex();
        double expResult = 0.0;
        double result = instance.getImm();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRe method, of class Complex.
     */
    @Test
    public void testSetRe() {
        System.out.println("setRe");
        double re = 0.0;
        Complex instance = new Complex();
        instance.setRe(re);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImm method, of class Complex.
     */
    @Test
    public void testSetImm() {
        System.out.println("setImm");
        double imm = 0.0;
        Complex instance = new Complex();
        instance.setImm(imm);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
