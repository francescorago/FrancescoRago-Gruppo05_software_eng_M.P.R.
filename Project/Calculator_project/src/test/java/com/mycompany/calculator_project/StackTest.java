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
    private Stack stack;
    
    public StackTest() {
        
    }
    
    
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        stack = new Stack();
    }
    
    @AfterEach
    public void tearDown() {
    }

    
    @Test
    public void testPushComplexNumber() {
        
        ComplexNumber number = new ComplexNumber(3.0, 4.0);
        stack.push(number);

        assertFalse(stack.isEmpty());
        assertEquals(number, stack.pop());
    }
    
    @Test
    public void testPushComplexNegativeNumber() {
        
        ComplexNumber number = new ComplexNumber(-3.0, -4.0);
        stack.push(number);

        assertFalse(stack.isEmpty());
        assertEquals(number, stack.pop());
    }
    
    @Test
    public void testPushComplexDecimalNumber() {
        
        ComplexNumber number = new ComplexNumber(3.5, 4.5);
        stack.push(number);

        assertFalse(stack.isEmpty());
        assertEquals(number, stack.pop());
    }
    
    @Test
    public void testPushComplexDecimalNegativeNumber() {
        
        ComplexNumber number = new ComplexNumber(-2.5, -3.6);
        stack.push(number);

        assertFalse(stack.isEmpty());
        assertEquals(number, stack.pop());
    }

    @Test
    public void testPopComplexNumber() {
        
        ComplexNumber number = new ComplexNumber(2.0, 5.0);
        stack.push(number);

        assertEquals(number, stack.pop());
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testPopComplexNegativeNumber() {
        
        ComplexNumber number = new ComplexNumber(-2.0, -5.0);
        stack.push(number);

        assertEquals(number, stack.pop());
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testPopComplexDecimalNumber() {
        
        ComplexNumber number = new ComplexNumber(2.3, 5.8);
        stack.push(number);

        assertEquals(number, stack.pop());
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testPopComplexDecimalNegativeNumber() {
        
        ComplexNumber number = new ComplexNumber(-2.3, -5.8);
        stack.push(number);

        assertEquals(number, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testClear() {
        
        stack.push(new ComplexNumber(1.0, 2.0));
        stack.push(new ComplexNumber(3.0, 4.0));

        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testDrop() {
        
        ComplexNumber number = new ComplexNumber(7.0, 0.0);
        stack.push(number);

        stack.drop();
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testDropNegative() {
        
        ComplexNumber number = new ComplexNumber(-7.0, -4.0);
        stack.push(number);

        stack.drop();
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testDropDecimal() {
        
        ComplexNumber number = new ComplexNumber(7.4, 3.2);
        stack.push(number);

        stack.drop();
        assertTrue(stack.isEmpty());
    }
    
    @Test
    public void testDropDecimalNegative() {
        
        ComplexNumber number = new ComplexNumber(-3.5, 2.3);
        stack.push(number);

        stack.drop();
        assertTrue(stack.isEmpty());
    }   

    @Test
    public void testDup() {
        
        stack.push(new ComplexNumber(1, 2));

        stack.dup();

        assertEquals(2, stack.size());
        assertEquals(new ComplexNumber(1, 2), stack.pop());
        assertEquals(new ComplexNumber(1, 2), stack.pop());
    }
    
    @Test
    public void testDupNegative() {
        
        stack.push(new ComplexNumber(-2, -3));

        stack.dup();

        assertEquals(2, stack.size());
        assertEquals(new ComplexNumber(-2, -3), stack.pop());
        assertEquals(new ComplexNumber(-2, -3), stack.pop());
    }
    
    @Test
    public void testDupDecimal() {
        
        stack.push(new ComplexNumber(1.5, 2.7));

        stack.dup();

        assertEquals(2, stack.size());
        assertEquals(new ComplexNumber(1.5, 2.7), stack.pop());
        assertEquals(new ComplexNumber(1.5, 2.7), stack.pop());
    }
    
    @Test
    public void testDupDecimalNegative() {
        
        stack.push(new ComplexNumber(-3.2, -2.7));

        stack.dup();

        assertEquals(2, stack.size());
        assertEquals(new ComplexNumber(-3.2, -2.7), stack.pop());
        assertEquals(new ComplexNumber(-3.2, -2.7), stack.pop());
    }

    @Test
    public void testSwap() {
        
        ComplexNumber num1 = new ComplexNumber(0.0, 7.0);
        ComplexNumber num2 = new ComplexNumber(2.0, 11.0);
        stack.push(num1);
        stack.push(num2);

        stack.swap();
        assertEquals(num1, stack.pop());
        assertEquals(num2, stack.pop());
    }
    
    @Test
    public void testSwapNegative() {
        
        ComplexNumber num1 = new ComplexNumber(-3.0, 7.0);
        ComplexNumber num2 = new ComplexNumber(5.0, -4.0);
        stack.push(num1);
        stack.push(num2);

        stack.swap();
        assertEquals(num1, stack.pop());
        assertEquals(num2, stack.pop());
    }
    
    @Test
    public void testSwapDecimal() {
        
        ComplexNumber num1 = new ComplexNumber(2.3, 4.5);
        ComplexNumber num2 = new ComplexNumber(3.6, 11.0);
        stack.push(num1);
        stack.push(num2);

        stack.swap();
        assertEquals(num1, stack.pop());
        assertEquals(num2, stack.pop());
    }
    
    @Test
    public void testSwapDecimalNegative() {
        
        ComplexNumber num1 = new ComplexNumber(-2.5, -4.2);
        ComplexNumber num2 = new ComplexNumber(-3.4, -2.0);
        stack.push(num1);
        stack.push(num2);

        stack.swap();
        assertEquals(num1, stack.pop());
        assertEquals(num2, stack.pop());
    }

    @Test
    public void testOver() {
        
        stack.push(new ComplexNumber(1, 2));
        stack.push(new ComplexNumber(3, 4));

        stack.over();

        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(1, 2), stack.pop());
        assertEquals(new ComplexNumber(3, 4), stack.pop());
        assertEquals(new ComplexNumber(1, 2), stack.pop());
    }
    
    @Test
    public void testOverNegative() {
        
        stack.push(new ComplexNumber(-4, 2));
        stack.push(new ComplexNumber(-5, -4));

        stack.over();

        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(-4, 2), stack.pop());
        assertEquals(new ComplexNumber(-5, -4), stack.pop());
        assertEquals(new ComplexNumber(-4, 2), stack.pop());
    }
    
    @Test
    public void testOverDecimal() {
        
        stack.push(new ComplexNumber(3.2, 2.5));
        stack.push(new ComplexNumber(3.4, 4.2));

        stack.over();

        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(3.2, 2.5), stack.pop());
        assertEquals(new ComplexNumber(3.4, 4.2), stack.pop());
        assertEquals(new ComplexNumber(3.2, 2.5), stack.pop());
    }
    
    @Test
    public void testOverDecimalNegative() {
        
        stack.push(new ComplexNumber(-1.4, -2.2));
        stack.push(new ComplexNumber(3.2, -4.5));

        stack.over();

        assertEquals(3, stack.size());
        assertEquals(new ComplexNumber(-1.4, -2.2), stack.pop());
        assertEquals(new ComplexNumber(3.2, -4.5), stack.pop());
        assertEquals(new ComplexNumber(-1.4, -2.2), stack.pop());
    }

    @Test
    public void testIsEmpty() {
        
        assertTrue(stack.isEmpty());

        stack.push(new ComplexNumber(3.0, 5.0));
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testSize() {
        
        assertEquals(0, stack.size());

        stack.push(new ComplexNumber(1.0, 2.0));
        stack.push(new ComplexNumber(3.0, 4.0));
        assertEquals(2, stack.size());
    }

    @Test
    public void testPush_double() {
        
        ComplexNumber number = new ComplexNumber(3.5, 0.0);
        stack.push(number);

        assertFalse(stack.isEmpty());
        assertEquals(number, stack.pop());
    }

    
    
    
}
