package com.capg.bean;

public class CustomerDetails {
	
	private String custName;
	private String mobileNo;
	private String emailId;
	private String accType;
	
	public CustomerDetails(String custName, String mobileNo, String emailId, String accType) {
		super();
		this.custName = custName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.accType = accType;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
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

	@Override
	public String toString() {
		return "CustomerDetails [custName=" + custName + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", accType=" + accType + "]";
	}
	
	
	
	
	

}
