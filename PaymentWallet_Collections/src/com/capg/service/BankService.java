package com.capg.service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import com.capg.bean.BankDetails;
import com.capg.dao.BankDatabase;
import com.capg.exception.InvalidException;


public class BankService implements BankServiceIntf {

	BankDatabase bd = new BankDatabase();

	@Override
	public void storeDetails(BankDetails b) {
		// TODO Auto-generated method stub
		bd.storeBankDetailsDb(b);

	}

	@Override
	public BankDetails getDetails(int accNo) {
		// TODO Auto-generated method stub
		Map<Integer, BankDetails> map = bd.getBankDetailsDb(accNo);
		BankDetails ba = null;
		Set<Integer> keys = map.keySet();
		for (Integer i : keys) {
			if (i == accNo) {
				ba = map.get(i);
				break;
			} else {
				continue;
			}
		}
		return ba;

	}

	@Override
	public void addBalance(int accNo, double balance, BankDetails b) {
		// TODO Auto-generated method stub
		double amt = b.getBalance();
		balance = balance + amt;
		b.setBalance(balance);
		// System.out.println(b.getBalance());

	}

	@Override
	public void deductBalance(int accNo, double balance, BankDetails b) throws InvalidException {
		// TODO Auto-generated method stub
		double amt = b.getBalance();
		if (b.getBalance() < balance) {
			throw new InvalidException("Insufficient Balance");
		} else {

			balance = Math.abs(balance - amt);
			b.setBalance(balance);
		}

	}

	@Override
	public void tranferAmount(BankDetails b1, BankDetails b2, double balance) throws InvalidException {

		double amt1 = b1.getBalance();
		if (b1.getBalance() < balance) {
			throw new InvalidException("Insufficient Balance");
		} else {
			double balance1 = amt1 - balance; // for account 1
			b1.setBalance(balance1);

			double amt2 = b2.getBalance();
			double balance2 = amt2 + balance; // for account 2

			b2.setBalance(balance2);

		}
	}

	@Override
	public boolean custMobValidation(String mobileNo) throws InvalidException {
		// TODO Auto-generated method stub
		boolean resultMobFlag = false;
		String mobRegex = "[6,7,8,9]{1}[0-9]{9}$";
		if (!Pattern.matches(mobRegex, mobileNo)) {
			throw new InvalidException("Mobile no should start with 7,8,9 and should be 10 digit");
		} else {
			resultMobFlag = true;
		}
		return resultMobFlag;
	}

	@Override
	public boolean custEmailValidation(String emailId) throws InvalidException {
		// TODO Auto-generated method stub
		boolean resultEmailFlag = false;
		String emailRegex = "^[a-z]{5,}@[a-z]{3,}.com$";
		if (!Pattern.matches(emailRegex, emailId)) {
			throw new InvalidException("Email should be in small case end with '.com' ");
		} else {
			resultEmailFlag = true;
		}
		return resultEmailFlag;
	}



	@Override
	public boolean checkAccount(int accNo) {
		// TODO Auto-generated method stub
		return bd.checkAccount(accNo);
	}

}
