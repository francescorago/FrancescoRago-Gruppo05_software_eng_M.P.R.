package com.mycompany.calculator_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Graphic.fxml"));
        Parent root = loader.load();

        // Crea il controller
        CalculatorController controller = loader.getController();

        // Inizializza il tuo stack, VariableManager e CalculatorOperations
        Stack stack = new Stack();
        VariableManager variableManager = new VariableManager();
        CalculatorOperations calculatorOperations = new CalculatorOperations(stack);

        // Associa lo stack, VariableManager e CalculatorOperations al controller
        
        controller.setVariableManager(variableManager);
        controller.setCalculatorOperations(calculatorOperations);

        // Imposta la scena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calcolatrice Scientifica");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}