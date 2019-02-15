
//task 2 Automat
public class AutomatTwo {

	// first variant
	// I first figured out the second variant(isAccept2), but I find it ineffective.
	// And I wrote the first(isAccept1), I think it's a bit more effective.
	public static boolean isAccept1(String word) {

		// if an interval is entered by mistake
		word.trim();

		if (word == "acbcbcbcbcbaaa") {
			return true;
		}

		if (word.length() < 14) {
			return false;
		}

		if (!(word.startsWith("acb") && word.endsWith("aaa"))) {
			return false;
		}

		String subWord = word.substring(3, word.length() - 3);

		String beginningStr = subWord.substring(0, subWord.indexOf("cb"));
		String middleStr = subWord.substring(subWord.indexOf("cb"), subWord.lastIndexOf("cb") + 2);
		String endStr = subWord.substring(subWord.lastIndexOf("cb") + 2, subWord.length());

		// check beginning string
		if (beginningStr.length() % 2 != 0) {
			return false;
		}
		if ((beginningStr.replace("b", "")).length() != 0) {
			return false;
		}

		// check middle string
		if (Math.ceil((double) middleStr.length() / 2) % 2 != 0 || middleStr.length() < 4) {
			return false;
		}
		if ((middleStr.replaceAll("cb", "")).length() != 0) {
			return false;
		}

		// check end string
		if (endStr.length() != 0) {
			if ((endStr.replace("a", "")).length() == 0) {
				return true;
			}
		}

		return true;
	}// end of first variant

	// second variant
	public static boolean isAccept2(String word) {

		// if an interval is entered by mistake
		word.trim();

		if (word == "acbcbcbcbcbaaa") {
			return true;
		}

		if (word.length() < 14) {
			return false;
		}

		if (!(word.startsWith("acb") && word.endsWith("aaa"))) {
			return false;
		}

		String subWord = word.substring(3, word.length() - 3);

		byte countB = 0;
		byte countCB = 0;
		boolean isLetterA = true;
		boolean isLettersCB = true;

		for (int i = subWord.length() - 1; i > 0; i--) {

			if (subWord.charAt(i) == 'a' && isLetterA) {
				continue;
			} else if (subWord.charAt(i) == 'b') {
				isLetterA = false;

				if (subWord.charAt(i - 1) == 'c' && isLettersCB) {
					countCB++;
				} else {
					countB++;
					isLettersCB = false;
				}
			} else if (subWord.charAt(i) == 'c') {
				isLetterA = false;
				continue;
			} else {
				return false;
			}
		}

		// this switch is needed, because if statement on line 89
		// will give argument out of range exception if i==0
		switch (subWord.charAt(0)) {
		case 'b':
			countB++;
			break;
		case 'a':
		case 'c':
			break;
		default:
			return false;
		}

		if (countCB % 2 != 0 || countCB < 4) {
			return false;
		}

		if (countB % 2 != 0) {
			return false;
		}

		return true;
	}// end of second variant

	public static String acceptor(String word) {

		if (isAccept1(word) == true) {
			return "accept";
		}

		return "reject";
	}
}
