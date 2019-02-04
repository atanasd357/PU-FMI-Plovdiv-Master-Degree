import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Catalogue {

	private final static String[] carType = { "Electric Car:", "Gas Car:", "Hybrid Car:" };

	public Scanner scanner = new Scanner(System.in);

	private ArrayList<Vehicle> list = new ArrayList<>();
	private int powerEngine;
	private int batteryCapacity;
	private float engineDisplacement;
	private int price;
	private String filePath = "";

	public ArrayList<String> readFile() {
		ArrayList<String> result = new ArrayList<String>();
		String pathToFile = "";

		while (true) {
			System.out.println("Input path to file:");
			pathToFile = scanner.nextLine();

			try (BufferedReader br = Files.newBufferedReader(Paths.get(pathToFile))) {

				result = (ArrayList<String>) br.lines().collect(Collectors.toList());
				this.filePath = pathToFile;
				break;
			} catch (Exception e) {

				System.out.println("Wrong path or missing file!");
				continue;
			}
		}
		return result;
	}

	public void addVehicle(Vehicle car) {
		this.list.add(car);
	}

	public void transformLine(String line) {
		line = line.replace(", ", ",");
		String[] content = line.split(",");
		String[] beginningOfLine = content[0].split(" ");

		switch (beginningOfLine[0]) {

		case "ELECTRIC_CAR":
			this.powerEngine = Integer.parseInt(content[2].replaceAll("KW", ""));
			this.batteryCapacity = Integer.parseInt(content[3].replaceAll("Ah", ""));
			this.price = Integer.parseInt(content[4].replaceAll(" euro", ""));
			this.list.add(new ElectricCar(beginningOfLine[1], content[1], this.powerEngine, this.price,
					this.batteryCapacity));
			break;
		case "HYBRID_CAR":
			this.engineDisplacement = Float.parseFloat(content[2].replaceAll("L", ""));
			this.powerEngine = Integer.parseInt(content[3].replaceAll("KW", ""));
			this.batteryCapacity = Integer.parseInt(content[4].replaceAll("Ah", ""));
			this.price = Integer.parseInt(content[5].replaceAll(" euro", ""));
			this.list.add(new HybridCar(beginningOfLine[1], content[1], this.powerEngine, this.price,
					this.engineDisplacement, this.batteryCapacity));
			break;
		case "GAS_CAR":
			this.engineDisplacement = Float.parseFloat(content[2].replaceAll("L", ""));
			this.powerEngine = Integer.parseInt(content[3].replaceAll("KW", ""));
			this.price = Integer.parseInt(content[4].replaceAll(" euro", ""));
			this.list.add(
					new GasCar(beginningOfLine[1], content[1], this.powerEngine, this.price, this.engineDisplacement));
			break;
		default:
			System.out.println("Wring format at line: ...");
			break;
		}
	}

	public void sortByBrand() {
		Comparator<Vehicle> byBrand = (Vehicle v1, Vehicle v2) -> v1.brand.compareTo(v2.brand);
		this.list.sort(byBrand);
	}

	public void sortByCarType() {
		Comparator<Vehicle> byCarType = (Vehicle v1, Vehicle v2) -> v1.getClass().getSimpleName()
				.compareTo(v2.getClass().getSimpleName());
		this.list.sort(byCarType);
	}

	public void printCatalogue() {

		String temp;

		for (Vehicle v : this.list) {
			temp = v.getClass().getSimpleName();

			switch (temp) {

			case "GasCar":
				System.out.println(carType[1] + " " + ((GasCar) v).printGasCar());
				break;
			case "ElectricCar":
				System.out.println(carType[0] + " " + ((ElectricCar) v).printElectricCar());
				break;
			case "HybridCar":
				System.out.println(carType[2] + " " + ((HybridCar) v).printHybridCar());
				break;
			}
		}
	}

	public void writeFile() {

		try {

			FileWriter fw = new FileWriter(this.filePath);
			@SuppressWarnings("resource")
			BufferedWriter bw = new BufferedWriter(fw);
			String temp;

			for (Vehicle v : this.list) {
				temp = v.getClass().getSimpleName();

				switch (temp) {

				case "GasCar":
					bw.write(carType[1] + " " + ((GasCar) v).printGasCar());
					bw.newLine();
					break;
				case "ElectricCar":
					bw.write(carType[0] + " " + ((ElectricCar) v).printElectricCar());
					bw.newLine();
					break;
				case "HybridCar":
					bw.write(carType[2] + " " + ((HybridCar) v).printHybridCar());
					bw.newLine();
					break;
				}
			}
			bw.flush();
		} catch (Exception e) {

			System.out.println("Wrong path or missing file!");
		}
	}
}