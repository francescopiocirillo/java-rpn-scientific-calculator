/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import Eccezioni.InvalidOrderException;
import Eccezioni.StackPienoException;
import Eccezioni.StackVuotoException;
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
public class CalculatorStackTest {

    private CalculatorStack instance;

    public CalculatorStackTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        instance = new CalculatorStack();
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isOperator method, of class CalculatorStack.
     */
    /**
     * TCIO-1
     */
    @Test
    public void testIsOperator1() {
        System.out.println("isOperator1");
        String s = "±";
        boolean result = instance.isOperator(s);
        assertTrue(result);
    }

    /**
     * TCIO-2
     */
    @Test
    public void testIsOperator2() {
        System.out.println("isOperator2");
        String s = "+";
        boolean result = instance.isOperator(s);
        assertTrue(result);
    }

    /**
     * TCIO-3
     */
    @Test
    public void testIsOperator3() {
        System.out.println("isOperator3");
        String s = "5";
        boolean result = instance.isOperator(s);
        assertFalse(result);
    }

    /**
     * Test of isUnaryOperator method, of class CalculatorStack.
     */
    /**
     * TCIUO-1
     */
    @Test
    public void testIsUnaryOperator1() {
        System.out.println("isUnaryOperator1");
        String s = "√";
        boolean result = instance.isUnaryOperator(s);
        assertTrue(result);
    }

    /**
     * TCIUO-2
     */
    @Test
    public void testIsUnaryOperator2() {
        System.out.println("isUnaryOperator2");
        String s = ":";
        boolean result = instance.isUnaryOperator(s);
        assertFalse(result);
    }

    /**
     * TCIUO-3
     */
    @Test
    public void testIsUnaryOperator3() {
        System.out.println("isUnaryOperator3");
        String s = "7.0000+j6,6600";
        boolean result = instance.isUnaryOperator(s);
        assertFalse(result);
    }

    /**
     * Test of calcola method, of class CalculatorStack.
     */
    /**
     * TCCAL-1
     * 
     * @throws StackPienoException
     * @throws InvalidOrderException
     * @throws StackVuotoException
     */
    @Test
    public void testCalcola1() throws StackPienoException, InvalidOrderException, StackVuotoException {
        System.out.println("calcola1");
        instance.push("2");
        instance.push("2");
        instance.push("+");
        instance.calcola();
        assertEquals("4.0000", instance.pop());
    }

    /**
     * TCCAL-2
     * 
     * @throws StackPienoException
     * @throws InvalidOrderException
     * @throws StackVuotoException
     */
    @Test
    public void testCalcola2() throws StackPienoException, InvalidOrderException, StackVuotoException {
        System.out.println("calcola2");
        instance.push("2");
        instance.push("+");
        assertThrows(InvalidOrderException.class, () -> {
            instance.calcola();
        });
    }

    /**
     * TCCAL-3
     * 
     * @throws StackPienoException
     * @throws InvalidOrderException
     * @throws StackVuotoException
     */
    @Test
    public void testCalcola3() throws StackPienoException, InvalidOrderException, StackVuotoException {
        System.out.println("calcola3");
        instance.push("2");
        instance.push("±");
        instance.calcola();
        assertEquals("-2.0000-j0.0000", instance.pop());
    }

    /**
     * TCCAL-4
     * 
     * @throws StackPienoException
     * @throws InvalidOrderException
     * @throws StackVuotoException
     */
    @Test
    public void testCalcola4() throws StackPienoException, InvalidOrderException, StackVuotoException {
        System.out.println("calcola4");
        instance.push("±");
        assertThrows(InvalidOrderException.class, () -> {
            instance.calcola();
        });
    }

    /**
     * TCCAL-5
     * 
     * @throws StackPienoException
     * @throws InvalidOrderException
     * @throws StackVuotoException
     */
    @Test
    public void testCalcola5() throws StackPienoException, InvalidOrderException, StackVuotoException {
        System.out.println("calcola5");
        instance.push("2");
        instance.push("2");
        instance.push("+");
        instance.push("3");
        instance.push("3");
        instance.push("+");
        instance.push("+");
        instance.calcola();
        assertEquals("10.0000", instance.pop());
    }

    /**
     * TCCAL-6
     * 
     * @throws StackPienoException
     * @throws InvalidOrderException
     * @throws StackVuotoException
     */
    @Test
    public void testCalcola6() throws StackPienoException, InvalidOrderException, StackVuotoException {
        System.out.println("calcola6");
        instance.push("2");
        instance.push("2");
        instance.push("+");
        instance.push("3");
        instance.push("3");
        instance.push("+");
        instance.push("√");
        instance.calcola();
        assertTrue(instance.pop().equals("2.4495") && instance.pop().equals("4.0000"));
    }

