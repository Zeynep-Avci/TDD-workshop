package pt.ipp.isep.dei.examples.tdd.basic.calculator;

import org.junit.jupiter.api.*;

import pt.ipp.isep.dei.examples.tdd.basic.calculator.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorTest {

    @BeforeAll
    public static void classSetUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place before any @Test is executed");
    }

    @AfterAll
    public static void classTearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "This is a CalculatorTest class method and takes place after all @Test are executed");
    }

    @BeforeEach
    public void setUp() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place before each @Test is executed");
    }

    @AfterEach
    public void tearDown() {
        //HACK: for demonstration purposes only
        System.out.println(
                "\tThis call takes place after each @Test is executed");
    }
    @Test
    public void ensureMinus6FactorialThrowsIllegalArgument(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = -6;

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Calculator().factorial(firsOperand);});
    }

    @Test 
    public void ensure6FactorialEquals720(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 6;
        int result = 0;
        int expectedResult = 720;
        
        //Act
        result = new Calculator().factorial(firsOperand);

        //Assert

        assertEquals(expectedResult,result);
    }

    @Test
    public void ensureFactorialZeroEqualsOne(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 0;
        int result = 0;
        int expectedResult = 1;
        
        //Act
        result = new Calculator().factorial(firsOperand);

        //Assert

        assertEquals(expectedResult,result);
    }

    @Test
    public void ensure0time8is0() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 0;
        int firsOperand = 0;
        int secondOperand = 8;
        int result = 3;

        // Act
        result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensure8times0is0() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 0;
        int firsOperand = 8;
        int secondOperand = 0;
        int result = 3;

        // Act
        result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureMinus5timesMinus5is25() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 25;
        int firsOperand = -5;
        int secondOperand = -5;
        int result = 3;

        // Act
        result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensure5timesMinus5is25() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = -25;
        int firsOperand = 5;
        int secondOperand = -5;
        int result = 3;

        // Act
        result = new Calculator().multiply(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensure5dividedby2is2(){
                //HACK: for demonstration purposes only
                System.out.println("\t\tExecuting " + new Object() {
                }.getClass().getEnclosingMethod().getName() + " Test");
        
                // Arrange
                int expectedResult = 2;
                int dividend = 5;
                int divisor = 2;
                int result = 1;
        
                // Act
                result = new Calculator().divide(dividend, divisor);
        
                // Assert
                assertEquals(expectedResult, result);

    }

    @Test
    @Disabled
    public void failingTest() {
        fail("a disabled failing test");
    }

    /**
     * Test to ensure two positive numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arrange: one positive number (three) and another positive number (two).<p>
     * Act: sum both numbers (three and two).<p>
     * Assert: the result is five.
     */
    @Test
    public void ensureThreePlusTwoEqualsFive() {

        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int expectedResult = 5;
        int firsOperand = 3;
        int secondOperand = 2;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    /**
     * Test to ensure positive and negative numbers are summed correctly.<p>
     * <p>
     * For demonstration purposes the Arrange/Act/Assert syntax is used:<p>
     * Arranje a positive number (three) and a negative number (minus two)<p>
     * Act I sum three to minus two<p>
     * Assert the sum result should be one.
     */
    @Test
    public void ensureThreePlusMinusTwoEqualsOne() {
        //HACK: for demonstration purposes only
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 3;
        int secondOperand = -2;
        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().sum(firsOperand, secondOperand);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureTwoMinusOneEqualsOne(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 2;
        int secondOperand = 1;
        int expectedResult = 1;
        int result = 3;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureTwoMinusThreeEqualsNegativeOne(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 2;
        int secondOperand = 3;
        int expectedResult = -1;
        int result = 3;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureThreeMinusNegativeFiveEqualsEight(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 3;
        int secondOperand = -5;
        int expectedResult = 8;
        int result = 3;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureNegativeThreeMinusThreeEqualsNegativeSix(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = -3;
        int secondOperand = 3;
        int expectedResult = -6;
        int result = 3;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureNegativeThreeMinusNegativeThreeEqualsZero(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = -3;
        int secondOperand = -3;
        int expectedResult = 0;
        int result = 3;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureZeroMinusZeroEqualsZero(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int firsOperand = 0;
        int secondOperand = 0;
        int expectedResult = 0;
        int result = 3;

        // Act
        result = new Calculator().subtract(firsOperand, secondOperand);

        assertEquals(expectedResult, result);
    }

    @Test
    public void ensureDivisionByZero(){
        System.out.println("\t\tExecuting " + new Object() {
        }.getClass().getEnclosingMethod().getName() + " Test");

        // Arrange
        int divisor = 0;
        int dividend = 1;

        // Act, Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {new Calculator().divide(dividend, divisor);});

    }

}



