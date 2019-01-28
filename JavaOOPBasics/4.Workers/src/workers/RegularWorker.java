package workers;

public class RegularWorker extends Worker {

	private String name = "";
	private int weeklyWorkDays = 0;
	private double dailyWorkHours = 0.0;
	private double weeklySalary = 0.0;

	public RegularWorker() {
	}

	public RegularWorker(String name, int weeklyWorkDays, double dailyWorkHours, double weeklySalary) {
		this.name = name;
		this.weeklyWorkDays = weeklyWorkDays;
		this.dailyWorkHours = dailyWorkHours;
		this.weeklySalary = weeklySalary;
	}

	@Override
	public void enter() {
		System.out.println("-----Enter regular worker details-----");
		MainProgram.scan.nextLine();
		System.out.print("Name: ");
		this.name = MainProgram.scan.nextLine();
		System.out.print("Weekly work days: ");
		this.weeklyWorkDays = MainProgram.scan.nextInt();
		System.out.print("Daily work hours: ");
		this.dailyWorkHours = MainProgram.scan.nextDouble();
		System.out.print("Weekly salary: ");
		this.weeklySalary = MainProgram.scan.nextDouble();
	}

	@Override
	public double getHourlySalary() {
		return this.weeklySalary / (this.weeklyWorkDays * this.dailyWorkHours);
	}

	@Override
	public String getName() {
		return this.name;
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
		return "Regular worker: " + this.name + ", weekly work days: " + this.weeklyWorkDays + ", daily work hours: "
				+ this.dailyWorkHours + " and weekly salary: " + this.weeklySalary;
	}
}
