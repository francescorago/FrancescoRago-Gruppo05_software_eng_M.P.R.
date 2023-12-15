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
        VariableManager variableManager = new VariableManager();
        ComplexNumber num = new ComplexNumber(-2.0, 7.0);

        variableManager.getStack().push(num);
        variableManager.executeOperation(">A");

        assertEquals(num, variableManager.getVariables().get('A'));
    }

    @Test
    public void testPushFromVariable() {
        VariableManager variableManager = new VariableManager();
        ComplexNumber num = new ComplexNumber(-2.0, 7.0);
        variableManager.getVariables().put('C', num);

        variableManager.executeOperation("<C");

        assertEquals(num, variableManager.getStack().pop());
    }

    @Test
    public void testAddToVariable() {
        VariableManager variableManager = new VariableManager();
        variableManager.getVariables().put('D', new ComplexNumber(2.0, 3.0));
        variableManager.getStack().push(new ComplexNumber(1.0, 2.0));

        variableManager.executeOperation("+D");

        assertEquals(new ComplexNumber(3.0, 5.0), variableManager.getVariables().get('D'));
    }

    @Test
    public void testSubtractFromVariable() {
        VariableManager variableManager = new VariableManager();
        variableManager.getVariables().put('E', new ComplexNumber(8.0, 5.0));
        variableManager.getStack().push(new ComplexNumber(3.0, 2.0));

        variableManager.executeOperation("-E");

        assertEquals(new ComplexNumber(5.0, 3.0), variableManager.getVariables().get('E'));
    }
    
}
