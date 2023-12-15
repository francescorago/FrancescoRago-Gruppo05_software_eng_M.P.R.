/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator_project;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Stack {
    private static final int MAX_CAPACITY = 12;
    private  List<ComplexNumber> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(ComplexNumber number) throws StackOverflowError {
        if (stack.size() >= MAX_CAPACITY) {
            throw new StackOverflowError("Stack is full. Cannot push more elements.");
// quest eccezione verrà controllata nel design, dove se ci troviamo in questa situazione disattiva alcuni tasti
        }
        stack.add(number);
    }

    public ComplexNumber pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public void clear() {
        stack.clear();
    }

    public void drop() {
        if (!isEmpty()) {
            stack.remove(stack.size() - 1);
        }
    }

    public void dup() {
        if (!isEmpty()) {
            ComplexNumber topElement = stack.get(stack.size() - 1);
            stack.add(new ComplexNumber(topElement.getReal(), topElement.getImag()));
        }
    }

    public void swap() {
        if (stack.size() >= 2) {
            int lastIndex = stack.size() - 1;
            ComplexNumber lastElement = stack.remove(lastIndex);
            ComplexNumber secondLastElement = stack.remove(lastIndex - 1);
            stack.add(lastElement);
            stack.add(secondLastElement);
        }
    }

    public void over() {
        if (stack.size() >= 2) {
            ComplexNumber secondLastElement = stack.get(stack.size() - 2);
            stack.add(new ComplexNumber(secondLastElement.getReal(), secondLastElement.getImag()));
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    void push(double number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  }