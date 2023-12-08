/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AH.gruppo14.stackbasedcalculator_gruppo14_ref;

import Eccezioni.InvalidOrderException;
import Eccezioni.StackPienoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 *
 * @author Gruppo14
 */
public class StackCalculatorController {

    CalculatorView calculatorView;
    Calculator calculator;

    public StackCalculatorController(Calculator calculator, StackCalculatorView stackCalculatorView) {
        this.calculator = calculator;
        this.calculatorView = calculatorView;

        initTastierinoNumerico();
        initOperazioniStack();
        initOperazioniBase();
        initBindings();
    }

    // inizializzazione dei bindings
    private void initBindings() {
        bindEnter();
        bindCanc();
        bindProdotto();
        bindDivisione();
        bindRadice();
        bindInvertiSegno();
        bindUguale();
        bindNumbers();
    }

    // condizioni di binding per Enter
    private void bindEnter() {
        calculatorView.keys[calculatorView.ENTER].disableProperty()
                .bind(Bindings.equal("", calculatorView.txtArea.textProperty()));
    }

    // condizioni di binding per Canc
    private void bindCanc() {
        calculatorView.keys[calculatorView.CANC].disableProperty()
                .bind(Bindings.equal("", calculatorView.txtArea.textProperty()));
    }

    // condizioni di binding per Prodotto
    private void bindProdotto() {
        calculatorView.keys[calculatorView.PRODOTTO].disableProperty()
                .bind(Bindings.notEqual("", calculatorView.txtArea.textProperty()));
    }

    // condizioni di binding per Divisione
    private void bindDivisione() {
        calculatorView.keys[calculatorView.DIVISIONE].disableProperty()
                .bind(Bindings.notEqual("", calculatorView.txtArea.textProperty()));
    }

    // condizioni di binding per Radice
    private void bindRadice() {
        calculatorView.keys[calculatorView.RADICE].disableProperty()
                .bind(Bindings.notEqual("", calculatorView.txtArea.textProperty()));
    }

    // condizioni di binding per Inverti Segno
    private void bindInvertiSegno() {
        calculatorView.keys[calculatorView.INVERTI_SEGNO].disableProperty()
                .bind(Bindings.notEqual("", calculatorView.txtArea.textProperty()));
    }

    // condizione di binding per Uguale
    private void bindUguale() {
        calculatorView.keys[calculatorView.UGUALE].disableProperty()
                .bind(Bindings.notEqual("", calculatorView.txtArea.textProperty()));
    }

    // WIP
    // condizione di binding per numeri del tastiernino numerico
    private void bindNumbers() {
        // azioni relative al tastierino numerico da 1 a 9
        for (int i = calculatorView.SETTE; i <= calculatorView.UNO; i += 5)
            for (int j = 0; j < 3; j++)
                calculatorView.keys[i + j].disableProperty()
                        .bind(Bindings.equal("×", calculatorView.txtArea.textProperty())
                                .or(Bindings.equal("±", calculatorView.txtArea.textProperty()))
                                .or(Bindings.equal("√", calculatorView.txtArea.textProperty()))
                                .or(Bindings.equal("÷", calculatorView.txtArea.textProperty())));

        // azioni relative al tastierino numerico di ENTER
        calculatorView.keys[calculatorView.ZERO].disableProperty()
                .bind(Bindings.equal("×", calculatorView.txtArea.textProperty())
                        .or(Bindings.equal("±", calculatorView.txtArea.textProperty()))
                        .or(Bindings.equal("√", calculatorView.txtArea.textProperty()))
                        .or(Bindings.equal("÷", calculatorView.txtArea.textProperty())));
    }

    // inizializzazione delle azioni relative al tastierino numerico
    private void initTastierinoNumerico() {

        // azioni relative al tastierino numerico da 1 a 9
        for (int i = calculatorView.SETTE; i <= calculatorView.UNO; i += 5)
            for (int j = 0; j < 3; j++)
                calculatorView.keys[i + j].setOnAction(e -> numberPressed(e));

        // azione relativa al tastierino numerico di .
        calculatorView.keys[calculatorView.PUNTO].setOnAction(e -> puntoPressed(e));

        // azione relativa al tastierino numerico di 0
        calculatorView.keys[calculatorView.ZERO].setOnAction(e -> numberPressed(e));

        // azione relativa al tastierino numerico di CANC
        calculatorView.keys[calculatorView.CANC].setOnAction(e -> cancPressed());
    }

