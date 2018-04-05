import java.util.Random;
import java.util.Scanner;

public class Ch5pt2 {

	public static void main(String[] args) {
		new Ch5pt2().run();
	}
	
	public void run() {
		//diceSum();
		//randomWalk();
		//printFactors(60);
		//printFactors();
		//hopscotch(3);
		//threeHeads();
		//printAverage();
		//testConsec(5, 6, 7); //true
		//testConsec(5, 6, 8); //false
		//testHasMidPoint(4, 7, 10); //true
		//testHasMidPoint(4, 5, 10); //false
		//testDom(1, 2, 10); //true
		//testDom(1, 2, 3); //false
		//testAngle(120, 60, 30); //true
		//testAngle(91, 34, 94); //false
		//testMonthApart();
		//System.out.println(digitSum(29107));
		//System.out.println(firstDigit(34));
		//System.out.println(digitRange(68437));
		//System.out.println(swapDigitPairs(482596)); //even digits
		//System.out.println(swapDigitPairs(1234567)); //odd digits
		//System.out.println(allDigitsOdd(1357)); // true
		//System.out.println(allDigitsOdd(1234)); // false
		//System.out.println(hasAnOddDigit(1468)); // true
		//System.out.println(hasAnOddDigit(2468)); // false
		//System.out.println(isAllVowels("eIEiO")); // true
		//System.out.println(isAllVowels("oink")); // false
		nums();
	}
	
	public void nums() {
		int x = generate(2, 10);
		int y;
		if(flip() == 1)
			y = x + 1;
		else
			y = x - 1;
		
		System.out.println(x);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(y);
	}
	
	public boolean isAllVowels(String word) {
		if(word == "")
			return true;
		
		for(int i = 0; i < word.length(); i++)
			if(!isVowel(word.charAt(i)))
				return false;
		
		return true;
	}
	
	public boolean isVowel(char c) {
		if(c == 'a' || c == 'A' ||
				c == 'e' || c == 'E' ||
				c == 'i' || c == 'I' ||
				c == 'o' || c == 'O' ||
				c == 'u' || c == 'U')
			return true;
		return false;
	}
	
	public boolean hasAnOddDigit(int number) {
		while(number > 0) {
			if(number % 2 == 1)
				return true;
			number /= 10;
		}
		return false;
	}
	
	public boolean allDigitsOdd(int number) {
		while(number > 0) {
			if((number % 10) % 2 == 0)
				return false;
			number /= 10;
		}
		return true;
	}
	
	public int swapDigitPairs(int number) {
		int intendedLeft = 0;
		int intendedRight = 0;
		int baseTen = 0;
		int swapped = 0;
		
		while(number > 0) {
			intendedLeft = number % 10;
			number /= 10;
			if(number != 0) { //if statement for dealing with odd digit numbers.
				intendedRight = number % 10;
				number /= 10;
				swapped += intendedRight * Math.pow(10, baseTen);
				baseTen++;
			}
			swapped += intendedLeft * Math.pow(10, baseTen);
			baseTen++;
		}
		return swapped;
	}
	
	public int numDigits(int number) {
		int digits = 0;
		if(number == 0)
			return 1;
		while(number != 0) {
			digits++;
			number /= 10;
		}
		return digits;
	}
	
	public int digitRange(int number) {
		int range = 1;
		int minDigit = 10;
		int maxDigit = 0;
		int remainder = 0;
		
		while(number > 10) {
			remainder = number % 10;
			if(maxDigit < remainder)
				maxDigit = remainder;
			if(remainder < minDigit)
				minDigit = remainder;
			range = maxDigit - minDigit + 1;
			number /= 10;
		}
		return range;
	}
	
	public int firstDigit(int number) {
		if(number < 0)
			number *= -1;
		while(number > 10)
			number /= 10;
		return number;
	}
	
