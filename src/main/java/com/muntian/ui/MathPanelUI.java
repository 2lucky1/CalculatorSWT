package com.muntian.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class MathPanelUI extends Composite {

	private static final String RESULT = "Result:";
	private static final String CALCULATE = "Calculate";
	private static final String CALCULATE_ON_THE_FLY = "Calculate on the fly";

	private static final String[] items = new String[] { "+", "-", "/", "*" };

	Text _firstNumber;
	Combo _mathOperator;
	Text _secondNumber;
	Button _checkBoxOnFlyMode;
	Label _labelCalcOnTheFly;
	Button _btnCalculate;
	Label _labelResult;
	Text _textResult;


	public MathPanelUI(Composite parent) {
		super(parent, SWT.NONE);
		createContent(parent);
	}

	private void createContent(Composite parent) {

		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(3, false);
		gridLayout.verticalSpacing = 85;
		gridLayout.horizontalSpacing = 18;
		setLayout(gridLayout);
		setBackground(parent.getShell().getBackground());

		_firstNumber = new Text(this, SWT.BORDER);

		_mathOperator = new Combo(this, SWT.DROP_DOWN);
		_mathOperator.setItems(items);
		GridData gridData = new GridData(GridData.CENTER, GridData.FILL, false, false);
		gridData.widthHint = 50;
		gridData.heightHint = 5;
		gridData.minimumHeight = 200;
		_mathOperator.setLayoutData(gridData);

		_secondNumber = new Text(this, SWT.BORDER);

		_checkBoxOnFlyMode = new Button(this, SWT.CHECK);

		_labelCalcOnTheFly = new Label(this, SWT.NONE);
		_labelCalcOnTheFly.setText(CALCULATE_ON_THE_FLY);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalIndent = -70;
		gridData.verticalIndent = 4;
		_labelCalcOnTheFly.setLayoutData(gridData);

		_btnCalculate = new Button(this, SWT.PUSH);
		_btnCalculate.setText(CALCULATE);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalIndent = 10;
		gridData.minimumWidth = 50;
		gridData.minimumHeight = 5;
		_btnCalculate.setLayoutData(gridData);

		_labelResult = new Label(this, SWT.NONE);
		_labelResult.setText(RESULT);

		_textResult = new Text(this, SWT.BORDER);
		gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.horizontalSpan = 2;
		_textResult.setLayoutData(gridData);
	}

	/**
	 * This method update result field in calculator.
	 * 
	 * @param text
	 */
	public void updateResultField(String text) {
		_textResult.setText(text);
	}
	
	Map<String, String> getParams(){
		Map<String, String> params = new HashMap<>();
		params.put("firstOperand", _firstNumber.getText());
		params.put("secondOperand", _secondNumber.getText());
		params.put("sign", _mathOperator.getText());
		return params;
	}
}