    // azione da compiere quando viene premuto il tasto del tastierino numerico .
    private void puntoPressed(ActionEvent e) {
        try {
            Button b = (Button) e.getSource();
            String txt = calculatorView.txtArea.getText();
            if (txt.equals("")) {
                calculatorView.txtArea.setText("0" + b.getText());
                calculatorView.keys[calculatorView.PUNTO].setDisable(true);
            } else {
                char lastC = txt.charAt(txt.length() - 1);
                if (lastC == '+' || lastC == '-' || lastC == 'j') {
                    calculatorView.txtArea.setText(txt + "0" + b.getText());
                    calculatorView.keys[calculatorView.PUNTO].setDisable(true);
                    return;
                }
                for (int i = 48; i <= 57; i++) {
                    if (lastC == (char) i) {
                        calculatorView.txtArea.setText(txt + b.getText());
                        calculatorView.keys[calculatorView.PUNTO].setDisable(true);
                        return;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("errore:");
            ex.printStackTrace();
        }
    }

    // azione da compiere quando viene premuto un tasto del tastierino numerico (0 a
    // 9)
    private void numberPressed(ActionEvent e) {
        if (calculatorView.txtArea.getText().equals("FULL"))
            calculatorView.txtArea.setText("");

        Button b = (Button) e.getSource();
        calculatorView.txtArea.setText(calculatorView.txtArea.getText() + b.getText());

        /*
         * Pattern pattern =
         * Pattern.compile("(\\\\+[^+-]*\\\\+)|(-[^+-]*-)|(\\\\+-)|(\\\\-\\\\+)");
         * Matcher matcher = pattern.matcher(calculatorView.txtArea.getText());
         * if (!matcher.find()) {
         * calculatorView.keys[calculatorView.SOMMA].setDisable(false);
         * calculatorView.keys[calculatorView.SOMMA].setDisable(false);
         * }
         */

        String txt = calculatorView.txtArea.getText();
        int c = 0;
        int soglia = 1;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '+' || txt.charAt(i) == '-') {
                if (i == 0)
                    soglia++;
                c++;
            }
        }
        if (c < soglia) {
            calculatorView.keys[calculatorView.SOMMA].setDisable(false);
            calculatorView.keys[calculatorView.SOTTRAZIONE].setDisable(false);
        }

        calculatorView.stackView.updateListView(calculator.stack);
    }

    // azione da compiere quando viene premuto il tasto CANC
    private void cancPressed() {
        calculatorView.txtArea.setText("");
        // riaattivo + e -
        calculatorView.keys[calculatorView.SOMMA].setDisable(false);
        calculatorView.keys[calculatorView.SOTTRAZIONE].setDisable(false);
        calculatorView.keys[calculatorView.PUNTO].setDisable(false);

        calculatorView.stackView.updateListView(calculator.stack);
    }

    // inizializzazione delle azioni relative allo stack
    private void initOperazioniStack() {
        // azione relativa alle operazioni sullo stack di Enter
        calculatorView.keys[calculatorView.ENTER].setOnAction(e -> enterPressed());
        calculatorView.keys[calculatorView.CLEAR].setOnAction(e -> clearPressed());
        calculatorView.keys[calculatorView.DUP].setOnAction(e -> dupPressed());
        calculatorView.keys[calculatorView.DROP].setOnAction(e -> dropPressed());
        calculatorView.keys[calculatorView.SWAP].setOnAction(e -> swapPressed());
        calculatorView.keys[calculatorView.OVER].setOnAction(e -> overPressed());
    }

    // azione da compiere quando viene premuto Enter
    private void enterPressed() {
        try {
            // riaattivo + e -
            calculatorView.keys[calculatorView.SOMMA].setDisable(false);
            calculatorView.keys[calculatorView.SOTTRAZIONE].setDisable(false);
            calculatorView.keys[calculatorView.PUNTO].setDisable(false);

            // aggiungere 0 se last character è .
            String txt = calculatorView.txtArea.getText();
            if (txt.charAt(txt.length() - 1) == '.') {
                calculatorView.txtArea.setText(txt + '0');
            }

            // per aggiungere 1 post j, risolto in parsing
            if (txt.charAt(txt.length() - 1) == 'j') {
                calculatorView.txtArea.setText(txt + '1');
            }

            // carico nello stack il valore nella text area
            calculator.push(calculatorView.txtArea.getText());
            calculatorView.stackView.updateListView(calculator.stack);
            // pulisco text area
            calculatorView.txtArea.setText("");
        } catch (StackPienoException ex) {
            calculatorView.txtArea.setText("FULL");
        }

        /* AGGIORNA STACK */

    }

    private void clearPressed() {
        calculator.clear();

        calculatorView.stackView.updateListView(calculator.stack);
    }

    private void dupPressed() {
        calculator.dup();

        calculatorView.stackView.updateListView(calculator.stack);
    }

    private void dropPressed() {
        calculator.drop();

        calculatorView.stackView.updateListView(calculator.stack);
    }

    private void swapPressed() {
        calculator.swap();

        calculatorView.stackView.updateListView(calculator.stack);
    }

    private void overPressed() {
        calculator.over();

        calculatorView.stackView.updateListView(calculator.stack);
    }

    // inizializzazione delle azioni relative alle operazioni di base
    public void initOperazioniBase() {
        calculatorView.keys[calculatorView.PRODOTTO].setOnAction(e -> operatorPressed(e));
        calculatorView.keys[calculatorView.INVERTI_SEGNO].setOnAction(e -> operatorPressed(e));
        calculatorView.keys[calculatorView.SOTTRAZIONE].setOnAction(e -> sommaSottrazionePressed(e));
        calculatorView.keys[calculatorView.RADICE].setOnAction(e -> operatorPressed(e));
        calculatorView.keys[calculatorView.SOMMA].setOnAction(e -> sommaSottrazionePressed(e));
        calculatorView.keys[calculatorView.DIVISIONE].setOnAction(e -> operatorPressed(e));
        calculatorView.keys[calculatorView.UGUALE].setOnAction(e -> ugualePressed());
    }

    // azione da compiere quando viene premuto un operatore
    private void operatorPressed(ActionEvent e) {
        if (calculatorView.txtArea.getText().equals("FULL"))
            calculatorView.txtArea.setText("");

        Button b = (Button) e.getSource();
        calculatorView.txtArea.setText(calculatorView.txtArea.getText() + b.getText());
        // disattivo + e -
        calculatorView.keys[calculatorView.SOMMA].setDisable(true);
        calculatorView.keys[calculatorView.SOTTRAZIONE].setDisable(true);

        calculatorView.stackView.updateListView(calculator.stack);
    }

    private void sommaSottrazionePressed(ActionEvent e) {
        Button b = (Button) e.getSource();
        String txt = calculatorView.txtArea.getText();

        boolean notEmpty = txt.length() > 0;

        if (notEmpty && txt.charAt(txt.length() - 1) == '.')
            calculatorView.txtArea.setText(txt + "0" + b.getText() + "j");
        else if (notEmpty)
            calculatorView.txtArea.setText(txt + b.getText() + "j");
        else
            calculatorView.txtArea.setText(txt + b.getText());

        // disattivo + e -
        calculatorView.keys[calculatorView.SOMMA].setDisable(true);
        calculatorView.keys[calculatorView.SOTTRAZIONE].setDisable(true);

        int c = 0;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == '+' || txt.charAt(i) == '-') {
                c++;
            }
        }
        if (c < 2) {
            calculatorView.keys[calculatorView.PUNTO].setDisable(false);
        }

        calculatorView.stackView.updateListView(calculator.stack);
    }

    private void ugualePressed() {
        try {
            calculator.calcola();

            calculatorView.stackView.updateListView(calculator.stack);
        } catch (InvalidOrderException ex) {
            calculatorView.txtArea.setText("INV_SEQ");
        }

    }

}
