package bean;

import java.util.Random;

public class BankDetails {
	
	int accNo;
	double balance;
	String accType;
	CustomerDetails c;
	
	public BankDetails(int accNo, double balance, String accType, CustomerDetails c) {
		
		Random rand = new Random();
		this.accNo  = rand.nextInt(9000000) + 1000000;
		this.balance = 0.0;
		this.c = c;
		this.accType = c.getAccType();
	}
	public BankDetails(){
		
	}

	public BankDetails(CustomerDetails c){
		Random rand = new Random();
		this.accNo  = rand.nextInt(9000000) + 1000000;
		this.balance=0.0;
		this.c=c;
		this.accType=c.getAccType();
		
	}
	
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public CustomerDetails getC() {
		return c;
	}

	public void setC(CustomerDetails c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "BankDetails [accNo=" + accNo + ", balance=" + balance + "]";
	}
	
	
	

}
