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

    /**
     * Test of sottrazione method, of class Complex.
     */
    /**
     * TCS-1
     */
    @Test
    public void testSottrazione1() {
        System.out.println("sottrazione1");
        Complex a = new Complex(0, 43.5);
        Complex b = new Complex(0, 10.96);
        Complex expResult = new Complex(0, 32.54);
        Complex result = Complex.sottrazione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCS-2
     */
    @Test
    public void testSottrazione2() {
        System.out.println("sottrazione2");
        Complex a = new Complex(-85.9, -62.22);
        Complex b = new Complex(0, 33.8);
        Complex expResult = new Complex(-85.9, -96.02);
        Complex result = Complex.sottrazione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCS-3
     */
    @Test
    public void testSottrazione3() {
        System.out.println("sottrazione3");
        Complex a = new Complex(5.7965, 0);
        Complex b = new Complex(0, 96.4);
        Complex expResult = new Complex(5.7965, -96.4);
        Complex result = Complex.sottrazione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCS-4
     */
    @Test
    public void testSottrazione4() {
        System.out.println("sottrazione4");
        Complex a = new Complex(43.9, -24.1);
        Complex b = new Complex(22.7, 34);
        Complex expResult = new Complex(21.2, -58.1);
        Complex result = Complex.sottrazione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCS-5
     */
    @Test
    public void testSottrazione5() {
        System.out.println("sottrazione5");
        Complex a = new Complex(77.7, 96.2);
        Complex b = new Complex(-34.8, 0);
        Complex expResult = new Complex(112.5, 96.2);
        Complex result = Complex.sottrazione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCS-6
     */
    @Test
    public void testSottrazione6() {
        System.out.println("sottrazione6");
        Complex a = new Complex(10.8005, 6);
        Complex b = new Complex(10.8005, 6);
        Complex expResult = new Complex(0, 0);
        Complex result = Complex.sottrazione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCS-7
     */
    @Test
    public void testSottrazione7() {
        System.out.println("sottrazione7");
        Complex a = new Complex(7.54, 0);
        Complex b = new Complex(44.3, 0);
        Complex expResult = new Complex(-36.76, 0);
        Complex result = Complex.sottrazione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of prodotto method, of class Complex.
     */
    /**
     * TCM-1
     */
    @Test
    public void testProdotto1() {
        System.out.println("prodotto1");
        Complex a = new Complex(0, 12.3);
        Complex b = new Complex(0, -45.6632);
        Complex expResult = new Complex(561.6574, 0);
        Complex result = Complex.prodotto(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCM-2
     */
    @Test
    public void testProdotto2() {
        System.out.println("prodotto2");
        Complex a = new Complex(-67.8, 90);
        Complex b = new Complex(0, 98);
        Complex expResult = new Complex(-8820, -6644.4);
        Complex result = Complex.prodotto(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCM-3
     */
    @Test
    public void testProdotto3() {
        System.out.println("prodotto3");
        Complex a = new Complex(87.6, 0);
        Complex b = new Complex(0, 655);
        Complex expResult = new Complex(0, 57378);
        Complex result = Complex.prodotto(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCM-4
     */
    @Test
    public void testProdotto4() {
        System.out.println("prodotto4");
        Complex a = new Complex(-54.3, 2);
        Complex b = new Complex(21, -9.08);
        Complex expResult = new Complex(-1122.14, 535.044);
        Complex result = Complex.prodotto(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCM-5
     */
    @Test
    public void testProdotto5() {
        System.out.println("prodotto5");
        Complex a = new Complex(7.41, 12.4);
        Complex b = new Complex(-85, 0);
        Complex expResult = new Complex(-629.85, -1054);
        Complex result = Complex.prodotto(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCM-6
     */
    @Test
    public void testProdotto6() {
        System.out.println("prodotto6");
        Complex a = new Complex(99.9696, 0);
        Complex b = new Complex(-3.7, 0);
        Complex expResult = new Complex(-369.8875, 0);
        Complex result = Complex.prodotto(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of divisione method, of class Complex.
     */
    /**
     * TCD-1
     */
    @Test
    public void testDivisione1() {
        System.out.println("Test divisione1");
        Complex a = new Complex(-96.3, -25.7);
        Complex b = new Complex(0, 7.89);
        Complex expResult = new Complex(-3.2573, 12.2053);
        Complex result = Complex.divisione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCD-2
     */
    @Test
    public void testDivisione2() {
        System.out.println("Test divisione2");
        Complex a = new Complex(6, 0);
        Complex b = new Complex(0, 52);
        Complex expResult = new Complex(0, -0.1154);
        Complex result = Complex.divisione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCD-3
     */
    @Test
    public void testDivisione3() {
        System.out.println("Test divisione3");
        Complex a = new Complex(0, 55);
        Complex b = new Complex(0, -99);
        Complex expResult = new Complex( -0.5555,0);
        Complex result = Complex.divisione(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * TCD-4
     */
    @Test
    public void testDivisione4() {
        System.out.println("Test divisione4");
        Complex a = new Complex(96.6,8.7787);
        Complex b = new Complex(-852, 0);
        Complex expResult = new Complex(-0.1134, -0.0103);
        Complex result = Complex.divisione(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * TCD-5
     */
    @Test
    public void testDivisione5() {
        System.out.println("Test divisione5");
        Complex a = new Complex(75, 3.41);
        Complex b = new Complex(6.754, -42);
        Complex expResult = new Complex(0.2008, 1.7534);
        Complex result = Complex.divisione(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * TCD-6
     */
    @Test
    public void testDivisione6() {
        System.out.println("Test divisione6");
        Complex a = new Complex(547, 0);
        Complex b = new Complex(0, 0);
        Complex expResult = new Complex(Double.NaN, 0);
        Complex result = Complex.divisione(a, b);
        assertEquals(expResult, result);
    }

    /**
     * TCD-7
     */
    @Test
    public void testDivisione7() {
        System.out.println("Test divisione7");
        Complex a = new Complex(5, 0);
        Complex b = new Complex(3.6321, 0);
        Complex expResult = new Complex(1.3766, 0);
        Complex result = Complex.divisione(a, b);
        assertEquals(expResult, result);
    }


    /**
     * Test of invertiSegno method, of class Complex.
     */
    /**
     * TCI-1
     */
    @Test
    public void testInvertiSegno1() {
        System.out.println("Test invertiSegno1");
        Complex a = new Complex(-42, -9.4);
        Complex expResult = new Complex(42, 9.4);
        Complex result = Complex.invertiSegno(a);
        assertEquals(expResult, result);
    }

    /**
     * TCI-2
     */
    @Test
    public void testInvertiSegno2() {
        System.out.println("Test invertiSegno2");
        Complex a = new Complex(0, 62);
        Complex expResult = new Complex(0, -62);
        Complex result = Complex.invertiSegno(a);
        assertEquals(expResult, result);
    }
    
    /**
     * TCI-3
     */
    @Test
    public void testInvertiSegno3() {
        System.out.println("Test invertiSegno3");
        Complex a = new Complex(43.9635, 0);
        Complex expResult = new Complex( -43.9635, 0);
        Complex result = Complex.invertiSegno(a);
        assertEquals(expResult, result);
    }
    
    /**
     * TCI-4
     */
    @Test
    public void testInvertiSegno4() {
        System.out.println("Test invertiSegno4");
        Complex a = new Complex(0,0);
        Complex expResult = new Complex(0, 0);
        Complex result = Complex.invertiSegno(a);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of radice method, of class Complex.
     */
    /**
     * TCR-1
     */
    @Test
    public void testRadice1() {
        System.out.println("Test radice1");
        Complex a = new Complex(9.77, 41);
        Complex expResult = new Complex(5.095, 4.0235);
        Complex result = Complex.radice(a);
        assertEquals(expResult, result);
    }
    
    /**
     * TCR-2
     */
    @Test
    public void testRadice2() {
        System.out.println("Test radice2");
        Complex a = new Complex(0, 399.2);
        Complex expResult = new Complex(14.1280, 14.1280);
        Complex result = Complex.radice(a);
        assertEquals(expResult, result);
    }
    
    /**
     * TCR-3
     */
    @Test
    public void testRadice3() {
        System.out.println("Test radice3");
        Complex a = new Complex(86.41, 0);
        Complex expResult = new Complex( 9.2957, 0);
        Complex result = Complex.radice(a);
        assertEquals(expResult, result);
    }
    
    /**
     * TCR-4
     */
    @Test
    public void testRadice4() {
        System.out.println("Test radice4");
        Complex a = new Complex(-4,0);
        Complex expResult = new Complex(0, 2);
        Complex result = Complex.radice(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Complex.
     */
    /**
     * TCTS-1
     */
    @Test
    public void testToString1() {
        System.out.println("Test toString1");
        Complex c = new Complex(12.5432, 0);
        String expResult = "12.5432";
        String result = c.toString();
        assertEquals(expResult, result);
    }

    /**
     * TCTS-2
     */
    @Test
    public void testToString2() {
        System.out.println("Test toString2");
        Complex c = new Complex(0, 76.3214);
        String expResult = "j76.3214";
        String result = c.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * TCTS-3
     */
    @Test
    public void testToString3() {
        System.out.println("Test toString3");
        Complex c = new Complex(-12.5432, -76.3214);
        String expResult = "-12.5432-j76.3214";
        String result = c.toString();
        assertEquals(expResult, result);
    }

    /**
     * TCTS-4
     */
    @Test
    public void testToString4() {
        System.out.println("Test toString4");
        Complex c = new Complex(451.1234, 0.7890);
        String expResult = "451.1234+j0.7890";
        String result = c.toString();
        assertEquals(expResult, result);
    }

    /**
     * TCTS-5
     */
    @Test
    public void testToString5() {
        System.out.println("Test toString5");
        Complex c = new Complex(0, -79.9999);
        String expResult = "-j79.9999";
        String result = c.toString();
        assertEquals(expResult, result);
    }

    /**
     * TCTS-6
     */
    @Test
    public void testToString6() {
        System.out.println("Test toString6");
        Complex c = new Complex(Double.NaN, 59.9999);
        String expResult = "ERR";
        String result = c.toString();
        assertEquals(expResult, result);
    }

    /**
     * TCTS-7
     */
    @Test
    public void testToString7() {
        System.out.println("Test toString7");
        Complex c = new Complex(19.9999, Double.POSITIVE_INFINITY);
        String expResult = "INF";
        String result = c.toString();
        assertEquals(expResult, result);
    }

    /**
     * TCTS-8
     */
    @Test
    public void testToString8() {
        System.out.println("Test toString8");
        Complex c = new Complex();
        String expResult = "0";
        String result = c.toString();
        assertEquals(expResult, result);
    }
    
    /**
    * Test of parseComplex method, of class Complex.
    */
    /**
     * TCPC-1
     */
    @Test
    public void testParseComplex1() {
        System.out.println("Test parseComplex1");
        String c = "12.5432";
        Complex expResult = new Complex(12.5432, 0);
        Complex result = Complex.parseComplex(c);
        assertEquals(expResult, result);
    }

    /**
     * TCPC-2
     */
    @Test
    public void testParseComplex2() {
        System.out.println("Test parseComplex2");
        String c = "j76.3214";
        Complex expResult = new Complex(0, 76.3214);
        Complex result = Complex.parseComplex(c);
        assertEquals(expResult, result);
    }

    /**
     * TCPC-3
     */
    @Test
    public void testParseComplex3() {
        System.out.println("Test parseComplex3");
        String c = "-12.5432-j76.3214";
        Complex expResult = new Complex(-12.5432, -76.3214);
        Complex result = Complex.parseComplex(c);
        assertEquals(expResult, result);
    }

    /**
     * TCPC-4
     */
    @Test
    public void testParseComplex4() {
        System.out.println("Test parseComplex4");
        String c = "451.1234+j0.7890";
        Complex expResult = new Complex(451.1234, 0.7890);
        Complex result = Complex.parseComplex(c);
        assertEquals(expResult, result);
    }

    /**
     * TCPC-5
     */
    @Test
    public void testParseComplex5() {
        System.out.println("Test parseComplex5");
        String c = "-0-j79.9999";
        Complex expResult = new Complex(0, -79.9999);
        Complex result = Complex.parseComplex(c);
        assertEquals(expResult, result);
    }

    /**
     * TCPC-6
     */
    @Test
    public void testParseComplex6() {
        System.out.println("Test parseComplex6");
        String c = "NaN+j59.9999";
        Complex expResult = new Complex(Double.NaN, 0);
        Complex result = Complex.parseComplex(c);
        assertEquals(expResult, result);
    }

    /**
     * TCPC-7
     */
    @Test
    public void testParseComplex7() {
        System.out.println("Test parseComplex7");
        String c = "19.9999-jINF";
        Complex expResult = new Complex(Double.NaN, 0);
        Complex result = Complex.parseComplex(c);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class Complex.
     */
    /**
     * TCEQ-1
     */
    @Test
    public void testEquals1() {
        System.out.println("Test equals1");
        Complex a = new Complex(15.2369, 0);
        Complex b = new Complex(15.2368, 0);
        boolean expResult = false;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }

    /**
     * TCEQ-2
     */
    @Test
    public void testEquals2() {
        System.out.println("Test equals2");
        Complex a = new Complex(46.3215, 0);
        Complex b = new Complex(0, 15.7543);
        boolean expResult = false;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }

    /**
     * TCEQ-3
     */
    @Test
    public void testEquals3() {
        System.out.println("Test equals3");
        Complex a = new Complex(0, 10.2547);
        Complex b = new Complex(0, 15.7543);
        boolean expResult = false;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }

    /**
     * TCEQ-4
     */
    @Test
    public void testEquals4() {
        System.out.println("Test equals4");
        Complex a = new Complex(17.9999, 487.2000);
        Complex b = new Complex(17.9999, 487.1999);
        boolean expResult = false;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }

    /**
     * TCEQ-5
     */
    @Test
    public void testEquals5() {
        System.out.println("Test equals5");
        Complex a = new Complex(58.4598, 0.7899);
        Complex b = new Complex(58.4598, -0.7899);
        boolean expResult = false;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }

    /**
     * TCEQ-6
     */
    @Test
    public void testEquals6() {
        System.out.println("Test equals6");
        Complex a = new Complex(Double.NaN, 25.1234);
        Complex b = new Complex(77.4569, 0);
        boolean expResult = false;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }
    
    /**
     * TCEQ-7
     */
    @Test
    public void testEquals7() {
        System.out.println("Test equals7");
        Complex a = new Complex(7, Double.NaN);
        Complex b = new Complex(Double.NaN, 12);
        boolean expResult = true;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }
    
    /**
     * TCEQ-8
     */
    @Test
    public void testEquals8() {
        System.out.println("Test equals8");
        Complex a = new Complex(Double.POSITIVE_INFINITY, 45);
        Complex b = new Complex(58.4598,-0.7899);
        boolean expResult = false;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }
    
    /**
     * TCEQ-9
     */
    @Test
    public void testEquals9() {
        System.out.println("Test equals9");
        Complex a = new Complex(124, Double.POSITIVE_INFINITY);
        Complex b = new Complex(Double.POSITIVE_INFINITY, -18);
        boolean expResult = true;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }

    /**
     * TCEQ-10
     */
    @Test
    public void testEquals10() {
        System.out.println("Test equals10");
        Complex a = new Complex();
        Complex b = new Complex();
        boolean expResult = true;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }

    /**
     * TCEQ-11
     */
    @Test
    public void testEquals11() {
        System.out.println("Test equals11");
        Complex a = new Complex(9.4, 5);
        Complex b = new Complex(9.4, 5);
        boolean expResult = true;
        boolean result = a.equals(b);
        assertEquals(expResult, result);
    }

}
