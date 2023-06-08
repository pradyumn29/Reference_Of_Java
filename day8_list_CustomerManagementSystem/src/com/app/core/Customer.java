package com.app.core;

import java.time.LocalDate;

public class Customer {
	
	private int custId;
	public static int counter;
	private String FirstName;
	private String LastName;
	private String Email;
	private double RegistrationAmt;
	private String Password;
	private LocalDate DOB;
	private ServicePlan Plan;
	
	static {
		counter=1000;
	
	}

	public Customer( String firstName, String lastName, String email, double registrationAmt,String password, LocalDate dOB,
			ServicePlan validPlan) {
		super();
		++counter;
		this.custId = counter;;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		RegistrationAmt = registrationAmt;
		Password=password;
		DOB = dOB;
		Plan = validPlan;
	}
	
	public Customer(String Email)
	{
		this.Email=Email;
	}
	
	public Customer(String Email, String Password) {
		this.Email=Email;
		this.Password=Password;
	}

	//getter for Email
	public String getEmail()
	{
		return this.Email;
	}
	
	//getter for Password
	public String getPassword()
	{
		return this.Password;
	}
	//setter
	public void setPassword(String Password)
	{
		this.Password=Password;
	}
	
	//setter
	public void setPlan(ServicePlan Plan)
	{
		this.Plan=Plan;
	}
	public void setRegistrationAmt(double RegistrationAmt)
	{
		this.RegistrationAmt=RegistrationAmt;
	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email
				+", Date of birth="+DOB+", RegistrationAmt=" + RegistrationAmt + ", Plan=" + Plan + "]";
	}
	
	//email validation
	public boolean equals(Object o)
	{
		if(o instanceof Customer) 
			return this.Email.equals(((Customer)o).Email);
		return false;
	}	

}
