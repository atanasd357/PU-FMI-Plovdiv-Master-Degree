package gardens;

public class FlowerGarden extends Garden {

	private String flowerType = "";
	private double gardenArea = 0.0;
	private double averageFlowerNum = 0.0;
	private double flowerPrice = 0.0;

	public FlowerGarden() {
	}

	public FlowerGarden(String flowerType, double gardenArea, double averageFlowerNum, double flowerPrice) {
		this.flowerType = flowerType;
		this.gardenArea = gardenArea;
		this.averageFlowerNum = averageFlowerNum;
		this.flowerPrice = flowerPrice;
	}

	@Override
	public double getYield() {
		return this.flowerPrice * this.averageFlowerNum * this.gardenArea;
	}

	@Override
	public void enter() {
		System.out.println("-----Enter flower garden details-----");
		MainProgram.scan.nextLine();
		System.out.print("Flower name: ");
		this.flowerType = MainProgram.scan.nextLine();
		System.out.print("Area of the garden: ");
		this.gardenArea = MainProgram.scan.nextDouble();
		System.out.print("Average flower number per unit area: ");
		this.averageFlowerNum = MainProgram.scan.nextDouble();
		System.out.print("Price per flower: ");
		this.flowerPrice = MainProgram.scan.nextDouble();
	}

	@Override
	public double getTotalYield(Garden garden) {
		return this.getYield() + garden.getYield();
	}

	@Override
	public String toString() {
		return "Flower garden from " + this.flowerType + ", garden area: " + this.gardenArea
				+ ", average flower number per area unit: " + this.averageFlowerNum + ", price per flower: "
				+ this.flowerPrice;
	}
}
