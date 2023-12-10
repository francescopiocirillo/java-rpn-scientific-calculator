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

import Eccezioni.StackPienoException;
import Eccezioni.StackVuotoException;
import Eccezioni.TopElementInvalidException;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gruppo14
 */
public class StackCalculatorTest {
    
    private StackCalculator instance;

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
        instance = new StackCalculator();
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    /**
     * Test of loadVariable method, of class CalculatorStack.
     */
    /**
     * TLV-1
     * @throws StackVuotoException 
     */
    @Test
    public void testLoadVariable1() throws StackVuotoException{
        System.out.println("loadVariable1");
        assertThrows(StackVuotoException.class, () ->{
            instance.loadVariable(0);
        });
    }
    
    /**
     * TCLV-2
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     * @throws TopElementInvalidException mai secondo il normale funzionamento
     */
    @Test
    public void testLoadVariable2() throws StackPienoException, StackVuotoException, TopElementInvalidException{
        System.out.println("loadVariable2");
        String num="9+j5";
        instance.push(num);
        instance.loadVariable(0);
        assertEquals("9.0000+j5.0000", instance.getVariable(0));
    }
    
    /**
     * TCLV-3
     * @throws StackPienoException
     * @throws StackVuotoException 
     */
    @Test
    public void testLoadVariable3() throws StackPienoException, StackVuotoException{
        System.out.println("loadVariable3");
        String op = "+";
        instance.push(op);
        assertThrows(TopElementInvalidException.class, ()->{
            instance.loadVariable(0);
        });
    }

    /**
     * Test of storeVariable method, of class StackCalculator.
     */
    /**
     * TCSTV-1
     * @throws StackPienoException mai secondo il funzionamento normale.
     * @throws StackVuotoException mai secondo il funzionamento normale.
     */
    @Test
    public void testStoreVariable1() throws StackPienoException, StackVuotoException {
        System.out.println("storeVariable1");
        int variabile = 0;
        instance.storeVariable(variabile);
        assertEquals("0", instance.peek());
    }

    /**
     * TCSTV-2
     * @throws StackPienoException mai secondo il funzionamento normale.
     * @throws StackVuotoException mai secondo il funzionamento normale.
     */
    @Test
    public void testStoreVariable2() throws StackPienoException, StackVuotoException {
        System.out.println("storeVariable2");
        int variabile = 0;
        /** creo stack mediamente pieno */
        for(int i = 1; i <= 32/2 ; i++)
            instance.push(i +  "+j" + i);
        
        instance.storeVariable(variabile);
        assertEquals("0", instance.peek());
    }

    /**
     * TCSTV-3
     * @throws StackPienoException mai secondo il funzionamento normale.
     * @throws StackVuotoException mai secondo il funzionamento normale.
     */
    @Test
    public void testStoreVariable3() throws StackPienoException, StackVuotoException {
        System.out.println("storeVariable3");
        int variabile = 0;
        /** creo stack pieno */
        for(int i = 1; i <= 32; i++)
           instance.push(i +  "+j" + i);
        
        assertThrows(StackPienoException.class, () -> {
            instance.storeVariable(variabile);
        });

    }
    
    /**
     * Test of addVariable method, of class StackCalculator.
     */
    /**
     * TCADV-1
     * 
     * @throws StackVuotoException se il test va a buon fine
     * @throws TopElementInvalidException mai secondo il normale funzionamento
     */
    @Test
    public void testAddVariable1() throws StackVuotoException, TopElementInvalidException {
        System.out.println("addVariable1");
        int variabile = 0;
        assertThrows(StackVuotoException.class, () -> {
            instance.addVariable(variabile);
        });
    }

    /**
     * TCADV-2
     * 
     * @throws StackVuotoException se il test va a buon fine
     * @throws TopElementInvalidException mai secondo il normale funzionamento
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testAddVariable2() throws StackVuotoException, TopElementInvalidException, StackPienoException {
        System.out.println("addVariable2");
        int variabile = 0;
        instance.push("3");
        instance.addVariable(variabile);
        assertEquals("3.0000", instance.getVariable(0));
    }

    /**
     * TCADV-3
     * 
     * @throws StackVuotoException se il test va a buon fine
     * @throws TopElementInvalidException mai secondo il normale funzionamento
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testAddVariable3() throws StackVuotoException, TopElementInvalidException, StackPienoException {
        System.out.println("addVariable3");
        int variabile = 0;
        instance.push("√");
        assertThrows(TopElementInvalidException.class, () -> {
            instance.addVariable(variabile);
        });
    }

    /**
     * Test of subtractVariable method, of class StackCalculator.
     */
    /**
     * TCSUV-1
     * 
     * @throws StackVuotoException se il test va a buon fine
     * @throws TopElementInvalidException mai secondo il normale funzionamento
     */
    @Test
    public void testSubtractVariable1() throws StackVuotoException, TopElementInvalidException {
        System.out.println("subtractVariable1");
        int variabile = 0;
        assertThrows(StackVuotoException.class, () -> {
            instance.subtractVariable(variabile);
        });
    }

    /**
     * TCSUV-2
     * 
     * @throws StackVuotoException se il test va a buon fine
     * @throws TopElementInvalidException mai secondo il normale funzionamento
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testSubtractVariable2() throws StackVuotoException, TopElementInvalidException, StackPienoException {
        System.out.println("subtractVariable2");
        int variabile = 0;
        instance.push("63.4+j7.2154");
        instance.subtractVariable(variabile);
        assertEquals("-63.4000-j7.2154", instance.getVariable(0));
    }

    /**
     * TCSUV-3
     * 
     * @throws StackVuotoException se il test va a buon fine
     * @throws TopElementInvalidException mai secondo il normale funzionamento
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testSubtractVariable3() throws StackVuotoException, TopElementInvalidException, StackPienoException {
        System.out.println("subtractVariable3");
        int variabile = 0;
        instance.push("±");
        assertThrows(TopElementInvalidException.class, () -> {
            instance.subtractVariable(variabile);
        });
    }
    
}
