package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capg.bean.Customer;
import com.capg.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerController {

	@Autowired
	CustomerService service;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createCustomer(@RequestBody Customer customer) {
		System.out.println("dfs");
		service.createCustomer(customer);
		System.out.println(customer.getName());
	}

	@RequestMapping("/show/{accountNo}")
	public double showBalance(@PathVariable int accountNo) {
		return service.getDetailsById(accountNo);
	}

	@PutMapping(path = "/deposit/{accountNo}/{balance}")
	public double deposit(@PathVariable int accountNo,@PathVariable double balance) {
		return service.deposit(accountNo, balance);
	}

	@PutMapping(path = "/withdraw/{accountNo}/{balance}")
	public double withdraw(@PathVariable int accountNo,@PathVariable double balance) {
		return service.withdraw(accountNo, balance);
	}

	@PutMapping(path = "/transfer/{accountNo1}/{accountNo2}/{balance}")
	public void fundTransfer(@PathVariable int accountNo1,@PathVariable int accountNo2,@PathVariable double balance) {
		service.fundTransfer(accountNo1, accountNo2, balance);
	}

}
