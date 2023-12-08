/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14_ref;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Gruppo14
 */

/*si tratta del View della parte inerenti le variabili*/
public class VariablesView extends GridPane {
    
    public Button[] keys;
    
    private final int COLUMNS=4;            /*le colonne che vogliamo ottenere*/
    private final int CHAROP=30;       /*i bottoni totali di questa sezione (operatori+variabili)*/
    
    private final int MAGGIORE=0;
    private final int MINORE=1;
    private final int SOMMAV=2;
    private final int SOTTRAZIONEV=3;
    
    public VariablesView() {
        super();
        
        keys = new Button[CHAROP];         /*inizializzo il vettore*/
        
        /*invocando initVarButtons questo mi consentirà di inizializzare i bottoni*/
        initVarButtons();
        placeVarButtons();        
    }
    
    /*istanziamo i pulsanti con questo metodo*/
    private void initVarButtons() {
        for(int i=0; i<(CHAROP); i++){
            keys[i]=new Button();
            keys[i].setMinWidth(30);            /*per far sì che abbiano tutti la stessa dim*/
            if(i>=4)
                keys[i].setText(Character.toString((char)(i+93)));          /*assegnamo le lettere dalla a alla z---> dovrei partire da 97 per 'a'*/
        }
        
        /*fuori dal for scrivo sui bottoni rimanenti che cosa indicano*/
        keys[MAGGIORE].setText(">");
        keys[MINORE].setText("<");
        keys[SOMMAV].setText("+");
        keys[SOTTRAZIONEV].setText("-");
    }  
    
    private void placeVarButtons() {
        this.setHgap(5);
        this.setVgap(5);
        
        this.setAlignment(Pos.CENTER);
        
        for(int i=0; i<CHAROP; i++){                     
            this.add(keys[i], i%COLUMNS, i/COLUMNS);
        }    
    }
    
}
