package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    @Test
    public void twoAddTwoEqualsFour() {
        Calculator calculator = new Calculator();

        int result = calculator.add(2,2);

        Assertions.assertEquals(4, result);
    }

    @Test
    public void twoSubtractTwoEqualsZero() {
        Calculator calculator = new Calculator();

        int result = calculator.subtract(2,2);

        Assertions.assertEquals(0, result);
    }

    @Test
    public void twoDivideByTwoEqualsOne() {
        Calculator calculator = new Calculator();

        int result = calculator.divide(2, 2);

        Assertions.assertEquals(1, result);
    }

    @Test
    public void twoDivideByZeroShouldStillWork() {
        Calculator calculator = new Calculator();

        int result = calculator.divide(2, 0);

        //Assertions.assertEquals(1, result);
    }
}
