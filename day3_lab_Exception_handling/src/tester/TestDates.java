package tester;

import java.util.Date;

public class TestDates {

	public static void main(String[] args) {
		// create date class instance to represent curnt date
		Date curntDate=new Date();
		System.out.println(curntDate);
		System.out.println("_____");
		//what will be o/p
		Date d1=new Date(7000);
		System.out.println(d1);
		System.out.println("_____");

		System.out.println(d1.before(curntDate));//t
		System.out.println(d1.after(curntDate));//f
		System.out.println(d1.compareTo(curntDate));// < 0

	}

}
