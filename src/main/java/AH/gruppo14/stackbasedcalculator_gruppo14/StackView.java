/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AH.gruppo14.stackbasedcalculator_gruppo14_ref;

import java.util.Stack;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

/**
 *
 * @author Gruppo14
 */
public class StackView extends HBox {
    
    private final ListView<String> listView = new ListView<>();
    public Stack<String> stack;
    
    public StackView(Stack<String> stack) {
        this.stack = stack;
        
        listView.setPrefWidth(500);
        listView.setPrefHeight(40);
        listView.setOrientation(Orientation.HORIZONTAL);
        listView.setMaxWidth(USE_PREF_SIZE);
        
        this.getChildren().add(listView);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
        
        updateListView(stack);
    }
    
    // metodo per aggiornare la view dello stack sull'interfaccia
    // prima svuota la lista poi la riempie con lo stack aggiornato
    public void updateListView(Stack<String> stack) {
        listView.getItems().clear();
        listView.getItems().addAll(stack);
    }
}
