package workers;

import java.util.Scanner;

public class MainProgram {

	protected static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Worker worker1;
		Worker worker2;

		byte option = 0;
		System.out.println("Choose \"1\" for regular worker or \"2\" for temporary worker:");
		option = scan.nextByte();

		String workerType = "";

		if (option == 1) {
			worker1 = new RegularWorker();
			worker2 = new RegularWorker();
			workerType = "regular";
		} else {
			worker1 = new TemporaryWorker();
			worker2 = new TemporaryWorker();
			workerType = "temporary";
		}

		worker1.enter();
		worker2.enter();

		System.out.println("The " + workerType + " worker with higher hourly payment is: "
				+ worker1.compareHourlyPayment(worker2));
	}
}
