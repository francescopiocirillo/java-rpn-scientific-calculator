/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14;

import Eccezioni.InvalidOrderException;
import Eccezioni.StackPienoException;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import static AH.gruppo14.stackbasedcalculator_gruppo14.Buttons.*;
import Eccezioni.StackVuotoException;
import Eccezioni.TopElementInvalidException;

/**
 *
 * @author Gruppo14
 */
public class StackCalculatorController {
    
    private StackCalculatorView stackCalculatorView;
    private StackCalculator calculator;
    
    public StackCalculatorController( StackCalculator calculator, StackCalculatorView stackCalculatorView ) {
        this.calculator = calculator;
        this.stackCalculatorView = stackCalculatorView;
        
        initTastierinoNumerico();
        initOperazioniStack();
        initOperazioniBase();
        initBindings();
        initVariables();
    }
    
    //inizializzazione dei bindings
    private void initBindings() {
        bindBlankTextArea();
        bindNumbers();
        bindOperatorPressed();
    }
    
    //condizioni di binding per i bottoni che sono abilitati solo a text area vuota
    private void bindBlankTextArea() {
        //ENTER
        stackCalculatorView.getKey(ENTER.getButton()).disableProperty().bind(Bindings.equal("", stackCalculatorView.getTxtArea().textProperty()));
        //CANC
        stackCalculatorView.getKey(CANC.getButton()).disableProperty().bind(Bindings.equal("", stackCalculatorView.getTxtArea().textProperty()));
        //PRODOTTO
        stackCalculatorView.getKey(PRODOTTO.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));
        //DIVISIONE
        stackCalculatorView.getKey(DIVISIONE.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));;
        //RADICE
        stackCalculatorView.getKey(RADICE.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));;
        //INVERTI_SEGNO
        stackCalculatorView.getKey(INVERTI_SEGNO.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));;
        //UGUALE
        stackCalculatorView.getKey(UGUALE.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));;
    }
    
    //condizione di binding per numeri del tastiernino numerico 
    private void bindNumbers() {
        //azioni relative al tastierino numerico da 1 a 9
        for( int i = SETTE.getButton(); i <= UNO.getButton(); i+=5 )
            for( int j = 0; j < 3; j++ )
                stackCalculatorView.getKey(i+j).disableProperty().bind(Bindings.equal("×", stackCalculatorView.getTxtArea().textProperty()).or(Bindings.equal("±", stackCalculatorView.getTxtArea().textProperty()))
                        .or(Bindings.equal("√", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal("÷", stackCalculatorView.getTxtArea().textProperty())));
        
        //azioni relative al tastierino numerico di ENTER
        stackCalculatorView.getKey(ZERO.getButton()).disableProperty().bind(Bindings.equal("×", stackCalculatorView.getTxtArea().textProperty()).or(Bindings.equal("±", stackCalculatorView.getTxtArea().textProperty()))
                        .or(Bindings.equal("√", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal("÷", stackCalculatorView.getTxtArea().textProperty())));
    }
    
    private void bindOperatorPressed() {
            for( int i = MAGGIORE.getButton(); i <= SOTTRAZIONEV.getButton(); i++ )
            stackCalculatorView.getKeyVar(i).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));
    }
    
    //inizializzazione delle azioni relative al tastierino numerico
    private void initTastierinoNumerico() {
        
        //azioni relative al tastierino numerico da 1 a 9
        for( int i = SETTE.getButton(); i <= UNO.getButton(); i+=5 )
            for( int j = 0; j < 3; j++ )
                stackCalculatorView.getKey(i+j).setOnAction( e -> numberPressed(e) );
        
        //azione relativa al tastierino numerico di .
        stackCalculatorView.getKey(PUNTO.getButton()).setOnAction( e -> puntoPressed(e) );
        
        //azione relativa al tastierino numerico di 0
        stackCalculatorView.getKey(ZERO.getButton()).setOnAction( e -> numberPressed(e) );
        
        //azione relativa al tastierino numerico di CANC
        stackCalculatorView.getKey(CANC.getButton()).setOnAction( e -> cancPressed() );
    }
    
    //azione da compiere quando viene premuto il tasto del tastierino numerico .
    private void puntoPressed( ActionEvent e ) {
    try {
        Button b = (Button) e.getSource();
        String txt = stackCalculatorView.getTxtArea().getText();
        if( txt.equals("") ) {
            stackCalculatorView.getTxtArea().setText("0" + b.getText());
            stackCalculatorView.getKey(PUNTO.getButton()).setDisable(true);
        }
        else {
            char lastC = txt.charAt(txt.length() - 1);
            if( lastC == '+' || lastC == '-' || lastC == 'j' ) {
                stackCalculatorView.getTxtArea().setText( txt + "0" + b.getText() );
                stackCalculatorView.getKey(PUNTO.getButton()).setDisable(true);
                return ;
            }
            for( int i = 48; i <= 57; i++ ) {
                if( lastC == (char)i ) {
                    stackCalculatorView.getTxtArea().setText( txt + b.getText() );
                    stackCalculatorView.getKey(PUNTO.getButton()).setDisable(true);
                    return ;
                }
            }
        }
    } catch( Exception ex ) {
        System.out.println("errore:");
        ex.printStackTrace();
    }
    }
    
    //azione da compiere quando viene premuto un tasto del tastierino numerico (0 a 9)
    private void numberPressed( ActionEvent e ) {
        if( stackCalculatorView.getTxtArea().getText().equals("FULL") )
            stackCalculatorView.getTxtArea().setText("");
        
        Button b = (Button) e.getSource();
        stackCalculatorView.getTxtArea().setText( stackCalculatorView.getTxtArea().getText() + b.getText() );
        
        String txt = stackCalculatorView.getTxtArea().getText();
        int c = 0;
        int soglia = 1;
        for( int i = 0; i < txt.length(); i++ ) {
            if( txt.charAt(i) == '+' || txt.charAt(i) == '-' ) {
                if( i == 0 )
                    soglia++;
                c++;
            }
        }
        if( c < soglia ) {
            stackCalculatorView.getKey(SOMMA.getButton()).setDisable(false);
            stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(false);
        }
        
        
        stackCalculatorView.updateListView(calculator.getStack());
    }
    
    //azione da compiere quando viene premuto il tasto CANC
    private void cancPressed() {
        stackCalculatorView.getTxtArea().setText("");
        //riaattivo + e -
        stackCalculatorView.getKey(SOMMA.getButton()).setDisable(false);
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(false);
        stackCalculatorView.getKey(PUNTO.getButton()).setDisable(false);
        
        stackCalculatorView.updateListView(calculator.getStack());
    }
    
    //inizializzazione delle azioni relative allo stack
    private void initOperazioniStack() {
        //azione relativa alle operazioni sullo stack di Enter
        stackCalculatorView.getKey(ENTER.getButton()).setOnAction( e -> enterPressed() );
        stackCalculatorView.getKey(CLEAR.getButton()).setOnAction( e -> clearPressed() );
        stackCalculatorView.getKey(DUP.getButton()).setOnAction( e -> dupPressed() );
        stackCalculatorView.getKey(DROP.getButton()).setOnAction( e -> dropPressed());
        stackCalculatorView.getKey(SWAP.getButton()).setOnAction( e -> swapPressed() );
        stackCalculatorView.getKey(OVER.getButton()).setOnAction( e -> overPressed() );
    }
    
    //azione da compiere quando viene premuto Enter
    private void enterPressed() {
        try {
            //riaattivo + e -
            stackCalculatorView.getKey(SOMMA.getButton()).setDisable(false);
            stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(false);
            stackCalculatorView.getKey(PUNTO.getButton()).setDisable(false);
            
            //aggiungere 0 se last character è .
            String txt = stackCalculatorView.getTxtArea().getText();
            if( txt.charAt( txt.length() - 1 ) == '.' ) {
                stackCalculatorView.getTxtArea().setText( txt + '0' );
            }
            
            //per aggiungere 1 post j, risolto in parsing
            if( txt.charAt( txt.length() - 1 ) == 'j' ) {
                stackCalculatorView.getTxtArea().setText( txt + '1' );
            }
            
            
            //carico nello stack il valore nella text area
            calculator.push( stackCalculatorView.getTxtArea().getText() );
            stackCalculatorView.updateListView(calculator.getStack());
            //pulisco text area
            stackCalculatorView.getTxtArea().setText("");
        } catch( StackPienoException ex ) {
            stackCalculatorView.getTxtArea().setText("ERR: FULL");
        }
        
        /* AGGIORNA STACK */
        
    }
    
    private void clearPressed() {
        calculator.clear();
        
        stackCalculatorView.updateListView(calculator.getStack());
    }
    
    private void dupPressed() {
        calculator.dup();
        
        stackCalculatorView.updateListView(calculator.getStack());
    }
    
    private void dropPressed() {
        calculator.drop();
        
        stackCalculatorView.updateListView(calculator.getStack());
    }
    
    private void swapPressed() {
        calculator.swap();
        
        stackCalculatorView.updateListView(calculator.getStack());
    }

    private void overPressed() {
        calculator.over();
        
        stackCalculatorView.updateListView(calculator.getStack());
    }
    
    //inizializzazione delle azioni relative alle operazioni di base
    public void initOperazioniBase() {
        stackCalculatorView.getKey(PRODOTTO.getButton()).setOnAction( e -> operatorPressed(e) );
        stackCalculatorView.getKey(INVERTI_SEGNO.getButton()).setOnAction( e -> operatorPressed(e) );
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setOnAction( e -> sommaSottrazionePressed(e) );
        stackCalculatorView.getKey(RADICE.getButton()).setOnAction( e -> operatorPressed(e) );
        stackCalculatorView.getKey(SOMMA.getButton()).setOnAction( e -> sommaSottrazionePressed(e) );
        stackCalculatorView.getKey(DIVISIONE.getButton()).setOnAction( e -> operatorPressed(e) );
        stackCalculatorView.getKey(UGUALE.getButton()).setOnAction( e -> ugualePressed() );
    }
    
    //azione da compiere quando viene premuto un operatore
    private void operatorPressed( ActionEvent e ) {
        if( stackCalculatorView.getTxtArea().getText().equals("FULL") )
            stackCalculatorView.getTxtArea().setText("");
        
        Button b = (Button) e.getSource();
        stackCalculatorView.getTxtArea().setText( stackCalculatorView.getTxtArea().getText() + b.getText() );
        //disattivo + e -
        stackCalculatorView.getKey(SOMMA.getButton()).setDisable(true);
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(true);
        
        stackCalculatorView.updateListView(calculator.getStack());
    }
    
    private void sommaSottrazionePressed( ActionEvent e ) {
        Button b = (Button) e.getSource();
        String txt = stackCalculatorView.getTxtArea().getText();
        
        boolean notEmpty = txt.length() > 0;
        
        if( notEmpty && txt.charAt(txt.length()-1) == '.' )
            stackCalculatorView.getTxtArea().setText( txt + "0" + b.getText() + "j" );
        else if( notEmpty )
            stackCalculatorView.getTxtArea().setText( txt + b.getText() + "j" );
        else
            stackCalculatorView.getTxtArea().setText( txt + b.getText() );
        
        //disattivo + e -
        stackCalculatorView.getKey(SOMMA.getButton()).setDisable(true);
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(true);
        
        int c = 0;
        for( int i = 0; i < txt.length(); i++ ) {
            if( txt.charAt(i) == '+' || txt.charAt(i) == '-' ) {
                c++;
            }
        }
        if( c < 2 ) {
            stackCalculatorView.getKey(PUNTO.getButton()).setDisable(false);
        }
        
       stackCalculatorView.updateListView(calculator.getStack());
    }
    
    private void ugualePressed() {
        try {
            calculator.calcola();
            
            stackCalculatorView.updateListView(calculator.getStack());
        } catch (InvalidOrderException ex) {
            stackCalculatorView.getTxtArea().setText("ERR: INV_SEQ");
        }
    }
    
    private void initVariables() {
        for(int i=0; i<4; i++)
            stackCalculatorView.getKeyVar(i).setOnAction( e -> varOperatorPressed(e) );
        
        /* 'a' si trova all'indice 4 della griglia di VariableView*/
        for(int i=4; i<30; i++) {
            stackCalculatorView.getKeyVar(i).setOnAction( e -> variablePressed(e) );
            stackCalculatorView.getKeyVar(i).setDisable(true);
        }
    }
    
    private void varOperatorPressed( ActionEvent e ) {
        for(int i=4; i<30; i++) {
            stackCalculatorView.getKeyVar(i).setDisable(false);
        }
        //da fare binding per spegnere gli operatori
        Button b = (Button)e.getSource();
        stackCalculatorView.getTxtArea().setText( b.getText() );
    }
    
    private void variablePressed( ActionEvent e ) {
        for(int i=4; i<30; i++) {
            stackCalculatorView.getKeyVar(i).setDisable(true);
        }
        String txt = stackCalculatorView.getTxtArea().getText();
        Button b = (Button) e.getSource();
        int varIndex = ((int) b.getText().charAt(0)) - 97;
        stackCalculatorView.getTxtArea().setText("");
        switch (txt.charAt(0)) {
            case '>':
            {
                try {
                    calculator.loadVariable( varIndex );
                    b.setText( b.getText().charAt(0) + ": " + calculator.getVariable( varIndex ) );
                } catch (StackVuotoException ex) {
                    stackCalculatorView.getTxtArea().setText("ERR: EMPTY");
                } catch (TopElementInvalidException ex) {
                    stackCalculatorView.getTxtArea().setText("ERR: TOP_INV");
                }
            }
                break;

            case '<':
            {
                try {
                    calculator.storeVariable( varIndex );
                } catch (StackPienoException ex) {
                    stackCalculatorView.getTxtArea().setText("ERR: FULL");
                }
            }
                break;

            case '+':
            {
                try {
                    calculator.addVariable( varIndex );
                    b.setText( b.getText().charAt(0) + ": " + calculator.getVariable( varIndex ) );
                } catch (StackVuotoException ex) {
                    stackCalculatorView.getTxtArea().setText("ERR: EMPTY");
                } catch (TopElementInvalidException ex) {
                    stackCalculatorView.getTxtArea().setText("ERR: TOP_INV");
                }
            }
                break;

            case '-':
            {
                try {
                    calculator.subtractVariable( varIndex );
                    b.setText( b.getText().charAt(0) + ": " + calculator.getVariable( varIndex ) );
                } catch (StackVuotoException ex) {
                    stackCalculatorView.getTxtArea().setText("ERR: EMPTY");
                } catch (TopElementInvalidException ex) {
                    stackCalculatorView.getTxtArea().setText("ERR: TOP_INV");
                }
            }
                break;

            default:
                
                break;
        }
        stackCalculatorView.updateListView(calculator.getStack());
    }
}
