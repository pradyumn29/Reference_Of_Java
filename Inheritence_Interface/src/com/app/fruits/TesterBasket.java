package com.app.fruits;

import java.util.Scanner;

public class TesterBasket {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		//creating basket size
		System.out.println("enter basket size:");
		int iSize=sc.nextInt();
		
		//creating array of frutis
		Fruits []f=new Fruits[iSize];
		
		int ch,index=0;
		
		//adding elements in basket
		do
		{
			System.out.println("1.Add Mango\t5.Show Basket\n2.Add Orange\t6.Mark as stale\n3.Add Apple\t7.Show functionality\n4.Basket Items\t8.Exit\nEnter Choice: ");
			ch=sc.nextInt();
			
			switch(ch)
			{
			
			case 1: //Add Mango
				
				if(index<f.length)
				{
					System.out.println("---Add Mango---"+"\nEnter:1]Name 2]Weight 3]color");
					f[index]=new Mango(sc.next(),sc.nextDouble(),sc.next());
					index++;
				}
				else
				{
					System.out.println("Array is full----");
				}
				
				break;
				
			case 2: //Add Orange
				
				if(index<f.length)
				{
					System.out.println("----Add orange----"+"\nEnter:1]Name 2]Weight 3]color");
					f[index]=new Orange(sc.next(),sc.nextDouble(),sc.next());
					index++;
				}
				else
				{
					System.out.println("Array is full----");
				}
				
				break;
				
			case 3: //Add Apple
				
				if(index<f.length)
				{
					System.out.println("----Add Apple----"+"\nEnter:1]Name 2]Weight 3]color");
					f[index]=new Apple(sc.next(),sc.nextDouble(),sc.next());
					index++;
				}
				else
				{
					System.out.println("Array is full----");
				}
				break;
				
			case 4://Show Names of fruits in the basket
				System.out.println("----Basket item names----");
				for(Fruits e:f)
				{
					if(e!=null)
					{
					  System.out.println(e.getName());
					}
				}
				System.out.println("----------------------");
				
				break;
				
			case 5://show name color weight taste
				System.out.println("-----Basket details----");
				int in=0;
				for(Fruits s:f)
				{
					if(s!=null)
					{
						System.out.println(in+1+"]"+s.toString()+"\nTaste: "+s.taste());
						System.out.println();
						in++;
					}
				}
				System.out.println("----------------------");
				
				break;
				
			case 6://Mark as stale
				System.out.println("Mark Stale for fruit at index:");
				int iVal=sc.nextInt();
				
				if(iVal<f.length)
				{
					  if(f[iVal].isStale(f[iVal])==false)
					  {
						  System.out.println("Mark as Stale");
					  }
					  else
					  {
						  System.out.println("it is Fresh");
					  }
				  
				}
				else
				  {
					  System.out.println("invalid index");
				  }
				  System.out.println();
				  
				  break;
				  
			case 7://invoking functionality
				System.out.println("enter index for functionality:");
				int ind=sc.nextInt();
				
				if(ind<f.length)
					{
						if(f[ind].taste()=="Sweet")
						{
							((Mango)f[ind]).pulp();
						}
						else if(f[ind].taste()=="Sour")
						{
							((Orange)f[ind]).juice();
						}
						else
						{
							((Apple)f[ind]).jam();
						}
					}
			  else
				{
					System.out.println("invalid index");
				}
				System.out.println();
				
				break;
				
			case 8://Exit
				System.out.println("---Exit---");
				
				break;
				
			default:
				System.out.println("invalid index");	
				
			}
			
		}while(ch!=8);
		
		sc.close();
      
	}

}