    /**
     * Test of push method, of class CalculatorStack.
     */
    /**
     * TCPU-1
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testPush1() throws StackPienoException, StackVuotoException {
        System.out.println("push1");
        String c = "x";
        for (int i = 0; i < 8; i++)
            instance.push(c);
        instance.push("j17.0483");
        assertEquals("j17.0483", instance.pop());
    }

    /**
     * TCPU-2
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testPush2() throws StackPienoException, StackVuotoException {
        System.out.println("push2");
        String c = "x";
        instance.push(c);
        assertEquals(c, instance.pop());
    }

    /**
     * TCPU-3
     * 
     * @throws StackPienoException se il test va a buon fine
     */
    @Test
    public void testPush3() throws StackPienoException {
        System.out.println("push3");
        String c = "x";
        for (int i = 0; i < 32; i++)
            instance.push(c);
        assertThrows(StackPienoException.class, () -> {
            instance.push(c);
        });
    }

    /**
     * Test of pop method, of class CalculatorStack.
     */
    /**
     * TCPOP-1
     * 
     * @throws StackVuotoException mai secondo il normale funzionamento
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testPop1() throws StackVuotoException, StackPienoException {
        System.out.println("pop1");
        for (int i = 0; i < 8; i++)
            instance.push("x");
        instance.push("20");
        assertEquals("20", instance.pop());
    }

    /**
     * TCPOP-2
     * 
     * @throws StackVuotoException se il test va a buon fine
     */
    @Test
    public void testPop2() throws StackVuotoException {
        System.out.println("pop2");
        assertThrows(StackVuotoException.class, () -> {
            instance.pop();
        });
    }

    /**
     * TCPOP-3
     * 
     * @throws StackVuotoException mai secondo il normale funzionamento
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testPop3() throws StackVuotoException, StackPienoException {
        System.out.println("pop3");
        for (int i = 0; i < 31; i++)
            instance.push("x");
        instance.push("20");
        assertEquals("20", instance.pop());
    }

    /**
     * Test of peek method, of class CalculatorStack.
     */
    /**
     * TCPK-1
     * 
     * @throws StackPienoException
     * @throws StackVuotoException
     */
    @Test
    public void testPeek1() throws StackPienoException, StackVuotoException {
        System.out.println("peek1");
        String c = "x";
        for (int i = 0; i < 5; i++)
            instance.push(c);
        instance.push("21");
        assertEquals("21", instance.peek());
    }

    /**
     * TCPK-2
     * 
     * @throws StackVuotoException
     */
    @Test
    public void testPeek2() throws StackVuotoException {
        System.out.println("peek2");
        assertThrows(StackVuotoException.class, () -> {
            instance.peek();
        });
    }

    /**
     * TCPK-3
     * 
     * @throws StackPienoException
     * @throws StackVuotoException
     */
    @Test
    public void testPeek3() throws StackPienoException, StackVuotoException {
        System.out.println("peek3");
        String c = "x";
        for (int i = 0; i < instance.CAPACITY - 1; i++)
            instance.push(c);
        instance.push("21");
        assertEquals("21", instance.peek());
    }

    /**
     * Test of size method, of class CalculatorStack.
     */
    /**
     * TCSZ-1
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testSize1() throws StackPienoException{
        System.out.println("size1");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY-2; i++)
            instance.push(c);
        assertEquals(instance.size(), instance.CAPACITY-2);
    }
    
    /**
     * TCSZ-2
     */
    @Test
    public void testSize2(){
        System.out.println("size2");
        assertEquals(instance.size(), 0);
    }
       
    /**
     * TCSZ-3
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testSize3() throws StackPienoException{
        System.out.println("size3");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY; i++)
            instance.push(c);
        assertEquals(instance.size(), instance.CAPACITY);
    }

    /**
     * Test of empty method, of class CalculatorStack.
     */
    /**
     * TCE-1
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testEmpty1() throws StackPienoException{
        System.out.println("empty1");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY/3; i++)
            instance.push(c);
        assertFalse(instance.empty());
    }
    
    /**
     * TCE-2
     */
    @Test
    public void testEmpty2(){
       System.out.println("empty2"); 
       assertTrue(instance.empty());
    }
    
    /**
     * TCE-3
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testEmpty3() throws StackPienoException{
        System.out.println("empty3");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY; i++)
            instance.push(c);
        assertFalse(instance.empty());
    }

    /**
     * Test of clear method, of class CalculatorStack.
     */
    /**
     * TCCL-1
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testClear1() throws StackPienoException {
        System.out.println("clear1");
        String c = "x";
        for (int i = 0; i < 5; i++)
            instance.push(c);
        instance.clear();
        assertTrue(instance.empty());
    }

    /**
     * TCCL-2
     */
    @Test
    public void testClear2() {
        System.out.println("clear2");
        instance.clear();
        assertTrue(instance.empty());
    }

