package ValidationRules;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import CustomException.CustomerHandlingException;

public class CustomerValidationRules {

	public static Customer AllValidInput(String firstName, String lastName, String email, double registrationAmt,
			String password, String DOB,String Plan,List<Customer>custDetails) throws CustomerHandlingException {
		
		checkForDup(email,custDetails);
		
		LocalDate ValidDate=parseAndValidate(DOB);
		
		ServicePlan validPlan=parsevalidPlan(Plan,registrationAmt);
	
		return new Customer(firstName,lastName,email,registrationAmt,password,ValidDate,validPlan);
		
	}
	
	//add a static amount to validate reg amount matching with plan
	//validate plan
	private static ServicePlan parsevalidPlan(String Plan,double registrationAmt) throws CustomerHandlingException
	{
	    ServicePlan ValidPlan=ServicePlan.valueOf(Plan.toUpperCase());
	    
	    if(ValidPlan.getServiceCost()!=registrationAmt)
	     throw new CustomerHandlingException("Plan is Not valid!!Enter correct amount");
	    return ValidPlan;
	    
	     
	}
	
	//parisng date for validation
	private static LocalDate parseAndValidate(String DOB)  throws CustomerHandlingException
	{
		LocalDate d1=LocalDate.parse(DOB);
		
		//21 year validation check condition
		if((Period.between(d1,LocalDate.now()).getYears())<21)
		{
			throw new CustomerHandlingException("Not Allowed!!!UnderAge");
		}
		else
		{
			return d1;
		}
	}
	
	//add static method to check duplication
	//why static? coz programmer doesnt have to use instance for calling
	public static void checkForDup(String NewEmail,List<Customer>customerList) throws CustomerHandlingException {
		
		
		//1.wrapp email in customer ref
		Customer newCustomer=new Customer(NewEmail);
		
		//contains iterate internally through the list
			if(customerList.contains(newCustomer))
					throw new CustomerHandlingException("Duplicate entry!!Email is already in use!!");
			System.out.println("valid emailid,No Dup");
		
		
	}
	
	//add a Static method customer logIn
	public static Customer CustomerLogIn(String Email,String Password,List<Customer>custDetails) throws CustomerHandlingException
	{
		//Search customer by email:PK
        int index=custDetails.indexOf(new Customer(Email));
        if(index==-1)
        {
        	throw new CustomerHandlingException("Email is Wrong");
        }
         Customer ValidCustomer=custDetails.get(index);
    	if(ValidCustomer.getPassword().equals(Password))
    	{
    		System.out.println("Signed in Successfully!!");
    	}
    	else
    	{
    		throw new CustomerHandlingException("Password is Wrong");
    	}
    	return ValidCustomer;
	}
	
	public static boolean Confirmation(String Confirmation)
	{
		if(Confirmation.toUpperCase().equals("YES")) 
			return true;
       return false;
	}
}
