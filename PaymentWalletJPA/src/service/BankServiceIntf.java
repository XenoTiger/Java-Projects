package service;

import bean.Bank;
import bean.Customer;

public interface BankServiceIntf {

	public void create(Customer cust);

	public Bank showBalance(int accountNo);

	public void deposit(int accountNo, double balance);

	public void withdraw(int accountNo, double balance);

	public void fundTransfer(int accountNo1, int accountNo2, double balance);

}
