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
public class CalculatorVariablesTest {
    
    private CalculatorVariables instance;

    public CalculatorVariablesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance = new CalculatorVariables();
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setVariable method, of class CalculatorVariables.
     */
    /**
     * TCL-1
     */
    @Test
    public void testSetVariable1() {
        System.out.println("setVariable1");
        int variabile = 0;
        String topElement = "j55";
        instance.setVariable(variabile, topElement);
        assertEquals(new Complex(0, 55).toString(), instance.getVariable(0));
    }
    
    /**
     * TCL-2
     */
    @Test
    public void testSetVariable2() {
        System.out.println("setVariable2");
        int variabile = 0;
        String varVal = "22.4+j6";        
        String topElement = "9+j5";
        instance.setVariable(variabile, varVal);
        instance.setVariable(variabile, topElement);
        assertEquals(new Complex(9, 5).toString(), instance.getVariable(0));
    }
    
    /**
     * Test of getVariable method, of class CalculatorVariables.
     */
    /**
     * TCGV-1
     */
    @Test
    public void testGetVariable1() {
        System.out.println("getVariable1");
        int variabile = 0;
        String topElement = "0.25";
        instance.setVariable(variabile, topElement);
        assertEquals(new Complex(0.25, 0).toString(), instance.getVariable(0));
    }
    
    /**
     * TCGV-2
     */
    @Test
    public void testGetVariable2() {
        System.out.println("getVariable2");
        int variabile = 0;
        String topElement = "9.3-j2.0001";
        instance.setVariable(variabile, topElement);
        assertEquals(new Complex(9.3, -2.0001).toString(), instance.getVariable(0));
    }
    
    /**
     * Test of addVariable method, of class CalculatorVariables.
     */
    /**
     * TCAV-1
     */
    @Test
    public void testAddVariable1() {
        System.out.println("addVariable1");
        int variabile = 0;
        String varVal = "0";
        String topElement = "j3.5";
        instance.setVariable(variabile, varVal);
        instance.addVariable(variabile, topElement);
        assertEquals(new Complex(0, 3.5).toString(), instance.getVariable(0));
    }
    
    /**
     * TCAV-2
     */
    @Test
    public void testAddVariable2() {
        System.out.println("addVariable2");
        int variabile = 0;
        String varVal = "39.3+j20";
        String topElement = "99.4562";
        instance.setVariable(variabile, varVal);
        instance.addVariable(variabile, topElement);
        assertEquals(new Complex(138.7562, 20).toString(), instance.getVariable(0));
    }
    
    /**
     * Test of subtractVariable method, of class CalculatorVariables.
     */
    /**
     * TCSV-1
     */
    @Test
    public void testSubtractVariable1() {
        System.out.println("subtractVariable1");
        int variabile = 0;
        String varVal = "0";        
        String topElement = "63.4+j7.2154";
        instance.setVariable(variabile, varVal);
        instance.subtractVariable(variabile, topElement);
        assertEquals(new Complex(-63.4, -7.2154).toString(), instance.getVariable(0));
    }
    
    /**
     * TCSV-2
     */
    @Test
    public void testSubtractVariable2() {
        System.out.println("subtractVariable2");
        int variabile = 0;
        String varVal = "2+j6.99";        
        String topElement = "5";
        instance.setVariable(variabile, varVal);
        instance.subtractVariable(variabile, topElement);
        assertEquals(new Complex(-3, 6.99).toString(), instance.getVariable(0));
    }
}
