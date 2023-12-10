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
 * Questa classe è il Controller dell'applicazione.
 * @author franc
 */
public class StackCalculatorController {
    
    /** View e Model sono componenti del Controller */
    private StackCalculatorView stackCalculatorView;
    private StackCalculator stackCalculator;

    /** 
     * variabili relative alla definizione dello stile dei numeri,
     * comandi e operatori di base al click del mouse e al successivo rilascio.
     */
    private final String STYLE_NUM_CLICK="-fx-border-color: rgb(6, 200, 194); -fx-border-width: 1; -fx-background-color: rgb(249,249,198); -fx-font: 20px Tahoma; -fx-font-weight: 600; -fx-border-radius: 2px;";
    private final String ORIGINAL_STYLE_NUM="-fx-background-color: rgb(249,249,198); -fx-font: 20px Tahoma; -fx-font-weight: 600; -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255);";
        
    private final String STYLE_COM_CLICK=" -fx-border-color: rgb(6, 200, 194); -fx-border-width: 1;  -fx-background-color: rgb(224,224,224); -fx-text-fill: rgb(163,34,23); -fx-font-weight: bold; -fx-border-radius: 2px;";
    private final String ORIGINAL_STYLE_COM="-fx-background-color: rgb(224,224,224); -fx-text-fill: rgb(163,34,23); -fx-font-weight: bold; -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255);";
    
    private final String ORIGINAL_STYLE_OP="-fx-background-color: rgb(249,249,198); -fx-font: 20px Tahoma; -fx-text-fill: rgb(163,34,23); -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255);";
    private final String STYLE_OP_CLICK="-fx-border-color: rgb(6, 200, 194); -fx-border-width: 1; -fx-background-color: rgb(249,249,198); -fx-font: 20px Tahoma; -fx-text-fill: rgb(163,34,23); -fx-border-radius: 2px;";
    
    private final String ORIGINAL_STYLE_VAR="-fx-background-color: rgb(255,240,218); -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255);";
    private final String STYLE_VAR_CLICK="-fx-background-color: rgb(255,240,218);-fx-border-color: rgb(6, 200, 194); -fx-border-radius: 2;";
    
    private final String ORIGINAL_STYLE_VAR_OP="-fx-background-color: rgb(247,227,112); -fx-border-width: 0 0 2 0; -fx-border-color: rgb(255,255,255); -fx-border-radius: 6; -fx-background-radius: 6;";
    private final String STYLE_VAR_OP_CLICK="-fx-background-color: rgb(247,227,112); -fx-border-width: 1px; -fx-border-color: rgb(6, 200, 194); -fx-border-radius: 6; -fx-background-radius: 6;";

    /**
     * Il costruttore del Controller prende come parametri il Model e la View.
     * Vengono inoltre chiamati i metodi per inizializzare il tastierino numerico,
     * le operazioni sullo stack e le operazioni di base e i bindings.
     * @param calculator è il Model.
     * @param stackCalculatorView è la View.
     */    
    public StackCalculatorController( StackCalculator stackCalculator, StackCalculatorView stackCalculatorView ) {
        this.stackCalculator = stackCalculator;
        this.stackCalculatorView = stackCalculatorView;
        
        initTastierinoNumerico();
        initOperazioniStack();
        initOperazioniBase();
        initBindings();
        initVariables();
    }
    
    /**
     * Questo metodo è utilizzato per inizializzare tutti i bindings.
     */
    private void initBindings() {
        bindBlankTextArea();
        bindNumbers();
        bindOperatorPressed();
    }
    
