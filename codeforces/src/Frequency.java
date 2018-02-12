
public class Frequency {

	public static void main(String[] args) {
		int[] array = populateArray(500);
		array[65] = 43;
		array[66] = 42;
		System.out.println(mostFrequent(array));
	}

	public static int mostFrequent(int[] array) {
		int count = 1;
		int tempCount = 0;
		int mostPopular = array[0];
		int temp = 0;
		for (int i = 0; i < (array.length - 1); i++) {
			temp = array[i];
			tempCount = 0;
			for (int j = 1; j < array.length; j++) {
				if (temp == array[j])
					tempCount++;
			}
			if (tempCount > count ||
					(tempCount == count && temp < mostPopular)) {
				mostPopular = temp;
				count = tempCount;
			}
		}
		return mostPopular;
	}

	public static int[] populateArray(int capacity) {
		int[] array = new int[capacity];
		for (int i = 0; i < capacity; i++) {
			array[i] = i;
		}
		return array;
	}
}
