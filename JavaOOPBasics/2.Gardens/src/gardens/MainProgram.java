package gardens;

import java.util.Scanner;

public class MainProgram {

	protected static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Garden garden1;
		Garden garden2;

		byte option = 0;
		System.out.println("Choose \"1\" for orchard or \"2\" for flower garden:");
		option = scan.nextByte();

		String gardenType = "";

		if (option == 1) {
			garden1 = new Orchard();
			garden2 = new Orchard();
			gardenType = "orchard";
		} else {
			garden1 = new FlowerGarden();
			garden2 = new FlowerGarden();
			gardenType = "flower garden";
		}

		garden1.enter();
		garden2.enter();

		System.out.println("The total yield from the both " + gardenType + " is: " + garden1.getTotalYield(garden2));
	}
}
