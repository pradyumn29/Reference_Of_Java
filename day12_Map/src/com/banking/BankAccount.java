package com.banking;

import java.time.LocalDate;
import java.time.Period;

import custom_exceptions.BankingException;

import static utils.BankValidations.validateBalance;

/*
 * BankAccount : acctNo, customer name , type , balance , creation date , 
 * last tx date , isActive
 */
public class BankAccount {
	private int acctNo;
	private String customerName;
	private AcctType type;
	private double balance;
	private LocalDate createdOn;
	private LocalDate lastUpdated;
	private boolean isActive;
	private double SimpleInterest;

	// ctor
	public BankAccount(int acctNo, String customerName, AcctType type, double balance, LocalDate createdOn) {
		super();
		this.acctNo = acctNo;
		this.customerName = customerName;
		this.type = type;
		this.balance = balance;
		this.createdOn = createdOn;
		this.lastUpdated = this.createdOn;
		this.isActive = true;
	}
	// fetch a/c summary : toString

	@Override
	public String toString() {
		return "BankAccount [acctNo=" + acctNo + ", customerName=" + customerName + ", type=" + type + ", balance="
				+ balance + ", createdOn=" + createdOn + ", lastUpdated=" + lastUpdated + ", isActive=" + isActive
				+ "]";
	}

	// For correct working of hashing algo + O(1) :
	// which methods(equals , hashCode) should be overridden? NONE , since HM will
	// call these methods on Key type
	// BankAccount : Value type
	public void deposit(double amount) throws BankingException{
		if (isActive) {
			balance += amount;
			this.lastUpdated=LocalDate.now();
		}
		else
			throw new BankingException("Inactive A/C !!!!!! , Can not deposit !!!!");
	}

	public void withdraw(double amount) throws BankingException {
		if (isActive) {
			validateBalance(balance - amount);
			balance -= amount;
			this.lastUpdated=LocalDate.now();
		} else
			throw new BankingException("Inactive A/C !!!!!!");
	}

	public void transferFunds(BankAccount dest, double amount) throws BankingException {
		if(isActive)
		{
			this.withdraw(amount);
			if(dest.isActive)
			{
				dest.deposit(amount);
				System.out.println("funds transferred.....");
				
			}
			else
			{
				this.deposit(amount);
				throw new BankingException("destination Account Inactive,amount deposited back to source account");
			}
		}
		else
		{
			throw new BankingException("Source is Account Inactive");
		}
		
	}
	//getters

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
     //getter
	public int getAcctNo() {
		return acctNo;
	}
	//getter
	public boolean getisActive()
	{
		return isActive;
	}
	
	//getter
	public String getName()
	{
		return customerName;
	}

	//getter
	public AcctType getType() {
		return type;
	}
	
	public void applyInterest(float rate) throws BankingException
	{
		
		float Month=Period.between(createdOn,LocalDate.now()).getMonths();
		double temp=balance;
		SimpleInterest=(this.balance*(rate/12)*Month)/100;
		
		if(isActive) {
			this.balance+=SimpleInterest;
			System.out.println("total period "+Month+"Interest Applied\n "+"Old balance:"+temp+" Simple Interest:"
			+SimpleInterest+" Updated balance:"+balance);
		}
		else {
		throw new BankingException("Inactive account!!");
		}
	}
	

}
