package AH.gruppo14.stackbasedcalculator_gruppo14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * classe principale dell'applicativo realizzato, estende Application come
 * previsto da JavaFX
 * @author Gruppo14
 */
public class StackBasedCalculator extends Application {

    /**
     * il metodo start inizializza Model e View, dopodiché inizializza il
     * Controller e gli passa le reference alle due componenti sopra citate
     * vengono anche definiti dettagli quali l'icona dell'applicativo, la dimensione
     * della scena e il "titolo" dell'applicativo
     * @param stage parametro obbligatorio del metodo start
     */
    @Override
    public void start(Stage stage) {
        try {
            StackCalculator stackCalculator = new StackCalculator();
            StackCalculatorView root = new StackCalculatorView( stackCalculator.getStack() );
            StackCalculatorController stackCalculatorController = new StackCalculatorController(stackCalculator, root);

            Scene scene = new Scene(root, 1490, 600);
            
            //settiamo l'icona dell'app
            Image image = new Image("/AH/gruppo14/stackbasedcalculator_gruppo14/CalculatorIcon.png");
            stage.getIcons().add(image);
            
            stage.setTitle("StackBasedCalculator_ABFA-14");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            System.out.println("La causa è: ");
            e.printStackTrace();
        }
    }

    /**
     * entry-point dell'applicativo, lancia il metodo launch() come previsto
     * da JavaFX
     * @param args vettore dei parametri passabili da riga di comando
     */
    public static void main(String[] args) {
        launch();
    }

}