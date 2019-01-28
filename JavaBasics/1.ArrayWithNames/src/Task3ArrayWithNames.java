
public class Task3ArrayWithNames {

	public static void main(String[] args) {
		//a
		String[] namesArray = {"Ana Ivanova Pelova", 
				"Penko Ivanov",
				"Ivanka Dimova",
				"Ruska Dimitrova Petrova", 
				"Ilka Deleva",
				"Vasilka Koleva",
				"Ivan Iliev Trifonov",
				"Penka Dimova Kirova",
				"Dimitar Spasov Petkov",
				"Petko Asenov",
				"Nenka Moneva Karaivanova",
				"Ana Ivanova Gogova"};
		
		//b
		for(int i=0; i<namesArray.length; i++) {
			if(namesArray[i].contains("Ivan") && 
					namesArray[i].charAt(namesArray[i].length() - 1) == 'a') {
				System.out.println(namesArray[i]);
			}
		}
	}
}
