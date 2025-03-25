package GUI1;
import java.util.Scanner;

public class LogicError {

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		//apply user input for rectangle's width
		System.out.print("Enter rectangle's width : ");
		int width = input.nextInt();
		//apply user input for rectangle's height
		System.out.print("Enter rectangle's Height : ");
		int height = input.nextInt();
		//res is the perimeter of the rectangle
		int res =  width+width+width+height;
		System.out.println("The perimeter of rectangle is "+res);
	}

}
