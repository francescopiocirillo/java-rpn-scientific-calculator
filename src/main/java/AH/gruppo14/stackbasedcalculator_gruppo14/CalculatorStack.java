package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;

import Eccezioni.InvalidOrderException;
import Eccezioni.StackPienoException;
import Eccezioni.StackVuotoException;

/**
 * Questa classe è la parte di Model che si occupa dello stack.
 * @author Gruppo14
 */
public class CalculatorStack {
    
    private Stack<String> stack;
    public final int CAPACITY;

    /**
     *  Dichiara lo Stack e imposta la capacità a 32
     */
    public CalculatorStack() {
        stack = new Stack<>();
        CAPACITY = 32;
    }
    
    /**
     * Restituisce la reference allo stack
     * @return la reference allo stack
     */
    public Stack<String> getStack() {
        return stack;
    }
      
    /**
     * Riconosce se la stringa passata è un operatore
     * @param s la stringa che bisogna riconoscere come operatore o no
     * @return vero se s è un operatore, falso altrimenti
     */
    public boolean isOperator( String s ) {
        if( s.length() > 1 )
            return false;
        if( Character.isDigit( s.charAt(0) ) )
            return false;
        return true;
    }

    /**
     * Riconosce se la stringa passata è un operatore unario
     * @param s la stringa che bisogna riconoscere come operatore unario o no
     * @return vero se s è un operatore unario, falso altrimenti
     */
    public boolean isUnaryOperator( String s ) {
        if( s.equals("√") || s.equals("±"))
            return true;
        return false;
    }

    /**
     * Esegue tutti i calcoli presenti nello stack
     * @throws InvalidOrderException se l'ordine degli elementi nello stack
     * non è valido, ergo non è possibile eseguire tutti i calcoli all'interno
     * dello stack
     */
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
                        String resString;
                        switch (element) {
                            case "+":
                                res = Complex.somma(c1, c2);
                                resString = res.toString();
                                if( resString.equals("ERR") || resString.equals("INF") )
                                    throw new InvalidOrderException();
                                stack.push(resString);
                                break;
                            case "-":
                                res = Complex.sottrazione(c2, c1);
                                resString = res.toString();
                                if( resString.equals("ERR") || resString.equals("INF") )
                                    throw new InvalidOrderException();
                                stack.push(res.toString());
                                break;
                            case "×":
                                res = Complex.prodotto(c1, c2);
                                resString = res.toString();
                                if( resString.equals("ERR") || resString.equals("INF") )
                                    throw new InvalidOrderException();
                                stack.push(res.toString());
                                break;
                            case "÷":
                                res = Complex.divisione(c2, c1);
                                resString = res.toString();
                                if( resString.equals("ERR") || resString.equals("INF") )
                                    throw new InvalidOrderException();
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

    /**
     * Metodo per inserire una stringa nello stack
     * @param c la stringa da inserire nello stack
     * @throws StackPienoException se è pieno sulla base del confronto tra la
     * size dello stack e CAPACITY
     */
    public void push( String c ) throws StackPienoException {
        if( stack.size() >= CAPACITY )
            throw new StackPienoException();
        stack.push(c);
    }

    /**
     * Metodo per rimuovere una stringa dallo stack
     * @return la stringa rimossa dallo stack
     * @throws StackVuotoException se è vuoto sulla base del metodo empty dello
     * stack
     */
    public String pop() throws StackVuotoException {
        if( stack.empty() )
            throw new StackVuotoException();
        return stack.pop();
    }
    
    /**
     * Metodo per leggere una stringa dallo stack
     * @return la stringa letta dallo stack
     * @throws StackVuotoException se è vuoto sulla base del metodo empty dello
     * stack
     */
    public String peek() throws StackVuotoException {
        if( stack.empty() )
            throw new StackVuotoException();
        return stack.peek();
    }

    /**
     * Metodo per sapere se lo stack è vuoto
     * @return vero se lo stack è vuoto, falso altrimenti
     */
    public boolean empty() {
        return stack.empty();
    }

    /**
     * Metodo per conoscere la size dello stack
     * @return la size dello stack
     */
    public int size() {
        return stack.size();
    }

    /**
     * Metodo per svuotare lo stack
     */
    public void clear() {
        if( !stack.empty() )
            stack = new Stack<>();
    }

    /**
     * Metodo per cancellare un elemento dallo stack
     */
    public void drop() {
        if( !stack.empty() )
            stack.pop();
    }

    /**
     * Metodo per duplicare il top element dello stack
     */
    public void dup() {
        if( !stack.empty() && stack.size() < CAPACITY) {
            String c = stack.peek();
            stack.push(c);
        }
    }

    /**
     * Metodo per effettuare lo swap degli ultimi due elementi dello stack
     */
    public void swap() {
        if( stack.size() >= 2 ) {
            String a = stack.pop();
            String b = stack.pop();
            stack.push(a);
            stack.push(b);
        }
    }

    /**
     * Metodo per aggiungere come top element dello stack una copia del
     * penultimo elemento
     */
    public void over() {
        if( stack.size() >= 2 && stack.size() < CAPACITY ) {
            String a = stack.pop();
            String b = stack.peek();
            stack.push(a);
            stack.push(b);
        }
    }
}
