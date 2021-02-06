package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class MainPanelUI extends Composite {

	private static final String TITLE_CALCULATOR = "Calculator";
	private static final String TITLE_HISTORY = "History";

	private CTabFolder tabFolder;
	private CTabItem tabItemCalc;
	private CTabItem tabItemHistory;
	
	MathPanelUI _mathPanelUI;
	HistoryPanelUI _historyPanelUI;
	

	public MainPanelUI(Composite parent) {
		super(parent, SWT.BORDER);		
		createContent(parent);
	}
	
	
	private void createContent(Composite parent) {
		tabFolder=new CTabFolder(MainPanelUI.this, SWT.BORDER);
		GridLayout gridLayout = new GridLayout(1,false);
		tabFolder.setLayout(gridLayout);
		
		GridData gridData = new GridData(SWT.FILL,SWT.FILL,true,true);
		tabFolder.setLayoutData(gridData);
		tabFolder.setSize(280, 280);

		_mathPanelUI = new MathPanelUI(tabFolder);
		
		tabItemCalc=new CTabItem(tabFolder,SWT.NONE);
		tabItemCalc.setText(TITLE_CALCULATOR);
		tabItemCalc.setControl(_mathPanelUI);
	
		
		_historyPanelUI = new HistoryPanelUI(tabFolder);
		
		tabItemHistory=new CTabItem(tabFolder,SWT.NONE);
		tabItemHistory.setText(TITLE_HISTORY);
		tabItemHistory.setControl(_historyPanelUI);
	}

	public MathPanelUI getMathOperationPanel() {
		return _mathPanelUI;
	}

	public HistoryPanelUI getHistoryPanel() {
		return _historyPanelUI;
	}
}
