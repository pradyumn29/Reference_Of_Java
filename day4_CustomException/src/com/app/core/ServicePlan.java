package com.app.core;

public enum ServicePlan {
 
	SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000);

	private double PlanCost;
	private ServicePlan(double PlanCost) {

		this.PlanCost=PlanCost;
	}
	
	public double getCost()
	{
		return PlanCost;
	}
	 
	public String toString()
	{
		return "Enum["+name()+"@"+PlanCost+"]";
	}
}
