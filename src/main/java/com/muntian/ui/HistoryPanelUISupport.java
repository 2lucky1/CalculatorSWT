package com.muntian.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class HistoryPanelUISupport {

	private HistoryPanelUI _historyUI;

	public HistoryPanelUISupport(HistoryPanelUI _historyUI) {
		this._historyUI = _historyUI;
		addActionListener();
	}
	
	private void addActionListener() {
		_historyUI._btnClear.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				switch(event.type) {
				case SWT.Selection:
					_historyUI._listResults.removeAll();
				}
			}
		});
	}
}
