package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.muntian.interfaces.MathOperation;
import com.muntian.model.CalcModelMgr;

public class MathPanelUISupport {

	private MathPanelUI _mathPanelUI;
	private CalcModelMgr _modelMgr;

	public MathPanelUISupport(MathPanelUI mathPanelUI) {
		this._mathPanelUI = mathPanelUI;
		_modelMgr = CalcModelMgr.getInstance();
		addActionListener();
	}
	
	private void addActionListener() {
		_mathPanelUI._firstNumber.addModifyListener(new ModifyListenerForFirstOperand());
		_mathPanelUI._firstNumber.addListener(SWT.Verify, new VerifyListenerForOperand());
		_mathPanelUI._secondNumber.addModifyListener(new ModifyListenerForSecondOperand());
		_mathPanelUI._secondNumber.addListener(SWT.Verify, new VerifyListenerForOperand());
		_mathPanelUI._mathOperator.addSelectionListener(new SelectionAdapterForMathOperator());
		_mathPanelUI._checkBoxOnFlyMode.addSelectionListener(new SelectionAdapterForCheckBox());
		_mathPanelUI._btnCalculate.addListener(SWT.Selection, new ListenerForButtonCalculate());
	}
	
	private boolean verifyInputNumber(Event e) {
		Text widget = (Text) e.widget;
		String wholNumber = widget.getText();
		String input = e.text;
		if (e.character == 8) {
			return true;
		} else if ((wholNumber.length() == 0) && input.equals(MathOperation.MINUS)) {
			return true;
		} else if (wholNumber.length() != 0 && !pointIsAdded(wholNumber) && input.equals(".")) {
			return true;
		} else {
			try {
				double digit = Double.parseDouble(input);
			} catch (NumberFormatException nfe) {
				return false;
			}
		}

		return true;
	}
	
	private boolean pointIsAdded(String number) {
		return number.indexOf(".") >= 0;
	}
	
	private class VerifyListenerForOperand implements Listener {
		@Override
		public void handleEvent(Event e) {
			if (verifyInputNumber(e) || e.character == 8) {
				System.out.println("All is good");
			} else {
				e.doit = false;
				System.out.println("incorrect input");
			}
		}
	}
	
	private class ModifyListenerForFirstOperand implements ModifyListener {
		@Override
		public void modifyText(ModifyEvent e) {
			Text widget = (Text) e.widget;
			String operand = widget.getText();
			if (_mathPanelUI._checkBoxOnFlyMode.getSelection()) {
				System.out.println("Modify listener!!");
				_modelMgr.getCalcModel().setFirstOperand(Double.parseDouble(operand));
			}
		}
	}
	
	private class ModifyListenerForSecondOperand implements ModifyListener {
		@Override
		public void modifyText(ModifyEvent e) {
			Text widget = (Text) e.widget;
			String operand = widget.getText();
			if (_mathPanelUI._checkBoxOnFlyMode.getSelection()) {
				System.out.println("Modify listener!!");
				_modelMgr.getCalcModel().setSecondOperand(Double.parseDouble(operand));
			}
		}
	}

	private class SelectionAdapterForMathOperator extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (_mathPanelUI._checkBoxOnFlyMode.getSelection()) {
				_modelMgr.getCalcModel().setSign(_mathPanelUI._mathOperator.getText());
			}
		}
	}

	
	private class SelectionAdapterForCheckBox extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			CalcModelMgr.getInstance().getCalcModel().setOnFlyMode(_mathPanelUI._checkBoxOnFlyMode.getSelection());
			if (_mathPanelUI._checkBoxOnFlyMode.getSelection()) {
				_mathPanelUI._btnCalculate.setEnabled(false);
			} else {
				_mathPanelUI._btnCalculate.setEnabled(true);
			}
		}
	}
	
	private class ListenerForButtonCalculate implements Listener{
		
		@Override
		public void handleEvent(Event event) {
			switch (event.type) {
			case SWT.Selection:
				_modelMgr.getCalcModel().setAllParams(_mathPanelUI.getParams());
				break;
			}
		}
	}
	
	
}
