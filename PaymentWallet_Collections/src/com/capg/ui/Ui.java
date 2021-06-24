package com.capg.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.capg.bean.BankDetails;
import com.capg.bean.CustomerDetails;
import com.capg.exception.InvalidException;
import com.capg.service.BankService;

public class Ui {

	static Scanner sc = new Scanner(System.in);
	static BankService bser = new BankService();
	static List<String> transactionList = new ArrayList<String>();

	public void fundTransfer() throws InvalidException {
		// TODO Auto-generated method stub
		System.out.println("Enter the account number from which you have to transfer money");
		int accNo1 = sc.nextInt();
		boolean check = bser.checkAccount(accNo1); // check whether account already exist or not
		if (check) // if account exist
		{

			System.out.println("Enter the account number to which you have to transfer money");
			int accNo2 = sc.nextInt();
			System.out.println("Enter the Amount to be Transfer");
			double balance = sc.nextDouble();
			if (balance < 0) {
				throw new InvalidException("Balance Should Be More than 0");
			} else {
				BankService bser = new BankService();
				BankDetails b1 = new BankDetails();
				BankDetails b2 = new BankDetails();
				b1 = bser.getDetails(accNo1);
				b2 = bser.getDetails(accNo2);
				bser.tranferAmount(b1, b2, balance);
				transactionList.add("Rupees " + balance + " Transferred from " + accNo1 + " to Account " + accNo2);
			}
		} else {
			System.out.println("Account Does not Exist");
		}

	}

	// Transaction history method which will print all the transaction
	public void printTransaction() {
		// TODO Auto-generated method stub

		for (String result : transactionList) {
			System.out.println(result);
		}

	}

	// Deposit method will help you to add balance in your Account
	public void deposit() throws InvalidException {
		// TODO Auto-generated method stub
		BankDetails b = new BankDetails();
		BankService bser = new BankService();
		System.out.println("Enter Account No:");
		int accNo = sc.nextInt();

		boolean check = bser.checkAccount(accNo); // check whether account already exist or not
		if (check) // if account exist
		{
			b = bser.getDetails(accNo);
			System.out.println("Enter the Amount to be added");
			double balance = sc.nextDouble();
			if (balance < 0) {
				throw new InvalidException("Balance Should Be More than 0");
			} else {

				bser.addBalance(accNo, balance, b);
				System.out.println("Amount deposited Successfully");
				transactionList.add("Rupees " + balance + " deposited in Account " + accNo);
			}
		} else {
			System.out.println("Account Does not Exist");
		}

	}

	// Withdraw method will help you to Withdraw money from your respective Account.
	public void withdraw() throws InvalidException {
		BankDetails b = new BankDetails();
		BankService bser = new BankService();
		System.out.println("Enter Account No:");
		int accNo = sc.nextInt();
		boolean check = bser.checkAccount(accNo); // check whether account already exist or not
		if (check) // if account exist
		{
			System.out.println("Enter the Amount to be Withdraw");
			double balance = sc.nextDouble();
			if (balance < 0) {
				throw new InvalidException("Balance Should Be More than 0");
			} else {

				b = bser.getDetails(accNo);
				bser.deductBalance(accNo, balance, b);
				transactionList.add("Rupees " + balance + " Withdrawl from Account " + accNo);
			}
		} else {
			System.out.println("Account Does not Exist");
		}
	}

	// It will show the balance in your Account
	public void showBalance() {
		// TODO Auto-generated method stub
		BankDetails b = new BankDetails();

		System.out.println("Enter the account no:");
		int accNo = sc.nextInt();
		boolean check = bser.checkAccount(accNo);
		// check whether account already exist or not
		if (check) // if account exist
		{
			double balance = b.getBalance();
			System.out.println(bser.getDetails(accNo));
		} else {
			System.out.println("Account Does not Exist");
		}
	}

	// This method eill help you to open account in a bank.
	public void createAccount() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Customer name");
		String name = sc.next();
		String mob = "";

		boolean mobileFlag = false;
		do {
			sc = new Scanner(System.in);
			System.out.println("Enter the Mobile Number");

			try {
				mob = sc.nextLine();
				bser.custMobValidation(mob);
				mobileFlag = true;
			} catch (InputMismatchException e) {
				mobileFlag = false;
				System.err.println("No should be in digits");
			} catch (InvalidException e) {
				mobileFlag = false;
				System.err.println(e.getMessage());
			}
		} while (!mobileFlag);

		String email = "";
		boolean emailFlag = false;
		do {

			System.out.println("Enter email :");
			try {
				email = sc.nextLine();
				bser.custEmailValidation(email);
				emailFlag = true;
			} catch (InputMismatchException e) {
				emailFlag = false;
				System.err.println("Cost should be in digits");
			} catch (InvalidException e) {
				emailFlag = false;
				System.err.println(e.getMessage());
			}
		} while (!emailFlag);

		System.out.println("Enter the Accout_Type");
		String accType = sc.next();
		CustomerDetails c = new CustomerDetails(name, mob, email, accType);
		BankDetails b = new BankDetails(c);
		BankService bser = new BankService();
		bser.storeDetails(b);
		System.out.println("Acoount has been created successfully" + "\n And the Account no is : " + b.getAccNo());

	}

}
