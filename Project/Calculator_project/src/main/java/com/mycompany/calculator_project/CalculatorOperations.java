/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator_project;

import java.util.EmptyStackException;

public class CalculatorOperations {

    private final Stack stack;

    public CalculatorOperations(Stack stack) {
        this.stack = stack;
    }


    
    public static double add(double num1, double num2){
         return num1+num2;
    }
    
    public static double sub(double num1, double num2) {
        return num1-num2;
    }
    
    public static double mul(double num1, double num2) {
        return num1*num2;
    }
    
    public static double div(double num1, double num2) {
        return num1/num2;
    }
    
    public static double sqrt(double num) {
        return Math.sqrt(num);
    }
    
    public static double inv(double num1) {
        return num1*(-1);
    }
    
}