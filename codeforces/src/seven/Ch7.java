package seven;

import java.util.Scanner;

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
	
	public static boolean isSorted(double[] list) {
		double lastValue = 0.0;
		int counter = 0;
		for (double d : list) {
			if (counter > 0) {
				if (lastValue > d) {
					return false;
				}
			}
			lastValue = d;
			counter ++;
		}
		return true;
	}
	
	public static int mode(int[] array) {
	    int[] arr2 = new int[101];

	    for (int i = 0; i < array.length; i++) {
	        arr2[array[i]]++;
	    }
	    
	    int mode = 101;
	    int count = 0;
	    
	    for (int i = 0; i < arr2.length; i++) {
	        if (arr2[i] > count) {
	            count = arr2[i];
	            mode = i;
	        }
	    }
	    
	    return mode;
	}
	
	public static double stdev(int[] array) {
	    int sum = 0;
	    
	    for (int i = 0; i < array.length; i++) {
	        sum += array[i];
	    }
	    
	    double average = 1.0 * sum / array.length;
	    double top = 0;
	    
	    for (int i = 0; i < array.length; i++) {
	        top += Math.pow(array[i] - average, 2);
	    }
	    
	    return Math.sqrt(top / (array.length - 1));
	}
	
	public static int kthLargest(int k, int[] array) {

	    for (int i = 0; i < array.length; i++) {
	        int min = array[i];
	        
	        for (int j = i + 1; j < array.length; j++) {
	            if (array[j] < min) {
	                int temp = min;
	                array[i] = array[j];
	                array[j] = temp;
	                min = array[i];
	            }
	        }
	    }
	    
	    return array[array.length - 1 - k];
	}
	
	public static int minGap(int[] array) {
	    if (array.length < 2) {
	        return 0;
	    } else {
	        int min = array[1] - array[0];
	        
	        for (int i = 1; i < array.length - 1; i++) {
	            int difference = array[i + 1] - array[i];
	            if (difference < min) 
	                min = difference;	            
	        }
	        
	        return min;
	    }
	}
	
	public static double percentEven(int[] array) {
	    if (array.length == 0) {
	        return 0.0;
	    } else {
	        double evenNum = 0;
	        
	        for (int i = 0; i < array.length; i++) {
	            if (array[i] % 2 == 0) 
	                evenNum++;	            
	        }
	        
	        return evenNum * 100 / array.length;    
	    }
	}
	
	public static boolean isUnique(int[] array) {
	    for (int i = 0; i < array.length; i++) {
	        int min = array[i];
	        
	        for (int j = i + 1; j < array.length; j++) {
	            if (min > array[j]) {
	                array[i] = array[j];
	                array[j] = min;
	                min = array[i];
	            }
	        }
	        
	    }
	    
	    for (int i = 0; i < array.length - 1; i++) {
	        if (array[i] == array[i + 1]) 
	            return false;	        
	    }
	    
	    return true;
	}
	
	public static int longestSortedSequence(int[] array) {
	    if (array.length == 0) {
	        return 0;
	    } else {
	        int count = 1;
	        int longest = 1;
	        
	        for (int i = 0; i < array.length - 1; i++) {
	            if (array[i] <= array[i + 1]) {
	                count++;
	                if (count > longest) {
	                    longest = count;
	                }
	            } else {
	                count = 1;
	            }
	        }
	        
	        return longest;
	    }
	}
	
	public static boolean contains(int[] a1, int[] a2) {
	    for (int i = 0; i <= a1.length - a2.length; i++) {
	        int count = 0;
	        
	        for (int j = 0; j < a2.length; j++) {   
	            if (a2[j] == a1[i + j]) {
	                count++;
	            }
	        }
	        
	        if (count == a2.length) 
	            return true;	        
	    }
	    
	    return false;
	}
	
	public static int[] append(int[] list1, int[] list2) {
	    int[] newList = new int[list1.length + list2.length];
	    int index = 0;
	    
	    for (int i = 0; i < list1.length; i++) {
	        newList[index] = list1[i];
	        index++;
	    }
	    
	    for (int i = 0; i < list2.length; i++) {
	        newList[index] = list2[i];
	        index++;
	    }
	    
	    return newList;
	}
	
	public static int[] vowelCount(String string) {
	    int[] array = new int[5];
	    
	    for (int i = 0; i < string.length(); i++) {
	        char letter = string.charAt(i);
	        if(letter == 'a') {
	            array[0]++;
	        } else if (letter == 'e') {
	            array[1]++;
	        } else if (letter == 'i') {
	            array[2]++;
	        } else if (letter == 'o') {
	            array[3]++;
	        } else if (letter == 'u') {
	            array[4]++;
	        } 
	    }
	    
	    return array;
	}
	
	public static void wordLengths(Scanner console) {
	    int[] array = new int[100];
	    
	    while (console.hasNext()) 
	        array[console.next().length()]++;
	    
	    
	    for (int i = 1; i < array.length; i++) {
	        if (array[i] != 0) {
	            System.out.printf("%d: %d\t", i, array[i]);
	            for (int j = 0; j < array[i]; j++) 
	                System.out.print("*");	            
	            System.out.println();
	        }
	    }
	}
	
	public static int[][] matrixAdd(int[][] a, int[][] b) {
	    if (a.length == 0 || b.length == 0) {
	        return new int[0][0];
	    } else {
	        int[][] result = new int[a.length][a[0].length];
	        
	        for (int i = 0; i < result.length; i++) {
	        
	            for (int j = 0; j < result[0].length; j++) 
	                result[i][j] = a[i][j] + b[i][j];
	            	            
	        }
	        
	        return result;
	    }
	}
	
	public static boolean isMagicSquare(int[][] array) {
	    boolean result = true;
	    
	    for (int row = 0; row < array.length; row++) {
	        if (array[row].length != array.length) 
	            result = false;	        
	    }
	    
	    if (result) {
	        int sum = 0;
	        
	        for (int col = 0; col < array.length; col++) 
	            sum += array[0][col];
	        
	        for (int row = 1; row < array.length; row++) {
	            int newSum = 0;
	            
	            for (int col = 0; col < array[row].length; col++) 
	                newSum += array[row][col];
	            	            
	            if (sum != newSum) 
	                result = false;
	        }
	    }
	        
	    return result;
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
