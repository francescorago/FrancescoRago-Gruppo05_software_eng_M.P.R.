/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.calculator_project;

import java.util.HashMap;
import java.util.Map;
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
public class VariableManagerTest {
    private VariableManager variableManager;
  
    public VariableManagerTest() {
        
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {    
        variableManager = new VariableManager();
    
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSaveToVariable() {
        
        ComplexNumber num = new ComplexNumber(2.0, 7.0);

        variableManager.getStack().push(num);
        variableManager.executeOperation(">A");

        assertEquals(num, variableManager.getVariables().get('A'));
    }
    
    @Test
    public void testSaveToVariable_Negative() {
        
        ComplexNumber num = new ComplexNumber(-2.0, -5.0);

        variableManager.getStack().push(num);
        variableManager.executeOperation(">A");

        assertEquals(num, variableManager.getVariables().get('A'));
    }
    
    @Test
    public void testSaveToVariable_Decimal() {
        
        ComplexNumber num = new ComplexNumber(4.5, 7.3);

        variableManager.getStack().push(num);
        variableManager.executeOperation(">A");

        assertEquals(num, variableManager.getVariables().get('A'));
    }
    
    @Test
    public void testSaveToVariable_DecimalNegative() {
        
        ComplexNumber num = new ComplexNumber(-2.2, -3.5);

        variableManager.getStack().push(num);
        variableManager.executeOperation(">A");

        assertEquals(num, variableManager.getVariables().get('A'));
    }

    @Test
    public void testPushFromVariable() {
        
        ComplexNumber num = new ComplexNumber(2.0, 7.0);
        variableManager.getVariables().put('C', num);

        variableManager.executeOperation("<C");

        assertEquals(num, variableManager.getStack().pop());
    }
    
    @Test
    public void testPushFromVariable_Negative() {
        
        ComplexNumber num = new ComplexNumber(-2.0, -8.0);
        variableManager.getVariables().put('C', num);

        variableManager.executeOperation("<C");

        assertEquals(num, variableManager.getStack().pop());
    }
    
    @Test
    public void testPushFromVariable_Decimal() {
        
        ComplexNumber num = new ComplexNumber(2.3, 3.8);
        variableManager.getVariables().put('C', num);

        variableManager.executeOperation("<C");

        assertEquals(num, variableManager.getStack().pop());
    }
    
    @Test
    public void testPushFromVariable_DecimalNegative() {
        
        ComplexNumber num = new ComplexNumber(-2.5, 4.3);
        variableManager.getVariables().put('C', num);

        variableManager.executeOperation("<C");

        assertEquals(num, variableManager.getStack().pop());
    }

    @Test
    public void testAddToVariable() {
        
        ComplexNumber num1 = new ComplexNumber(2.0, 3.0);

        variableManager.getStack().push(num1);
        variableManager.executeOperation(">D");
        
        ComplexNumber num2 = new ComplexNumber(2.0, 3.0);
        variableManager.getStack().push(num2);
         
        

        variableManager.executeOperation("+D");
        num1 = num1.add(num2);
        assertEquals(num1, variableManager.getVariables().get('D'));      
    }
    
    @Test
    public void testAddToVariable_Negative() {
        
        ComplexNumber num1 = new ComplexNumber(-2.0, -5.0);

        variableManager.getStack().push(num1);
        variableManager.executeOperation(">D");
        
        ComplexNumber num2 = new ComplexNumber(-5.0, -3.0);
        variableManager.getStack().push(num2);
         
        

        variableManager.executeOperation("+D");
        num1 = num1.add(num2);
        assertEquals(num1, variableManager.getVariables().get('D'));      
    }
    
    @Test
    public void testAddToVariable_Decimal() {
        
        ComplexNumber num1 = new ComplexNumber(2.5, 5.3);

        variableManager.getStack().push(num1);
        variableManager.executeOperation(">D");
        
        ComplexNumber num2 = new ComplexNumber(5.6, 2.0);
        variableManager.getStack().push(num2);
         
        

        variableManager.executeOperation("+D");
        num1 = num1.add(num2);
        assertEquals(num1, variableManager.getVariables().get('D'));      
    }
    
    @Test
    public void testAddToVariable_DecimalNegative() {
        
        ComplexNumber num1 = new ComplexNumber(-2.7, -5.9);

        variableManager.getStack().push(num1);
        variableManager.executeOperation(">D");
        
        ComplexNumber num2 = new ComplexNumber(5.0, -3.3);
        variableManager.getStack().push(num2);
         
        

        variableManager.executeOperation("+D");
        num1 = num1.add(num2);
        assertEquals(num1, variableManager.getVariables().get('D'));      
    }

    @Test
    public void testSubtractFromVariable() {
        
        ComplexNumber num1 = new ComplexNumber(5.0, 3.0);

        variableManager.getStack().push(num1);
        variableManager.executeOperation(">D");
        
        ComplexNumber num2 = new ComplexNumber(2.0, 2.0);
        variableManager.getStack().push(num2);
        
        variableManager.executeOperation("-D");
        num1 = num1.subtract(num2);
        assertEquals(num1, variableManager.getVariables().get('D')); 
    }   
    
    @Test
    public void testSubtractFromVariable_Negative() {
        
        ComplexNumber num1 = new ComplexNumber(-5.0,-12.0);

        variableManager.getStack().push(num1);
        variableManager.executeOperation(">D");
        
        ComplexNumber num2 = new ComplexNumber(-3.0, 6.0);
        variableManager.getStack().push(num2);
        
        variableManager.executeOperation("-D");
        num1 = num1.subtract(num2);
        assertEquals(num1, variableManager.getVariables().get('D')); 
    }   
    
    @Test
    public void testSubtractFromVariable_Decimal() {
        
        ComplexNumber num1 = new ComplexNumber(5.7, 3.4);

        variableManager.getStack().push(num1);
        variableManager.executeOperation(">D");
        
        ComplexNumber num2 = new ComplexNumber(2.7, 2.4);
        variableManager.getStack().push(num2);
        
        variableManager.executeOperation("-D");
        num1 = num1.subtract(num2);
        assertEquals(num1, variableManager.getVariables().get('D')); 
    }   
    
    @Test
    public void testSubtractFromVariable_DecimalNegative() {
        
        ComplexNumber num1 = new ComplexNumber(-7.3, -3.2);

        variableManager.getStack().push(num1);
        variableManager.executeOperation(">D");
        
        ComplexNumber num2 = new ComplexNumber(2.5, -4.5);
        variableManager.getStack().push(num2);
        
        variableManager.executeOperation("-D");
        num1 = num1.subtract(num2);
        assertEquals(num1, variableManager.getVariables().get('D')); 
    }   
}
