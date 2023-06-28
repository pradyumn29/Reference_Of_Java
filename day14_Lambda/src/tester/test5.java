package tester;

import java.util.List;
import java.util.Map;

import static utils.StudentCollectionUtils.populateList;
import java.util.Scanner;
import static utils.StudentCollectionUtils.populateMap;
import com.app.core.Student;

public class test5 {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		//1.Display all student details from a student list
		
		  List<Student>StudentList=populateList();
		  StudentList.forEach(s->System.out.println("Students:"+StudentList));
		 
		//2.Display all Students from a student Map
		Map<String,Student>StudentMap=populateMap(populateList());
		StudentMap.values()
		.forEach(s1->System.out.println(s1));
		
		//3.Display all student details(list) sorted as per GPA 
		//Use custom ordering
		
		
		
		

	}

}
