package ph.com.bpi.hello;

import java.util.Scanner;




public class gradingSystem {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); 
		
		int cntr = 0;
		double sumGrades = 0;
		String StudentName = "";
		String StudentId = "";
		String Status="";
		
		
		while (cntr == 0) {
			System.out.println("====STUDENT GRADING SYSTEM====");
			System.out.println("A - Add student information");
			System.out.println("B - Compute student average");
			System.out.println("C - Display Student Information");
			System.out.println("D - Exit");
			System.out.println("Enter Choice:");
			String optList = sc.next();
			
			if (optList.equals("A")) {

	            System.out.println("Enter student name: ");
	            StudentName = sc.next();

	            System.out.println("Enter student ID: ");
	            StudentId = sc.next();
	            
	            System.out.print("Enter number of subjects: ");
	            int numSubjects = sc.nextInt();

	            for (int i = 1; i <= numSubjects; i++) {
	            	System.out.print("Enter grade for subject " + i + ": ");
	                double grades = sc.nextDouble();
	                sumGrades = (sumGrades + grades);
	            }
	            System.out.println("=== STUDENT SAVED ===");
			}
			
			else if (optList.equals("B")) {
				System.out.println("Average is: " + (sumGrades/2));
				if ((sumGrades/2)>= 75) {
					System.out.println("Status: You PASSED!");
					Status = "PASSED";
				}
				else {
					System.out.println("Status: You FAILED!");
					Status = "FAILED";
				}
			}
			else if (optList.equals("C")) {
				System.out.println("Student Name: " + StudentName);
				System.out.println("Student ID: " + StudentId);
				System.out.println("Average Grade: " + (sumGrades/2));
				System.out.println("Status: " + Status);
				
			}
			else if (optList.equals("D")) {
				cntr++;
				System.out.println("program closed");
			}
			else {
				System.out.println("Select options above");
			}
			
		} 
		
		sc.close();
		
		

}
}
