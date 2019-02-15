package constructorAndPuzzle;

import java.util.Scanner;

public class MainProgram {

	protected static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		IToy toy1;
		IToy toy2;

		byte option = 0;
		System.out.println("Choose \"1\" for 3D puzzle or \"2\" for constructor:");
		option = scan.nextByte();

		String toyType = "";

		if (option == 1) {
			toy1 = new Puzzle();
			toy2 = new Puzzle();
			toyType = "3D puzzle";
		} else {
			toy1 = new Constructor();
			toy2 = new Constructor();
			toyType = "constructor";
		}

		toy1.enter();
		toy2.enter();

		System.out.println("The " + toyType + " with more details is: " + toy1.compareTo(toy2));
	}
}
