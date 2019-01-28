package workerAndWorkwear;

import java.util.Scanner;

public class MainProgram {

	protected static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		IObject obj1;
		IObject obj2;

		byte option = 0;
		System.out.println("Choose \"1\" for workwear or \"2\" for worker:");
		option = scan.nextByte();

		String objectType = "";

		if (option == 1) {
			obj1 = new Workwear();
			obj2 = new Workwear();
			objectType = "workwears";
		} else {
			obj1 = new Worker();
			obj2 = new Worker();
			objectType = "workers";
		}

		obj1.enter();
		obj2.enter();

		boolean isEqual = obj1.isEqual(obj2);

		System.out.println("Is 2 " + objectType + " have the same size? " + isEqual);
	}

}
