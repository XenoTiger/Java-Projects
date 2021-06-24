package service;

import bean.Bank;
import bean.Customer;
import dao.BankDao;

public class BankService implements BankServiceIntf{
	
	BankDao bd=new BankDao();
	
	public void create(Customer cust) {
		bd.begin();
		bd.createAccount(cust);
		bd.commit();
	}
	
	public Bank showBalance(int accountNo) {
		//no need of transaction, as it's an read operation
		
		bd.begin();
		Bank bank  = bd.showBalance(accountNo);
		bd.commit();
		return bank;
		
	}
	
	public void deposit(int accountNo, double balance ){
		bd.begin();
		Bank bank  = bd.showBalance(accountNo);
		bank.setBalance(bank.getBalance() + balance);
		
		bd.commit();
		
	}
	
	public void withdraw(int accountNo, double balance ){
		bd.begin();
		Bank bank  = bd.showBalance(accountNo);
		bank.setBalance(bank.getBalance() - balance);
		bd.commit();
		
	}
	
	public void fundTransfer(int accountNo1,int accountNo2 ,double balance){
		
		
		withdraw(accountNo1 ,balance);
		deposit(accountNo2 ,balance);
	
		
	}


}
