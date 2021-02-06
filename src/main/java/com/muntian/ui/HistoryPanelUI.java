package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

public class HistoryPanelUI extends Composite {

	private static final String CLEAR = "Clear";
	List _listResults;
	Button _btnClear;
	
	public HistoryPanelUI(Composite parent) {
		super(parent, SWT.NONE);
		createContent(parent);
	}

	private void createContent(Composite parent) {
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setLayout(new GridLayout(1, false));
		setBackground(parent.getShell().getBackground());
		
		_listResults = new List(this, SWT.V_SCROLL | SWT.BORDER);
		_listResults.setLayoutData(new GridData(240, 210));
		
		_btnClear = new Button(this, SWT.PUSH);
		_btnClear.setText(CLEAR);
		GridData gridData = new GridData(GridData.END, GridData.CENTER,false,false);
		_btnClear.setLayoutData(gridData);
	}
	
	public void addStatementToHistory(String statement) {
		_listResults.add(statement);
	}

}
