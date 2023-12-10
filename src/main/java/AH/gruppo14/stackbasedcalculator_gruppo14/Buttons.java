/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

/**
 * Questa classe è una enumerazione utilizzara per assegnare ad ogni pulsante della calcolatrice un indice
 * @author Gruppo14
 */
public enum Buttons {
    ZERO(21),
    UNO(15),
    DUE(16),
    TRE(17),
    QUATTRO(10),
    CINQUE(11),
    SEI(12),
    SETTE(5),
    OTTO(6),
    NOVE(7),
    PUNTO(20),
    ENTER(0),
    CANC(1),
    CLEAR(2),
    DUP(3),
    DROP(4),
    SWAP(8),
    OVER(9),
    SOMMA(23),
    SOTTRAZIONE(18),
    RADICE(19),
    DIVISIONE(24),
    PRODOTTO(13),
    INVERTI_SEGNO(14),
    UGUALE(22),
    MAGGIORE(0),
    MINORE(1),
    SOMMAV(2),
    SOTTRAZIONEV(3);

    private final int button;

    /**
     * Il costruttore serve ad inizializzare il valore intero (indice) associato ad ogni istanza dell'enumerazione
     * @param button 
     */
    Buttons(int button) {
        this.button = button;
    }

    /**
     * Questo metodo restituisce l'indice associato ad un'istanza dell'enumerazione
     * @return l'indice associato all'istanza chiamante
     */
    public int getButton() {
        return button;
    }
}
