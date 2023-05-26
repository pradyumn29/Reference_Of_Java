package com.app.core;

import java.time.LocalDate;

public class Customer {

	private int CustId;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Password;
	private double NetAmount;
	private LocalDate DOB;
	private String ServicePlan;
	

	//paramtertrised constructor
	public Customer(int CustId,String firstName, String lastName, String email, String password, double NetAmount,
			LocalDate dOB, String servicePlan, Customer[] custDetails) {
		super();
		this.CustId=CustId;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		Password = password;
		this.NetAmount= NetAmount;
		DOB = dOB;
		ServicePlan = servicePlan;
	}
	
	
	public Customer(String email) {
		super();
		Email = email;
	}


	@Override
	public String toString() {
		return "Customer [CustId="+CustId+", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", Password="
				+ Password + ", NetAmount=" + NetAmount + ", DOB=" + DOB + ", ServicePlan="
				+ ServicePlan.toUpperCase() + "]";
	}
	
	public String getEmail()
	{
		return this.Email;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Customer)
		
			return this.Email.equals(((Customer)obj).Email);
		return false;
		
	}
	
}
