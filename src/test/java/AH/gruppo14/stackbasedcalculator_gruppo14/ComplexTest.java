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
    /**
     * TCA-1
     */
    @Test
    public void testSomma1() {
        System.out.println("somma1");
        Complex a = new Complex(0, 12.2518);
        Complex b = new Complex(0, -15.7543);
        Complex expResult = new Complex(0, -3.5025);
        Complex result = Complex.somma(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCA-2
     */
    @Test
    public void testSomma2() {
        System.out.println("somma2");
        Complex a = new Complex(15.1482, 10.1253);
        Complex b = new Complex(0, 15.7543);
        Complex expResult = new Complex(15.1482, 25.8796);
        Complex result = Complex.somma(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCA-3
     */
    @Test
    public void testSomma3() {
        System.out.println("somma3");
        Complex a = new Complex(10.2547, 0);
        Complex b = new Complex(0, 15.7583);
        Complex expResult = new Complex(10.2547, 15.7583);
        Complex result = Complex.somma(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCA-4
     */
    @Test
    public void testSomma4() {
        System.out.println("somma4");
        Complex a = new Complex(-18.4571, -19.9999);
        Complex b = new Complex(17.9999, 487.1999);
        Complex expResult = new Complex(-0.4572, 467.2000);
        Complex result = Complex.somma(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCA-5
     */
    @Test
    public void testSomma5() {
        System.out.println("somma5");
        Complex a = new Complex(13.22, 43.1);
        Complex b = new Complex(-94, 0);
        Complex expResult = new Complex(-80.78, 43.1);
        Complex result = Complex.somma(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCA-6
     */
    @Test
    public void testSomma6() {
        System.out.println("somma6");
        Complex a = new Complex(7.55, 8.3);
        Complex b = new Complex(-7.55, -8.3);
        Complex expResult = new Complex(0, 0);
        Complex result = Complex.somma(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCA-7
     */
    @Test
    public void testSomma7() {
        System.out.println("somma7");
        Complex a = new Complex(5, 0);
        Complex b = new Complex(76.9011, 0);
        Complex expResult = new Complex(81.9011, 0);
        Complex result = Complex.somma(a, b);
        assertEquals(expResult, result);
    }

}
