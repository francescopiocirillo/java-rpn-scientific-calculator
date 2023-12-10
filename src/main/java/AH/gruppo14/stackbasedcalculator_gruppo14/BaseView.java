/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import static AH.gruppo14.stackbasedcalculator_gruppo14.Buttons.*;
import javafx.scene.text.Font;

/**
 * BaseView è un VBox una composizione di TextField e Button,
 * mostra il tastierino numerico, le operazioni di base,
 * le operazioni sullo stack e la text area.
 * @author Gruppo14
 */

public class BaseView extends VBox {
    
    /*
     * la text area è rappresentata da un TextField, i vari pulsanti da dei Button */
    private TextField txtArea;
    private Button [] keys;
    
    /** Costanti di utilità, 25 pulsanti in  5 colonne */
    private final int NUMKEYS = 25;
    private final int COLUMNS = 5;

    /** Il costruttore crea la text area e i pulsanti e ne imposta anche il layout */
    public BaseView() {
        txtArea = new TextField();
        this.setAlignment(Pos.TOP_CENTER);
        this.setSpacing(10);
        
        txtArea.setFont(Font.loadFont("file:resources/fonts/LEDCalculator.ttf", 40));
        
        this.getChildren().add(txtArea);
        txtArea.setMinWidth(520);
        txtArea.setMinHeight(93);
        txtArea.setEditable(false);
        
        txtArea.setAlignment(Pos.CENTER_RIGHT);
        
        keys = new Button[NUMKEYS];
        initButtons();
        placeButtons();
    }

    /**
     * Questo metodo restituisce un Button a seconda dell'indice passato
     * @param index è un intero che rappresenta l'indice del Button richiesto
     * @return il Button relativo ad index
     */
    public Button getKey( int index ) {
        return keys[index];
    }

    /**
     * Questo metodo restituisce il TextField, che è la text area dell'interfaccia.
     * @return la text area dell'interfaccia.
     */
    public TextField getTxtArea() {
        return txtArea;
    }
    
    /**
     * Questo metodo serve ad inizializzare tutti i Button di BaseView, imposta sia il testo che lo stile.
     */
    private void initButtons() {
        //creazione bottoni
        for( int i = 0; i < NUMKEYS; i++ ) {
            keys[i] = new Button();
            keys[i].setMinWidth(100);
            keys[i].setMinHeight(48);
        }
        String styleNumber = "-fx-background-color: rgb(249,249,198); -fx-font: 20px Tahoma; -fx-font-weight: 600; -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255);";
        String styleCommands="-fx-background-color: rgb(224,224,224); -fx-text-fill: rgb(163,34,23); -fx-font-weight: bold; -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255);";
        String styleOperator="-fx-background-color: rgb(249,249,198); -fx-font: 20px Tahoma; -fx-text-fill: rgb(163,34,23); -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255);";
        //set del testo legato ai bottoni
        //tastierino numerico     
        keys[SETTE.getButton()].setText("7");
        keys[SETTE.getButton()].setStyle(styleNumber);
        
        keys[OTTO.getButton()].setText("8");
        keys[OTTO.getButton()].setStyle(styleNumber);
        
        keys[NOVE.getButton()].setText("9");
        keys[NOVE.getButton()].setStyle(styleNumber);
        
        keys[QUATTRO.getButton()].setText("4");
        keys[QUATTRO.getButton()].setStyle(styleNumber);
        
        keys[CINQUE.getButton()].setText("5");
        keys[CINQUE.getButton()].setStyle(styleNumber);
        
        keys[SEI.getButton()].setText("6");
        keys[SEI.getButton()].setStyle(styleNumber);
        
        keys[UNO.getButton()].setText("1");
        keys[UNO.getButton()].setStyle(styleNumber);
        
        keys[DUE.getButton()].setText("2");
        keys[DUE.getButton()].setStyle(styleNumber);
        
        keys[TRE.getButton()].setText("3");
        keys[TRE.getButton()].setStyle(styleNumber);
        
        keys[ZERO.getButton()].setText("0");
        keys[ZERO.getButton()].setStyle(styleNumber);
        
        keys[PUNTO.getButton()].setText(".");
        keys[PUNTO.getButton()].setStyle(styleOperator);
        
        keys[CANC.getButton()].setText("Canc");
        keys[CANC.getButton()].setStyle(styleCommands);

        //operazioni di base
        keys[PRODOTTO.getButton()].setText("×");
        keys[PRODOTTO.getButton()].setStyle(styleOperator);
        
        keys[INVERTI_SEGNO.getButton()].setText("±");
        keys[INVERTI_SEGNO.getButton()].setStyle(styleOperator);
        
        keys[SOTTRAZIONE.getButton()].setText("-");
        keys[SOTTRAZIONE.getButton()].setStyle(styleOperator);
        
        keys[RADICE.getButton()].setText("√");
        keys[RADICE.getButton()].setStyle(styleOperator);
        
        keys[SOMMA.getButton()].setText("+");
        keys[SOMMA.getButton()].setStyle(styleOperator);
        
        keys[DIVISIONE.getButton()].setText("÷");
        keys[DIVISIONE.getButton()].setStyle(styleOperator);
        
        keys[UGUALE.getButton()].setText("=");
        keys[UGUALE.getButton()].setStyle(styleOperator);
        
        //operazioni sullo stack
        keys[ENTER.getButton()].setText("Enter");
        keys[ENTER.getButton()].setStyle(styleCommands);
        
        keys[CLEAR.getButton()].setText("Clear");
        keys[CLEAR.getButton()].setStyle(styleCommands);
        
        keys[DUP.getButton()].setText("Dup");
        keys[DUP.getButton()].setStyle(styleCommands);
        
        keys[DROP.getButton()].setText("Drop");
        keys[DROP.getButton()].setStyle(styleCommands);
        
        keys[SWAP.getButton()].setText("Swap");
        keys[SWAP.getButton()].setStyle(styleCommands);
        
        keys[OVER.getButton()].setText("Over");
        keys[OVER.getButton()].setStyle(styleCommands);
    }
    
    /** 
     * Questo metodo serve a posizionare i Button inizializzati in un GridPane,
     * i Button si disporranno in modo ordinato formando una griglia 5x5.
     */
    private void placeButtons() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(10);
        
        for( int i = 0; i < NUMKEYS; i++ ) {
            gridPane.add(keys[i], i%COLUMNS, i/COLUMNS); // questo serve a fare 7 tasti per rigo
        }
        this.getChildren().add(gridPane);
    }
    
}
