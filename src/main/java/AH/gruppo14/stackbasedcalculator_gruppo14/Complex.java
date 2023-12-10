/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import static java.lang.Math.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Classe che rappresenta un numero complesso e le relative operazioni matematiche 
 * @author Gruppo14
 */
public class Complex {

    private double re;
    private double imm;
    
    /**
     * Costruttore della classe Complex, crea un numero complesso
     * @param re è la parte reale del numero complesso
     * @param imm è la parte immaginaria del numero complesso
     */
    public Complex(double re, double imm){
        this.re = re;
        this.imm = imm;
    }
    
    /**
     *  Overload costruttore per Complex, crea un numero complesso inizializzato a 0
     */
    public Complex(){
        this.re = 0;
        this.imm = 0;
    }
    
    
    /**
     * Metodo statico che restituisce la somma tra due numeri complessi passati come parametro
     * @param a è il primo addendo complesso
     * @param b è il secondo addendo complesso
     * @return la somma tra a e b
     */
    public static Complex somma(Complex a, Complex b){
        
        double re = a.re + b.re;
        double imm = a.imm + b.imm;
        
        return new Complex(re, imm);
    }
    
    /**
     * Metodo statico che restituisce la differenza tra due numeri complessi passati come parametro 
     * @param a è il minuendo
     * @param b è il sottraendo
     * @return la differenza tra a e b
     */
    public static Complex sottrazione(Complex a, Complex b){
        
        double re = a.re - b.re;
        double imm = a.imm - b.imm;
        
        return new Complex(re, imm);
    }
    
    /**
     * Metodo statico che restituisce il prodotto tra due numeri complessi passati come parametro 
     * @param a è il moltiplicando
     * @param b è il moltiplicatore
     * @return il prodotto tra a e b
     */
    public static Complex prodotto(Complex a, Complex b){        
        /**
         * Se z1 = a + jb e z2 = x + jy allora
         * z1 * z2 = (ax - by) + j(ay + bx)
         */
        double re = (a.re * b.re) - (a.imm * b.imm);  
        double imm = (a.re * b.imm) + (a.imm * b.re);
        
        return new Complex(re, imm);
    }
    
    /**
     * Metodo statico che restituisce il quoziente tra due numeri complessi passati come parametro 
     * @param a è il dividendo
     * @param b è il divisore
     * @return il quoziente tra a e b
     */
    public static Complex divisione(Complex a, Complex b){
        /** 
         * Se z1 = a + jb e z2 = x + jy allora
         * z1 / z2 = ( (ax + by) + j(bx - ay) ) / (x^2 + y^2) 
         */
        double den = pow(b.re, 2) + pow(b.imm, 2); // x^2 + y^2 
        double re = ( (a.re * b.re) + (a.imm * b.imm) ) / den;  
        double imm = ( (a.imm * b.re) - (a.re * b.imm) ) / den;
        
        return new Complex(re, imm);
    }
    
    /**
     * la radice quadrata di un numero complesso restituisce due valori
     * il cacolo della radice in questo metodo è effettuato con la formula di De Moivre:
     * se z = z.re + j*z.imm allora la radice quadrata di z è<br>
     * sqrt(z) = sqrt(r) * ( cos( (theta + 2*k*pi )/2 ) + j(sin( (theta + 2*k*pi)/2 ) )
     * con r = sqrt(z.re^2 + z.imm^2), theta = atan(z.imm / z.re ), k = [0, 1];
     * 
     * N.B: Da requisito questa operazione di estrazione di radice quadrata produce 
     * un unico risultato: quello a fase minore (considerando la fase nell’intervallo [0 a 2π]),
     * dunque non è necessario considerare il caso per k = 1.<br>
     * Inoltre, poiché il metodo Math.atan2() restituisce la fase nell'intervallo [-PI, PI], allora
     * per passare all'intervallo [0, 2PI] è necessario sommare 2PI alle fasi comprese in [-PI, 0).4
     * 
     * @param c è il radicando
     * @return la radice quadrata di c
     */
    public static Complex radice(Complex c) {
        /** r = sqrt(z.re^2 + z.o+imm^2) */
        double modulo = sqrt( pow(c.getRe(), 2) + pow(c.getImm(),2) ); 
        double theta = atan2( c.getImm(), c.getRe() ); // theta = atan(z.imm / z.re)
        
        /** per passare all'intervallo [0, 2PI] si deve sommare 2PI alle fasi comprese in [-PI, 0) */
        if( theta < 0 & theta >= -1*PI ) {
            theta += 2*PI;
        }
        
        /** per comodità salvo sqrt(r) in una variabile */
        double radicalModulo = sqrt(modulo); 

        /** considero solo il caso per k = 0 ovvero a fase minore, dunque la fase della radice sarà theta/2 */
        double re = radicalModulo * cos( theta / 2 );
        double imm = radicalModulo * sin( theta / 2 );
            
        return new Complex(re, imm);
    }
    
    /**
     * Metodo statico che restituisce una copia del numero complesso pasasto come parametro
     * con segno invertito sia per la parte reale che quella immaginaria
     * @param c è il numero complesso a cui invertire il segno
     * @return una copia di c con segni delle parti reale e complessa invertiti
     */
    public static Complex invertiSegno(Complex c) {
        return new Complex(-1 * c.getRe(), -1 * c.getImm());
    }

