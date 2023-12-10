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
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of setVariable method, of class CalculatorVariables.
     */
    @Test
    public void testSetVariable() {
        System.out.println("setVariable");
        int variabile = 0;
        String topElement = "";
        CalculatorVariables instance = new CalculatorVariables();
        instance.setVariable(variabile, topElement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVariable method, of class CalculatorVariables.
     */
    @Test
    public void testGetVariable() {
        System.out.println("getVariable");
        int variabile = 0;
        CalculatorVariables instance = new CalculatorVariables();
        String expResult = "";
        String result = instance.getVariable(variabile);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVariable method, of class CalculatorVariables.
     */
    @Test
    public void testAddVariable() {
        System.out.println("addVariable");
        int variabile = 0;
        String topElement = "";
        CalculatorVariables instance = new CalculatorVariables();
        instance.addVariable(variabile, topElement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtractVariable method, of class CalculatorVariables.
     */
    @Test
    public void testSubtractVariable() {
        System.out.println("subtractVariable");
        int variabile = 0;
        String topElement = "";
        CalculatorVariables instance = new CalculatorVariables();
        instance.subtractVariable(variabile, topElement);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
