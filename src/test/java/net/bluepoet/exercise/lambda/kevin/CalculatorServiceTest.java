package net.bluepoet.exercise.lambda.kevin;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

/**
 * Created by daumkakao on 2017. 4. 12..
 */
public class CalculatorServiceTest {
    @Test
    public void calculate() throws Exception {

        assertThat(new CalculatorService(new Addition()).calculate(1, 1)).isEqualTo(2);
        assertThat(new CalculatorService(new Subtration()).calculate(1, 1)).isEqualTo(0);
        assertThat(new CalculatorService(new Multiplication()).calculate(3, 1)).isEqualTo(3);
        assertThat(new CalculatorService(new Division()).calculate(4, 2)).isEqualTo(2);
    }

}