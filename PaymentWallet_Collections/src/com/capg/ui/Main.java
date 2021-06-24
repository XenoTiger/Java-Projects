package com.capg.ui;

import java.util.List;
import java.util.Scanner;

import com.capg.bean.BankDetails;
import com.capg.bean.CustomerDetails;
import com.capg.exception.InvalidException;
import com.capg.service.BankService;

public class Main {
	static Scanner sc = new Scanner(System.in);

	static Ui ui = new Ui();

	// Fund Transfer Method from one Account to Another.

	public static void main(String[] args) throws InvalidException {
		// TODO Auto-generated method stub
		String dec = " ";
		do {
			System.out.println("Welcome to Bank");
			System.out.println("ENTER THE CHOICE");
			System.out.println("1 CREATE ACCOUNT");
			System.out.println("2 SHOW BALANCE"); // This is user_interface part
			System.out.println("3 DEPOSIT");
			System.out.println("4 WITHDRAW");
			System.out.println("5 FUND TRANSFER");
			System.out.println("6 PRINT TRANSACTION");

			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				ui.createAccount();
				break;

			case 2:
				ui.showBalance();
				break;

			case 3:
				ui.deposit();
				break;

			case 4:
				ui.withdraw();
				break;

			case 5:
				ui.fundTransfer();
				break;

			case 6:
				ui.printTransaction();
				break;

			default:
				System.out.println("Invalid Chice");
				break;
			}

			System.out.println("Do you want to continue:  YES or NO");
			dec = sc.next();
		} while (dec.equalsIgnoreCase("yes"));

	}

}
