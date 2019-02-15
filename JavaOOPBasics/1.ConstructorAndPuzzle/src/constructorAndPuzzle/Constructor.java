package constructorAndPuzzle;

public class Constructor implements IToy {

	private String name = "";
	private int connectingDetailsNum = 0;
	private int relatedDetailsNum = 0;
	private int instrumNum = 0;

	public Constructor() {
	}

	public Constructor(String name, int connectingDetailsNum, int relatedDetailsNum, int instrumNum) {
		this.name = name;
		this.connectingDetailsNum = connectingDetailsNum;
		this.relatedDetailsNum = relatedDetailsNum;
		this.instrumNum = instrumNum;
	}

	public void enter() {
		System.out.println("-----Enter constructor data-----");
		MainProgram.scan.nextLine();
		System.out.print("Name: ");
		this.name = MainProgram.scan.nextLine();
		System.out.print("Number of connecting details: ");
		this.connectingDetailsNum = MainProgram.scan.nextInt();
		System.out.print("Number of related details: ");
		this.relatedDetailsNum = MainProgram.scan.nextInt();
		System.out.print("Number of instruments: ");
		this.instrumNum = MainProgram.scan.nextInt();
	}

	public int getDetailsNum() {
		return this.connectingDetailsNum + this.relatedDetailsNum;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String compareTo(IToy toy) {
		if (this.getDetailsNum() >= toy.getDetailsNum()) {
			return this.name;
		} else {
			return toy.getName();
		}
	}

	@Override
	public String toString() {
		return "Constructor: " + this.name + ", " + this.connectingDetailsNum + " connecting details and "
				+ this.relatedDetailsNum + " related details, " + this.instrumNum + " instruments";
	}
}
