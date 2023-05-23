package com.app.fruits;

public class Apple extends Fruits {
 
	public Apple(String name,double weight,String color)
	{
		super(name,weight,color);
	}
	
	public String toString()
	{
		return super.toString();
	}
	
	public String taste()
	{
		return "Sweet n Sour";
	}
	
	public void jam()
	{
		System.out.println(super.getName()+" making jam!");
	}
}
