import java.util.Scanner;

public class Menu {

	public Scanner scanner = new Scanner(System.in);
	private String choice;
	private Catalogue catalogue;

	private String brand;
	private String model;
	private int powerEngine;
	private int price;
	private float engineDisplacement;
	private int batteryCapacity;

	public Menu(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public void mainMenu() {
		System.out.println("Please make your choice: ");
		System.out.println("\t1. Show the entire MobilityForYou catalogue: ");
		System.out.println("\t2. Add a new electric car: ");
		System.out.println("\t3. Add a new gas-powered car: ");
		System.out.println("\t4. Add a new hybrid car: ");
		System.out.println("\t5. Show the entire MobilityForYou catalogue sorted by car-type: ");
		System.out.println("\t6. Show the entire MobilityForYou catalogue sorted by brand: ");
		System.out.println("\t7. Write to file: ");
		System.out.println("\t8. Write different car types to different files: ");
		System.out.println("\t9. Stop the program");
		choice = scanner.nextLine();
	}

	public void goAroundMenu() {

		while (true) {

			mainMenu();

			switch (choice) {
			case "1":
				catalogue.printCatalogue();
				break;
			case "2":
				runChoiceTwo();
				break;
			case "3":
				runChoiceThree();
				break;
			case "4":
				runChoiceFour();
				break;
			case "5":
				catalogue.sortByCarType();
				catalogue.printCatalogue();
				break;
			case "6":
				catalogue.sortByBrand();
				catalogue.printCatalogue();
				break;
			case "7":
				catalogue.writeFile();
				System.out.println("The file is writed successfully!");
				break;
			case "8":
				catalogue.writeToDifferentFiles();
				System.out.println("The files are writed successfully!");
				break;
			case "9":
				return;
			default:
				continue;
			}
		}
	}

	public void readVehicleData() {
		System.out.println("Input brand: ");
		brand = scanner.nextLine();
		System.out.println("Input model: ");
		model = scanner.nextLine();
		System.out.println("\nInput power engine: ");
		powerEngine = scanner.nextInt();
		System.out.println("\nInput price: ");
		price = scanner.nextInt();
	}

	public void runChoiceTwo() {
		System.out.println("\nInput Electric car data: ");
		readVehicleData();
		System.out.println("\nInput battery capacity: ");
		batteryCapacity = scanner.nextInt();
		scanner.nextLine();

		catalogue.addVehicle(new ElectricCar(brand, model, powerEngine, price, batteryCapacity));
		System.out.println("New Electric car is added to the catalogue.");
	}

	public void runChoiceThree() {
		System.out.println("\nInput Gas car data: ");
		readVehicleData();
		System.out.println("\nInput engine displacement: ");
		engineDisplacement = scanner.nextFloat();
		scanner.nextLine();

		catalogue.addVehicle(new GasCar(brand, model, powerEngine, price, engineDisplacement));
		System.out.println("New Gas car is added to the catalogue.");
	}

	public void runChoiceFour() {
		System.out.println("\nInput Hybrid car data: ");
		readVehicleData();
		System.out.println("\nInput battery capacity: ");
		batteryCapacity = scanner.nextInt();
		System.out.println("\nInput engine displacement: ");
		engineDisplacement = scanner.nextFloat();
		scanner.nextLine();

		catalogue.addVehicle(new HybridCar(brand, model, powerEngine, price, engineDisplacement, batteryCapacity));
		System.out.println("New Hybrid car is added to the catalogue.");
	}
}
