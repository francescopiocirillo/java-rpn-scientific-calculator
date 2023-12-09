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
        keys[5].setText("7");
        keys[6].setText("8");
        keys[7].setText("9");
        keys[10].setText("4");
        keys[11].setText("5");
        keys[12].setText("6");
        keys[15].setText("1");
        keys[16].setText("2");
        keys[17].setText("3");
        keys[21].setText("0");
        keys[20].setText(".");
        keys[1].setText("CANC");
        
        //operazioni di base
        keys[13].setText("×");
        keys[14].setText("±");
        keys[18].setText("-");
        keys[19].setText("√");
        keys[23].setText("+");
        keys[24].setText("÷");
        keys[22].setText("=");
        
        //operazioni sullo stack
        keys[0].setText("ENTER");
        keys[2].setText("CLEAR");
        keys[3].setText("DUP");
        keys[4].setText("DROP");
        keys[8].setText("SWAP");
        keys[9].setText("OVER");
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