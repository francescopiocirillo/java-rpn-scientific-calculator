package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;
import Eccezioni.InvalidOrderException;
import Eccezioni.StackPienoException;
import Eccezioni.StackVuotoException;
import Eccezioni.TopElementInvalidException;

public class StackCalculator {
    
    private CalculatorStack calculatorStack;
    private CalculatorVariables calculatorVariables;

    public StackCalculator() {
        this.calculatorStack = new CalculatorStack();
        this.calculatorVariables = new CalculatorVariables();
    }

//  metodo per passare lo stack alla view       
    public Stack<String> getStack() {
        return calculatorStack.getStack();
    }
//  end_metodo per passare lo stack alla view

//  metodo per il calcolo del risultato sullo stack
    public void calcola() throws InvalidOrderException {
        calculatorStack.calcola();
    }
//  end_metodo per il calcolo del risultato sullo stack

//  metodi per le stack operations
    public void push( String c ) throws StackPienoException {
        calculatorStack.push(c);
    }

    public String pop() throws StackVuotoException {
        return calculatorStack.pop();
    }
    
    public String peek() throws StackVuotoException {
        return calculatorStack.peek();
    }

    public boolean empty() {
        return calculatorStack.empty();
    }

    public int size() {
        return calculatorStack.size();
    }

    public void clear() {
        calculatorStack.clear();
    }

    public void drop() {
        calculatorStack.drop();
    }

    public void dup() {
        calculatorStack.dup();
    }

    public void swap() {
        calculatorStack.swap();
    }

    public void over() {
        calculatorStack.over();
    }
//  end_metodi per le stack operations


//  metodi ponte tra variabili e stack
    public String getVariable( int variable ) {
        return calculatorVariables.getVariable(variable);
    }

    public void loadVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( calculatorStack.empty() )
            throw new StackVuotoException();
        if( calculatorStack.isOperator( calculatorStack.peek() ) )
            throw new TopElementInvalidException();
        calculatorVariables.setVariable(variabile, calculatorStack.pop());
    }

    public void storeVariable( int variabile ) throws StackPienoException {
        if( calculatorStack.size() >= calculatorStack.capacity )
            throw new StackPienoException();
        calculatorStack.push( calculatorVariables.getVariable( variabile ) );
    }

    public void addVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( calculatorStack.empty() )
            throw new StackVuotoException();
        if( calculatorStack.isOperator(calculatorStack.peek()) )
            throw new TopElementInvalidException();
        calculatorVariables.addVariable(variabile, calculatorStack.pop());
    }

    public void subtractVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( calculatorStack.empty() )
            throw new StackVuotoException();
        if( calculatorStack.isOperator(calculatorStack.peek()) )
            throw new TopElementInvalidException();
        calculatorVariables.subtractVariable(variabile, calculatorStack.pop());
    }
//  end_metodi per le variabili
}