    /**
     * TCCL-3
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testClear3() throws StackPienoException {
        System.out.println("clear3");
        String c = "x";
        for (int i = 0; i < 32; i++)
            instance.push(c);
        instance.clear();
        assertTrue(instance.empty());
    }

    /**
     * Test of drop method, of class CalculatorStack.
     */
    /**
     * TCDR-1
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testDrop1() throws StackPienoException, StackVuotoException {
        System.out.println("drop1");
        String c = "x";
        for (int i = 0; i < 5; i++)
            instance.push(c);
        instance.push("20");
        instance.push("21");
        instance.drop();
        assertEquals("20", instance.pop());
    }

    /**
     * TCDR-2
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testDrop2() throws StackPienoException, StackVuotoException {
        System.out.println("drop2");
        instance.drop();
        assertTrue(instance.empty());
    }

    /**
     * TCDR-3
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testDrop3() throws StackPienoException, StackVuotoException {
        System.out.println("drop3");
        String c = "x";
        for (int i = 0; i < 30; i++)
            instance.push(c);
        instance.push("20");
        instance.push("21");
        instance.drop();
        assertTrue(instance.peek().equals("20") && instance.size() == 31);
    }

    /**
     * Test of dup method, of class CalculatorStack.
     */
    /**
     * TCDU-1
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test 
    public void testDup1() throws StackPienoException, StackVuotoException{
        System.out.println("dup1");
        String c = "x";
        for(int i = 0; i < 3; i++)
            instance.push(c);
        instance.push("21");
        instance.dup();
        String a = instance.pop();
        String b = instance.pop();
        assertEquals(a,b);        
    }
    
    /**
     * TCDU-2
     */
    @Test
    public void testDup2(){
        System.out.println("dup2");
        assertTrue(instance.empty());
    }

    /**
     * TCDU-3
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testDup3() throws StackPienoException{
        System.out.println("dup3");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY-1; i++)
            instance.push(c);
        instance.push("21");
        instance.dup();
        assertEquals(instance.CAPACITY, instance.size());
    }

    /**
     * Test of swap method, of class CalculatorStack.
     */
    /**
     * TCSW-1
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testSwap1() throws StackPienoException, StackVuotoException{
        System.out.println("swap1");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY/8; i++)
            instance.push(c);
        instance.push("21");
        instance.push("12");
        instance.swap();
        assertTrue( instance.pop().equals("21") && instance.pop().equals("12") );
    }

    /**
     * TCSW-2
     */
    @Test
    public void testSwap2(){
        System.out.println("swap2");
        instance.swap();
        assertTrue(instance.empty());
    }
    
    /**
     * TCSW-3
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testSwap3() throws StackPienoException, StackVuotoException{
        System.out.println("swap3");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY-2; i++)
            instance.push(c);
        instance.push("21");
        instance.push("12");
        instance.swap();
        assertTrue(instance.pop().equals("21") && instance.pop().equals("12"));
    }

    /**
     * TCSW-4
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testSwap4() throws StackPienoException, StackVuotoException{
        System.out.println("swap4");
        instance.push("20.4000+j22.0000");
        instance.swap();
        assertTrue(instance.size() == 1 && instance.peek().equals("20.4000+j22.0000"));
    }
    
    /**
     * TCSW-5
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testSwap5() throws StackPienoException, StackVuotoException{
        System.out.println("swap5");
        instance.push("+");
        instance.push(":");
        instance.swap();
        assertTrue(instance.pop().equals("+") && instance.pop().equals(":"));
    }

    /**
     * Test of over method, of class CalculatorStack.
     */
    /**
     * TCO-1
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testOver1() throws StackPienoException, StackVuotoException{
        System.out.println("over1");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY/8; i++)
            instance.push(c);
        instance.push("18");
        instance.push("39");
        int sizePreOver=instance.size();
        instance.over();
        assertTrue((sizePreOver + 1) == instance.size() && instance.peek().equals("18"));
    }
    
    /**
     * TCO-2
     */
    @Test
    public void testOver2(){
        System.out.println("over2");
        instance.over();
        assertTrue(instance.empty());
    }
    
    /**
     * TCO-3
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testOver3() throws StackPienoException, StackVuotoException{
        System.out.println("over3");
        String c = "x";
        for(int i = 0; i < instance.CAPACITY-2; i++)
            instance.push(c);
        instance.push("22");
        instance.push("48");
        assertTrue(instance.size() == instance.CAPACITY && instance.peek().equals("48"));
    }
    
    /**
     * TCO-4
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     */
    @Test
    public void testOver4() throws StackPienoException{
        System.out.println("over4");
        instance.push("22");
        instance.over();
        assertTrue(instance.size()==1);
    }
    
    /**
     * TCO-5
     * 
     * @throws StackPienoException mai secondo il normale funzionamento
     * @throws StackVuotoException mai secondo il normale funzionamento
     */
    @Test
    public void testOver5() throws StackPienoException, StackVuotoException{
        System.out.println("over5");
        instance.push("22");
        instance.push("44");
        instance.over();
        assertTrue(instance.size() == 3 && instance.peek().equals("22"));
    }

}
