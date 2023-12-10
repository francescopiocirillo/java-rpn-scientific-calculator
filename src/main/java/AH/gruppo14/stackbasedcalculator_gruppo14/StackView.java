/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import java.util.Stack;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

/**
 * Questa classe rappresenta la view dello stack sull'interfaccia.
 * É un HBox usato per contenere una ListView di String per visualizzare lo stack.
 * @author Gruppo14
 */
public class StackView extends HBox {
    
    /** StackView è composta da ListView<String> */
    private ListView<String> listView;
    
    /**
     * Il costruttore crea una nuova istanza di ListView, ne imposta lo stile e la aggiunge come figlio.
     * @param stack è lo stack che ListView deve visualizzare.
     */
    public StackView(Stack<String> stack) {
        
        listView = new ListView<>();
        listView.setPrefWidth(776);
        listView.setPrefHeight(65);
        listView.setOrientation(Orientation.HORIZONTAL);
        listView.setMaxWidth(USE_PREF_SIZE);
        listView.setStyle("-fx-font-size:20.0;");
        
        this.getChildren().add(listView);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        
        updateListView(stack);
    }
    
    /**
     * Questo metodo serve ad aggiornare la view dello stack sull'interfaccia,
     * prima svuota la lista poi la riempie con lo stack aggiornato.
     * @param stack lo stack i cui elementi vanno inseriti nella view
     */
    public final void updateListView(Stack<String> stack) {
        listView.getItems().clear();
        listView.getItems().addAll(stack);
    }
}
