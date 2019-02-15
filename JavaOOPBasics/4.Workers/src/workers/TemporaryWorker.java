package workers;

public class TemporaryWorker extends Worker {

	private String name = "";
	private double workHours = 0.0;
	private double agreedSalary = 0.0;

	public TemporaryWorker() {
	}

	public TemporaryWorker(String name, int workHours, double agreedSalary) {
		this.name = name;
		this.workHours = workHours;
		this.agreedSalary = agreedSalary;
	}

	@Override
	public void enter() {
		System.out.println("-----Enter temporary worker details-----");
		MainProgram.scan.nextLine();
		System.out.print("Name: ");
		this.name = MainProgram.scan.nextLine();
		System.out.print("Agreed working hours: ");
		this.workHours = MainProgram.scan.nextDouble();
		System.out.print("Salary for agreed working hours: ");
		this.agreedSalary = MainProgram.scan.nextDouble();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getHourlySalary() {
		return this.agreedSalary / this.workHours;
	}

	@Override
	public String compareHourlyPayment(Worker worker) {
		if (this.getHourlySalary() >= worker.getHourlySalary()) {
			return this.name;
		} else {
			return worker.getName();
		}
	}

	@Override
	public String toString() {
		return "Temporary worker: " + this.name + ", agreed working hours: " + this.workHours + " and agreed salary: "
				+ this.agreedSalary;
	}
}
