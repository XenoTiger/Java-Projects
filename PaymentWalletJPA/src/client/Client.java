package client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {
	
	static Scanner sc= new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		ClientUI cu=new ClientUI();
		
		String dec=" ";
		do{
		System.out.println("Welcome to Bank");
		System.out.println("ENTER THE CHOICE");
		System.out.println("1 CREATE ACCOUNT");
		System.out.println("2 SHOW BALANCE");			//This is user_interface part
		System.out.println("3 DEPOSIT");
		System.out.println("4 WITHDRAW");
		System.out.println("5 FUND TRANSFER");
		System.out.println("6 PRINT TRANSACTION");	

		int	choice= sc.nextInt();
		switch(choice){
		
		case 1: cu.createAccount();
		break;
		
		case 2: cu.showBalance();
		break;
//		
		case 3: cu.deposit();
		break;
//		
		case 4: cu.withdraw();
		break;
//		
		case 5: cu.fundTransfer();
		break;
		
		case 6: cu.printTransaction();
		break;
		
		default: System.out.println("Invalid Chice");
		break;
		}
		
		System.out.println("Do you want to continue:  YES or NO");
		dec=sc.next();
		} while(dec.equalsIgnoreCase("yes"));
		
	}
	
}



