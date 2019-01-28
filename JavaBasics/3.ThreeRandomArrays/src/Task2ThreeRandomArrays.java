import java.util.Random;

public class Task2ThreeRandomArrays {

	public static void main(String[] args) {
		Random r = new Random();
		int[] firstRandomArray = r.ints(-100, 100).limit(20).toArray();
		int[] secondRandomArray = r.ints(-100, 100).limit(20).toArray();
		int[] thirdRandomArray = r.ints(-100, 100).limit(20).toArray();
		
		//a
		int firstArrSum = CalculateSumOfArray(firstRandomArray);
		System.out.println("The sum of elements from first array is: " + firstArrSum);
		
		int secondArrSum = CalculateSumOfArray(secondRandomArray);
		System.out.println("The sum of elements from second array is: " + secondArrSum);
		
		int thirdArrSum = CalculateSumOfArray(thirdRandomArray);
		System.out.println("The sum of elements from third array is: " + thirdArrSum);

		System.out.println("The average of sums from the three array is: " + 
		((firstArrSum + secondArrSum + thirdArrSum) / 3));
		
		//b
		int firstArrProduct = CalculateProductOfNonZeroEvenNums(firstRandomArray);
		System.out.println("The product of non zero even numbers in first array is: " + 
				firstArrProduct);
		
		int secondArrProduct = CalculateProductOfNonZeroEvenNums(secondRandomArray);
		System.out.println("The product of non zero even numbers in first array is: " + 
				secondArrProduct);
		
		int thirdArrProduct = CalculateProductOfNonZeroEvenNums(thirdRandomArray);
		System.out.println("The product of non zero even numbers in first array is: " + 
				thirdArrProduct);
		
		//c
		int firstArrOddNumsCount = CountOddIndexNumsInInterval(firstRandomArray);
		System.out.println("The number of numbers in first array with odd index in interval [-30, 30] is: " + 
				firstArrOddNumsCount);
		
		int secondArrOddNumsCount = CountOddIndexNumsInInterval(secondRandomArray);
		System.out.println("The number of numbers in second array with odd index in interval [-30, 30] is: " +
				secondArrOddNumsCount);
	
		int thirdArrOddNumsCount = CountOddIndexNumsInInterval(thirdRandomArray);
		System.out.println("The number of numbers with odd index in interval [-30, 30] is: " +
				thirdArrOddNumsCount);
		
		int maxCount = Math.max(firstArrOddNumsCount, secondArrOddNumsCount);
		maxCount = Math.max(maxCount, thirdArrOddNumsCount);
		System.out.println("The biggest count num is: " + maxCount);
		
		//d
		double firstArrAverage = FindAverageOfNumsDivideBy5(firstRandomArray);
		System.out.println("The average of numbers in first array divide by 5 is: " + firstArrAverage);
		
		double secondArrAverage = FindAverageOfNumsDivideBy5(secondRandomArray);
		System.out.println("The average of numbers in second array divide by 5 is: " + secondArrAverage);
		
		double thirdArrAverage = FindAverageOfNumsDivideBy5(thirdRandomArray);
		System.out.println("The average of numbers in third array divide by 5 is: " + thirdArrAverage);
		
		double minAverage = Math.min(firstArrAverage, secondArrAverage);
		minAverage = Math.min(minAverage, thirdArrAverage);
		System.out.println("The smallest average from arrays is: " + minAverage);
		
		//e
		double firstQuadAv = FindQuadAverage(firstRandomArray);
		System.out.println("The quadratic average of first array is: " + firstQuadAv);
		
		double secondQuadAv = FindQuadAverage(secondRandomArray);
		System.out.println("The quadratic average of second array is: " + secondQuadAv);
		
		double thirdQuadAv = FindQuadAverage(thirdRandomArray);
		System.out.println("The quadratic average of third array is: " + thirdQuadAv);
		
		double quadAvSum = firstQuadAv + secondQuadAv + thirdQuadAv;
		System.out.println("The sum of quad averages from 3 arrays is: " + quadAvSum);
		
		//f
		double firstGeomAverage = FindGeomAverageOfNumsInInterval(firstRandomArray);
		System.out.println("The geometric average of numbers in first array in interval (6, 50] is: " + 
				firstGeomAverage);
		
		double secondGeomAverage = FindGeomAverageOfNumsInInterval(secondRandomArray);
		System.out.println("The geometric average of numbers in second array in interval (6, 50] is: " + 
				secondGeomAverage);
		
		double thirdGeomAverage = FindGeomAverageOfNumsInInterval(thirdRandomArray);
		System.out.println("The geometric average of numbers in third array in interval (6, 50] is: " + 
				thirdGeomAverage);
		//g
		double firstArrHarm = FindHarmonicAverageOfNumsInInterval(firstRandomArray);
		System.out.println("The harmonic average of numbers in first array that not in interval (-6, 50] is: " + 
				firstArrHarm);
		
		double secondArrHarm = FindHarmonicAverageOfNumsInInterval(secondRandomArray);
		System.out.println("The harmonic average of numbers in second array that not in interval (-6, 50] is: " + 
				secondArrHarm);
		
		double thirdArrHarm = FindHarmonicAverageOfNumsInInterval(thirdRandomArray);
		System.out.println("The harmonic average of numbers in third array that not in interval (-6, 50] is: " + 
				thirdArrHarm);
	}

	//a
	public static int CalculateSumOfArray(int[] randomArray) {
		int sum = 0;		
		for(int i=0; i<randomArray.length; i++) {
			sum += randomArray[i];					
		}	
		return sum;
	}
	
	//b
	public static int CalculateProductOfNonZeroEvenNums(int[] randomArray) {
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
		return product;
	}
	
	//c
	public static int CountOddIndexNumsInInterval(int[] randomArray) {
		int count = 0;		
		for(int i=0; i<randomArray.length; i++) {
			if(i % 2 == 0) {
				if(randomArray[i] >= -30 && randomArray[i] <= 30) {
					count++;
				}			
			}				
		}	
		return count;
	}
	
	//d
	public static double FindAverageOfNumsDivideBy5(int[] randomArray) {
		int sum = 0;
		int count = 0;	
		for(int i=0; i<randomArray.length; i++) {
			if(randomArray[i] % 5 == 0) {
				sum += randomArray[i];
				count++;
				}										
		}
		double average = (double)sum / count;
		return average;
	}
	
	//e
	public static double FindQuadAverage(int[] randomArray) {
		int sum = 0;
		int count = 0;	
		for(int i = 0; i < randomArray.length; i++) {
			sum += randomArray[i];
			count++;												
		}
		double quadAverage = Math.sqrt(((double)sum / count));
		return quadAverage;
	}
	
	//f
	public static double FindGeomAverageOfNumsInInterval(int[] randomArray) {
		int product = 0;
		int count = 0;	
		for(int i = 0; i < randomArray.length; i++) {
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
		return geomAverage;
	}

	//g
	public static double FindHarmonicAverageOfNumsInInterval(int[] randomArray) {
		double sum = 0;
		int count = 0;	
		for(int i=0; i<randomArray.length; i++) {
			if(randomArray[i] <= -6 && randomArray[i] > 50) {
				sum += (1 / randomArray[i]);
				count++;
			}		
		}
		double harmonicAverage = count / sum;
		return harmonicAverage;
	}
}
