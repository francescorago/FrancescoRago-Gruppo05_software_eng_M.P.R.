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
public class CalculatorOperationsTest {
    
    public CalculatorOperationsTest() {
    }
    
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
    }
    
    @Test
    public void testAddition() {
        ComplexNumber num1 = new ComplexNumber(3.0, 4.0);
        ComplexNumber num2 = new ComplexNumber(2.0, 5.0);
        ComplexNumber result = num1.add(num2);

        assertEquals(5.0, result.getReal(), 0.0001);
        assertEquals(9.0, result.getImag(), 0.0001);
    }

   @Test
    public void testAdditionDecimal() {
        ComplexNumber num1 = new ComplexNumber(2.3, 4.5);
        ComplexNumber num2 = new ComplexNumber(1.2, 3.4);
        ComplexNumber result = num1.add(num2);

        assertEquals(3.5, result.getReal(), 0.0001);
        assertEquals(7.9, result.getImag(), 0.0001);
    }
    
    @Test
    public void testAdditionNegative() {
        ComplexNumber num1 = new ComplexNumber(-4.0, 3.0);
        ComplexNumber num2 = new ComplexNumber(-2.0, -2.0);
        ComplexNumber result = num1.add(num2);

        assertEquals(-6.0, result.getReal(), 0.0001);
        assertEquals(1.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testAdditionDecimalNegative() {
        ComplexNumber num1 = new ComplexNumber(-2.3, 4.5);
        ComplexNumber num2 = new ComplexNumber(-1.2, 3.4);
        ComplexNumber result = num1.add(num2);

        assertEquals(-3.5, result.getReal(), 0.0001);
        assertEquals(7.9, result.getImag(), 0.0001);
    }
    
    @Test
    public void testAdditionZero() {
        ComplexNumber num1 = new ComplexNumber(3.0, 2.0);
        ComplexNumber num2 = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = num1.add(num2);

        assertEquals(3.0, result.getReal(), 0.0001);
        assertEquals(2.0, result.getImag(), 0.0001);
    }

    @Test
    public void testAdditionOpposite() {
        ComplexNumber num1 = new ComplexNumber(4.0, -5.0);
        ComplexNumber num2 = new ComplexNumber(-4.0, 5.0);
        ComplexNumber result = num1.add(num2);

        assertEquals(0.0, result.getReal(), 0.0001);
        assertEquals(0.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testAdditionNoImag() {
        ComplexNumber num1 = new ComplexNumber(4.0, 0.0);
        ComplexNumber num2 = new ComplexNumber(3.0, 0.0);
        ComplexNumber result = num1.add(num2);

        assertEquals(7.0, result.getReal(), 0.0001);
        assertEquals(0.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testAdditionNoReal() {
        ComplexNumber num1 = new ComplexNumber(0.0, 5.0);
        ComplexNumber num2 = new ComplexNumber(0.0, 3.0);
        ComplexNumber result = num1.add(num2);

        assertEquals(0.0, result.getReal(), 0.0001);
        assertEquals(8.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testSubtraction() {
        ComplexNumber num1 = new ComplexNumber(8.0, 11.0);
        ComplexNumber num2 = new ComplexNumber(3.0, 7.0);
        ComplexNumber result = num1.subtract(num2);

        assertEquals(5.0, result.getReal(), 0.0001);
        assertEquals(4.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testSubtractionDecimal() {
        ComplexNumber num1 = new ComplexNumber(2.5, 4.3);
        ComplexNumber num2 = new ComplexNumber(1.5, 3.2);
        ComplexNumber result = num1.subtract(num2);

        assertEquals(1.0, result.getReal(), 0.0001);
        assertEquals(1.1, result.getImag(), 0.0001);
    }
    
    @Test
    public void testSubtractionNegative() {
        ComplexNumber num1 = new ComplexNumber(-2.0, -4.0);
        ComplexNumber num2 = new ComplexNumber(-1.0, 3.0);
        ComplexNumber result = num1.subtract(num2);

        assertEquals(-1.0, result.getReal(), 0.0001);
        assertEquals(-7.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testSubtractionDecimalNegative() {
        ComplexNumber num1 = new ComplexNumber(-2.5, 4.3);
        ComplexNumber num2 = new ComplexNumber(1.2, -3.7);
        ComplexNumber result = num1.subtract(num2);

        assertEquals(-3.7, result.getReal(), 0.0001);
        assertEquals(8.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testSubtractionZero() {
        ComplexNumber num1 = new ComplexNumber(3.0, 2.0);
        ComplexNumber num2 = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = num1.add(num2);

        assertEquals(3.0, result.getReal(), 0.0001);
        assertEquals(2.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testSubtractionNoImag() {
        ComplexNumber num1 = new ComplexNumber(3.0, 0.0);
        ComplexNumber num2 = new ComplexNumber(2.0, 0.0);
        ComplexNumber result = num1.subtract(num2);

        assertEquals(1.0, result.getReal(), 0.0001);
        assertEquals(0.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testSubtractionNoReal() {
        ComplexNumber num1 = new ComplexNumber(0.0, 4.0);
        ComplexNumber num2 = new ComplexNumber(0.0, 3.0);
        ComplexNumber result = num1.subtract(num2);

        assertEquals(0.0, result.getReal(), 0.0001);
        assertEquals(1.0, result.getImag(), 0.0001);
    }

    @Test
    public void testMultiplication() {
        ComplexNumber num1 = new ComplexNumber(1.0, 2.0);
        ComplexNumber num2 = new ComplexNumber(7.0, 4.0);
        ComplexNumber result = num1.multiply(num2);

        assertEquals(-1.0, result.getReal(), 0.0001);
        assertEquals(18.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testMultiplicationDecimal() {
        ComplexNumber num1 = new ComplexNumber(1.5, 2.3);
        ComplexNumber num2 = new ComplexNumber(3.3, 6.2);
        ComplexNumber result = num1.multiply(num2);

        assertEquals(-9.31, result.getReal(), 0.0001);
        assertEquals(16.89, result.getImag(), 0.0001);
    }
    
    @Test
    public void testMultiplicationNegative() {
        ComplexNumber num1 = new ComplexNumber(-3.0, -2.0);
        ComplexNumber num2 = new ComplexNumber(-2.0, -4.0);
        ComplexNumber result = num1.multiply(num2);

        assertEquals(-2.0, result.getReal(), 0.0001);
        assertEquals(16.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testMultiplicationNegativeDecimal() {
        ComplexNumber num1 = new ComplexNumber(-1.5, -1.3);
        ComplexNumber num2 = new ComplexNumber(-7.0, 1.0);
        ComplexNumber result = num1.multiply(num2);

        assertEquals(11.8, result.getReal(), 0.0001);
        assertEquals(7.6, result.getImag(), 0.0001);
    }
    
    @Test
    public void testMultiplicationZero() {
        ComplexNumber num1 = new ComplexNumber(1.5, -1.3);
        ComplexNumber num2 = new ComplexNumber(0.0, 0.0);
        ComplexNumber result = num1.multiply(num2);

        assertEquals(0.0, result.getReal(), 0.0001);
        assertEquals(0.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testMultiplicationNoImag() {
        ComplexNumber num1 = new ComplexNumber(1.0, 0.0);
        ComplexNumber num2 = new ComplexNumber(2.0, 0.0);
        ComplexNumber result = num1.multiply(num2);

        assertEquals(2.0, result.getReal(), 0.0001);
        assertEquals(0.0, result.getImag(), 0.0001);
    }
    
    @Test
    public void testMultiplicationNoReal() {
        ComplexNumber num1 = new ComplexNumber(0.0, 3.0);
        ComplexNumber num2 = new ComplexNumber(0.0, 2.0);
        ComplexNumber result = num1.multiply(num2);

        assertEquals(-6.0, result.getReal(), 0.0001);
        assertEquals(0.0, result.getImag(), 0.0001);
    }

    @Test
    public void testDivision() {
        ComplexNumber num1 = new ComplexNumber(12.0, 18.0);
        ComplexNumber num2 = new ComplexNumber(3.0, 6.0);
        ComplexNumber result = num1.divide(num2);

        assertEquals(3.2, result.getReal(), 0.001);
        assertEquals(-0.4, result.getImag(), 0.001);
    }
    
    @Test
    public void testDivisionNegative() {
        ComplexNumber num1 = new ComplexNumber(-5.0, -10.0);
        ComplexNumber num2 = new ComplexNumber(-2.0, -4.0);
        ComplexNumber result = num1.divide(num2);

        assertEquals(2.5, result.getReal(), 0.001);
        assertEquals(0.0, result.getImag(), 0.001);
    }

    @Test
    public void testDivisionPositiveDecimal() {
        ComplexNumber num1 = new ComplexNumber(3.5, 7.0);
        ComplexNumber num2 = new ComplexNumber(1.4, 2.0);
        ComplexNumber result = num1.divide(num2);

        assertEquals(3.1711409395973154, result.getReal(), 0.001);
        assertEquals(0.46979865771891206, result.getImag(), 0.001);
    }

    @Test
    public void testDivisionNegativeDecimal() {
        ComplexNumber num1 = new ComplexNumber(-4.0, -8.0);
        ComplexNumber num2 = new ComplexNumber(-2.5, -3.0);
        ComplexNumber result = num1.divide(num2);

        assertEquals(2.2295081967213113, result.getReal(), 0.001);
        assertEquals(0.5245501639344263, result.getImag(), 0.001);
    }

    @Test
    public void testDivisionNoReal() {
        ComplexNumber num1 = new ComplexNumber(0.0, 8.0);
        ComplexNumber num2 = new ComplexNumber(0.0, 4.0);
        ComplexNumber result = num1.divide(num2);

        assertEquals(2.0, result.getReal(), 0.001);
        assertEquals(0.0, result.getImag(), 0.001);
    }

    @Test
    public void testDivisionNoImag() {
        ComplexNumber num1 = new ComplexNumber(6.0, 0.0);
        ComplexNumber num2 = new ComplexNumber(3.0, 0.0);
        ComplexNumber result = num1.divide(num2);

        assertEquals(2.0, result.getReal(), 0.001);
        assertEquals(0.0, result.getImag(), 0.001);
}

    @Test
    public void testSquareRoot() {
        ComplexNumber num = new ComplexNumber(3.0, 4.0);
        ComplexNumber result = num.squareRoot();

        assertEquals(2.0, result.getReal(), 0.001);
        assertEquals(1.0, result.getImag(), 0.001);
    }
    
    @Test
    public void testSquareRootNegative() {
        ComplexNumber num = new ComplexNumber(-3.0, 4.0);
        ComplexNumber result = num.squareRoot();

        assertEquals(1.0, result.getReal(), 0.001);
        assertEquals(2.0, result.getImag(), 0.001);
    }

    @Test
    public void testSquareRootDecimal() {
        ComplexNumber num = new ComplexNumber(2.5, 3.5);
        ComplexNumber result = num.squareRoot();

        assertEquals(1.8440665163601493, result.getReal(), 0.001);
        assertEquals(0.948989629427349, result.getImag(), 0.001);
    }

    @Test
    public void testSquareRootNegativeDecimal() {
        ComplexNumber num = new ComplexNumber(-2.5, -3.5);
        ComplexNumber result = num.squareRoot();

        assertEquals(0.948989629427349, result.getReal(), 0.001);
        assertEquals(-1.844066516360149, result.getImag(), 0.001);
}

    @Test
    public void testSquareRootNoReal() {
        ComplexNumber num = new ComplexNumber(0.0, 4.5);
        ComplexNumber result = num.squareRoot();

        assertEquals(1.5, result.getReal(), 0.001);
        assertEquals(1.5, result.getImag(), 0.001);
    }

    @Test
    public void testSquareRootNoImaginary() {
        ComplexNumber num = new ComplexNumber(3.5, 0.0);
        ComplexNumber result = num.squareRoot();

        assertEquals(1.8708, result.getReal(), 0.001);
        assertEquals(0.0, result.getImag(), 0.001);
    }

    @Test
    public void testInverse() {
        ComplexNumber num = new ComplexNumber(-1.0, 2.0);
        ComplexNumber result = num.inv();

        assertEquals(1.0, result.getReal(), 0.001);
        assertEquals(-2.0, result.getImag(), 0.001);
    }
    
    @Test
    public void testInverseDecimalNumbers() {
        ComplexNumber num = new ComplexNumber(0.5, 0.25);
        ComplexNumber result = num.inv();

        assertEquals(-0.5, result.getReal(), 0.001);
        assertEquals(-0.25, result.getImag(), 0.001);
    }
    
    @Test
    public void testInverseNoReal() {
        ComplexNumber num = new ComplexNumber(0.0, 2.0);
        ComplexNumber result = num.inv();

        assertEquals(0.0, result.getReal(), 0.001);
        assertEquals(-2.0, result.getImag(), 0.001);
    }

    @Test
    public void testInverseNoImaginary() {
        ComplexNumber num = new ComplexNumber(-3.0, 0.0);
        ComplexNumber result = num.inv();

        assertEquals(3.0, result.getReal(), 0.001);
        assertEquals(0.0, result.getImag(), 0.001);
    }
   
    
}
