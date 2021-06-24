package bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="customer_details")
public class Customer implements Serializable {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	 int custId;
	String name;
	long phoneNo;
	String emailId;
	String accType;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNo")
	Bank account;

	  static int counter=100;
	  
	  public Customer() {
	 
	  this.custId= counter; 
	  counter++; 
	  }
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public Bank getAccount() {
		return account;
	}
	public void setAccount(Bank account) {
		this.account = account;
	}


}