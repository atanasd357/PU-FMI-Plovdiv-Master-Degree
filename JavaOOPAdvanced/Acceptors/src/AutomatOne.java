
//task 1 Automat
public class AutomatOne {

	public static boolean isAccept(String word) {

		// if an interval is entered by mistake
		word.trim();

		if (word == "aaab") {
			return true;
		}

		if (word.length() < 4) {
			return false;
		}

		if (!(word.startsWith("aa") && word.endsWith("ab"))) {
			return false;
		}

		String subWord = word.substring(2, word.length() - 2);

		byte countA = 0;
		boolean isLetterA = true;

		for (int i = 0; i < subWord.length(); i++) {
			if (subWord.charAt(i) == 'a' && isLetterA) {
				countA++;
			} else if (subWord.charAt(i) == 'b') {
				isLetterA = false;
			} else {
				return false;
			}
		}

		if (!(countA % 2 == 0)) {
			return false;
		}

		return true;
	}

	public static String acceptor(String word) {

		if (isAccept(word) == true) {
			return "accept";
		}

		return "reject";
	}
}
