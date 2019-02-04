
abstract public class Vehicle {

	public String brand;
	public String modelName;
	public int powerEngine;
	public int price;

	public Vehicle(String b, String m, int pow, int pr) {
		this.brand = b;
		this.modelName = m;
		this.powerEngine = pow;
		this.price = pr;
	}

	public String printVehicle(String arg1) {
		return this.brand + ", " + this.modelName + ", " + arg1 + ", " + this.price + " euro.";
	}
}