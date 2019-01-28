package appliancesExamTask;

public class KitchenRobot implements Appliances {

	private String brandAndModel = "";
	private int regimeNumber = 0;
	private double grinderVol = 0.0;
	private double juicerVol = 0.0;
	private double price = 0.0;

	public KitchenRobot() {
	}

	public KitchenRobot(String brandAndModel, int regimeNumber, double grinderVol, double juicerVol, double price) {
		this.brandAndModel = brandAndModel;
		this.regimeNumber = regimeNumber;
		this.grinderVol = grinderVol;
		this.juicerVol = juicerVol;
		this.price = price;
	}

	public String getBrandAndModel() {
		return this.brandAndModel;
	}

	public int getRegimeNumber() {
		return this.regimeNumber;
	}

	public void enter() {
		System.out.println("-----Enter kitchen robot specifications-----");
		MainProgram.scan.nextLine();
		System.out.print("Brand and model: ");
		this.brandAndModel = MainProgram.scan.nextLine();
		System.out.print("Number of regimes: ");
		this.regimeNumber = MainProgram.scan.nextInt();
		System.out.print("Volume of grinder: ");
		this.grinderVol = MainProgram.scan.nextDouble();
		System.out.print("Volume of juicer: ");
		this.juicerVol = MainProgram.scan.nextDouble();
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
		return "Kitchen robot: " + this.brandAndModel + ", " + this.regimeNumber + " working regimes, grinder volume: "
				+ this.grinderVol + ", juicer volume: " + this.juicerVol + ", with price: " + this.price + " lv.";
	}
}
