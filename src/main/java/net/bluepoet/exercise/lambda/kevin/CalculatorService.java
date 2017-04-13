package net.bluepoet.exercise.lambda.kevin;

/**
 * Created by daumkakao on 2017. 4. 12..
 */
class CalculatorService {
    private final Calculation calculation;

    public CalculatorService(Calculation calculation) {
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2) {
        return calculation.calculate(num1, num2);
    }
}