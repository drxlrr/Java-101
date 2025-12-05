/**
 * 
 */
package ph.com.bpi.hello;

import java.util.Scanner;

/**
 * 
 */
public class Loop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int loopNum = 0;
		
		for (int i=1; i <= 50;i++) {
			loopNum = loopNum + i;
		}
	
		System.out.println("Sum is: " + loopNum);
	
		sc.close();
	}

}
