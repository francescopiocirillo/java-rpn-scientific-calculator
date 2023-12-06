/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import static java.lang.Math.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gruppo14
 */

public class Complex {

    private double re;
    private double imm;
    
    public Complex(double re, double imm){
        this.re = re;
        this.imm = imm;
    }
    
    public Complex(){
        this.re = 0;
        this.imm = 0;
    }
    
    /*
     * Metodo statico che restituisce la somma tra due numeri complessi pasasti come parametro 
     */
    public static Complex somma(Complex a, Complex b){
        
        double re = a.re + b.re;
        double imm = a.imm + b.imm;
        
        return new Complex(re, imm);
    }
    
    /*
     * Metodo statico che restituisce la differenza tra due numeri complessi pasasti come parametro 
     */
    public static Complex sottrazione(Complex a, Complex b){
        
        double re = a.re - b.re;
        double imm = a.imm - b.imm;
        
        return new Complex(re, imm);
    }
    
    /*
     * Metodo statico somma che restituisce il prodotto tra due numeri complessi pasasti come parametro 
     */
    public static Complex prodotto(Complex a, Complex b){        
        // Se z1 = a + jb e z2 = x + jy allora
        // z1 * z2 = (ax - by) + j(ay + bx)
        double re = (a.re * b.re) - (a.imm * b.imm);  
        double imm = (a.re * b.imm) + (a.imm * b.re);
        
        return new Complex(re, imm);
    }
    
    /*
     * Metodo statico somma che restituisce il quoziente tra due numeri complessi pasasti come parametro 
     */
    public static Complex divisione(Complex a, Complex b){
        // Se z1 = a + jb e z2 = x + jy allora
        // z1 / z2 = ( (ax + by) + j(bx - ay) ) / (x^2 + y^2) 
        double den = pow(b.re, 2) + pow(b.imm, 2); // x^2 + y^2 
        double re = ( (a.re * b.re) + (a.imm * b.imm) ) / den;  
        double imm = ( (a.imm * b.re) - (a.re * b.imm) ) / den;
        
        return new Complex(re, imm);
    }
    
    // la radice quadrata di un numero complesso restituisce due valori
    // il cacolo della radice in questo metodo è effettuato con la formula di De Moivre:
    // se z = z.re + j*z.imm allora la radice quadrata di z è
    // sqrt(z) = sqrt(r) * ( cos( (theta + 2*k*pi )/2 ) + j(sin( (theta + 2*k*pi)/2 ) )
    // con r = sqrt(z.re^2 + z.imm^2), theta = atan(z.imm / z.re ), k = [0, 1];
    //
    // N.B: Da requisito questa operazione di estrazione di radice quadrata produce 
    // un unico risultato: quello a fase minore (considerando la fase nell’intervallo [0 a 2π]),
    // dunque non è necessario considerare il caso per k = 1.
    // Inoltre, poiché il metodo Math.atan2() restituisce la fase nell'intervallo [-PI, PI], allora
    // per passare all'intervallo [0, 2PI] è necessario sommare 2PI alle fasi comprese in [-PI, 0). 
    public static Complex radice(Complex c) {

        double modulo = sqrt( pow(c.getRe(), 2) + pow(c.getImm(),2) ); // r = sqrt(z.re^2 + z.o+imm^2)
        double theta = atan2( c.getImm(), c.getRe() ); // theta = atan(z.imm / z.re)
        
        // per passare all'intervallo [0, 2PI] si deve sommare 2PI alle fasi comprese in [-PI, 0)
        if( theta < 0 & theta >= -1*PI ) {
            theta += 2*PI;
        }
        
        double radicalModulo = sqrt(modulo); // per comodità salvo sqrt(r) in una variabile

        // considero solo il caso per k = 0 ovvero a fase minore, dunque la fase della radice sarà theta/2
        double re = radicalModulo * cos( theta / 2 );
        double imm = radicalModulo * sin( theta / 2 );
            
        return new Complex(re, imm);
    }
    
    /*
     * Metodo statico che restituisce una copia del numero complesso pasasto come parametro
     * con segno invertito sia per la parte reale che quella immaginaria
     */
    public static Complex invertiSegno(Complex c) {
        return new Complex(-1 * c.getRe(), -1 * c.getImm());
    }
    
    /*
     * Metodo toString per la stampa di un numero complesso
     * La stampa è eseguita stampando la parte reale e quella immaginaria come due double distinti
     * N.B: Per evitare problemi di compatibilità con il metodo parseDouble() viene usato il punto "."
     *      come separatore decimale.
     */
    @Override
    public String toString(){
        
        if(this.re == Double.NaN || this.imm == Double.NaN) {
            return "ERR";//....
        }
        if(this.re == 0 && this.imm == 0){ 
            return "0";
        } 
        else if(this.re == 0) {
            return String.format(java.util.Locale.US,"%.3fj", this.imm);
        } 
        else if(this.imm == 0) {
            return String.format(java.util.Locale.US,"%.3f", this.re);
        } 
        else {
            // Nota: "%+" fa stampare il segno del numero in ogni caso.
            return String.format(java.util.Locale.US,"%.3f%+.3fj", this.re, this.imm);
        }
    }
 
    /*
     * Metodo parse per la classe Complex
     * Riconosce un Complex da String
     */
    public static Complex parseComplex(String c) {
        
        if(c == null) return null;
        
        if(c.contains("NaN")) 
            return new Complex(Double.NaN, 0);//....
        
        if(c.equals("0")) 
            return new Complex();
        
        /* Chiarimento regex per un double: 
         * ^ e $ indicano rispettivamente inizio e fine della stringa
         * [-+]? => questa parte corrisponde a un segno opzionale (+ o -).
         * [0-9]* => Questa parte corrisponde a zero o più cifre decimali nella parte intera del numero.
         * \\.? => Questa parte corrisponde a un punto decimale opzionale.
         * [0-9]+ => Questa parte corrisponde a almeno una cifra decimale nella parte decimale del numero. Il carattere + richiede che almeno una cifra sia presente.
         * [j]? => Questa parte indica un carattere opzionale "j"
         */   
        Pattern doublePattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+[j]?");
        Matcher doubleMatcher = doublePattern.matcher(c);

        double re = 0.0, 
        imm = 0.0;
        // ciclo che avanza fintantoché nella stringa in input vengono trovate corrispondenze col pattern 
        while(doubleMatcher.find()) {
            // salvo la stringa trovata che combacia col pattern
            String field = doubleMatcher.group();
            
            if(field.endsWith("j")) {
                imm = Double.parseDouble(field.replace("j", ""));
            } else
                re = Double.parseDouble(field); 
        }
        return new Complex(re, imm);
       
    }
    
    // metodi setter e getter
 
    public double getRe() {
        return (this.re);
    }
    public double getImm() {
        return (this.imm);
    }
    public void setRe(double re) {
        this.re = re;
    }
    public void setImm(double imm) {
        this.imm = imm;
    }
    
}
