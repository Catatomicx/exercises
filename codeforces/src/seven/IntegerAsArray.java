package seven;

import java.util.Scanner;

public class IntegerAsArray {		
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {	
		int[] firstNumber = readNumber();
		int[] secondNumber = readNumber();
		
		int[] sumOfNumbers = addNumbers(firstNumber, secondNumber);		
		
		System.out.print("\nNumber #1: ");
		printNumber(firstNumber);
		
		System.out.print("Number #2: ");
		printNumber(secondNumber);
		
		System.out.print("Sum of numbers: ");
		printNumber(sumOfNumbers);
	}

	public static int[] readNumber() {
		System.out.print("\nEnter the number of digits in the number: ");
		int size = input.nextInt();
		
		while(size <= 0 || size > 50) {
			System.out.print("Enter the number of digits (1 - 50): ");
			size = input.nextInt();
		}
		
		int[] number = new int[size];
		
		for(int i = size; i >= 1; i--) {
			System.out.print("Enter digit #" + i + ": ");
			number[i - 1] = input.nextInt();
		}
		
		return number;
	}

	public static int[] addNumbers(int[] firstNumber, int[] secondNumber) {
		int size = firstNumber.length;
		
		if(secondNumber.length > size)
			size = secondNumber.length;
		
		int[] sum = new int[size + 1];
		
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		int carry = 0;
		int temp = 0;
		
		while(i1 < firstNumber.length && i2 < secondNumber.length) {
			temp = firstNumber[i1] + secondNumber[i2] + carry;
			
			if(temp < 10) {
				sum[i3] = temp;
				carry = 0;
			}
			else {
				sum[i3] = temp % 10;
				carry = temp / 10;
			}
			
			i1++;
			i2++;
			i3++;
		}
		
		while(i1 < firstNumber.length) {
			temp = firstNumber[i1] + carry;
			
			if(temp < 10) {
				sum[i3] = temp;
				carry = 0;
			}
			else {
				sum[i3] = temp % 10;
				carry = temp / 10;
			}
			
			i1++;
			i3++;
		}
		
		while(i2 < secondNumber.length) {
			temp = secondNumber[i2] + carry;
	
			if(temp < 10) {
				sum[i3] = temp;
				carry = 0;
			}
			else {
				sum[i3] = temp % 10;
				carry = temp / 10;
			}
			i2++;
			i3++;
		}
		sum[i3] = carry;
		return sum;
	}
	
	public static void printNumber(int[] number) {
			if(number[number.length - 1] != 0)
			System.out.print(number[number.length - 1]);
		
		for(int i = number.length - 2; i >= 0; i--)
			System.out.print(number[i]);
		
		System.out.println();
	}
}
