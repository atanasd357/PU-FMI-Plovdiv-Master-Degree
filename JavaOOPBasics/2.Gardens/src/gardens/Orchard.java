package gardens;

public class Orchard extends Garden {

	private int treeNum = 0;
	private String fruitType = "";
	private double averageFruitQuan = 0.0;
	private double fruitPrice = 0.0;

	public Orchard() {
	}

	public Orchard(int treeNum, String fruitType, double averageFruitQuan, double fruitPrice) {
		this.treeNum = treeNum;
		this.fruitType = fruitType;
		this.averageFruitQuan = averageFruitQuan;
		this.fruitPrice = fruitPrice;
	}

	@Override
	public double getYield() {
		return this.fruitPrice * this.averageFruitQuan * this.treeNum;
	}

	@Override
	public void enter() {
		System.out.println("-----Enter orchard details-----");
		MainProgram.scan.nextLine();
		System.out.print("Number of trees: ");
		this.treeNum = MainProgram.scan.nextInt();
		MainProgram.scan.nextLine();
		System.out.print("Type of the fruit: ");
		this.fruitType = MainProgram.scan.nextLine();
		System.out.print("Average fruit quantity: ");
		this.averageFruitQuan = MainProgram.scan.nextDouble();
		System.out.print("Fruit price per quantity unit: ");
		this.fruitPrice = MainProgram.scan.nextDouble();
	}

	@Override
	public double getTotalYield(Garden garden) {
		return this.getYield() + garden.getYield();
	}

	@Override
	public String toString() {
		return "Orchard with " + this.treeNum + "trees, type of fruit: " + this.fruitType + ", average fruit quantity: "
				+ this.averageFruitQuan + ", fruit price per quantity unit: " + this.fruitPrice;
	}
}
