package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;
import Eccezioni.InvalidOrderException;
import Eccezioni.StackPienoException;
import Eccezioni.StackVuotoException;
import Eccezioni.TopElementInvalidException;

/**
 * Questa classe è il Model del progetto.
 * @author Gruppo14
 */
public class StackCalculator {
    
    private CalculatorStack calculatorStack;
    private CalculatorVariables calculatorVariables;

    /**
     * Crea i componenti del Model
     */
    public StackCalculator() {
        this.calculatorStack = new CalculatorStack();
        this.calculatorVariables = new CalculatorVariables();
    }

    /**
     * Metodo per passare lo stack alla view
     * @return la reference allo stack presa da calculatorStack
     */
    public Stack<String> getStack() {
        return calculatorStack.getStack();
    }

    /**
     * Metodo per il calcolo del risultato sullo stack
     * @throws InvalidOrderException se lanciato da calcola() di calculatorStack
     */
    public void calcola() throws InvalidOrderException {
        calculatorStack.calcola();
    }

    /**
     * Metodo per eseguire la push
     * @param c la stringa da aggiungere allo stack
     * @throws StackPienoException se lanciato da push() di calculatorStack
     */
    public void push( String c ) throws StackPienoException {
        calculatorStack.push(c);
    }

    /**
     * Metodo per eseguire la pop
     * @return l'oggetto prelevato dallo stack dalla pop() su calculatorStack
     * @throws StackVuotoException se lanciato da pop() di calculatorStack
     */
    public String pop() throws StackVuotoException {
        return calculatorStack.pop();
    }
    
    /**
     * Metodo per eseguire la peek
     * @return l'oggetto letto dallo stack dalla peek() su calculatorStack
     * @throws StackVuotoException se lanciato da peek() di calculatorStack
     */
    public String peek() throws StackVuotoException {
        return calculatorStack.peek();
    }

    /**
     * Metodo per verificare se lo stack è vuoto
     * @return il risultato del metodo empty() di calculatorStack
     */
    public boolean empty() {
        return calculatorStack.empty();
    }

    /**
     * Metodo per leggere quanti elementi ci sono nello stack
     * @return il valore restituito da size() di calculatorStack
     */
    public int size() {
        return calculatorStack.size();
    }

    /**
     * Metodo per svuotare lo stack
     */
    public void clear() {
        calculatorStack.clear();
    }

    /**
     * Metodo per eliminare il top element dello stack
     */
    public void drop() {
        calculatorStack.drop();
    }

    /**
     * Metodo per duplicare il top element dello stack
     */
    public void dup() {
        calculatorStack.dup();
    }

    /**
     * Metodo per scambiare i due elementi più in alto dello stack
     */
    public void swap() {
        calculatorStack.swap();
    }

    /**
     * Metodo per copiare in cima allo stack il penultimo elemento presente
     */
    public void over() {
        calculatorStack.over();
    }

    /**
     * Metodo per prelevare il valore di una variabile
     * @param variabile è l'indice che identifica la variabile nell'array,
     * ad ogni numero corrisponde una lettera (0 a, 25 z)
     * @return il valore della variabile desiderata restituito da getVariable
     * di calculatorVariables
     */
    public String getVariable( int variabile ) {
        return calculatorVariables.getVariable(variabile);
    }

    /**
     *
     * @param variabile è l'indice che identifica la variabile nella quale
     * caricare il valore del top element
     * @throws StackVuotoException se lo stack è vuoto secondo empty() di
     * calculatorStack
     * @throws TopElementInvalidException se il top element è un operatore
     * secondo il metodo isOperator calculatorStack
     */
    public void loadVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( calculatorStack.empty() )
            throw new StackVuotoException();
        if( calculatorStack.isOperator( calculatorStack.peek() ) )
            throw new TopElementInvalidException();
        calculatorVariables.setVariable(variabile, calculatorStack.pop());
    }

    /**
     *
     * @param variabile è l'indice che identifica la variabile il cui valore è
     * da caricare nello stack
     * @throws StackPienoException se lo stack è pieno secondo il confronto
     * tra size() di calculatorStack e CAPACITY
     */
    public void storeVariable( int variabile ) throws StackPienoException {
        if( calculatorStack.size() >= calculatorStack.CAPACITY )
            throw new StackPienoException();
        calculatorStack.push( calculatorVariables.getVariable( variabile ) );
    }

    /**
     *
     * @param variabile è l'indice che identifica la variabile al cui valore è
     * da aggiungere quello del top element dello stack
     * @throws StackVuotoException se lo stack è vuoto secondo empty() di
     * calculatorStack
     * @throws TopElementInvalidException se il top element è un operatore
     * secondo il metodo isOperator calculatorStack
     */
    public void addVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( calculatorStack.empty() )
            throw new StackVuotoException();
        if( calculatorStack.isOperator(calculatorStack.peek()) )
            throw new TopElementInvalidException();
        calculatorVariables.addVariable(variabile, calculatorStack.pop());
    }

    /**
     *
     * @param variabile è l'indice che identifica la variabile al cui valore è
     * da sottrarre quello del top element dello stack
     * @throws StackVuotoException se lo stack è vuoto secondo empty() di
     * calculatorStack
     * @throws TopElementInvalidException se il top element è un operatore
     * secondo il metodo isOperator calculatorStack
     */
    public void subtractVariable( int variabile ) throws StackVuotoException, TopElementInvalidException {
        if( calculatorStack.empty() )
            throw new StackVuotoException();
        if( calculatorStack.isOperator(calculatorStack.peek()) )
            throw new TopElementInvalidException();
        calculatorVariables.subtractVariable(variabile, calculatorStack.pop());
    }
}
