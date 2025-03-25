package proceduarl;

import java.util.Scanner;

public class CurrencyConverter {
	static Scanner input = new Scanner(System.in);
	static int userIn;
	static int option;
	final static int usdCurrency = 4000;
	final static double sgdCurrency = 1532.46;
	final static double chnCurrency = 286.69;
	final static double jpnCurrency = 14.02;
	final static double thaiCurrency = 100.00;
	public static void main(String[] args) {
		userInput();
		userMenu();
		while(option != 0) {
			converter();
			userMenu();
		}
		System.out.println("Program end.");
	}
	static int userInput() {
		System.out.print("Please enter MM Kyats :");
		userIn = input.nextInt();
		return userIn;
	}
	static void converter() {
		switch(option) {
		case 1:
			System.out.print((double)userIn/usdCurrency+"USD"+"\n");break;
		case 2:
			System.out.print((double)userIn/sgdCurrency+"SGD"+"\n");break;
		case 3:
			System.out.print((double)userIn/chnCurrency+"Yuan"+"\n");break;
		case 4:
			System.out.print((double)userIn/jpnCurrency+"Yen"+"\n");break;
		case 5:
			System.out.print((double)userIn/thaiCurrency+"Bhat"+"\n");break;
		}
	}
	static int userMenu() {
		String menu = ("Please choose Currency You want to change \n");
		menu +="1 : USD\n";
		menu +="2 : SGD\n";
		menu +="3 : Yuan\n";
		menu +="4 : Yen\n";
		menu +="5 : Bhat\n";
		menu +="0 : quit\n";
		System.out.print(menu);
		option = input.nextInt();
		return option;
	}

}
