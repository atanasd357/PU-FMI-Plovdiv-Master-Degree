package appliancesExamTask;

public class SewingMachine implements Appliances {

	private String brandAndModel = "";
	private int regimeNumber = 0;
	private double sewingSpeed = 0.0;
	private double price = 0.0;

	public SewingMachine() {
	}

	public SewingMachine(String brandAndModel, int regimeNumber, double sewingSpeed, double price) {
		this.brandAndModel = brandAndModel;
		this.regimeNumber = regimeNumber;
		this.sewingSpeed = sewingSpeed;
		this.price = price;
	}

	public String getBrandAndModel() {
		return this.brandAndModel;
	}

	public int getRegimeNumber() {
		return this.regimeNumber;
	}

	public void enter() {
		System.out.println("-----Enter sewing machine specifications-----");
		MainProgram.scan.nextLine();
		System.out.print("Brand and model: ");
		this.brandAndModel = MainProgram.scan.nextLine();
		System.out.print("Number of regimes: ");
		this.regimeNumber = MainProgram.scan.nextInt();
		System.out.print("Maximal sewing speed: ");
		this.sewingSpeed = MainProgram.scan.nextDouble();
		System.out.print("Price: ");
		this.price = MainProgram.scan.nextDouble();
	}

	public String compareTo(Appliances appl) {
		if (this.regimeNumber >= appl.getRegimeNumber()) {
			return this.brandAndModel;
		} else {
			return appl.getBrandAndModel();
		}
	}

	@Override
	public String toString() {
		return "Sewing machine: " + this.brandAndModel + ", " + this.regimeNumber + " working regimes, "
				+ this.sewingSpeed + " stitches per second, with price: " + this.price + " lv.";
	}
}
