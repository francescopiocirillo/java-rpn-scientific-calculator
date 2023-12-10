/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


/**
 * Questa classe rappresenta la view del tastierino numerico e del tastierino delle variabili.
 * É una composizione di BaseView e VariablesView.
 * @author Gruppo14
 */
public class CalculatorView extends HBox {         
    
    /** BaseView e VariablesView sono componenti di CalculatorView */
    private BaseView baseView;
    private VariablesView varView;
    
    /**
     * Il costruttore crea due nuove istanze di BaseView e VariablesView e le aggiunge come figli
     */
    public CalculatorView() {
       
        this.baseView = new BaseView();
        this.varView = new VariablesView();
        
        this.getChildren().addAll(varView, baseView);
        
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

    }

    /**
     * Questo metodo restituisce un Button associato all'indice passato come parametro.
     * É da usare per ottenere un Button di BaseView.
     * @param index è un intero rappresentante l'indice del Button richiesto.
     * @return il Button associato ad index.
     */
    public Button getKey( int index ) {
        return baseView.getKey(index);
    }

    /**
     * Questo metodo restituisce un TextField che rappresenta la text area dell'interfaccia.
     * @return la text area dell'interfaccia.
     */
    public TextField getTxtArea() {
        return baseView.getTxtArea();
    }

    /**
     * Questo metodo restituisce un Button associato all'indice passato come parametro.
     * É da usare per ottenere un Button di VariablesView.
     * @param index è un intero rappresentante l'indice del Button richiesto.
     * @return il Button associato ad index.
     */
    public Button getKeyVar( int index ) {
        return varView.getKey(index);
    }
    
}
