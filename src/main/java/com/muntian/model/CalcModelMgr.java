package com.muntian.model;

import java.util.Map;

public class CalcModelMgr {

	private static CalcModelMgr _instance;
	
	private CalcModel _calCalcModel; 
	
	private CalcModelMgr () {
		
	}
	
	public static CalcModelMgr getInstance() {
		if(_instance == null) {
			_instance = new CalcModelMgr();
		}
		return _instance;
	}
		
	public CalcModel getCalcModel() {
		if(_calCalcModel == null) {
			_calCalcModel = new CalcModel();
		}
		return _calCalcModel;
	}
	
	public void updateModelFromUI(Map<String, String> params) {
		_calCalcModel.setAllParams(params);
	}
}
