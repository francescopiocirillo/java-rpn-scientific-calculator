/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14_ref;

import java.util.Stack;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author Gruppo14
 */
public class StackCalculatorView extends VBox {

   private StackView stackView;
   private CalculatorView calcView;

   public StackCalculatorView(Stack<String> stack) {

      this.stackView = new StackView(stack);
      this.calcView = new CalculatorView();

      this.getChildren().addAll(stackView, calcView); /* aggiungi i suoi figli alla visualizzazione */
      this.setAlignment(Pos.CENTER);
      this.setSpacing(10);
   }

   public Button getKey( int index ) {
      return calcView.getKey(index);
   }

   public TextField getTxtArea() {
      return calcView.getTxtArea();
   }

   public void updateListView( Stack<String> stack ) {
      stackView.updateListView(stack);
   }

   public Button getKeyVar( int index ) {
      return calcView.getKeyVar(index);
   }
}
