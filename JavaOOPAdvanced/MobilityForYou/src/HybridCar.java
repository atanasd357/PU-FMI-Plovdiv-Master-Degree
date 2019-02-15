
public class HybridCar extends GasCar {

	public int batteryCapacity;

	public HybridCar(String b, String m, int pow, int pr, float engDis, int batCap) {
		super(b, m, pow, pr, engDis);
		this.batteryCapacity = batCap;
	}

	public String printHybridCar() {
		String inputArg = this.engineDisplacement + " L, " + this.powerEngine + " kW, " + this.batteryCapacity + " Ah";
		return super.printVehicle(inputArg);
	}
}