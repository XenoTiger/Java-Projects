package client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.security.auth.login.AccountException;
import bean.Bank;
import bean.Customer;
import exception.InvalidException;
import service.BankService;

public class ClientUI {

	static Scanner sc = new Scanner(System.in);
	Customer cust = new Customer();
	Bank bank = new Bank();
	static BankService bser = new BankService();

	static List<String> transactionList = new ArrayList<String>();

	static int accountNo = 87711000;
	static int custId = 100;

	public void createAccount() {
		Bank bank = new Bank();
		Customer cust = new Customer();
		System.out.println("Enter the Customer name");
		String name = sc.next();
		System.out.println("Enter the Mobile Number");
		long mob = sc.nextLong();
		try {
			if (String.valueOf(mob).length() == 10 && mob > 0) {
				System.out.println("Enter the email Id");
				String email = sc.next();
				System.out.println("Enter the Accout_Type");
				String accType = sc.next();
				cust.setName(name);
				cust.setPhoneNo(mob);
				cust.setEmailId(email);
				cust.setAccType(accType);

				cust.setAccount(bank);
				bser.create(cust);
				System.out.println("Account is Created Successfully for Account No: " + bank.getAccountNo());
			} else
				throw new InvalidException("Mobile Number Should Be 10 Digits");
		} catch (InvalidException e) {
			System.out.println("Please Try With Valid Mobile Number");
		}
	}

	public void showBalance() {

		System.out.println("Enter Account No");
		int accountNo = sc.nextInt();

		try {
			if (bser.showBalance(accountNo) != null) {
				Bank bank = bser.showBalance(accountNo);
				bank = bser.showBalance(accountNo);

				System.out.println("Account No : " + bank.getAccountNo());
				System.out.println("Balance : " + bank.getBalance());
			} else
				throw new InvalidException("Account not registered with Our Bank");
		} catch (InvalidException e) {
			System.out.println("Please Try Again" + " " + e);
		}

	}

	public void deposit() {
		System.out.println("Enter the Account No");
		int accountNo = sc.nextInt();
		try {
			if (bser.showBalance(accountNo) != null) {
				Bank bank = bser.showBalance(accountNo);

				System.out.println("Enter the Amount you Want to Add");
				double balance = sc.nextDouble();
				bser.deposit(accountNo, balance);

				System.out.println("Amount Deposited Successfully");

				transactionList.add("Rupees " + balance + " deposited in Account " + accountNo);
			} else
				throw new InvalidException("Account not registered with Our Bank");
		} catch (InvalidException e) {
			System.out.println("Please Try Again " + " " + e);
		}

	}

	public void withdraw() {
		System.out.println("Enter the Account No");
		int accountNo = sc.nextInt();
		try {
			if (bser.showBalance(accountNo) != null) {
				Bank bank = bser.showBalance(accountNo);
				System.out.println("Available Balance :" + bank.getBalance());
				System.out.println("Enter the Amount you Want to Withdraw");
				double balance = sc.nextDouble();
				double currBal = bank.getBalance();

				try {
					if (balance < currBal) {
						bser.withdraw(accountNo, balance);
						System.out.println("Amount Withdrawl Successfully");

						transactionList.add("Rupees " + balance + " Withdrawl from Account " + accountNo);
					} else

						throw new InvalidException("Insufficient Balance");
				} catch (InvalidException e) {
					System.out.println("Insufficient Balance, Please Update Balance and Try Again");
				}
			} else
				throw new InvalidException("Account not registered with Our Bank");
		} catch (InvalidException e) {
			System.out.println("Please Try Again With Valid Account No" + " " + e);
		}

	}

	public void fundTransfer() {
		System.out.println("Enter the account number from which you have to transfer money");
		int accountNo1 = sc.nextInt();

		try {
			if (bser.showBalance(accountNo1) != null) {
				Bank bank = bser.showBalance(accountNo1);
				System.out.println("Enter the account number to which you have to transfer money");
				int accountNo2 = sc.nextInt();
				if (bser.showBalance(accountNo2) != null) {
					Bank bank2 = bser.showBalance(accountNo2);
					System.out.println("Enter the Amount to be Transfer");
					double balance = sc.nextDouble();
					double currBal1 = bank.getBalance();
					try {
						if (balance < currBal1) {

							bser.fundTransfer(accountNo1, accountNo2, balance);
							System.out.println("Amount Transferred Successfully");
							transactionList.add("Rupees " + balance + " Transferred from Account No: " + accountNo1
									+ " to Account No: " + accountNo2);
						} else
							throw new InvalidException("Available Blance is Low");
					} catch (Exception e) {
						System.out.println("Insufficient Balance, Please Update Balance and Try Again");
					}
				} else
					throw new InvalidException("Account not registered with Our Bank");
			} else
				throw new InvalidException("Account Number Not Exist");
		} catch (InvalidException e) {
			System.out.println("Try Again" + " " + e);
		}

	}

	public void printTransaction() {
		for (String result : transactionList) {
			System.out.println(result);
		}
	}
}
