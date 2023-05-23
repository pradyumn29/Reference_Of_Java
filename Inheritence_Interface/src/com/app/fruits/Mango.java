package com.app.fruits;

public class Mango extends Fruits {

	public Mango(String name,double weight,String color)
	{
		super(name,weight,color);
	}
	
	@Override
	public String taste()
	{
		return "Sweet";
	}
	
	public void pulp()
	{
		System.out.println(super.getName()+" "+super.getColor()+" "+" creating pulp");
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
}
