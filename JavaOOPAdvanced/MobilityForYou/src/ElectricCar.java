
public class ElectricCar extends Vehicle {

	public int batteryCapacity;

	public ElectricCar(String b, String m, int pow, int pr, int batCap) {
		super(b, m, pow, pr);
		this.batteryCapacity = batCap;
	}

	public String printElectricCar() {
		String inputArg = this.powerEngine + " kW, " + this.batteryCapacity + " Ah";
		return super.printVehicle(inputArg);
	}
}