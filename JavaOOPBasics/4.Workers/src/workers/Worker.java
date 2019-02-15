package workers;

public abstract class Worker {

	public abstract void enter();

	public abstract String getName();

	public abstract double getHourlySalary();

	public abstract String compareHourlyPayment(Worker worker);
}
