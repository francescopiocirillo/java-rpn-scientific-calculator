/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;

import Eccezioni.StackPienoException;
import Eccezioni.StackVuotoException;
import Eccezioni.InvalidOrderException;
import Eccezioni.TopElementInvalidException;

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

    public void calcola() throws InvalidOrderException {
        Stack<String> stackSupporto = new Stack<>();
        int size = stack.size();
        for( int i = 0; i < size; i++ ) {
            stackSupporto.push( stack.pop() );
        }

        while( !stackSupporto.empty() ) {
            String element = stackSupporto.pop();

            if( isOperator(element) ) {
                if( isUnaryOperator(element) ) {
                    if( stack.empty() ) {
                        throw new InvalidOrderException();
                    }
                    else {
                        String operando = stack.pop();
                        Complex c = Complex.parseComplex(operando);
                        if( element.equals("r") ) {
                            c = Complex.radice(c);
                        }
                        else {
                            c = Complex.invertiSegno(c);
                        }
                        stack.push( c.toString() );
                    }
                }
                else {
                    if( stack.size() < 2 ) {
                        throw new InvalidOrderException();
                    }
                    else {
                        String operando1 = stack.pop();
                        String operando2 = stack.pop();
                        Complex c1 = Complex.parseComplex(operando1);
                        Complex c2 = Complex.parseComplex(operando2);
                        Complex res;
                        switch (element) {
                            case "+":
                                res = Complex.somma(c1, c2);
                                stack.push(res.toString());
                                break;
                            case "-":
                                res = Complex.sottrazione(c1, c2);
                                stack.push(res.toString());
                                break;
                            case "*":
                                res = Complex.prodotto(c1, c2);
                                stack.push(res.toString());
                                break;
                            case "/":
                                res = Complex.divisione(c1, c2);
                                stack.push(res.toString());
                                break;
                            default:
                                throw new InvalidOrderException();
                        }
                    }
                }
            }
            else {
                stack.push(element);
            }
        }
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

    //  metodi per le variabili
    public void loadVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( stack.empty() )
            throw new StackVuotoException();
        if( isOperator(stack.peek()) )
            throw new TopElementInvalidException();
        variabili[variabile] = Complex.parseComplex(stack.pop());
    }

    public void storeVariable( int variabile ) throws StackPienoException {
        if( stack.size() >= capacity )
            throw new StackPienoException();
        stack.push(variabili[variabile].toString());
    }

    public void addVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( stack.empty() )
            throw new StackVuotoException();
        if( isOperator(stack.peek()) )
            throw new TopElementInvalidException();
        Complex c = Complex.parseComplex( stack.pop() );
        variabili[variabile] = Complex.somma(variabili[variabile], c);
    }

    public void subtractVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( stack.empty() )
            throw new StackVuotoException();
        if( isOperator(stack.peek()) )
            throw new TopElementInvalidException();
        Complex c = Complex.parseComplex( stack.pop() );
        variabili[variabile] = Complex.sottrazione(variabili[variabile], c);
    }
//  end_metodi per le variabili
}
