package ph.com.bpi.hello;

import java.util.Scanner;

public class Integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter age:");
		int age = sc.nextInt();
		if (age >= 0 && age < 18) {
			System.out.println("Minor");
		}
		else if (age >= 18 && age <= 59) {
			System.out.println("Adult");
		}
		else if (age > 59) {
			System.out.println("Senior");
		}
		else {
			System.out.println("Age must be positive integer");
		}
			
		sc.close();
	}

}
