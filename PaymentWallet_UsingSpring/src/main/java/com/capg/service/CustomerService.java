package com.capg.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.capg.bean.Customer;

public interface CustomerService {
	public void createCustomer(Customer customer);
	public double getDetailsById(int accountNo);
	public double deposit(int accountNo, double balance);
	public double withdraw(int accountNo, double balance);
	public void fundTransfer(int accountNo1,int accountNo2,double balance);
	
}


