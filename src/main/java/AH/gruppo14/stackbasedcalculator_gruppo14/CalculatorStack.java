package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;

import Eccezioni.InvalidOrderException;
import Eccezioni.StackPienoException;
import Eccezioni.StackVuotoException;

public class CalculatorStack {
    
    private Stack<String> stack;
    public final int capacity;

    public CalculatorStack() {
        stack = new Stack<>();
        capacity = 12;
    }

//  metodo per passare lo stack alla view
    public Stack<String> getStack() {
        return stack;
    }
//  end_metodo per passare lo stack alla view

//  supporto  
    public boolean isOperator( String s ) {
        if( s.length() > 1 )
            return false;
        if( Character.isDigit( s.charAt(0) ) )
            return false;
        return true;
    }

    public boolean isUnaryOperator( String s ) {
        if( s.equals("√") || s.equals("±"))
            return true;
        return false;
    }
//  end_supporto

//  metodo per il calcolo del risultato sullo stack
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
                        if( element.equals("√") ) {
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
                                res = Complex.sottrazione(c2, c1);
                                stack.push(res.toString());
                                break;
                            case "×":
                                res = Complex.prodotto(c1, c2);
                                stack.push(res.toString());
                                break;
                            case "÷":
                                res = Complex.divisione(c2, c1);
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
//  end_metodo per il calcolo del risultato sullo stack

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
    
    public String peek() throws StackVuotoException {
        if( stack.empty() )
            throw new StackVuotoException();
        return stack.peek();
    }

    public boolean empty() {
        return stack.empty();
    }

    public int size() {
        return stack.size();
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

    public void over() {
        if( stack.size() >= 2 && stack.size() < capacity ) {
            String a = stack.pop();
            String b = stack.peek();
            stack.push(a);
            stack.push(b);
        }
    }
//  end_metodi per le stack operations

}
