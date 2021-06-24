package com.capg.dao;

import java.util.Map;

import com.capg.bean.BankDetails;

public interface BankDatabaseIntf {

	
	public void storeBankDetailsDb(BankDetails b);
	
	public Map<Integer,BankDetails> getBankDetailsDb(int i);
	
	public boolean checkAccount(int accNo);
	
}
