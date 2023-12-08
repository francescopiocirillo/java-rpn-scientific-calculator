/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Gruppo14
 */
public class StackCalculatorView extends VBox{
    
    public final int NUMKEYS = 25;
    public final int COLUMNS = 5;
    public final int ENTER = 0, CLEAR = 2, DUP = 3, DROP = 4, SWAP = 8, OVER = 9;
    public final int SOMMA = 23, SOTTRAZIONE = 18, RADICE = 19, DIVISIONE = 24,
                        PRODOTTO = 13, INVERTI_SEGNO = 14, UGUALE = 22, CANC = 1;
    public final int ZERO = 21, UNO = 15, DUE = 16, TRE = 17, QUATTRO = 10,
                        CINQUE = 11, SEI = 12, SETTE = 5, OTTO = 6, NOVE = 7, PUNTO = 20;
    
    public StackView stackView;
    public CalculatorView calcView;
    
     public StackCalculatorView( Stack<String> stack ) {
         
         this.stackView = new StackView(stack);
         this.calcView = new CalculatorView();
         
         this.getChildren().addAll(stackView, calcView);        /*aggiungi i suoi figli alla visualizzazione*/
         this.setAlignment(Pos.CENTER);
         this.setSpacing(10);
     }
}
