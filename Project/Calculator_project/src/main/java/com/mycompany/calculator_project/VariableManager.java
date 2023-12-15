/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator_project;

/**
 *
 * @author Lenovo
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class VariableManager {

    private Map<Character, ComplexNumber> variables;
    private Stack<ComplexNumber> stack;

    public VariableManager() {
        this.variables = new HashMap<>();
        this.stack = new Stack<>();
    }
    
    public Map<Character, ComplexNumber> getVariables() {
        return variables;
    }

    public Stack<ComplexNumber> getStack() {
        return stack;
    }

    public void executeOperation(String operation) {
        if (operation.startsWith(">") || operation.startsWith("<") || operation.startsWith("+") || operation.startsWith("-")) {
            char variable = operation.charAt(1);

            switch (operation.charAt(0)) {
                case '>':
                    saveToVariable(variable);
                    break;
                case '<':
                    pushFromVariable(variable);
                    break;
                case '+':
                    addToVariable(variable);
                    break;
                case '-':
                    subtractFromVariable(variable);
                    break;
                // Altri casi per ulteriori operazioni
                default:
                    // Gestione di operazioni non supportate
                    break;
            }
        } 
    }

    private void saveToVariable(char variable) {
        if (!stack.isEmpty()) {
            variables.put(variable, stack.pop());
        }
    }

    private void pushFromVariable(char variable) {
        ComplexNumber value = variables.getOrDefault(variable, new ComplexNumber(0, 0));
        stack.push(value);
    }

    private void addToVariable(char variable) {
        if (!stack.isEmpty()) {
            ComplexNumber current = variables.getOrDefault(variable, new ComplexNumber(0, 0));
            variables.put(variable, current.add(stack.pop()));
        }
    }

    private void subtractFromVariable(char variable) {
        if (!stack.isEmpty()) {
            ComplexNumber current = variables.getOrDefault(variable, new ComplexNumber(0, 0));
            variables.put(variable, current.subtract(stack.pop()));
        }
    }

    // Altri metodi per operazioni con variabili e stack
}
