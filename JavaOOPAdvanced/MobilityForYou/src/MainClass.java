import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {

		Catalogue catalogue = new Catalogue();
		
		Menu myMenu = new Menu(catalogue);
		
		//This is file for reading in the project directory: "mobility.txt"
		ArrayList<String> fromFile = catalogue.readFile();
		
		for(String s : fromFile) {
			catalogue.transformLine(s);
		}	
		
		myMenu.goAroundMenu();
	}
}

