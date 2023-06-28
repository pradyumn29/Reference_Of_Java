package tester;
    
		
		import java.util.*;
		import java.util.stream.Collectors;

		class Student {
		    private String name;
		    private String city;
		    private double gpa;
		    private Map<String, Double> subjects;

		    public Student(String name, String city, double gpa, Map<String, Double> subjects) {
		        this.name = name;
		        this.city = city;
		        this.gpa = gpa;
		        this.subjects = subjects;
		    }

		    public String getName() {
		        return name;
		    }

		    public String getCity() {
		        return city;
		    }

		    public double getGpa() {
		        return gpa;
		    }

		    public Map<String, Double> getSubjects() {
		        return subjects;
		    }
		}

		public class StudentExample {
		    public static void main(String[] args) {
		        List<Student> students = new ArrayList<>();
		        students.add(new Student("John", "New York", 3.8, createSubjectMap(90, 85, 95)));
		        students.add(new Student("Emma", "London", 3.6, createSubjectMap(75, 80, 70)));
		        students.add(new Student("Michael", "Paris", 4.0, createSubjectMap(95, 90, 92)));

		        // 1. Display all student details from a student list
		        students.stream().forEach(student -> System.out.println(student.getName()));

		        // 2. Display all student details from a student map
		        students.stream().forEach(student -> System.out.println(student.getName() + " - " + student.getCity()));

		        // 3. Display all student details(list) sorted as per GPA
		        students.stream()
		                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
		                .forEach(student -> System.out.println(student.getName() + " - " + student.getGpa()));

		        // 4. Write a tester to print average of GPA of students(map) for the specified subject
		        String subject = "Math";
		        double averageGpa = students.stream()
		                .mapToDouble(student -> student.getSubjects().getOrDefault(subject, 0.0))
		                .average()
		                .orElse(0.0);
		        System.out.println("Average GPA for " + subject + ": " + averageGpa);

		        // 5. Print name of specified subject topper
		        String specifiedSubject = "Science";
		        Optional<String> subjectTopper = students.stream()
		                .max(Comparator.comparingDouble(student -> student.getSubjects().getOrDefault(specifiedSubject, 0.0)))
		                .map(Student::getName);
		        subjectTopper.ifPresentOrElse(
		                name -> System.out.println("Topper in " + specifiedSubject + ": " + name),
		                () -> System.out.println("No student found for " + specifiedSubject));

		        // 6. Print the number of failures for the specified subject chosen by the user
		        String chosenSubject = "English";
		        long failuresCount = students.stream()
		                .filter(student -> student.getSubjects().getOrDefault(chosenSubject, 0.0) < 5)
		                .count();
		        System.out.println("Failures in " + chosenSubject + ": " + failuresCount);

		        // 7. Display student names of all the students from a specified city
		        String specifiedCity = "London";
		        List<String> studentNamesFromCity = students.stream()
		                .filter(student -> student.getCity().equals(specifiedCity))
		                .map(Student::getName)
		                .collect(Collectors.toList());
		        System.out.println("Students from " + specifiedCity + ": " + studentNamesFromCity);
		    }


		
		

	}

}