    /**
     * Metodo toString per la stampa di un numero complesso
     * La stampa è eseguita stampando la parte reale e quella immaginaria come due double distinti
     * N.B: Per evitare problemi di compatibilità con il metodo parseDouble() viene usato il punto "."
     *      come separatore decimale.
     * @return una String che rappresenta un Complex
     */
    @Override
    public String toString() {
        
        if(Double.isInfinite(this.re) || Double.isInfinite(this.imm)) {
            return "INF";//....
        }
        
        if(Double.isNaN(this.re) || Double.isNaN(this.imm)) {
            return "ERR";//....
        }
        
        if(this.equals(new Complex())){ 
            return "0";
        } 
        
        if(Double.compare(this.imm, 0.0) == 0) {
            return String.format(java.util.Locale.US,"%.4f", this.re);
        } 
        
        if(Double.compare(this.re, 0.0) == 0) {
            if(this.imm > 0.0)
                return String.format(java.util.Locale.US,"j%.4f", this.imm);
            else
                return String.format(java.util.Locale.US,"-j%.4f", abs(this.imm));
        }

        if(this.imm > 0.0)
            return String.format(java.util.Locale.US,"%.4f+j%.4f", this.re, this.imm);
        else 
            return String.format(java.util.Locale.US,"%.4f-j%.4f", this.re, abs(this.imm));
    }
 
    /**
     * Metodo parse per la classe Complex
     * Riconosce un Complex da String e lo restituisce
     * @param c è una String che rappresenta un Complex coerentemente col metodo toString()
     * @return un Complex riconosciuto dalla String c
     */
    public static Complex parseComplex(String c) {
        
        if(c == null) return null;
        
        if(c.contains("NaN") || c.contains("ERR") || c.contains("INF")) 
            return new Complex(Double.NaN, 0);//....
        
        if(c.equals("0")) 
            return new Complex();
        
        /** 
         * Chiarimento della regex per un double: 
         * [-+]?  => questa parte corrisponde a un segno opzionale (+ o -).
         * [j]?   => Questa parte indica un carattere opzionale "j"
         * [0-9]* => Questa parte corrisponde a zero o più cifre decimali nella parte intera del numero.
         * \\.?   => Questa parte corrisponde a un punto decimale opzionale.
         * [0-9]+ => Questa parte corrisponde a almeno una cifra decimale nella parte decimale del numero. Il carattere + richiede che almeno una cifra sia presente.
         */   
        Pattern doublePattern = Pattern.compile("[-+]?[j]?[0-9]*\\.?[0-9]+");
        Matcher doubleMatcher = doublePattern.matcher(c);

        double re = 0.0;
        double imm = 0.0;
        /** 
         * ciclo che avanza fintantoché nella stringa in input vengono trovate corrispondenze col pattern
         * una corrispondenza rappresenta una delle parti (reale o immaginaria) del numero complesso
         */
        while(doubleMatcher.find()) {
            /** salvo la stringa trovata che combacia col pattern */
            String field = doubleMatcher.group();
            
            if(field.contains("j")) {
                    imm = Double.parseDouble(field.replace("j", ""));
            } else
                re = Double.parseDouble(field); 
        }
        return new Complex(re, imm);
       
    }
 
    /**
     * Restituisce la parte reale di un numero complesso
     * @return la parte reale di un numero complesso
     */
    public double getRe() {
        return (this.re);
    }

    /**
     * Restituisce la parte immaginaria di un numero complesso
     * @return la parte imamginaria del numero complesso
     */
    public double getImm() {
        return (this.imm);
    }

    /**
     * Imposta la parte reale di un numero complesso
     * @param re è il valore da impostare
     */
    public void setRe(double re) {
        this.re = re;
    }

    /**
     * Imposta la parte immaginaria di un numero complesso
     * @param imm è il valore da impostare
     */
    public void setImm(double imm) {
        this.imm = imm;
    }

    /**
     * Controlla se un Complex e un oggetto passato come parametro sono uguali
     * @param obj è l'oggetto con cui controllare l'uguaglianza
     * @return true se obj è un'istanza di Complex e i campi reali e immaginari dei due numeri sono uguali, altrimenti false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }
        final Complex other = (Complex) obj;
        
        if( ( this.re == Double.NaN || this.imm == Double.NaN ) && ( other.re == Double.NaN || other.imm == Double.NaN ) )
            return true;
        
        if( ( this.re == Double.POSITIVE_INFINITY || this.imm == Double.POSITIVE_INFINITY ) && ( other.re == Double.POSITIVE_INFINITY || other.imm == Double.POSITIVE_INFINITY ) )
            return true;
        
        if( ( this.re == Double.NEGATIVE_INFINITY || this.imm == Double.NEGATIVE_INFINITY ) && ( other.re == Double.NEGATIVE_INFINITY || other.imm == Double.NEGATIVE_INFINITY ) )
            return true;

        Double dif = 0.00009;
        if( abs(this.re - other.getRe()) > dif )
            return false;
        return !(abs(this.imm - other.getImm()) > dif);
    }
    
    /**
     * Metodo hashCode per generare l'hash code da un'istanza di Complex, il metodo è coerente con equals()
     * @return un'intero che rappresenta l'hash code
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.re) ^ (Double.doubleToLongBits(this.re) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.imm) ^ (Double.doubleToLongBits(this.imm) >>> 32));
        return hash;
    }
}