/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.List;
import javafx.scene.control.ListCell;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class CalculatorController implements Initializable {


    // Altri elementi del controller...
    
    private Stack stack;
    private VariableManager variableManager;
    private CalculatorOperations calculatorOperations;
    @FXML
    private TextField textDisplay;
    private int decimalClick = 0;
    @FXML
    private ListView<String> stackDisplay;
    private ObservableList<String> stackItems;
    
    private ObservableList<String> variableValues;
    private Map<String, String> variableValuesDisplayMap;
    private ObservableList<String> alphabetLetters;
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    
    @FXML
    private ListView<String> variablesDisplay;
    private Map<String, ComplexNumber> variableMap;

    public void setVariableManager(VariableManager variableManager) {
        this.variableManager = variableManager;
    }

    public void setCalculatorOperations(CalculatorOperations calculatorOperations) {
        this.calculatorOperations = calculatorOperations;
    }

   
    //controllo generale
    @Override
public void initialize(URL url, ResourceBundle rb) {
    // TODO
    stackItems = FXCollections.observableArrayList();
    stackDisplay.setItems(stackItems);

    variableValues = FXCollections.observableArrayList();
    variableMap = new HashMap<>();

    for (char letter : alphabet.toCharArray()) {
        variableMap.put(String.valueOf(letter), new ComplexNumber());
     variableValues.add(letter + ": " + variableMap.get(String.valueOf(letter))); // Inizializza a "lettera generica : 0"
    }

      variablesDisplay.setItems(variableValues);
    variablesDisplay.setCellFactory(param -> new ListCell<String>() {
        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(item);
        }
    });
}   
  


    
 


    @FXML
    private void Operation(ActionEvent event) {
    String digitObject = ((Button)event.getSource()).getText();
      
    String currentText = textDisplay.getText();
    textDisplay.setText(currentText + digitObject);
    }

  @FXML
private void decimal(ActionEvent event) {
    String decimalObject = ((Button)event.getSource()).getText();

    // Verifica se l'utente sta inserendo nella parte reale o immaginaria
    if (textDisplay.getText().isEmpty() || textDisplay.getText().endsWith("+") || textDisplay.getText().endsWith("-")) {
        // Inserimento nella parte reale
        if (decimalClick == 0) {
            textDisplay.appendText(decimalObject);
            decimalClick = 1;
        }
    } else {
        // Inserimento nella parte immaginaria
        String[] parts = textDisplay.getText().split("(?=[+-])");
        String lastPart = parts[parts.length - 1];

        if (!lastPart.contains(".") || !decimalObject.equals(".")) {
            textDisplay.appendText(decimalObject);
            decimalClick = 1;
        }
    }
}
//controllo operazioni
    
   @FXML
private void enter(ActionEvent event) {
    try {
        String complexNumberText = textDisplay.getText();
        ComplexNumber complexNumber = new ComplexNumber(complexNumberText);

        stackItems.add(complexNumber.toString()); // Aggiunge il numero complesso confermato alla ListView
        textDisplay.clear(); // Svuota il campo di testo dopo la conferma
        decimalClick = 0;
    } catch (NumberFormatException e) {
        System.out.println("Inserimento non valido. Inserisci un numero complesso valido.");
    }
}


    @FXML
    private void add(ActionEvent event) {
          ObservableList<String> stackItems = stackDisplay.getItems();

        if (stackItems.size() >= 2) {
            try {
                ComplexNumber num1 = new ComplexNumber(stackItems.get(stackItems.size() - 1));
                ComplexNumber num2 = new ComplexNumber(stackItems.get(stackItems.size() - 2));

                ComplexNumber result = num1.add(num2);

                stackItems.remove(stackItems.size() - 1);
                stackItems.remove(stackItems.size() - 1);

                stackItems.add(result.toString());
            } catch (NumberFormatException e) {
                System.out.println("Errore durante la somma: numeri non validi nello stack");
            }
        } else {
            System.out.println("Impossibile eseguire la somma: meno di due numeri nello stack");
        }
    }

    @FXML
    private void sub(ActionEvent event) {
        ObservableList<String> stackItems = stackDisplay.getItems();

        if (stackItems.size() >= 2) {
            try {
                ComplexNumber num1 = new ComplexNumber(stackItems.get(stackItems.size() - 1));
                ComplexNumber num2 = new ComplexNumber(stackItems.get(stackItems.size() - 2));

                ComplexNumber result = num1.subtract(num2);

                stackItems.remove(stackItems.size() - 1);
                stackItems.remove(stackItems.size() - 1);

                stackItems.add(String.valueOf(result));
            } catch (NumberFormatException e) {
                System.out.println("Errore durante la sottrazione: numeri non validi nello stack");
            }
        } else {
            System.out.println("Impossibile eseguire la sottrazione: meno di due numeri nello stack");
        }
    }

    @FXML
    private void mul(ActionEvent event) {
        ObservableList<String> stackItems = stackDisplay.getItems();

        if (stackItems.size() >= 2) {
            try {
                ComplexNumber num1 = new ComplexNumber(stackItems.get(stackItems.size() - 1));
                ComplexNumber num2 = new ComplexNumber(stackItems.get(stackItems.size() - 2));

                ComplexNumber result = num1.multiply(num2);

                stackItems.remove(stackItems.size() - 1);
                stackItems.remove(stackItems.size() - 1);

                stackItems.add(String.valueOf(result));
            } catch (NumberFormatException e) {
                System.out.println("Errore durante la moltiplicazione: numeri non validi nello stack");
            }
        } else {
            System.out.println("Impossibile eseguire la moltiplicazione: meno di due numeri nello stack");
        }
    }
    
   @FXML
