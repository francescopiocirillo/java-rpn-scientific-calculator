/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Questa classe è la view di più alto livello, è un HBox che contiene le view di più basso livello.
 * É una classe composta da StackView e CalculatorView
 * @author Gruppo14
 */
public class StackCalculatorView extends VBox {

   private StackView stackView;
   private CalculatorView calcView;

    /**
     * Il costruttore crea due nuove istanze di StackView e di CalculatorView e
     * poi le aggiunge come figli alla nuova istanza di StackCalculatorView.
     * Inoltre imposta dello stile all'istanza.
     * @param stack è lo stack che viene passato come argomento al costruttore di StackView
     */
    public StackCalculatorView(Stack<String> stack) {
      this.setStyle("-fx-background-color: rgb(7,94,98);"); 
      this.stackView = new StackView(stack);
      this.calcView = new CalculatorView();

      /** aggiunge i suoi figli alla visualizzazione */
      this.getChildren().addAll(stackView, calcView); 
      this.setAlignment(Pos.CENTER);
      this.setSpacing(10);
   }

    /**
     * Questo metodo restituisce un Button di CalculatorView associato all'indice passato.
     * Da usare per ottenere un Button di CalculatorView.
     * @param index è un intero rappresentante l'indice del Button richiesto.
     * @return il Button associato ad index.
     */
    public Button getKey( int index ) {
      return calcView.getKey(index);
   }

    /**
     * Questo metodo restitusce un TextField richiamando l'omonimo metodo su CalculatorView.
     * @return la text area della view.
     */
    public TextField getTxtArea() {
      return calcView.getTxtArea();
   }

    /**
     * Questo metodo aggiorna la view dell stack sull'interfaccia richiamando l'omonimo metodo su StackView.
     * @param stack è lo stack con cui aggiornare la view.
     */
    public void updateListView( Stack<String> stack ) {
      stackView.updateListView(stack);
   }

    /**
     * Questo metodo restituisce un Button associato all'indice passato.
     * Da usare per ottenere un Button di VariablesView.
     * @param index è l'intero rappresentante l'indice del Button.
     * @return il Button associato all'indice.
     */
    public Button getKeyVar( int index ) {
      return calcView.getKeyVar(index);
   }
}
