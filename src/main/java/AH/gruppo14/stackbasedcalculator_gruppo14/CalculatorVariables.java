package AH.gruppo14.stackbasedcalculator_gruppo14;

/**
 * Classe per le variabili della calcolatrice rappresentate dalle lettere dell'alfabeto
 * @author Gruppo14
 */
public class CalculatorVariables {
    
    /** le variabili sono rappresentate da un array di Complex*/
    private Complex[] variabili;

    /**
     * Il costruttore della classe istanzia ogni variabile come Complex inizializato a 0
     * l'indice 0 rappresenta la a, l'indice 25 rappresenta la z.
     */
    public CalculatorVariables() {
        variabili = new Complex[26];
        for( int i = 0; i < 26; i++ ) {
            variabili[i] = new Complex();
        }
    }

    /**
     * Imposta il valore dell'array ad uno specifico indice
     * @param variabile è l'indice dell'array a cui assegnare il valore
     * @param topElement è una stringa da parsare a Complex
     */
    public void setVariable( int variabile, String topElement ) {
        variabili[variabile] = Complex.parseComplex(topElement);
    }
    
    /**
     * Restituisce una String che rappresenta il valore dell'array ad uno specifico indice
     * @param variabile è l'indice della variabile nell'array di Button in variablesView
     * @return una String che rappresenta il Complex all'indice passato
     */
    public String getVariable( int variabile ) {
        return variabili[variabile].toString();
    }

    /**
     * Somma il valore associato ad una variabile con un altro complex ottenuto da parsing di una String
     * @param variabile è l'indice dell'array associato alla variabile
     * @param topElement è la String che rappresenta l'altro Complex
     */
    public void addVariable( int variabile, String topElement ) {
        Complex c = Complex.parseComplex( topElement );
        variabili[variabile] = Complex.somma(variabili[variabile], c);
    }

    /**
     * Sottrae il valore associato ad una variabile con un altro complex ottenuto da parsing di una String
     * @param variabile è l'indice dell'array associato alla variabile
     * @param topElement è la String che rappresenta l'altro Complex
     */
    public void subtractVariable( int variabile, String topElement ) {
        Complex c = Complex.parseComplex( topElement );
        variabili[variabile] = Complex.sottrazione(variabili[variabile], c);
    }
}
