package com.muntian.interfaces;

public interface MathOperation {
    
  public static final String PLUS      = "+";
  public static final String MINUS     = "-";
  public static final String DIVISION  = "/";
  public static final String MULTIPLY  = "*";

	double calculateResult(double firstNumber, double secondNumber);

}
