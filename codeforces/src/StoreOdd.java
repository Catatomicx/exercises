
public class StoreOdd {

	public static void main(String[] args) {
		storeOdds(3, 11);
	}

	public static void storeOdds(int min, int max) {
		int numOdds = calcNumOdds(min, max);
		int[] container = new int[numOdds];
		container = populateArray(container, min, max);
		printArray(container);
	}
	
	public static void printArray(int[] container) {
		for(int odd: container)
			System.out.println(odd);
	}
	
	public static int[] populateArray(int[] array, int min, int max) {
		if(isOdd(min))
			array[0] = min;
		else
			array[0] = min + 1;
		
		int currentOdd = array[0] + 2;
		
		if(max - min >= 2) {
			for(int i = 1; i < array.length; i++) {
				array[i] = currentOdd;
				currentOdd += 2;
			}
		}
		return array;
	}
	
	public static int calcNumOdds(int min, int max) {
		int odds = (max - min) / 2;
		if(isOdd(min) || isOdd(max))
			odds++;
		return odds;
	}
	
	public static boolean isOdd(int number) {
		if(number % 2 == 0)
			return false;
		return true;
	}
}
