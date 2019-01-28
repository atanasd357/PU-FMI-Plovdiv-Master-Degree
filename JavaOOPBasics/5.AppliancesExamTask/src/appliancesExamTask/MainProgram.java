package appliancesExamTask;

import java.util.Scanner;

public class MainProgram {

	protected static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Appliances appliance1 = generate();
		appliance1.enter();

		Appliances appliance2 = generate();
		appliance2.enter();

		System.out.println("The device with more regimes of work is: " + appliance1.compareTo(appliance2));
	}

	private static Appliances generate() {
		byte option = 0;
		System.out.println("Choose \"1\" for sewing machine or \"2\" for kitchen robot:");
		option = scan.nextByte();

		if (option == 1) {
			return new SewingMachine();
		} else {
			return new KitchenRobot();
		}
	}
}
