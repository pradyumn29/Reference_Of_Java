package com.app.core;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),PLATINUM(10000),DIAMOND(5000);
	
	private double ServiceCost;
	
	private ServicePlan(double ServiceCost){
		//super(name,ordinal):java.lang.Enum
		this.ServiceCost=ServiceCost;	
	}
	
	//getter
	public double getServiceCost()
	{
		return this.ServiceCost ;
	}
	
	//toString  //optional
	@Override
	public String toString()
	{
		return name()+" Cost:"+ServiceCost;
	}

}
