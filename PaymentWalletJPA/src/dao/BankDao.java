package dao;

import javax.persistence.EntityManager;



import bean.Bank;
import bean.Customer;

public class BankDao {
	
	EntityManager entityManager;
	
	public BankDao() {
		entityManager =JPAUtil.getEntityManager();
		}
		
	
	public void begin() {
		entityManager.getTransaction().begin();
	}
	
	public void commit() {
		entityManager.getTransaction().commit();
	}

	
	public void createAccount(Customer cust) {
		entityManager.persist(cust);
	}
	
	public Bank showBalance(int accountNo){
	
		Bank bank = entityManager.find(Bank.class, accountNo);
		return bank;
		
	}
	
	
	
	
	
	
	
	
	
}
