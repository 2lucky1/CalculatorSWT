package com.muntian.logic;

import com.muntian.interfaces.MathOperation;

public class SimpleCalculatorImpl extends AbstractCalculator {

    public SimpleCalculatorImpl() {
        creatMainOperationsMap();
    }

    @Override
    public double makeCalculation(double firstNumber, double secondNumber, String mathOperator) {
        MathOperation mathOperation = null;

        if (mathOperationsMap.containsKey(mathOperator)) {
            mathOperation = mathOperationsMap.get(mathOperator);
        } else {
            System.out.println("Invalid sign");
        }

        return mathOperation.calculateResult(firstNumber, secondNumber);
    }

}
