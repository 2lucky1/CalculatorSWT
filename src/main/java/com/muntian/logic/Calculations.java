package com.muntian.logic;

import java.util.Map;

import com.muntian.interfaces.Observer;
import com.muntian.model.CalcModel;
import com.muntian.ui.CalcViewMgr;
import com.muntian.ui.MainPanelUI;

public class Calculations implements Observer {

	private double firstNumber;
	private String mathOperator;
	private double secondNumber;
	private double result;

	private CalcModel mathData;
	private AbstractCalculator calculator;
	
	private CalcViewMgr _calcViewMgr;

	public Calculations(AbstractCalculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void update(Map params) {
		
		_calcViewMgr = CalcViewMgr.getInstance();
		
		this.firstNumber = (double) params.get("firstOperand");
		this.mathOperator = (String) params.get("sign");
		this.secondNumber = (double) params.get("secondOperand");
		
		this.result = calculator.makeCalculation(firstNumber, secondNumber, mathOperator);
		setResultIntoResultField(result);
		setResultIntoHistory(result);
	}
	
	private void setResultIntoResultField(double result) {
		_calcViewMgr.getMathPanel().updateResultField(String.valueOf(result));
	}
	
	private void setResultIntoHistory(double result) {
		_calcViewMgr.getHistoryPanel()
		            .addStatementToHistory(firstNumber + mathOperator + secondNumber + " = " + result);
	}
	

}
