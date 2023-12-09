/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14_ref;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Gruppo14
 */
//base view mostra il tastierino numerico, le operazioni di base,
//le operazioni sullo stack e la text area
public class BaseView extends VBox {
    
    public TextField txtArea;
    public Button [] keys;
    
    public final int NUMKEYS = 25;
    public final int COLUMNS = 5;
    public final int ENTER = 0, CLEAR = 2, DUP = 3, DROP = 4, SWAP = 8, OVER = 9;
    public final int SOMMA = 23, SOTTRAZIONE = 18, RADICE = 19, DIVISIONE = 24,
                        PRODOTTO = 13, INVERTI_SEGNO = 14, UGUALE = 22, CANC = 1;
    public final int ZERO = 21, UNO = 15, DUE = 16, TRE = 17, QUATTRO = 10,
                        CINQUE = 11, SEI = 12, SETTE = 5, OTTO = 6, NOVE = 7, PUNTO = 20;

    public BaseView() {
        txtArea = new TextField();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        
        this.getChildren().add(txtArea);
        txtArea.setMaxWidth(500);
        txtArea.setEditable(false);
        
        keys = new Button[NUMKEYS];
        initButtons();
        placeButtons();
    }

    public Button getKey( int index ) {
        return keys[index];
    }

    public TextField getTxtArea() {
        return txtArea;
    }
    
    private void initButtons() {
        //creazione bottoni
        for( int i = 0; i < NUMKEYS; i++ ) {
            keys[i] = new Button();
            keys[i].setMinWidth(100);
        }
        
        //set del testo legato ai bottoni
        //tastierino numerico
        keys[SETTE].setText("7");
        keys[OTTO].setText("8");
        keys[NOVE].setText("9");
        keys[QUATTRO].setText("4");
        keys[CINQUE].setText("5");
        keys[SEI].setText("6");
        keys[UNO].setText("1");
        keys[DUE].setText("2");
        keys[TRE].setText("3");
        keys[ZERO].setText("0");
        keys[PUNTO].setText(".");
        keys[CANC].setText("CANC");
        
        //operazioni di base
        keys[PRODOTTO].setText("×");
        keys[INVERTI_SEGNO].setText("±");
        keys[SOTTRAZIONE].setText("-");
        keys[RADICE].setText("√");
        keys[SOMMA].setText("+");
        keys[DIVISIONE].setText("÷");
        keys[UGUALE].setText("=");
        
        //operazioni sullo stack
        keys[ENTER].setText("ENTER");
        keys[CLEAR].setText("CLEAR");
        keys[DUP].setText("DUP");
        keys[DROP].setText("DROP");
        keys[SWAP].setText("SWAP");
        keys[OVER].setText("OVER");
    }
    
    private void placeButtons() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        for( int i = 0; i < NUMKEYS; i++ ) {
            gridPane.add(keys[i], i%COLUMNS, i/COLUMNS); // questo serve a fare 7 tasti per rigo
        }
        this.getChildren().add(gridPane);
    }
    
}