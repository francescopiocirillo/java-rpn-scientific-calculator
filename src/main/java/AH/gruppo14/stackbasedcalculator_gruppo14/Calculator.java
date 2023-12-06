/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;

import Eccezioni.StackPienoException;
import Eccezioni.StackVuotoException;

/**
 *
 * @author Gruppo14
 */

public class Calculator {

    private Complex[] variabili;
    private Stack<String> stack;
    private final int capacity;

    public Calculator() {
        variabili = new Complex[26];
        stack = new Stack<>();
        capacity = 64;
    } 

//  metodi per le stack operations
    public void push( String c ) throws StackPienoException {
        if( stack.size() >= capacity )
            throw new StackPienoException();
        stack.push(c);
    }

    public String pop() throws StackVuotoException {
        if( stack.empty() )
            throw new StackVuotoException();
        return stack.pop();
    }

    public void clear() {
        if( !stack.empty() )
            stack = new Stack<>();
    }

    public void drop() {
        if( !stack.empty() )
            stack.pop();
    }

    public void dup() {
        if( !stack.empty() && stack.size() < capacity) {
            String c = stack.peek();
            stack.push(c);
        }
    }

    public void swap() {
        if( stack.size() >= 2 ) {
            String a = stack.pop();
            String b = stack.pop();
            stack.push(a);
            stack.push(b);
        }
    }

    //errato
    public void over() {
        if( stack.size() >= 2 ) {
            String a = stack.pop();
            String b = stack.pop();
            stack.push(a);
            stack.push(b);
        }
    }
//  end_metodi per le stack operations

//  supporto  
    private boolean isOperator( String s ) {
        if( s.length() > 1 )
            return false;
        if( Character.isDigit( s.charAt(0) ) )
            return false;
        return true;
    }

    private boolean isUnaryOperator( String s ) {
        if( s.equals("r") || s.equals("s"))
            return true;
        return false;
    }
//  end_supporto
}
