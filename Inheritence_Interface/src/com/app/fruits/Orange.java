package com.app.fruits;

public class Orange extends Fruits {

	public Orange(String name,double weight,String color)
	{
		super(name,weight,color);
	}

	@Override
	public String taste()
	{
       return "Sour";
	}
	
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	public void juice()
	{
		System.out.println(super.getName()+" "+super.getWeight()+" "+"extraxting juice!");
	}
}
