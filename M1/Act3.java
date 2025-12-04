package ph.com.bpi.hello;

import java.util.Scanner;

public class Integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter First Integer");
		int firstInteger = sc.nextInt();
		System.out.println("Enter Second Integer");
		int secondInteger = sc.nextInt();
		System.out.println("Sum:" + (firstInteger + secondInteger));
		System.out.println("Difference:" + (firstInteger - secondInteger));
		System.out.println("Product:" + (firstInteger * secondInteger));
		
		
		sc.close();
	}

}
