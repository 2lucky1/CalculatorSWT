package com.muntian.logic;

import com.muntian.interfaces.MathOperation;

public class MathOperationSubtraction implements MathOperation {

	@Override
	public double calculateResult(double firstNumber, double secondNumber) {
		return firstNumber - secondNumber;
	}

}
