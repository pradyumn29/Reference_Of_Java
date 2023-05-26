package validate;

import java.time.LocalDate;

import com.app.core.Customer;
import com.app.core.ServicePlan;

import java.time.format.DateTimeParseException;



import ExceptionHandling.CustomerInvalidException;

public class CustomerValidation {

	private static int CustId;
	private static int RegistrationAmount;
	
	static {
		CustId=1000;
		RegistrationAmount=500;
	}
	public static Customer validateInput(String FirstName,String LastName,String Email,String Password,String DOB,String Plan,Customer []custDetails) throws CustomerInvalidException
	{
		
		CustId++;
		//check for duplicate email id
		validEmail(Email,custDetails);
		
		
		//parse string value to enum for service_plan
		ServicePlan validPlan=parsePlanAndValidate(Plan);
		
		double NetPlanCost=RegistrationAmount+validPlan.getCost();//total amount to pay after choosing valid plan
		
		//parsing validating date
		LocalDate validdb=parseAndValidDate(DOB);
		
		return new Customer(CustId,FirstName,LastName,Email,Password,NetPlanCost,validdb,Plan,custDetails);
	}

	private static LocalDate parseAndValidDate(String dOB) throws CustomerInvalidException  {
		
		//Parsing
		LocalDate d=LocalDate.parse(dOB);
		
		LocalDate validDOB=LocalDate.of(2004,1,1);
		if(d.isBefore(validDOB))
		return d;
		throw new CustomerInvalidException("Wrong Date of Birth or UnderAge!!!");
	}

	//ServisePlan validation
	private static ServicePlan parsePlanAndValidate(String plan) {
		
		
		return ServicePlan.valueOf(plan.toUpperCase());
	}


	//duplicate email entry checking
	private static void validEmail(String email, Customer[] custDetails) throws CustomerInvalidException {
		
		Customer custEmail=new Customer(email);//conc calling
		for(Customer c:custDetails)
		{
			if(c!=null)
			{
				if(c.equals(custEmail))
				{
					throw new CustomerInvalidException("Duplicate entry! Account for this Email exists Already!!");
				}
				System.out.println("Valid Customer mailId");
			}
			
		}
		
	}
	

}
