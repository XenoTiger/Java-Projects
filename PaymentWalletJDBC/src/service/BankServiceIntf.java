package service;

import java.util.List;

import bean.BankDetails;


public interface BankServiceIntf {

	public void storeDetails(BankDetails b);

	public double getDetails(int i);

	public void addBalance(int accNo, double balance);

	public void deductBalance(int accNo, double balance);

	public void tranferAmount(int accNo1, int accNo2, double balance);

	
	

}
