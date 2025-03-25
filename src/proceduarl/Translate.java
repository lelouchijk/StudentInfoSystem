package proceduarl;

import java.util.Scanner;

public class Translate {
	static Scanner input = new Scanner(System.in);
	static String userIn;
	static String outP;
	static int option1;
	public static void main(String[] args) {
		userInput();
		userMenu();
		switch(option1) {
		case 1:  outPutEtoM(); break;
		case 2: outPutMtoE(); break;
		}

	}
	static String userInput() {
		System.out.print("Please enter smt to translate : ");
		userIn = input.next();
		input.nextLine();
		return userIn;
	}
	static String outPutEtoM() {
		if(userIn.equalsIgnoreCase("Hello"))
			System.out.print("မင်္ဂလာပါ");
		else if (userIn.equalsIgnoreCase("Hello world"))
			System.out.print("မင်္ဂလာပါကမ္ဘာကြီး");
		else if (userIn.equalsIgnoreCase("Java"))
			System.out.print("လွယ်တယ်");
		else
			System.out.print("အဲ့လောက်ကြီးကြ");
		return outP;
	}
	static String outPutMtoE() {
		if(userIn == "အဲ့လောက်ကြီးကြ")
			System.out.print("htae chin yrr htae");
		else 
			System.out.print("try again later");
		return outP;
	}
	
	static int userMenu() {
		String menu = ("Please choose Language \n");
		menu +="1 : English to Myanmar\n";
		menu +="2 : Myanmar to English\n";
		System.out.print(menu);
		return option1 = input.nextInt();
		
	}

}
