package AH.gruppo14.stackbasedcalculator_gruppo14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class StackBasedCalculator extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Calculator calculator = new Calculator();
            BaseView root = new BaseView();
            CalculatorController calculatorController = new CalculatorController(calculator, root);

            Scene scene = new Scene(root, 550, 250);

            stage.setTitle("MyCalculator");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            System.out.println("La causa è: ");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}