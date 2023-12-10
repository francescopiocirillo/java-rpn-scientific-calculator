/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import static AH.gruppo14.stackbasedcalculator_gruppo14.Buttons.*;

/**
 * Si tratta del View della parte di GUI inerente le variabili
 * @author Gruppo14
 */
public class VariablesView extends GridPane {
    
    private Button[] keys;
    
    private final int COLUMNS=4;            /*le colonne che vogliamo ottenere*/
    private final int CHAROP=30;       /*i bottoni totali di questa sezione (operatori+variabili)*/
    
    /**
     * il costruttore inizializza l'array di bottoni e chiama i metodi
     * per l'inizializzazione e il piazzamento dei bottoni stessi
     */
    public VariablesView() {
        super();
        keys = new Button[CHAROP];
        /*invocando initVarButtons questo mi consentirà di inizializzare i bottoni*/
        initVarButtons();
        placeVarButtons();        
    }

    /**
     * getter per ottenere la reference al bottone desiderato
     * @param index l'indice del bottone desiderato nell'array di bottoni
     * @return la reference al bottone desiderato
     */
    public Button getKey( int index ) {
        return keys[index];
    }
    
    /**
     * i singoli bottoni vengono istanziati e ne vengono definite dimensioni e stile
     */
    private void initVarButtons() {
        for(int i=0; i<(CHAROP); i++){
            keys[i]=new Button();
            keys[i].setMinWidth(55);            /*per far sì che abbiano tutti la stessa dim*/
            if(i>=4) {
                keys[i].setText(Character.toString((char)(i+93)));           /*assegnamo le lettere dalla a alla z---> dovrei partire da 97 per 'a'*/
                keys[i].setStyle("-fx-background-color: rgb(255,240,218); -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255);");
                keys[i].setMinHeight(46);
            }
            else {
                keys[i].setStyle("-fx-background-color: rgb(247,227,112); -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255); -fx-border-radius: 6; -fx-background-radius: 6;");
                keys[i].setMinHeight(93);
            }
        }
        
        /*fuori dal for scrivo sui bottoni rimanenti che cosa indicano*/
        keys[MAGGIORE.getButton()].setText(">");
        keys[MINORE.getButton()].setText("<");
        keys[SOMMAV.getButton()].setText("+");
        keys[SOTTRAZIONEV.getButton()].setText("-");
    }  
    
    /**
     * i bottoni inizializzati vengono posizionati
     */
    private void placeVarButtons() {
        this.setHgap(8);
        this.setVgap(6);
        
        this.setAlignment(Pos.CENTER);
        
        for(int i=0; i<CHAROP; i++){                     
            this.add(keys[i], i%COLUMNS, i/COLUMNS);
        }    
    }
    
}
