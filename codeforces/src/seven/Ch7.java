package seven;

public class Ch7 {

	public static void main(String[] args) {
		new Ch7().run();
	}
	
	public void run() {
		//runLastIndexOf();
		//runRange();
		//runCountInRange();
		//priceIsRight();
	}
	
	public int[] collapse(int[] array) {
	    int[] collapsed = new int[(array.length + 1) / 2];
	    int i = 0;
	    for(int j = 0; j <= array.length - 2; j += 2) {
	        collapsed[i] = array[j] + array[j + 1];
	        i++;
	    }
	    if(i != collapsed.length)
	        collapsed[i] = array[array.length - 1];
	        
	    return collapsed;
	}
	
	public int priceIsRight(int[] array, int price) {
		int closest = -1;
		for(int guess : array) {
			if(guess <= price && guess > closest)
				closest = guess;
		}
		return closest;
	}
	
	
	public void runCountInRange() {
		int[] array = {14, 1, 22, 17, 36, 7, -43, 5};
		System.out.println(countInRange(array, 4, 17));
	}
	
	public int countInRange(int[] array, int min, int max) {
		int inRange = 0;
		for(int current : array) {
			if(min <= current && current <= max)
				inRange++;
		}
		return inRange;
	}
	
	public void runRange() {
		int[] array = {36, 12, 25, 19, 46, 31, 22};
		System.out.println(range(array));
	}
	
	public void runLastIndexOf() {
		int[] array = {74, 85, 102, 99, 101, 85, 56};
		int number = 85;
		System.out.println(lastIndexOf(array, number));
	}
	
	public int lastIndexOf(int[] arry, int number) {
		int index = -1;
		for(int i = 0; i < arry.length; i++) {
			if(arry[i] == number)
				index = i;
		}
		return index;
	}
	
	public int range(int[] array) {
		int min = array[0];
		int max = array[1];
		
		for(int current : array) {
			if(current < min)
				min = current;
			if(current > max)
				max = current;
		}
		return max - min + 1;
	}

}
