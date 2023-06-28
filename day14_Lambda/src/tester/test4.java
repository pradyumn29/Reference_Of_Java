package tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.*;

import static utils.StudentCollectionUtils.populateList;
import java.util.Scanner;
import static utils.StudentCollectionUtils.populateMap;
import com.app.core.Student;
import com.app.core.Subject;

public class test4 {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		
		//1.Display all student details from a student list
		
		  List<Student>StudentList=populateList();
		  StudentList.forEach(s->System.out.println("Students:"+StudentList));
		 
		//2.Display all Students from a student Map
		
		 Map<String,Student>StudentMap=populateMap(StudentList);
		 //StudentMap.values() .forEach(s1->System.out.println(s1));
		 
	//	4. Write a tester to print average of  gpa of students for the specified subject
	//	eg : i/p : subject
		System.out.println("Enter the subject:");
		String subject=sc.next();
	Subject sub=Subject.valueOf(subject.toUpperCase());
	List<Student> Studentlist=new ArrayList<Student>(StudentMap.values()); 
	OptionalDouble AvgGpa=Studentlist.stream()
				      .filter(s->s.getSubject()==sub)
		              .mapToDouble(s->s.getGpa()).average();
		System.out.println("Average:"+AvgGpa);
		
		
		/*
		 * System.out.println("Enter the subject:"); String subject=sc.next(); 
		 * Subject sub=Subject.valueOf(subject.toUpperCase());
		 *  List<Student> Studentlist=new ArrayList<Student>(StudentMap.values()); 
		 *  OptionalDouble AvgGpa=Studentlist.stream() .filter(s->s.getSubject()==sub)
		 * .mapToDouble(s->s.getGpa()).average().isPresent().getAsDouble(); 
		 * System.out.println("Average:"+AvgGpa);
		 */
		
		//OptionalDouble Subtop=StudentList.stream()
		//.mapToDouble(s->s.getGpa()).max();
		

	}

}
