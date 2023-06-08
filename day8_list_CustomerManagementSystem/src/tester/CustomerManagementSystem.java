package tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.core.Customer;

import CustomException.CustomerHandlingException;

import static ValidationRules.CustomerValidationRules.AllValidInput;
import static ValidationRules.CustomerValidationRules.CustomerLogIn;
import static ValidationRules.CustomerValidationRules.Confirmation;

public class CustomerManagementSystem {

	public static void main(String[] args) {
	  try(Scanner sc=new Scanner(System.in))
	  {
		  //initiliaze
		  //create empty AL to hold customer refs
		  List<Customer>custDetails=new ArrayList<>();
		  boolean Exit=false;
		  
		  while(!Exit)
		  {
			  System.out.println("0.Exit\r\n"
			  		+ "1. Sign up\r\n"
			  		+ "2. Sign in\r\n"
			  		+ "3. Change password\r\n"
			  		+ "4. Un subscribe customer\r\n"
			  		+ "5. Display all customers\r\n"
			  		+"6.Remove Account");
			  
			  System.out.println("Enter Chooice");
			  try 
			  {//inside while for switch loop
			      switch(sc.nextInt())
				  {
				    case 1://SignUp Case:
				    	
				     	System.out.println("Enter"
				    			+ "\nfirst name, \tlast name (string),\r\n"
				    			+ "email(string),\tregistrationAmount(double),\r\n"
				    			+ "password(string),\tdob(LocalDate),plan:ServicePlan charges : \r\n"
				    			+ "SILVER : 1000 \r\n"
				    			+ "GOLD : 2000\r\n"
				    			+ "DIAMOND : 5000\r\n"
				    			+ "PLATINUM : 10000");
				    	
				    	Customer ValidCustomer=AllValidInput(sc.next(),sc.next(),sc.next(),sc.nextDouble(),
				    			                             sc.next(),sc.next(),sc.next(),custDetails);
				    	custDetails.add(ValidCustomer);
				    	System.out.println("Customer Added!!!");
				    	
				    	break;
				    	
				    case 2: //signIn case
				    	
				    	System.out.println("Enter Registered EmailId And Password");
				        
				        Customer validCust=CustomerLogIn(sc.next(),sc.next(),custDetails);
				    	System.out.println(validCust);
				    	break;
				    	
				    case 3: //change password
				    	//1.valid Log_In
				    	System.out.println("Enter Registered EmailId And  Old Password");
				    	Customer ValidCust=CustomerLogIn(sc.next(),sc.next(),custDetails);
				    	
				    	//set NewPassword
				    	System.out.println("Enter New Password");
				    	ValidCust.setPassword(sc.next());
				    	System.out.println("Password updated successfully");
				    	break;
				    	
				    case 4: //Unsubsribe the user
				    	//validate log in
				    	System.out.println("Enter Registered EmailId And Password");
				    	Customer UnSubValidCust=CustomerLogIn(sc.next(),sc.next(),custDetails);
				    	
				    	//get confirmation
				    	System.out.println("Confirm YES/NO");
				    	boolean Confirm=Confirmation(sc.next());
				    	
				    	if(Confirm==true)
				    	{//unsubscribe user
				    	 UnSubValidCust.setPlan(null);
				    	System.out.println("Unsubscribed succesfully");
				    	}
				    	else
				    	{
				    	throw new CustomerHandlingException("cancelled Unsubscription!!");
				         }
				    	break;
				    	
				    case 5: //Show All Customer Details
				    	for(Customer c:custDetails)
				    	System.out.println(c);
				    	
				    	break;
				    	
				    case 6://delete Account
				    	System.out.println("To Remove Account");
				    	//validate log in
				    	System.out.println("Enter Registered EmailId And Password");
				    	Customer RemoveValidCust=CustomerLogIn(sc.next(),sc.next(),custDetails);
				    	
				    	//get confirmation
				    	System.out.println("Confirm YES/NO");
				    	boolean Confirm1=Confirmation(sc.next());
				    	
				    	if(Confirm1==true)
				    	{//unsubscribe user
				    	custDetails.remove(RemoveValidCust);
				    	System.out.println("removed succesfully");
				    	}
				    	else
				    	{
				    	throw new CustomerHandlingException("cancelled delete!!");
				         }
				    	
				    	break;
				    	
				    case 0: //Exit
				    	Exit=true;
				    	break;
				    	
				  }//end of switch
			  }//end of inner try
		      catch(Exception e)
		          {
				  e.printStackTrace();
					 //read off pending token from the Scanne	r till End Of Line
					 sc.nextLine();
				  }//end of inner try catch
			}//end of while
				  
	    }//end of try
	   catch(Exception e)
	  {
		 e.printStackTrace();
		 //read off pending token from the Scanenr till End Of Line
		 
	  }//end of catch

	}//end of main

}//end of class


/*
Pradyumn Patil prad@gmail.com 2000 asdf 2000-03-01 gold
omkar bhise omkar@gmail.com 5000 zxcv 1999-06-21 diamond
sourabh magdum sourabh@gmail.com 10000 mnbv 2001-05-12 platinum
shubham tigane shubham@gmail.com 1000 qwer 2005-09-23 silver
akanksha patwardhan pat@gmail.com 200 asdf 2000-05-23 silver
pruthvi patil pru@gmail.com 2000 asdf 1995-23-05 silver
sourabh magdum sourabh@gmail.com 10000 mnbv 2002-05-12 platinum
suraj jagtap suraj@gmail.com 5000 zxcv 2000-05-15 diamond
akanksha patwardhan pat@gmail.com 2000 asdf 2000-05-23 silver
shubham tigane shubham@gmail.com 1000 qwer 2000-09-23 silver
pruthvi patil pru@gmail.com 2000 asdf 1995-02-05 gold
akanksha patwardhan pat@gmail.com 2000 asdf 2000-05-23 gold

*/
