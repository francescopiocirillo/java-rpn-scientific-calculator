/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14_ref;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


/**
 *
 * @author franc
 */
public class CalculatorView extends HBox{          /*la HBox pone gli elementi in orizzontale*/
    
    public BaseView baseView;
    public VariablesView varView;
    
    public CalculatorView() {
       
        this.baseView = new BaseView();
        this.varView = new VariablesView();
        
        this.getChildren().addAll(varView, baseView);
        
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

    }
    
}
