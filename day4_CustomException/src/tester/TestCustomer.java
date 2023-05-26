package tester;

import java.util.Scanner;

import com.app.core.Customer;

import ExceptionHandling.CustomerInvalidException;

import static validate.CustomerValidation.validateInput;

public class TestCustomer {
//driver code
	public static void main(String[] args) throws CustomerInvalidException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Size of array:");
		Customer []custDetails=new Customer[sc.nextInt()];//customer class array
		
		int ch;
		int Index=0;
		boolean exit=false;
		do
		{
			System.out.println("Enter the choice: 1.Add User 2.Show User Details 3.Unsubsribe 4.Exit");
			ch=sc.nextInt();
			
			switch(ch)
			{
			  case 1: //Add User
				  if(Index<custDetails.length) 
				  {
					  System.out.println("enter user details to create account:"
					  		+ "\n1.first name \t2.last name\n3.Email \t4.Password \n5.Date of Birth \t6.plan\nServicePlan charges : \r\n"
					  		+ "SILVER : 1000 \r\n"
					  		+ "GOLD : 2000\r\n"
					  		+ "DIAMOND : 5000\r\n"
					  		+ "PLATINUM : 10000");
					  
					  Customer customer=validateInput(sc.next(),sc.next(),sc.next(),sc.next(),
							 sc.next(),sc.next(),custDetails);
					  custDetails[Index++]=customer;
					  System.out.println("New User Added!!!");
				  }
				  else
					  System.out.println("array is full!!");
				  
				  break;
				  
			  case 2://show all details
				  System.out.println("Details are here...");
				  for(Customer c:custDetails)
				  {
					  if(c!=null)
					  {
					   System.out.println(c.toString());
					  }
					  System.out.println();
				  }
				  
				  break;
				  
			  case 3://Unsubscribe
				  System.out.println("to Unsubscribe enter EmailId:");
				  String mail=sc.next();
				  for(int i=0;i<custDetails.length;i++)
				  {
					  if(custDetails[i]!=null)
					  {
						  if(custDetails[i].getEmail().equals(mail))
						  {
							 custDetails[i]=null;
						  }
					  }
				  }
				  break;
				  
			  case 4://Exit
				  exit=true;
				  break;
				  		
			}//end of switch
			
		}while(ch!=4);//end of do-while

		sc.close();
	}//end of main

}//end of class
