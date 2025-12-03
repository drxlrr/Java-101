package ph.com.bpi.hello;

import java.util.Scanner;

public class Age {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); 
		//act2
		System.out.println("Enter your age");
		String age = sc.nextLine();
		int ageInt = Integer.parseInt(age);
		double ageDouble = Double.parseDouble(age);
		System.out.println("Your age as int:" + ageInt);
		System.out.println("Your age as double:" + ageDouble);
		
		sc.close();
	}

}
