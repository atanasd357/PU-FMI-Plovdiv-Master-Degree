package constructorAndPuzzle;

public class Puzzle implements IToy {

	private String name = "";
	private int detailsNum = 0;
	private String size = "";
	private String material = "";

	public Puzzle() {
	}

	public Puzzle(String name, int detailsNum, String size, String material) {
		this.name = name;
		this.detailsNum = detailsNum;
		this.size = size;
		this.material = material;
	}

	public void enter() {
		System.out.println("-----Enter 3D puzzle data-----");
		MainProgram.scan.nextLine();
		System.out.print("Name: ");
		this.name = MainProgram.scan.nextLine();
		System.out.print("Number of details: ");
		this.detailsNum = MainProgram.scan.nextInt();
	    MainProgram.scan.nextLine();
		System.out.print("Puzzle size: ");
		this.size = MainProgram.scan.nextLine();
		System.out.print("Material type: ");
		this.material = MainProgram.scan.nextLine();
	}

	public int getDetailsNum() {
		return this.detailsNum;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String compareTo(IToy toy) {
		if (this.detailsNum >= toy.getDetailsNum()) {
			return this.name;
		} else {
			return toy.getName();
		}
	}

	@Override
	public String toString() {
		return "3D puzzle: " + this.name + ", " + this.detailsNum + " details, puzzle size:  " + this.size
				+ ", puzzle material: " + this.material;
	}
}
