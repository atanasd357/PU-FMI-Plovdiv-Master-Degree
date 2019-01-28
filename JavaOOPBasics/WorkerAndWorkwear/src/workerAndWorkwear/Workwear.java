package workerAndWorkwear;

public class Workwear implements IObject {

	private String typeAndModel = "";
	private String size = "";
	private double price = 0.0;

	public Workwear() {
	}

	public Workwear(String typeAndModel, String size, double price) {
		this.typeAndModel = typeAndModel;
		this.size = size;
		this.price = price;
	}

	public String getSize() {
		return this.size;
	}

	public void enter() {
		System.out.println("-----Enter workwear details-----");
		MainProgram.scan.nextLine();
		System.out.print("Type and model: ");
		this.typeAndModel = MainProgram.scan.nextLine();
		System.out.print("Size: ");
		this.size = MainProgram.scan.nextLine();
		System.out.print("Price: ");
		this.price = MainProgram.scan.nextDouble();
	}

	@Override
	public boolean isEqual(IObject obj) {
		if (this.size.equals(obj.getSize())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Workwear: " + this.typeAndModel + ", size: " + this.size + ", with price: " + this.price;
	}
}
