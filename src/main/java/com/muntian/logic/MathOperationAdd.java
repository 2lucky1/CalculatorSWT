package com.muntian.logic;

import com.muntian.interfaces.MathOperation;

public class MathOperationAdd implements MathOperation {

	@Override
	public double calculateResult(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

}
