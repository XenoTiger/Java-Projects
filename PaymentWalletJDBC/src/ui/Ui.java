package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import bean.BankDetails;
import bean.CustomerDetails;
import exception.InvalidException;
import service.BankService;

public class Ui {
	static Scanner sc = new Scanner(System.in);
	static BankService bser = new BankService();
	static List<String> transactionList = new ArrayList<String>();
	static BankDetails bank = new BankDetails();

	// Fund Transfer Method from one Account to Another.
	public void fundTransfer() {
		// TODO Auto-generated method stub
		System.out.println("Enter the account number from which you have to transfer money");
		int accNo1 = sc.nextInt();

		try {
			if (bser.getDetails(accNo1) != 0L) {
				double data1 = bser.getDetails(accNo1);
				data1 = bser.getDetails(accNo1);
				System.out.println("Enter the account number to which you have to transfer money");
				int accNo2 = sc.nextInt();
				if (bser.getDetails(accNo1) != 0L) {
					double data2 = bser.getDetails(accNo2);
					data2 = bser.getDetails(accNo2);
					System.out.println("Enter the Amount to be Transfer");
					double balance = sc.nextDouble();
					double currBal1 = bser.getDetails(accNo1);
					try {
						if (balance < currBal1) {

							bser.tranferAmount(accNo1, accNo2, balance);
							System.out.println("Amount Transferred Successfully");
							transactionList
									.add("Rupees " + balance + " Transferred from " + accNo1 + " to Account " + accNo2);
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
		// TODO Auto-generated method stub
		for (String result : transactionList) {
			System.out.println(result);
		}

	}

	public void deposit() {
		// TODO Auto-generated method stub
		BankDetails b = new BankDetails();
		BankService bser = new BankService();
		System.out.println("Enter Account No:");
		int accNo = sc.nextInt();

		try {
			if (bser.getDetails(accNo) != 0L) {
				double data = bser.getDetails(accNo);
				data = bser.getDetails(accNo);

				System.out.println("Enter the Amount to be added");
				double balance = sc.nextDouble();
				// b=bser.getDetails(accNo);
				bser.addBalance(accNo, balance);
				System.out.println("Amount deposited Successfully");
				transactionList.add("Rupees " + balance + " deposited in Account " + accNo);
			} else
				throw new InvalidException("Account not registered with Our Bank");
		} catch (InvalidException e) {
			System.out.println("Please Try Again " + " " + e);
		}

	}

	public void withdraw() {
		BankDetails b = new BankDetails();
		BankService bser = new BankService();
		System.out.println("Enter Account No:");
		int accNo = sc.nextInt();

		try {
			if (bser.getDetails(accNo) != 0L) {
				double data = bser.getDetails(accNo);
				data = bser.getDetails(accNo);
				System.out.println("Enter the Amount to be Withdraw");
				double balance = sc.nextDouble();
				double currBal = bser.getDetails(accNo);

				try {
					if (balance < currBal) {
						bser.deductBalance(accNo, balance);
						System.out.println("Amount Withdrawl Successfully");
						transactionList.add("Rupees " + balance + " Withdrawl from Account " + accNo);
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

	// It will show the balance in your Account
	public void showBalance() {
		// TODO Auto-generated method stub

		System.out.println("Enter the account no:");
		int accNo = sc.nextInt();

		try {
			if (bser.getDetails(accNo) != 0L) {
				double data = bser.getDetails(accNo);
				data = bser.getDetails(accNo);
				double balance = bank.getBalance();
				System.out.println(bser.getDetails(accNo));
			} else
				throw new InvalidException("Account not registered with Our Bank");
		} catch (InvalidException e) {
			System.out.println("Please Try Again" + " " + e);
		}

	}

	// This method Will help you to open account in a bank.
	public void createAccount() {
		// TODO Auto-generated method stub
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
				CustomerDetails c = new CustomerDetails(name, mob, email, accType);
				BankDetails b = new BankDetails(c);
				BankService bser = new BankService();
				bser.storeDetails(b);
				System.out.println(
						"Acoount has been created successfully" + "\n And the Account no is : " + b.getAccNo());

			} else
				throw new InvalidException("Mobile Number Should Be 10 Digits");
		} catch (InvalidException e) {
			System.out.println("Please Try With Valid Mobile Number");
		}
	}
}
