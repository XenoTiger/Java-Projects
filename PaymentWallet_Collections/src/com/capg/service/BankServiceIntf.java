package com.capg.service;

import java.util.List;

import com.capg.bean.BankDetails;
import com.capg.exception.InvalidException;

public interface BankServiceIntf {

	public void storeDetails(BankDetails b);

	public BankDetails getDetails(int i);

	public void addBalance(int accNo, double balance, BankDetails b);

	public void deductBalance(int accNo, double balance, BankDetails b) throws InvalidException;

	public void tranferAmount(BankDetails b1, BankDetails b2, double balance) throws InvalidException;

	public boolean custMobValidation(String mobileNo) throws InvalidException;

	public boolean custEmailValidation(String emailId) throws InvalidException;

	public boolean checkAccount(int accNo);

}
