
public class KthLargest {
//Problem 7, page 512 in book, 541 in pdf
// It seemed interesting until it suggesting sorting it first, in which you just return the element at an index.
//Regardless of that I did it anyway, and spent most of my time just figuring out how to sort the array, not
//solving the problem.
	public static void main(String[] args) {
		int[] array = {74, 85, 102, 99, 101, 56, 84};
		kthLargest(array, 4);
	}

	
	public static int kthLargest(int[] array, int k) {
		sortArray(array);
		printArray(array);
		int kth = array[k];
		return kth;
	}
	
	public static int[] sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        return array;
	}
	
	public static void printArray(int[] array) {
		for(int element: array)
			System.out.println(element);
	}
}
