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

/**
 *
 * @author Gruppo14
 */
public class BaseView extends VBox {
    
    private TextField txtArea;
    private Button [] keys;
    
    private final int NUMKEYS = 25;
    private final int COLUMNS = 5;

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
        keys[SETTE.getButton()].setText("7");
        keys[OTTO.getButton()].setText("8");
        keys[NOVE.getButton()].setText("9");
        keys[QUATTRO.getButton()].setText("4");
        keys[CINQUE.getButton()].setText("5");
        keys[SEI.getButton()].setText("6");
        keys[UNO.getButton()].setText("1");
        keys[DUE.getButton()].setText("2");
        keys[TRE.getButton()].setText("3");
        keys[ZERO.getButton()].setText("0");
        keys[PUNTO.getButton()].setText(".");
        keys[CANC.getButton()].setText("CANC");
        
        //operazioni di base
        keys[PRODOTTO.getButton()].setText("×");
        keys[INVERTI_SEGNO.getButton()].setText("±");
        keys[SOTTRAZIONE.getButton()].setText("-");
        keys[RADICE.getButton()].setText("√");
        keys[SOMMA.getButton()].setText("+");
        keys[DIVISIONE.getButton()].setText("÷");
        keys[UGUALE.getButton()].setText("=");
        
        //operazioni sullo stack
        keys[ENTER.getButton()].setText("ENTER");
        keys[CLEAR.getButton()].setText("CLEAR");
        keys[DUP.getButton()].setText("DUP");
        keys[DROP.getButton()].setText("DROP");
        keys[SWAP.getButton()].setText("SWAP");
        keys[OVER.getButton()].setText("OVER");
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