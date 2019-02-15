
public class MainClass {

	public static void main(String[] args) {

		/* // Test automat one 
		 * System.out.println(AutomatOne.acceptor("aaab"));// accept
		 * System.out.println(AutomatOne.acceptor("aabab"));// accept
		 * System.out.println(AutomatOne.acceptor("aabbab"));// accept
		 * System.out.println(AutomatOne.acceptor("aa"));// reject
		 * System.out.println(AutomatOne.acceptor("aaaaab"));// accept
		 * System.out.println(AutomatOne.acceptor("aaaaaaab"));// accept
		 * System.out.println(AutomatOne.acceptor("aaaabbbbbbbbbbbbbbbab"));// accept
		 * System.out.println(AutomatOne.acceptor("aaaabbbbbbbbbbbbbbbaab"));// reject
		 */
		
		//Test automat two
		System.out.println(AutomatTwo.acceptor("acbcbcbcbcbaaa"));// accept
		System.out.println(AutomatTwo.acceptor("acbcbcbcbcbcbcbaaa"));// accept
		System.out.println(AutomatTwo.acceptor("acbcbcbcbcbcbcbaaaa"));// accept
	    System.out.println(AutomatTwo.acceptor("acbcbcbcbcbcbcbcbaaa"));// reject
		System.out.println(AutomatTwo.acceptor("acbcbcbcbcbcbcbaa"));// reject
	    System.out.println(AutomatTwo.acceptor("acbbbcbcbcbcbaaa"));// accept
	    System.out.println(AutomatTwo.acceptor("acbcbcbcbcb"));// reject
		System.out.println(AutomatTwo.acceptor("acbcbcbcbaaa"));// reject
		System.out.println(AutomatTwo.acceptor("accbcbcbcbaaa"));// reject
		System.out.println(AutomatTwo.acceptor("acbbbcbcbcbcbcbcbcbcbaaaaaaaaaa"));// accept
		System.out.println(AutomatTwo.acceptor("acbaaa"));// reject
	}

}
