package net.bluepoet.exercise.lambda.kevin;

/**
 * Created by daumkakao on 2017. 4. 12..
 */
public class OopAndFpExamples {
    public static void main(String[] args) {
        FpCalculatorService fpCalculatorService = new FpCalculatorService();
        System.out.println(fpCalculatorService.calculate((num1, num2) -> num1 + num2, 11, 2));
        System.out.println(fpCalculatorService.calculate((num1, num2) -> num1 - num2, 11, 2));
        System.out.println(fpCalculatorService.calculate((num1, num2) -> num1 * num2, 11, 2));
        System.out.println(fpCalculatorService.calculate((num1, num2) -> num1 / num2, 11, 2));
    }
}

@FunctionalInterface
interface Calculation {
    int calculate(int num1, int num2);
}

class Addition implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Subtration implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}

class Multiplication implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 * num2;
    }
}

class Division implements Calculation {
    @Override
    public int calculate(int num1, int num2) {
        return num1 / num2;
    }
}

class FpCalculatorService {
    public int calculate(Calculation calculation, int num1, int num2) {
        if (num1 > 10 && num1 > num2) {
            return calculation.calculate(num1, num2);
        } else {
            throw new IllegalArgumentException(num1 + " : " + num2);
        }
    }
}