package m3.act1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String[] listGadgets = new String[] {"Laptop","Mouse","Keyboard","Monitor","Printer"};
		
		List<String> selectGadgets = new ArrayList<>(Arrays.asList(listGadgets));
		
		System.out.println("All Products Before Changing:");
		for(String gadget : selectGadgets) {
			System.out.println(gadget);
		}
		System.out.println("");
		System.out.println("Adding Webcam and removing Mouse.....");
		System.out.println("");
	
		
		selectGadgets.add("Webcam");
		selectGadgets.remove("Mouse");
		
		System.out.println("All Products After Changing:");
		for(String gadget : selectGadgets) {
			System.out.println(gadget);
		}
		
		System.out.print("Select Gadget:");
		String selGadget = sc.nextLine();
		
		if (selectGadgets.contains(selGadget)){
			System.out.println(selGadget + " Found");
		}
		else {
			System.out.println(selGadget + " Not Found");
		}
				

	}

}
