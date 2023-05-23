package com.app.fruits;

public abstract class Fruits {
	
	private String color;
	private double weight;
	private String name;
	private boolean Fresh=true;

	public Fruits(String name,double weight,String color)
	{
		super();
		this.name=name;
		this.weight=weight;
		this.color=color;
	}
	
	public String getName()
	{
		return this.name;
	}
	public String getColor()
	{
		return this.color;
	}
	public double getWeight()
	{
		return this.weight;
	}
	
	//stale check
	public boolean isStale(Fruits f)
	{
		if((f.taste()).equals("Sour"))
		{
			Fresh=false;
			return Fresh;
		}
		else
		{
			return Fresh;
		}
	}
	@Override
	public String toString()
	{
		return "Name: "+this.name+"\nWeight: "+this.weight+"\nColor: "+this.color;
	}
	 
	public abstract String taste();//********************
}
