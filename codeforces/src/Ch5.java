import java.util.Random;

public class Ch5 {
	
	public static void main(String[] args) {
		randomX();
	}
	
	public static void showTwos(int number) {
		System.out.print(number + " = ");
		if(number == 0 || number == 1)
			System.out.print(number);
		while(number % 2 == 0 && number > 2) { //could use for
			System.out.print(2 + " * ");
			number /= 2;
		}
		if(number > 1)
			System.out.print(number);
		System.out.println();
	}
	
	public static int gcd(int n1, int n2) {
		if(n2 == 0)
			return Math.abs(n1);
		return gcd(n2, n1 % n2);
	}
	
	public static String printBinary(int number) {
		int power = 0;
		while(number > Math.pow(2, power) && number - Math.pow(2, power) > Math.pow(2, power - 1))
			power++;
/*
 * 		instead of the 2nd condition above, we could say: if(number < Math.pow(2, power)
 * 															power--;
 */
		StringBuffer sb = new StringBuffer();
		while(number != 0 || power >= 0) {
			double product = Math.pow(2,  power);
			if(number >= product) {
				sb.append(1);
				number -= product;
			}
			else {
				sb.append(0);
			}
			power--;
		}
		return sb.toString();
	}
	
	public static void randomX() {
		int xs;
		boolean done = false;
		while(!done) {
			xs = generate(5, 20);
			for(int i = 0; i < xs; i++)
				System.out.print("x");
			if(xs > 15)
				done = true;
			System.out.println();
		}
	}
	
	public static void makeGuesses() {
		int guesses = 0;
		int guess = generate(1, 50);
		
	}
	
	public static int generate(int min, int max) {
		Random gen = new Random();
		int number = 0;
		while(number < min)
			number = gen.nextInt(max + 1);
		return number;
	}
	
	public static int smallestOddPrimeFactor(int number) {
		int divisor = 3;
		while(number % divisor != 0 && divisor % 2 != 0) {
			divisor += 2;
		}
		return divisor;
	}
}
