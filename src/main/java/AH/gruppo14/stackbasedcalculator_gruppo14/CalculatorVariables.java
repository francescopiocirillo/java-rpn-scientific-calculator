package AH.gruppo14.stackbasedcalculator_gruppo14;

public class CalculatorVariables {
    
    private Complex[] variabili;

    public CalculatorVariables() {
        variabili = new Complex[26];
        for( int i = 0; i < 26; i++ ) {
            variabili[i] = new Complex();
        }
    }

    public void setVariable( int variabile, String topElement ) {
        variabili[variabile] = Complex.parseComplex(topElement);
    }
    
    public String getVariable( int variabile ) {
        return variabili[variabile].toString();
    }

    public void addVariable( int variabile, String topElement ) {
        Complex c = Complex.parseComplex( topElement );
        variabili[variabile] = Complex.somma(variabili[variabile], c);
    }

    public void subtractVariable( int variabile, String topElement ) {
        Complex c = Complex.parseComplex( topElement );
        variabili[variabile] = Complex.sottrazione(variabili[variabile], c);
    }
}
