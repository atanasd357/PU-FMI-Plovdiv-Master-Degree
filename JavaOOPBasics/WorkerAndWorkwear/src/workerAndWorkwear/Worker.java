package workerAndWorkwear;

public class Worker implements IObject {

	private String name = "";
	private String wearSize = "";
	private double monthlySalary = 0.0;

	public Worker() {
	}

	public Worker(String name, String wearSize, double monthlySalary) {
		this.name = name;
		this.wearSize = wearSize;
		this.monthlySalary = monthlySalary;
	}

	public void enter() {
		System.out.println("-----Enter worker details-----");
		MainProgram.scan.nextLine();
		System.out.print("Type and model: ");
		this.name = MainProgram.scan.nextLine();
		System.out.print("Size: ");
		this.wearSize = MainProgram.scan.nextLine();
		System.out.print("Price: ");
		this.monthlySalary = MainProgram.scan.nextDouble();
	}

	public String getSize() {
		return this.wearSize;
	}

	@Override
	public boolean isEqual(IObject obj) {
		if (this.wearSize.equals(obj.getSize())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Worker: " + this.name + ", wear size: " + this.wearSize + ", with monthly salary: "
				+ this.monthlySalary;
	}
}