	public int digitSum(int number) {
		int sum = 0;
		if(number < 0)
			number *= -1;

		while(number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
	
	public void testMonthApart() {
		System.out.println(monthApart(4, 15, 5, 22));
		System.out.println(monthApart(5, 22, 4, 15));
		
		System.out.println(monthApart(9, 19, 10, 17));
		System.out.println(monthApart(10, 17, 9, 19));
	}
	
	public boolean monthApart(int m1, int d1, int m2, int d2) {
		if(m2 - m1 > 1 || m1 - m2 > 1)
			return true;
		if(m1 - m2 == 1)
			if(d1 >= d2)
				return true;
		if(m2 - m1 == 1)
			if(d2 >= d1)
				return true;
		return false;
	}
	
	public void testAngle(int n1, int n2, int n3) {
		System.out.println(anglePairs(n1, n2, n3));
		System.out.println(anglePairs(n1, n3, n2));

		System.out.println(anglePairs(n2, n1, n3));
		System.out.println(anglePairs(n2, n3, n1));
		
		System.out.println(anglePairs(n3, n2, n1));
		System.out.println(anglePairs(n3, n1, n2));
	}
	
	//There's some redundancy here, but it seems clean and is what I think is the least amount of code
	public boolean anglePairs(int i1, int i2, int i3) {
		if(i1 + i2 == 180 || i1 + i3 == 180 || i2 + i3 == 180)
			if(i1 + i2 == 90 || i1 + i3 == 90 || i2 + i3 == 90)
				return true;
		return false;
	}
	
	public void testDom(int n1, int n2, int n3) {
		System.out.println(dominant(n1, n2, n3));
		System.out.println(dominant(n1, n3, n2));

		System.out.println(dominant(n2, n1, n3));
		System.out.println(dominant(n2, n3, n1));
		
		System.out.println(dominant(n3, n2, n1));
		System.out.println(dominant(n3, n1, n2));
	}
	
	public boolean dominant(int i1, int i2, int i3) {
		if(i1 + i2 < i3 || i1 + i3 < i2 || i2 + i3 < i1)
			return true;
		return false;
	}
	
	public boolean hasMidpoint(int i1, int i2, int i3) {
		if(i1 == i2 || i1 == i3 || i2 == i3)
			return false;
		if(i2 - i1 == i3 - i2 || i1 - i2 == i3 - i1 || i3 - i1 == i2 - i3)
			return true;
		return false;
	}
	
	public void testHasMidPoint(int n1, int n2, int n3) {
		System.out.println(hasMidpoint(n1, n2, n3));
		System.out.println(hasMidpoint(n1, n3, n2));

		System.out.println(hasMidpoint(n2, n1, n3));
		System.out.println(hasMidpoint(n2, n3, n1));
		
		System.out.println(hasMidpoint(n3, n2, n1));
		System.out.println(hasMidpoint(n3, n1, n2));
	}
	
	public void testConsec(int n1, int n2, int n3) {
		System.out.println(consecutive(n1, n2, n3));
		System.out.println(consecutive(n1, n3, n2));

		System.out.println(consecutive(n2, n1, n3));
		System.out.println(consecutive(n2, n3, n1));
		
		System.out.println(consecutive(n3, n2, n1));
		System.out.println(consecutive(n3, n1, n2));
	}
	
	//My solution seems ugly, is there a better way to do this?
	public boolean consecutive(int i1, int i2, int i3) {
		if(i1 + 1 == i2) { 
			if(i2 + 1 == i3 || i2 - 2 == i3)  
				return true;
		}
		if(i1 - 1 == i2) {
			if(i2 - 1 == i3 || i2 + 2 == i3)
				return true;
		}
		if(i1 + 1 == i3) {
			if(i3 + 1 == i2 || i3 - 2 == i2)
				return true;
		}
		if(i1 - 1 == i3) {
			if(i3 + 2 == i2 || i3 - 1 == i2)
				return true;
		}
		return false;
	}

	public void printAverage() {
		double sum = 0;
		int adds = 0;
		int number = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Type a number: ");
		number = sc.nextInt();
		while(number > -1) {
			sum += number;
			adds++;
			System.out.print("Type a number: ");
			number = sc.nextInt();
		}
		if(adds > 0)
			System.out.println("Average was " + sum / adds);
	}

	public void threeHeads() {
		int consecutiveHeads = 0;
		while(consecutiveHeads < 3) {
			if(flip() == 1) {
				consecutiveHeads++;
				System.out.print("H ");
			}
			else {
				consecutiveHeads = 0;
				System.out.print("T ");
			}
		}
		System.out.println();
		System.out.println("Three heads in a row!");
	}

	public void hopscotch(int hops) {
		int square = 1;
		if(hops >= 0) {
			System.out.println("  " + square);
			for(int i = 0; i < hops; i++) {
				System.out.print(++square + "   " + ++square);
				System.out.println();
				System.out.println("  " + ++square);
			}
		}
	}

	//Can I deal with this without writing 2 different signatures?
	//Write a method that accepts an integer as its parameter
	//Your method should print nothing if the empty string ("") is passed.
	public void printFactors(int number) {
		int factor = 1;
		System.out.print(factor);
		while(factor < number) {
			factor++;
			if(number % factor == 0)
				System.out.print(" and " + factor);
		}
	}
	
	public void printFactors() {
		//
	}
	
	public void randomWalk() {
		int position = 0;
		int maxPos = 0;
		while(position != 3 && position != -3) {
			position += flip();
			if(position > maxPos)
				maxPos = position;
			System.out.println("position = " + position);
		}
		System.out.println("position = " + position);
		System.out.println("max position = " + maxPos);
	}
	
	public int flip() {
		Random gen = new Random();
		int number = 0;
		number = gen.nextInt(2);
		if(number > 0)
			return 1;
		else return -1;
	}
	
	public void diceSum() {
		System.out.print("Desired dice sum: ");
		Scanner sc = new Scanner(System.in);
		int desiredSum = sc.nextInt();
		int d1 = generate(1, 6);
		int d2 = generate(1, 6);
		int sum = d1 + d2;
		while(sum != desiredSum) {
			System.out.println(d1 + " and " + d2 + " = " + sum);
			d1 = generate(1, 6);
			d2 = generate(1, 6);
			sum = d1 + d2;
		}
		System.out.println(d1 + " and " + d2 + " = " + sum);
	}

	public int generate(int min, int max) {
		Random gen = new Random();
		int number = 0;
		while(number < min)
			number = gen.nextInt(max + 1);
		return number;
	}
}
