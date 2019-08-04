package com.cybertek.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CalculatorTests {

    Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();

    }

    @Test
    public void classTest() {
        assertNotNull(calculator);
    }

    @Test
    public void addTest() {
        assertEquals(calculator.add(1, 1), 2);
        assertEquals(calculator.add(-1, 1), 0);
    }

    @Test
    public void subtractTest() {
        assertEquals(calculator.subtract(1, 1), 0);
        assertEquals(calculator.subtract(-1, 1), -2);
    }

//    @Test
//    public void multiplyTest() {
//        assertEquals(calculator.multiply(1, 1), 1);
//        assertEquals(calculator.multiply(-1, 1), -1);
//    }
//
//    @Test
//    public void divideTest() {
//        assertEquals(calculator.divide(1, 1), 1);
//        assertEquals(calculator.divide(4, 2), 2);
//    }
//
//    @Test(expectedExceptions = ArithmeticException.class)
//    public void divideBy0Test() {
//        calculator.divide(1, 0);
//    }


}