private void div(ActionEvent event) {
    ObservableList<String> stackItems = stackDisplay.getItems();

    if (stackItems.size() >= 2) {
        try {
            ComplexNumber num1 = new ComplexNumber(stackItems.get(stackItems.size() - 1));
            ComplexNumber num2 = new ComplexNumber(stackItems.get(stackItems.size() - 2));

            if (num2.getReal() == 0 && num2.getImag() == 0) {
                throw new ArithmeticException("Divisione per zero non consentita.");
            }

            ComplexNumber result = num1.divide(num2);

            stackItems.remove(stackItems.size() - 1);
            stackItems.remove(stackItems.size() - 1);

            stackItems.add(String.valueOf(result));
        } catch (NumberFormatException e) {
            System.out.println("Errore durante la divisione: numeri non validi nello stack");
        } catch (ArithmeticException e) {
            System.out.println("Errore durante la divisione: " + e.getMessage());
        }
    } else {
        System.out.println("Impossibile eseguire la divisione: meno di due numeri nello stack");
    }
}


    
    @FXML
    private void sqrt(ActionEvent event) {
        ObservableList<String> stackItems = stackDisplay.getItems();

        if (!stackItems.isEmpty()) {
            try {
                ComplexNumber num1 = new ComplexNumber(stackItems.get(stackItems.size() - 1));

                ComplexNumber result = num1.squareRoot();

                stackItems.remove(stackItems.size() - 1);

                stackItems.add(String.valueOf(result));
            } catch (NumberFormatException e) {
                System.out.println("Errore durante il calcolo della radice quadrata: numero non valido nello stack");
            }
        } else {
            System.out.println("Impossibile eseguire la radice quadrata: stack vuoto");
        }
    }
    
    @FXML
    private void inv(ActionEvent event) {
        ObservableList<String> stackItems = stackDisplay.getItems();

        if (!stackItems.isEmpty()) {
            try {
                ComplexNumber num1 = new ComplexNumber(stackItems.get(stackItems.size() - 1));

                 ComplexNumber result = num1.inv();
                
                stackItems.remove(stackItems.size() - 1);
                
                stackItems.add(String.valueOf(result));
            } catch (NumberFormatException e) {
                System.out.println("Errore durante il calcolo dell'inverti segno: numero non valido nello stack");
            }
        } else {
            System.out.println("Impossibile eseguire l'inverti segno: stack vuoto");
        }
    }
    //controllo dello stack 
     private void pushToStack(ComplexNumber value) {
        stackItems.add(value.toString());
    }

    private ComplexNumber popFromStack() {
        if (!stackItems.isEmpty()) {
            String stackTop = stackItems.remove(stackItems.size() - 1);
            return new ComplexNumber(stackTop);
        } else {
            System.out.println("Lo stack è vuoto.");
            return new ComplexNumber(); // Ritorna zero se lo stack è vuoto
        }
    }

    @FXML
    private void clear(ActionEvent event) {
        ObservableList<String> stackItems = stackDisplay.getItems();
        stackItems.clear();
    }

    @FXML
    private void dup(ActionEvent event) {
        ObservableList<String> stackItems = stackDisplay.getItems();

        if (!stackItems.isEmpty()) {
            String lastItem = stackItems.get(stackItems.size() - 1);
            stackItems.add(lastItem);
        } else {
            System.out.println("Impossibile eseguire il duplicato: stack vuoto");
    }
    }

    @FXML
    private void drop(ActionEvent event) {
        if (!stackItems.isEmpty()) {
           stackItems.remove(stackItems.size() - 1);
        } else {
           System.out.println("Impossibile eseguire la cancellazione: stack vuoto");
        }
    }

    @FXML
    private void swap(ActionEvent event) {
        ObservableList<String> stackItems = stackDisplay.getItems();

        if (stackItems.size() >= 2) {
            int lastIndex = stackItems.size() - 1;
            String lastItem = stackItems.remove(lastIndex);
            String secondLastItem = stackItems.remove(lastIndex - 1);
            stackItems.add(lastItem);
            stackItems.add(secondLastItem);
        } else {
            System.out.println("Impossibile eseguire lo scambio: meno di due numeri nello stack");
    }
    }

    
    @FXML
    private void over(ActionEvent event) {
       ObservableList<String> stackItems = stackDisplay.getItems();

    if (stackItems.size() >= 2) {
        String secondLastItem = stackItems.get(stackItems.size() - 2);
        stackItems.add(secondLastItem);
    } else {
        System.out.println("Impossibile eseguire l'operazione 'over': meno di due numeri nello stack");
    }
    }
    
    @FXML
    private void canc(ActionEvent event) {
        String currentText = textDisplay.getText();
       if (!currentText.isEmpty()) {
        // Rimuove l'ultimo carattere dalla stringa
        currentText = currentText.substring(0, currentText.length() - 1);
        textDisplay.setText(currentText);
       }
    }
      
    
    
 private void updateVariableDisplay(String variable) {
    ComplexNumber value = variableMap.get(variable);
    String displayText = variable + ": " + value;
    int index = alphabet.indexOf(variable);
    variableValues.set(index, displayText);
}
    

   @FXML
    private void variables(ActionEvent event) {
        String buttonText = ((Button) event.getSource()).getText();
        textDisplay.appendText(buttonText);
        updateVariableDisplay(buttonText);
    }

    @FXML
    private void saveToVariable(ActionEvent event) {
        String variable = textDisplay.getText();
        if (variable.length() == 1 && variableMap.containsKey(variable)) {
            ComplexNumber value = popFromStack();
            variableMap.put(variable, value);
            updateVariableDisplay(variable);
        } else {
            System.out.println("Operazione non valida: selezionare una variabile dall'alfabeto.");
        }
    }

    @FXML
    private void pushFromVariable(ActionEvent event) {
        String variable = textDisplay.getText();
        if (variable.length() == 1 && variableMap.containsKey(variable)) {
            pushToStack(variableMap.get(variable));
            updateVariableDisplay(variable);
        } else {
            System.out.println("Operazione non valida: selezionare una variabile dall'alfabeto.");
        }
    }

    @FXML
    private void addToVariable(ActionEvent event) {
        performOperationOnVariable('+');
    }

    @FXML
    private void subtractFromVariable(ActionEvent event) {
        performOperationOnVariable('-');
    }

    private void performOperationOnVariable(char operation) {
        String variable = textDisplay.getText();
        if (variable.length() == 1 && variableMap.containsKey(variable)) {
            ComplexNumber stackTop = popFromStack();
            ComplexNumber currentValue = variableMap.get(variable);

            switch (operation) {
                case '+':
                    variableMap.put(variable, currentValue.add(stackTop));
                    break;
                case '-':
                    variableMap.put(variable, currentValue.subtract(stackTop));
                    break;
            }

            pushToStack(variableMap.get(variable));
            updateVariableDisplay(variable);
        } else {
            System.out.println("Operazione non valida: selezionare una variabile dall'alfabeto.");
        }
    }

   

}