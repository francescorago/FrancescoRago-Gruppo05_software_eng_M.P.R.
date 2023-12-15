/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator_project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author macer
 */
public class StackTest {
    
    public StackTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    /*
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }*/

    
    @Test
    public void testPush_ComplexNumber() {
        Stack stack = new Stack();
        ComplexNumber number = new ComplexNumber(3.0, 4.0);
        stack.push(number);

        assertFalse(stack.isEmpty());
        assertEquals(number, stack.pop());
    }

    @Test
    public void testPop() {
        Stack stack = new Stack();
        ComplexNumber number = new ComplexNumber(2.0, 5.0);
        stack.push(number);

        assertEquals(number, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testClear() {
        Stack stack = new Stack();
        stack.push(new ComplexNumber(1.0, 2.0));
        stack.push(new ComplexNumber(3.0, 4.0));

        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testDrop() {
        Stack stack = new Stack();
        ComplexNumber number = new ComplexNumber(7.0, 0.0);
        stack.push(number);

        stack.drop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testDup() {
        Stack stack = new Stack();
        ComplexNumber number = new ComplexNumber(0.0, 4.0);
        stack.push(number);

        stack.dup();
        assertEquals(number, stack.pop());
        assertEquals(number, stack.pop());
    }

    @Test
    public void testSwap() {
        Stack stack = new Stack();
        ComplexNumber num1 = new ComplexNumber(0.0, 7.0);
        ComplexNumber num2 = new ComplexNumber(2.0, 11.0);
        stack.push(num1);
        stack.push(num2);

        stack.swap();
        assertEquals(num1, stack.pop());
        assertEquals(num2, stack.pop());
    }

    @Test
    public void testOver() {
        Stack stack = new Stack();
        ComplexNumber num1 = new ComplexNumber(1.0, 0.0);
        ComplexNumber num2 = new ComplexNumber(-2.0, 7.0);
        stack.push(num1);
        stack.push(num2);

        stack.over();
        assertEquals(num2, stack.pop());
        assertEquals(num1, stack.pop());
        assertEquals(num2, stack.pop());
    }

    @Test
    public void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());

        stack.push(new ComplexNumber(3.0, 5.0));
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        Stack stack = new Stack();
        assertEquals(0, stack.size());

        stack.push(new ComplexNumber(1.0, 2.0));
        stack.push(new ComplexNumber(3.0, 4.0));
        assertEquals(2, stack.size());
    }

    @Test
    public void testPush_double() {
        Stack stack = new Stack();
        double number = 3.5;
        stack.push(number);

        assertFalse(stack.isEmpty());
        assertEquals(number, stack.pop().getReal());
    }
    
}
