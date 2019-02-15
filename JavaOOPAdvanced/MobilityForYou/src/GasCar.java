
public class GasCar extends Vehicle {

	public float engineDisplacement;

	public GasCar(String b, String m, int pow, int pr, float engDis) {
		super(b, m, pow, pr);
		this.engineDisplacement = engDis;
	}

	public String printGasCar() {
		String inputArg = this.engineDisplacement + " L, " + this.powerEngine + " kW";
		return super.printVehicle(inputArg);
	}
}