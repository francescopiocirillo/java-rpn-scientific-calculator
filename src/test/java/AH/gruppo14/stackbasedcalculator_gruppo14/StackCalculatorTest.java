/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;
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
public class StackCalculatorTest {
    
    public StackCalculatorTest() {
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
     * Test of getStack method, of class StackCalculator.
     */
    @Test
    public void testGetStack() {
        System.out.println("getStack");
        StackCalculator instance = new StackCalculator();
        Stack<String> expResult = null;
        Stack<String> result = instance.getStack();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcola method, of class StackCalculator.
     */
    @Test
    public void testCalcola() throws Exception {
        System.out.println("calcola");
        StackCalculator instance = new StackCalculator();
        instance.calcola();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of push method, of class StackCalculator.
     */
    @Test
    public void testPush() throws Exception {
        System.out.println("push");
        String c = "";
        StackCalculator instance = new StackCalculator();
        instance.push(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class StackCalculator.
     */
    @Test
    public void testPop() throws Exception {
        System.out.println("pop");
        StackCalculator instance = new StackCalculator();
        String expResult = "";
        String result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of peek method, of class StackCalculator.
     */
    @Test
    public void testPeek() throws Exception {
        System.out.println("peek");
        StackCalculator instance = new StackCalculator();
        String expResult = "";
        String result = instance.peek();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of empty method, of class StackCalculator.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        StackCalculator instance = new StackCalculator();
        boolean expResult = false;
        boolean result = instance.empty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class StackCalculator.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        StackCalculator instance = new StackCalculator();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class StackCalculator.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        StackCalculator instance = new StackCalculator();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drop method, of class StackCalculator.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        StackCalculator instance = new StackCalculator();
        instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dup method, of class StackCalculator.
     */
    @Test
    public void testDup() {
        System.out.println("dup");
        StackCalculator instance = new StackCalculator();
        instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swap method, of class StackCalculator.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        StackCalculator instance = new StackCalculator();
        instance.swap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of over method, of class StackCalculator.
     */
    @Test
    public void testOver() {
        System.out.println("over");
        StackCalculator instance = new StackCalculator();
        instance.over();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVariable method, of class StackCalculator.
     */
    @Test
    public void testGetVariable() {
        System.out.println("getVariable");
        int variable = 0;
        StackCalculator instance = new StackCalculator();
        String expResult = "";
        String result = instance.getVariable(variable);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadVariable method, of class StackCalculator.
     */
    @Test
    public void testLoadVariable() throws Exception {
        System.out.println("loadVariable");
        int variabile = 0;
        StackCalculator instance = new StackCalculator();
        instance.loadVariable(variabile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeVariable method, of class StackCalculator.
     */
    @Test
    public void testStoreVariable() throws Exception {
        System.out.println("storeVariable");
        int variabile = 0;
        StackCalculator instance = new StackCalculator();
        instance.storeVariable(variabile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVariable method, of class StackCalculator.
     */
    @Test
    public void testAddVariable() throws Exception {
        System.out.println("addVariable");
        int variabile = 0;
        StackCalculator instance = new StackCalculator();
        instance.addVariable(variabile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtractVariable method, of class StackCalculator.
     */
    @Test
    public void testSubtractVariable() throws Exception {
        System.out.println("subtractVariable");
        int variabile = 0;
        StackCalculator instance = new StackCalculator();
        instance.subtractVariable(variabile);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
