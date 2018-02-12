import java.util.Scanner;

public class TooLong {

	public static void main(String[] args) {
		tooLongWords();
	}

	
	public static void tooLongWords() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] input = new String[n];
		sc.nextLine();
		
		for(int i = 0; i < input.length; i++)
			input[i] = sc.nextLine();

		
		for(String str : input) {
			if(str.length() <= 10)
				System.out.println(str);
			else
				shorten(str);
		}
	}
	
	public static void shorten(String word) {
		int length = word.length();
		
		char first = word.charAt(0);
		int middle = length - 2;
		char last = word.charAt(length - 1);
		System.out.println("" + first + middle + last);
	}
}
