package com.capg.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.bean.Customer;
import com.capg.dao.CustomerRepository;
import com.capg.exception.InvalidException;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;
	
	@Override
	public void createCustomer(Customer customer) {
		repository.save(customer);
	}

	public double getDetailsById(int accountNo)  {
		
		Customer customer = repository.findById(accountNo).orElse(null);
		return customer.getBalance();

	}

	@Override
	 public double deposit(int accountNo, double balance) {
        Customer customer = repository.findById(accountNo).orElse(null);
        try {
        	if(balance>0) {
        		double totalBalance = customer.getBalance() + balance;
                customer.setBalance(totalBalance);
                repository.save(customer);
                return customer.getBalance();
        	}
        	else
        		throw new InvalidException("Amount must be greater than 0 !!");
        }catch(InvalidException e) {
        	System.out.println(e);
        }
        return customer.getBalance();
    }

	@Override
	public double withdraw(int accountNo, double balance) {
		
		 Customer customer = repository.findById(accountNo).orElse(null);
		 try {
			 if(balance>0 && customer.getBalance()>balance) {
				 double totalBalance = customer.getBalance() - balance;
			        customer.setBalance(totalBalance);
			        repository.save(customer);
			        return customer.getBalance();
			 }
			 else
				 throw new InvalidException("Insufficient Balance");
		 }catch(InvalidException e) {
			 System.out.println(e);
		 }
		 return customer.getBalance();   
	}

	@Override
	public void fundTransfer(int accountNo1, int accountNo2, double balance) {
	
	withdraw(accountNo1,balance);
	deposit(accountNo2,balance);
	}
	
	
}
