import java.util.Arrays;

public class Task4TownsArray {

	public static void main(String[] args) {
		// a
		String[] townsArray = { "Varna", "Sofiq", "Burgas", "Plovdiv", "Pazardzik", "Dimitrovgrad", "Asenovgrad",
				"Veliko Tarnovo", "Stara Zagora", "Ivailovgrad", "Gradeshnica", "Sopot", "Gabrovo", "Smolyan", "Dospat",
				"Topolovgrad", "Sliven", "Bansko", "Botevgrad", "Svilengrad", "Montana", "Vraca", "Vidin", "Dolenica",
				"Ruse", "Dolen Chiflik", "Haskovo", "Targovishte", "Velingrad", "Teteven", "Dobrich",
				"Dolno Kalugerovo" };

		// b
		System.out.println("The all towns who have \"grad\" or \"Grad\" in their names are: ");
		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].toLowerCase().contains("grad")) {
				System.out.println(townsArray[i]);
			}
		}

		// c
		System.out.println("\nThe all towns who starts their names with \"Dolen\" are: ");
		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].startsWith("Dolen")) {
				System.out.println(townsArray[i]);
			}
		}

		// d
		System.out.println("\nThe all towns whose names contains 2 or more words are: ");
		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].trim().contains(" ")) {
				System.out.println(townsArray[i]);
			}
		}

		// e
		System.out.println("\nThe all towns whose names end with \"ovo\" are: ");
		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].contains("ovo")) {
				System.out.println(townsArray[i]);
			}
		}

		// f
		System.out.println("\nThe all towns whose names contains \"O\" or \"o\" " + "more than 3 times are: ");
		boolean isContains = false;
		short countLetter = 0;
		int tempIndex = 0;

		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].toLowerCase().indexOf('o') != -1) {
				isContains = true;
				tempIndex = townsArray[i].toLowerCase().indexOf('o');

				while (isContains == true) {
					countLetter++;
					if (townsArray[i].toLowerCase().indexOf('o', tempIndex + 1) != -1) {
						tempIndex = townsArray[i].toLowerCase().indexOf('o', tempIndex + 1);
					} else {
						isContains = false;
					}
				}
				if (countLetter > 3) {
					System.out.println(townsArray[i]);
				}
				countLetter = 0;
			}
		}

		// g
		System.out.println("\nThe all towns whose names contains \"e\" 2,3 or 4 times" + " and not contains \"p\" are: ");
		isContains = false;
		countLetter = 0;
		tempIndex = 0;

		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].toLowerCase().indexOf('e') != -1) {
				isContains = true;
				tempIndex = townsArray[i].toLowerCase().indexOf('e');

				while (isContains == true) {
					countLetter++;
					if (townsArray[i].toLowerCase().indexOf('e', tempIndex + 1) != -1) {
						tempIndex = townsArray[i].toLowerCase().indexOf('e', tempIndex + 1);
					} else {
						isContains = false;
					}
				}
				if ((countLetter == 2 || countLetter == 3 || countLetter == 4)
						&& townsArray[i].toLowerCase().indexOf("r") == -1) {
					System.out.println(townsArray[i]);
				}
				countLetter = 0;
			}
		}

		// h
		int maxLength = 0;

		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].length() > maxLength) {
				maxLength = townsArray[i].length();
			}
		}
		System.out.println("\nThe max length of town's name is: " + maxLength + "\n"
				+ "and the towns who has names with this length are:");

		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].length() == maxLength) {
				System.out.println(townsArray[i]);
			}
		}

		// i
		int lengthSum = 0;

		for (int i = 0; i < townsArray.length; i++) {
			lengthSum += townsArray[i].length();
		}
		double averageLength = (double) lengthSum / townsArray.length;
		System.out.println("\nThe average length of town's names is: " + averageLength + "\n"
				+ "and the towns who has names lenght shorter than average are:");

		for (int i = 0; i < townsArray.length; i++) {
			if (townsArray[i].length() < averageLength) {
				System.out.println(townsArray[i]);
			}
		}
		
		// j
		Arrays.sort(townsArray);

		System.out.println("\nSorted towns array: ");
		for (int i = 0; i < townsArray.length; i++) {
			System.out.println(townsArray[i]);
		}
	}
}