    /**
     * Questo metodo stabilisce le condizioni di binding per i bottoni che sono abilitati solo da condizioni sulla text area.
     * ENTER è disabilitato se la text area è vuota o contiene gli operatori usati sulle variabili;
     * CANC, PRODOTTO, DIVISIONE, RADICE, INVERTI_SEGNO, UGUALE sono disabilitati solo a text area vuota.
     */
    private void bindBlankTextArea() {
        /** 
         * il tasto ENTER è disabilitato se la text area è vuota oppure se è presente 
         * una delle operazioni sulle variabili " >", " <", " +", " -". 
         */
        stackCalculatorView.getKey(ENTER.getButton()).disableProperty().bind(Bindings.equal("", stackCalculatorView.getTxtArea().textProperty())
            .or(Bindings.equal(" >", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal(" <", stackCalculatorView.getTxtArea().textProperty()))
            .or(Bindings.equal(" +", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal(" -", stackCalculatorView.getTxtArea().textProperty())));
        /** il tasto CANC è disabilitato se la text area è vuota */
        stackCalculatorView.getKey(CANC.getButton()).disableProperty().bind(Bindings.equal("", stackCalculatorView.getTxtArea().textProperty()));
        /** il tasto PRODOTTO è disabilitato se la text area è vuota */
        stackCalculatorView.getKey(PRODOTTO.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));
        /** il tasto DIVISIONE è disabilitato se la text area è vuota */
        stackCalculatorView.getKey(DIVISIONE.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));;
        /** il tasto CANC è disabilitato se la text area è vuota */
        stackCalculatorView.getKey(RADICE.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));;
        /** il tasto INVERTI SEGNO è disabilitato se la text area è vuota */
        stackCalculatorView.getKey(INVERTI_SEGNO.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));;
        /** il tasto UGUALE è disabilitato se la text area è vuota */
        stackCalculatorView.getKey(UGUALE.getButton()).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));;
    }
    
    /**
     * Questo metodo stabilisce le condizioni di binding per numeri del tastiernino numerico,
     * disabilitato in presenza nella text area degli operatori delle variabili e dei numeri stessi 
     * ad eccezione degli operatori + e - relativi alle operazioni aritmetiche. 
     * Questo perchè + e - verranno gestiti in un metodo distinto data la maggiore complessità.
     */
    private void bindNumbers() {
       /** 
         * azioni relative al tastierino numerico da 1 a 9, sono disattivati se nella text area
         * è presente un'operatore (diverso da "+" o "-") o un'operazione delle variabili.
         */
        for( int i = SETTE.getButton(); i <= UNO.getButton(); i+=5 )
            for( int j = 0; j < 3; j++ )
                stackCalculatorView.getKey(i+j).disableProperty().bind(Bindings.equal("×", stackCalculatorView.getTxtArea().textProperty()).or(Bindings.equal("±", stackCalculatorView.getTxtArea().textProperty()))
                        .or(Bindings.equal("√", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal("÷", stackCalculatorView.getTxtArea().textProperty()))
                        .or(Bindings.equal(" >", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal(" <", stackCalculatorView.getTxtArea().textProperty()))
                        .or(Bindings.equal(" +", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal(" -", stackCalculatorView.getTxtArea().textProperty())));
        
        /**  
         * azioni relative al tasto numerico 0, disattivato se nella text area
         * è presente un'operatore (diverso da "+" o "-") o un'operazione delle variabili.
         */
        stackCalculatorView.getKey(ZERO.getButton()).disableProperty().bind(Bindings.equal("×", stackCalculatorView.getTxtArea().textProperty()).or(Bindings.equal("±", stackCalculatorView.getTxtArea().textProperty()))
                        .or(Bindings.equal("√", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal("÷", stackCalculatorView.getTxtArea().textProperty()))
                        .or(Bindings.equal(" >", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal(" <", stackCalculatorView.getTxtArea().textProperty()))
                        .or(Bindings.equal(" +", stackCalculatorView.getTxtArea().textProperty())).or(Bindings.equal(" -", stackCalculatorView.getTxtArea().textProperty())));
    }
    
    /**
    * Questo metodo stabilisce le condizioni di binding per gli operatori delle variabili " >", " <", " +", " -".
    */
    private void bindOperatorPressed() {
        /** gli operatori " >", " <", " +", " -" sono disattivati se la text area è NON vuota */
        for( int i = MAGGIORE.getButton(); i <= SOTTRAZIONEV.getButton(); i++ )
            stackCalculatorView.getKeyVar(i).disableProperty().bind(Bindings.notEqual("", stackCalculatorView.getTxtArea().textProperty()));
    }
    
    /**
     * Questo metodo riguarda l'inizializzazione delle azioni relative al tastierino numerico.
     */
    private void initTastierinoNumerico() {
        
        /** azioni relative al tastierino numerico da 1 a 9 */
        for( int i = SETTE.getButton(); i <= UNO.getButton(); i+=5 )
            for( int j = 0; j < 3; j++ ) {
                Button b = stackCalculatorView.getKey(i+j);
                b.setOnAction( e -> numberPressed(e) );

                //stile al click da 1 a 9
                b.setOnMousePressed(event -> {
                    b.setStyle(STYLE_NUM_CLICK);
                });
                b.setOnMouseReleased(event ->{
                    b.setStyle(ORIGINAL_STYLE_NUM);
                });
            }
        /** azione relativa al tastierino numerico di . */
        stackCalculatorView.getKey(PUNTO.getButton()).setOnAction( e -> puntoPressed(e) );
        /** imposta uno stile al tasto nel caso di pressione e di rilascio */
        stackCalculatorView.getKey(PUNTO.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(PUNTO.getButton()).setStyle(STYLE_OP_CLICK);
        });     
        stackCalculatorView.getKey(PUNTO.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(PUNTO.getButton()).setStyle(ORIGINAL_STYLE_OP);
        });


        /** azione relativa al tastierino numerico di 0 */
        stackCalculatorView.getKey(ZERO.getButton()).setOnAction( e -> numberPressed(e) );
        /** imposta uno stile al tasto nel caso di pressione e di rilascio */
        stackCalculatorView.getKey(ZERO.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(ZERO.getButton()).setStyle(STYLE_NUM_CLICK);
        });     
        stackCalculatorView.getKey(ZERO.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(ZERO.getButton()).setStyle(ORIGINAL_STYLE_NUM);
        });

        /** azione relativa al tastierino numerico di CANC */
        stackCalculatorView.getKey(CANC.getButton()).setOnAction( e -> cancPressed() );
        /** imposta uno stile al tasto nel caso di pressione e di rilascio */
        stackCalculatorView.getKey(CANC.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(CANC.getButton()).setStyle(STYLE_COM_CLICK);
        });     
        stackCalculatorView.getKey(CANC.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(CANC.getButton()).setStyle(ORIGINAL_STYLE_COM);
        });
    }
    
    /**
     * Questo metodo è utilizzato per ripulire la text area nel caso in cui sia stata causata una
     * situazioe di errore, ovvero nella text area è presente un messaggio del tipo "ERR: <<codice errore>>".
     * 
     * @return un booleano che vale true se nella text area non era presente il messaggio d'errore,
     * false se la text area è stata ripulita dal messaggio d'errore.
     */
    private boolean cleanError() {
        if( stackCalculatorView.getTxtArea().getText().length() > 0 && stackCalculatorView.getTxtArea().getText().charAt(0) == 'E' ) {
            stackCalculatorView.getTxtArea().setText("");
            return false;
        }
        return true;
    }

    /** 
     * Questo metodo rappresenta l'azione da compiere quando viene premuto il tasto del tastierino numerico .
     */
    private void puntoPressed( ActionEvent e ) {
        cleanError();
        try {
            Button b = (Button) e.getSource();
            String txt = stackCalculatorView.getTxtArea().getText();
            if( txt.equals("") ) {
                /** se la text area è vuota allora scrive "0." e disattiva il tasto . */
                stackCalculatorView.getTxtArea().setText("0" + b.getText());
                stackCalculatorView.getKey(PUNTO.getButton()).setDisable(true);
            }
            else {
                char lastC = txt.charAt(txt.length() - 1);
                /** se l'ultimo carattere della text area è "+", "-" o "j allora aggiunge "0." al testo e disattiva il tasto . */
                if( lastC == '+' || lastC == '-' || lastC == 'j' ) {
                    stackCalculatorView.getTxtArea().setText( txt + "0" + b.getText() );
                    stackCalculatorView.getKey(PUNTO.getButton()).setDisable(true);
                    return ;
                }
                for( int i = 48; i <= 57; i++ ) {
                    if( lastC == (char)i ) {
                        /** se l'ultimo carattere della text area è una cifra numerica aggiunge "." al testo e disattiva il tasto . */
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
    
    /**
     * Questo metodo descrive l'azione da compiere quando viene premuto un tasto del tastierino numerico (0 a 9).
     */
    private void numberPressed( ActionEvent e ) {
        cleanError();

        String txt = stackCalculatorView.getTxtArea().getText();
        /** non è possibile inserire più di 4 cifre decimali */
        if(txt.length() > 5 && txt.charAt(txt.length()-5) == '.')
            if( !( txt.charAt(txt.length()-3) == '+' || txt.charAt(txt.length()-3) == '-' || txt.charAt(txt.length()-2) == '+' || txt.charAt(txt.length()-2) == '-') )
            return;
         /** non permette di inserire numeri se ci sono più di 15 caratteri nella text area */
        if(txt.length() > 16)
            return;
        
        Button b = (Button) e.getSource();
        /** aggiunge alla text area la cifra inserita da tastierino */
        stackCalculatorView.getTxtArea().setText( stackCalculatorView.getTxtArea().getText() + b.getText() );
        
        txt = stackCalculatorView.getTxtArea().getText();

        /** è necessario un controllo sul numero di "+" e "-" presenti nella text area. */ 
        /** c è il contatore di "+" o "-" presenti nella text area */
        int c = 0;
        /** 
         * soglia è il numero massimo di "+" o "-" consentiti nella text area, 
         * inizialmente è 1 per reappresentare il segno della parte reale o immaginaria di un numero inserito.
         */
        int soglia = 1;
        for( int i = 0; i < txt.length(); i++ ) {
            /** 
             * se il primo carattere della text area è "+" o "-" allora è stato specificato
             * il segno della parte reale del numero inserito. 
             * Dunque la soglia di "+" o "-" consentiti viene aumentata di 1.
             */
            if( txt.charAt(i) == '+' || txt.charAt(i) == '-' ) {
                if( i == 0 )
                    soglia++;
                c++;
            }
        }
        /** se il numero di "+" e "-" consentiti è minore della soglia allora i pulsanti + e - sono attivi */
        if( c < soglia ) {
            stackCalculatorView.getKey(SOMMA.getButton()).setDisable(false);
            stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(false);
        }
    }
    
    /**
     * Questo metodo rappresenta l'azione da compiere quando viene premuto il tasto CANC.
     */
    private void cancPressed() {
        /** quando viene premuto CANC la text area viene svuotata */
        stackCalculatorView.getTxtArea().setText("");
        /** 
         * quando viene premuto CANC bisogna riattivare i pulsanti "+", "-", "." 
         * che potrebbero essere stati disattivati durante l'inserimento di un numero nella text area.
         */
        stackCalculatorView.getKey(SOMMA.getButton()).setDisable(false);
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(false);
        stackCalculatorView.getKey(PUNTO.getButton()).setDisable(false);
        
        /** 
        * quando viene premuto CANC il tastierino delle variabili viene spento
        * poiché non deve essere possibile inserire una variabile quando la text area è vuota 
        */
        for(int i=4; i<30; i++) {
            stackCalculatorView.getKeyVar(i).setDisable(true);
        }
    }
    
    /**
     * Questo metodo inizializza le azioni relative allo stack e lo stile al click e al rilascio del mouse.
     */
    private void initOperazioniStack() {
        //azione relativa alle operazioni sullo stack di Enter
        stackCalculatorView.getKey(ENTER.getButton()).setOnAction( e -> enterPressed() );
        //stile al click di ENTER
        stackCalculatorView.getKey(ENTER.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(ENTER.getButton()).setStyle(STYLE_COM_CLICK);
        });     
        stackCalculatorView.getKey(ENTER.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(ENTER.getButton()).setStyle(ORIGINAL_STYLE_COM);
        });

        stackCalculatorView.getKey(CLEAR.getButton()).setOnAction( e -> clearPressed() );
        //stile al click di CLEAR
        stackCalculatorView.getKey(CLEAR.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(CLEAR.getButton()).setStyle(STYLE_COM_CLICK);
        });     
        stackCalculatorView.getKey(CLEAR.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(CLEAR.getButton()).setStyle(ORIGINAL_STYLE_COM);
        });

        stackCalculatorView.getKey(DUP.getButton()).setOnAction( e -> dupPressed() );
        //stile al click di DUP
        stackCalculatorView.getKey(DUP.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(DUP.getButton()).setStyle(STYLE_COM_CLICK);
        });
        stackCalculatorView.getKey(DUP.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(DUP.getButton()).setStyle(ORIGINAL_STYLE_COM);
        });
        
        stackCalculatorView.getKey(DROP.getButton()).setOnAction( e -> dropPressed());
        //stile al click di DROP
        stackCalculatorView.getKey(DROP.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(DROP.getButton()).setStyle(STYLE_COM_CLICK);
        });
        stackCalculatorView.getKey(DROP.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(DROP.getButton()).setStyle(ORIGINAL_STYLE_COM);
        });

        //stile al click di SWAP
        stackCalculatorView.getKey(SWAP.getButton()).setOnAction( e -> swapPressed() );
        stackCalculatorView.getKey(SWAP.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(SWAP.getButton()).setStyle(STYLE_COM_CLICK);
        });     
        stackCalculatorView.getKey(SWAP.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(SWAP.getButton()).setStyle(ORIGINAL_STYLE_COM);
        });
        
        stackCalculatorView.getKey(OVER.getButton()).setOnAction( e -> overPressed() );
        //stile al click di OVER
        stackCalculatorView.getKey(OVER.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(OVER.getButton()).setStyle(STYLE_COM_CLICK);
        });
        stackCalculatorView.getKey(OVER.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(OVER.getButton()).setStyle(ORIGINAL_STYLE_COM);
        });
    }
    
    /**
     * Questo metodo definisce l'azione da compiere quando viene premuto ENTER.
     */
    private void enterPressed() {
        if( cleanError() ) {
            /** ENTER funziona solo se nella text area non è presente un messaggio di errore */
            try {
                /** riattiva i pulsanti "+" e "-" e "." */
                stackCalculatorView.getKey(SOMMA.getButton()).setDisable(false);
                stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(false);
                stackCalculatorView.getKey(PUNTO.getButton()).setDisable(false);
                
                /** se l'ultimo carattere dellatext area è . allora aggiunge uno "0" */
                String txt = stackCalculatorView.getTxtArea().getText();
                if( txt.charAt( txt.length() - 1 ) == '.' ) {
                    stackCalculatorView.getTxtArea().setText( txt + '0' );
                }
                
                /** se l'ultimo carattere è "j" aggiunge 1 per favorire il parsing */
                if( txt.charAt( txt.length() - 1 ) == 'j' ) {
                    stackCalculatorView.getTxtArea().setText( txt + '1' );
                }
                
                
                /** chiama il metodo push per inserire il contenuto della text area nello stack */
                stackCalculator.push( stackCalculatorView.getTxtArea().getText() );
                /** aggiorna la view dello stack dopo la push */
                stackCalculatorView.updateListView(stackCalculator.getStack());
                /** ripulisce la text area */
                stackCalculatorView.getTxtArea().setText("");
            } catch( StackPienoException ex ) {
                /** nel caso di stack pieno stampa nella text area il mesaggio di errore */
                stackCalculatorView.getTxtArea().setText("ERR: FULL");
            }
        }
    }
    
    /**
     * Questo metodo definisce l'azione da compiere quando viene premuto CLEAR.
     */
    private void clearPressed() {
        cleanError();
        stackCalculator.clear();
        
        stackCalculatorView.updateListView(stackCalculator.getStack());
    }
    
    /**
     * Questo metodo definisce l'azione da compiere quando viene premuto DUP.
     */
    private void dupPressed() {
        cleanError();
        stackCalculator.dup();
        
        stackCalculatorView.updateListView(stackCalculator.getStack());
    }
    
    /**
     * Questo metodo definisce l'azione da compiere quando viene premuto DROP.
     */
    private void dropPressed() {
        cleanError();
        stackCalculator.drop();
        
        stackCalculatorView.updateListView(stackCalculator.getStack());
    }

    /**
     * Questo metodo definisce l'azione da compiere quando viene premuto SWAP.
     */
    private void swapPressed() {
        cleanError();
        stackCalculator.swap();
        
        stackCalculatorView.updateListView(stackCalculator.getStack());
    }

    /**
     * Questo metodo definisce l'azione da compiere quando viene premuto OVER.
     */
    private void overPressed() {
        cleanError();
        stackCalculator.over();
        
        stackCalculatorView.updateListView(stackCalculator.getStack());
    }
    
    /**
     *  Questo metodo inizializza le azioni relative alle operazioni di base e lo stile al click e al rilascio del mouse.
     */
    public void initOperazioniBase() {
        stackCalculatorView.getKey(PRODOTTO.getButton()).setOnAction( e -> operatorPressed(e) );
        //stile al click di PRODOTTO
        stackCalculatorView.getKey(PRODOTTO.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(PRODOTTO.getButton()).setStyle(STYLE_OP_CLICK);
        });
        stackCalculatorView.getKey(PRODOTTO.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(PRODOTTO.getButton()).setStyle(ORIGINAL_STYLE_OP);
        });
        
        stackCalculatorView.getKey(INVERTI_SEGNO.getButton()).setOnAction( e -> operatorPressed(e) );
        //stile al click di INVERTI_SEGNO
        stackCalculatorView.getKey(INVERTI_SEGNO.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(INVERTI_SEGNO.getButton()).setStyle(STYLE_OP_CLICK);
        });
        stackCalculatorView.getKey(INVERTI_SEGNO.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(INVERTI_SEGNO.getButton()).setStyle(ORIGINAL_STYLE_OP);
        });
        
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setOnAction( e -> sommaSottrazionePressed(e) );
        //stile al click di SOTTRAZIONE
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setStyle(STYLE_OP_CLICK);
        });
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setStyle(ORIGINAL_STYLE_OP);
        });
        
        stackCalculatorView.getKey(RADICE.getButton()).setOnAction( e -> operatorPressed(e) );
        //stile al click di RADICE
        stackCalculatorView.getKey(RADICE.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(RADICE.getButton()).setStyle(STYLE_OP_CLICK);
        });
        stackCalculatorView.getKey(RADICE.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(RADICE.getButton()).setStyle(ORIGINAL_STYLE_OP);
        });
        
        stackCalculatorView.getKey(SOMMA.getButton()).setOnAction( e -> sommaSottrazionePressed(e) );
        //stile al click di SOMMA
        stackCalculatorView.getKey(SOMMA.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(SOMMA.getButton()).setStyle(STYLE_OP_CLICK);
        });     
        stackCalculatorView.getKey(SOMMA.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(SOMMA.getButton()).setStyle(ORIGINAL_STYLE_OP);
        });
        
        stackCalculatorView.getKey(DIVISIONE.getButton()).setOnAction( e -> operatorPressed(e) );
        //stile al click di DIVISIONE
        stackCalculatorView.getKey(DIVISIONE.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(DIVISIONE.getButton()).setStyle(STYLE_OP_CLICK);
        });
        stackCalculatorView.getKey(DIVISIONE.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(DIVISIONE.getButton()).setStyle(ORIGINAL_STYLE_OP);
        });
        
        stackCalculatorView.getKey(UGUALE.getButton()).setOnAction( e -> ugualePressed() );
        //stile al click di UGUALE
        stackCalculatorView.getKey(UGUALE.getButton()).setOnMousePressed(event -> {
            stackCalculatorView.getKey(UGUALE.getButton()).setStyle(STYLE_OP_CLICK);
        });
        stackCalculatorView.getKey(UGUALE.getButton()).setOnMouseReleased(event ->{
            stackCalculatorView.getKey(UGUALE.getButton()).setStyle(ORIGINAL_STYLE_OP);
        });
    }
    
    /**
     * Questo metodo descrive l'azione da compiere quando viene premuto un operatore diverso da "+" e "-".
     * @param e è l'ActionEvent relativo alla pressione del pulsante dell'operatore premuto.
     */
    private void operatorPressed( ActionEvent e ) {

        Button b = (Button) e.getSource();
        /** aggiunge alla text area l'operatore */
        stackCalculatorView.getTxtArea().setText( stackCalculatorView.getTxtArea().getText() + b.getText() );
        /** al click dell'operatore vengono disattivati "+" e "-" */
        stackCalculatorView.getKey(SOMMA.getButton()).setDisable(true);
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(true);
        /** al click dell'operatore viene disattivato "." */
        stackCalculatorView.getKey(PUNTO.getButton()).setDisable(true);
    }
    
    /**
     * Questo metodo definisce l'azione da compiere quando viene premuto un operatore tra "+" e "-". 
     * @param e è l'ActionEvent relativo alla pressione del pulsante dell'operatore premuto.
     */
    private void sommaSottrazionePressed( ActionEvent e ) {
        cleanError();

        Button b = (Button) e.getSource();
        String txt = stackCalculatorView.getTxtArea().getText();
        
        /** crea un booleano che vale true se la text area non è vuota */
        boolean notEmpty = txt.length() > 0;
        
        /** 
         * se la text area non è vuota e l'ultimo carattere è "." 
         * allora aggiunge al testo "0", l'operatore premuto e "j".
         */
        if( notEmpty && txt.charAt(txt.length()-1) == '.' )
            stackCalculatorView.getTxtArea().setText( txt + "0" + b.getText() + "j" );
        else if( notEmpty )
            /** 
             * altrimenti, se la text area non è vuota e l'ultimo carattere non è "." allora
             * concatena il contenuto della text area con l'operatore e il carattere "j".
             */
            stackCalculatorView.getTxtArea().setText( txt + b.getText() + "j" );
        else
            /** altrimenti concatena il contenuto della text area con l'operatore scelto. */
            stackCalculatorView.getTxtArea().setText( txt + b.getText() );
        
        //disattivo + e -
        stackCalculatorView.getKey(SOMMA.getButton()).setDisable(true);
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(true);
        
        /*
        int c = 0;
        for( int i = 0; i < txt.length(); i++ ) {
            if( txt.charAt(i) == '+' || txt.charAt(i) == '-' ) {
                c++;
            }
        }
        if( c < 2 ) {
            stackCalculatorView.getKey(PUNTO.getButton()).setDisable(false);
        }
        */
        
        stackCalculatorView.getKey(PUNTO.getButton()).setDisable(false);
        stackCalculatorView.updateListView(stackCalculator.getStack());
    }
    
    /**
     * Questo metodo definisce l'azione da compuere quando viene premuto "=".
     */
    private void ugualePressed() {
        try {
            /** chiama il metodo calcola del Model */
            stackCalculator.calcola();
        } catch (InvalidOrderException ex) {
            /** nel caso di sequenza invalida stampa il messaggio di errore opportuno */
            stackCalculatorView.getTxtArea().setText("ERR: INV_SEQ");
        } finally {
            /** in ogni caso procede ad aggiornare la view dello stack */
            stackCalculatorView.updateListView(stackCalculator.getStack());
        }
    }
    
    /**
     * Questo metodo inizializza le variabili e i relativi operatori
     * associando a ciascun pulsante un'azione ed uno stile. 
     */
    private void initVariables() {
        for(int i=0; i<4; i++){
            /** associa agli operatori delle variabili l'azione e lo stile */
            Button var=stackCalculatorView.getKeyVar(i);
            var.setOnAction( e -> varOperatorPressed(e) );
            
            //stile al click degli operatori sulle variabili
            var.setOnMousePressed(event -> {
                var.setStyle(STYLE_VAR_OP_CLICK);
            });
            var.setOnMouseReleased(event ->{
                var.setStyle(ORIGINAL_STYLE_VAR_OP);
            });
        }
        /** 
         * associa alle variabili l'azione e lo stile.
         * 'a' si trova all'indice 4 della griglia di VariableView. 
         */
        for(int i=4; i<30; i++) {
            Button var=stackCalculatorView.getKeyVar(i);
            var.setOnAction( e -> variablePressed(e) );
            var.setDisable(true);
            
            //stile al click delle variabili
            var.setOnMousePressed(event -> {
                var.setStyle(STYLE_VAR_CLICK);
            });
            var.setOnMouseReleased(event ->{
                var.setStyle(ORIGINAL_STYLE_VAR);
            });
        }
    }
    
    /**
     * Questo metodo definisce l'azione da compiere quando viene premuto un operatore delle variabili.
     * @param e è l'ActionEvent relativo alla pressione di un operatore delle variabili.
     */
    private void varOperatorPressed( ActionEvent e ) {
        /** quando viene premuto un operatore delle variabili i pulsanti delle variabili diventano attivi. */
        for(int i=4; i<30; i++) {
            stackCalculatorView.getKeyVar(i).setDisable(false);
        }

        /** 
         * quando viene premuto un operatore delle variabili si procede a disabilitare ".", "+", "-"
         * poiché questi non vengono disattivati da text area non vuota.
         */
        stackCalculatorView.getKey(PUNTO.getButton()).setDisable(true);
        stackCalculatorView.getKey(SOMMA.getButton()).setDisable(true);
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(true);

        Button b = (Button)e.getSource();
        /** 
         * quando viene premuto un operatore delle variabili viene aggiunto uno spazio vuoto
         * seguito dal simbolo dell'operatore, questo viene fatto per differenziare gli operatori 
         * delle variabili dagli operatori di base, in particolar modo per gli operatori 
         * "+" e "-" che altrimenti causerebbero ambiguità.
         */
        stackCalculatorView.getTxtArea().setText( " " + b.getText() );
    }
    
    /**
     * Questo metodo definisce l'azione da compiere quando vengono premuti i tasti relativi alle variabili.
     * @param e è l'ActionEvent relativo alla pressione di una variabile.
     */
    private void variablePressed( ActionEvent e ) {
        /** quando viene premuta una variabile allora queste vengono spente */
        for(int i=4; i<30; i++) {
            stackCalculatorView.getKeyVar(i).setDisable(true);
        }
        String txt = stackCalculatorView.getTxtArea().getText();
        Button b = (Button) e.getSource();
        /** calcolo l'indice nella view della variabile premuta */
        int varIndex = ((int) b.getText().charAt(0)) - 97;
        /** svuota la text area dopo aver premuto la variabile */
        stackCalculatorView.getTxtArea().setText("");
        /** riattiva i pulsanti ".", "+", "-" */
        stackCalculatorView.getKey(PUNTO.getButton()).setDisable(false);
        stackCalculatorView.getKey(SOMMA.getButton()).setDisable(false);
        stackCalculatorView.getKey(SOTTRAZIONE.getButton()).setDisable(false);
        
        /**
         * controlla il secondo carattere della text area che corrisponde all'operatore inserito precedentemente.
         * l'operatore è il secondo carattere perché il primo è uno spazio vuoto.
         */
        switch (txt.charAt(1)) {
            case '>':
            {
                try {
                    /** 
                     * nel caso l'operatore sia " >" viene chiamato il metodo loadVariable del Model
                     * e viene visualizzato il valore caricato di fianco alla variabile nel tastierino delle variabili.
                     */
                    stackCalculator.loadVariable( varIndex );
                    b.setText( b.getText().charAt(0) + ": " + stackCalculator.getVariable( varIndex ) );
                } catch (StackVuotoException ex) {
                    /** nel caso di stack vuoto stampa il messaggio di errore relativo */
                    stackCalculatorView.getTxtArea().setText("ERR: EMPTY");
                } catch (TopElementInvalidException ex) {
                    /** nel caso di top element invalido (non un numero) stampa il messaggio di errore relativo */
                    stackCalculatorView.getTxtArea().setText("ERR: TOP_INV");
                }
            }
                break;

            case '<':
            {
                try {
                    /** 
                     * nel caso l'operatore sia " <" viene chiamato il metodo storeVariable del Model.
                     */
                    stackCalculator.storeVariable( varIndex );
                } catch (StackPienoException ex) {
                    /** nel caso di stack pieno stampa il messaggio di errore relativo */
                    stackCalculatorView.getTxtArea().setText("ERR: FULL");
                }
            }
                break;

            case '+':
            {
                try {
                    /** 
                     * nel caso l'operatore sia " +" viene chiamato il metodo addVariable del Model sull'indice della variabile
                     * e viene visualizzato il valore della variabile aggiornato di fianco
                     * alla variabile nel tastierino delle variabili.
                     */
                    stackCalculator.addVariable( varIndex );
                    b.setText( b.getText().charAt(0) + ": " + stackCalculator.getVariable( varIndex ) );
                } catch (StackVuotoException ex) {
                    /** nel caso di stack vuoto stampa il messaggio di errore relativo */
                    stackCalculatorView.getTxtArea().setText("ERR: EMPTY");
                } catch (TopElementInvalidException ex) {
                    /** nel caso di top element invalido (non un numero) stampa il messaggio di errore relativo */
                    stackCalculatorView.getTxtArea().setText("ERR: TOP_INV");
                }
            }
                break;

            case '-':
            {
                try {
                    /** 
                     * nel caso l'operatore sia " -" viene chiamato il metodo subtractVariable del Model sull'indice della variabile
                     * e viene visualizzato il valore della variabile aggiornato di fianco
                     * alla variabile nel tastierino delle variabili.
                     */
                    stackCalculator.subtractVariable( varIndex );
                    b.setText( b.getText().charAt(0) + ": " + stackCalculator.getVariable( varIndex ) );
                } catch (StackVuotoException ex) {
                    /** nel caso di stack vuoto stampa il messaggio di errore relativo */
                    stackCalculatorView.getTxtArea().setText("ERR: EMPTY");
                } catch (TopElementInvalidException ex) {
                    /** nel caso di top element invalido (non un numero) stampa il messaggio di errore relativo */
                    stackCalculatorView.getTxtArea().setText("ERR: TOP_INV");
                }
            }
                break;

            default:
                /** il caso default non è mai raggiungibile secondo l'implementazione */
                break;
        }
        /** in ogni caso aggiorna la view dello stack */
        stackCalculatorView.updateListView(stackCalculator.getStack());
    }
}
