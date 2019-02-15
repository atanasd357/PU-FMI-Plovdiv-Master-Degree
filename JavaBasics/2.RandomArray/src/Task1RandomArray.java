import java.util.Random;

public class Task1RandomArray {

	public static void main(String[] args) {	
		Random r = new Random();
		int[] randomArray = r.ints(-100, 100).limit(20).toArray();
		
		for(int i=0; i<randomArray.length; i++) {
			System.out.println(randomArray[i]);
		}
		
		CalculateSumOfNumsAbove30(randomArray);
		
		CalculateProductOfNonZeroEvenNums(randomArray);
		
		CountOddIndexNumsInInterval(randomArray);
		
		FindAverageOfNumsDivideBy5(randomArray);
		
		FindQuadAverageOfEveryThirdNum(randomArray);
		
		FindGeomAverageOfNumsInInterval(randomArray);
		
		FindHarmonicAverageOfNumsInInterval(randomArray);
	}
	
	//a
	public static void CalculateSumOfNumsAbove30(int[] randomArray) {
		int sum = 0;		
		for(int i=0; i<randomArray.length; i++) {
			if(randomArray[i] > 30) {
				sum += randomArray[i];
			}				
		}	
		System.out.println("The sum of numbers above 30 is: " + sum);
	}
	
	//b
	public static void CalculateProductOfNonZeroEvenNums(int[] randomArray) {
		int product = 0;		
		for(int i=0; i<randomArray.length; i++) {
			if(randomArray[i] != 0 && (randomArray[i] % 2 != 0)) {
				if(product == 0) {
					product = randomArray[i];
				}
				else {
					product *= randomArray[i];
				}
			}				
		}	
		System.out.println("The product of non zero even numbers is: " + product);
	}
	
	//c
	public static void CountOddIndexNumsInInterval(int[] randomArray) {
		int count = 0;		
		for(int i=0; i<randomArray.length; i++) {
			if(i % 2 == 0) {
				if(randomArray[i] >= -30 && randomArray[i] <= 30) {
					count++;
				}			
			}				
		}	
		System.out.println("The number of numbers with odd index in interval [-30, 30] is: " + count);
	}
	
	//d
	public static void FindAverageOfNumsDivideBy5(int[] randomArray) {
		int sum = 0;
		int count = 0;	
		for(int i=0; i<randomArray.length; i++) {
			if(randomArray[i] % 5 == 0) {
				sum += randomArray[i];
				count++;
				}										
		}
		double average = (double)sum / count;
		System.out.println("The average of numbers divide by 5 is: " + average);
	}
	
	//e
	public static void FindQuadAverageOfEveryThirdNum(int[] randomArray) {
		int sum = 0;
		int count = 0;	
		for(int i=0; i<randomArray.length; i++) {
			if(i % 3 == 0) {
				sum += randomArray[i];
				count++;
			}										
		}
		double quadAverage = Math.sqrt(((double)sum / count));
		System.out.println("The quadratic average of every third num is: " + quadAverage);
	}
	
	//f
	public static void FindGeomAverageOfNumsInInterval(int[] randomArray) {
		int product = 0;
		int count = 0;	
		for(int i=0; i<randomArray.length; i++) {
			if(randomArray[i] > 6 && randomArray[i] <= 50) {
				if(product == 0){
					product = randomArray[i];
				}
				else {
					product *= randomArray[i];
				}
				count++;
			}
		}
		double geomAverage = Math.pow(product, 1.0 / count);
		System.out.println("The geometric average of numbers in interval (6, 50] is: " + geomAverage);
	}
	
	//g
	public static void FindHarmonicAverageOfNumsInInterval(int[] randomArray) {
		double sum = 0;
		int count = 0;	
		for(int i=0; i<randomArray.length; i++) {
			if(randomArray[i] <= -6 && randomArray[i] > 50) {
				sum += (1 / randomArray[i]);
				count++;
			}		
		}
		double harmonicAverage = count / sum;
		System.out.println("The harmonic average of numbers that not in interval (-6, 50] is: " + harmonicAverage);
	}
}
