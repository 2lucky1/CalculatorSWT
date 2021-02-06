package com.muntian.ui;

import org.eclipse.swt.widgets.Composite;

public class CalcViewMgr {
	private static CalcViewMgr _instance;
	
	private MainPanelUI _mainPanel;
	private MathPanelUI _mathPanel;
	private HistoryPanelUI _historyPanel;
	
	private MathPanelUISupport _mathPanelUISupport;
	private HistoryPanelUISupport _historyPanelUISupport;
	
	private CalcViewMgr() {
		
	}
	
	public static CalcViewMgr getInstance() {
		if(_instance == null) {
			_instance = new CalcViewMgr();
		}
		return _instance;
	}
	
	public void createUI(Composite parent) {
		_mainPanel = new MainPanelUI(parent);
		_mathPanel = _mainPanel._mathPanelUI;
		_historyPanel = _mainPanel._historyPanelUI;
		
		_mathPanelUISupport = new MathPanelUISupport(_mathPanel);
		_historyPanelUISupport = new HistoryPanelUISupport(_historyPanel);
	}

	public MainPanelUI getMainPanel() {
		return _mainPanel;
	}

	public MathPanelUI getMathPanel() {
		return _mathPanel;
	}

	public HistoryPanelUI getHistoryPanel() {
		return _historyPanel;
	}

	public MathPanelUISupport getMathPanelUISupport() {
		return _mathPanelUISupport;
	}

	public HistoryPanelUISupport getHisHistoryPanelUISupport() {
		return _historyPanelUISupport;
	}
	
	
}
