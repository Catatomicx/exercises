package seven;

import java.util.Scanner;

public class HangMan {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String word= "BANANA";
		char[] key={'B','A','N','A','N', 'A'};
		char ch= '-';
		String keyChar;
		int length;
		int pos;
		int st = 0;
		length = word.length();
		int count = 0;
		for(int i = 0; i < key.length; i++)
			key[i]= '-';
		
		while(count != length) {
			System.out.print("Enter your guess: (Turn on Caps)");
			keyChar = input.next();
			ch = keyChar.charAt(0);
			
			while(st < length) {
				boolean res = check(word, ch, st, length);
				if(res == true)
					count++;
				pos = getPosition(word, ch, st, length);
				if(pos == -1)
					break;
				key[pos] = ch;
				st = pos + 1;
			}
			st = 0;
			pos = 0;
			display(key, length);
		}
			System.out.println("You won");
	}

	public static boolean check(String word, char ch, int st, int length) {
		for(int i = st; i < length; i++) {
			if(word.charAt(i) == ch)
				return true;
		}
		return false;
	}
	
	public static int getPosition(String word, char ch, int st, int length) {
		for(int i = st; i < length; i++)
	 		if(word.charAt(i) == ch) {
				return i;
			}
		return -1;
	}
	
	public static void display(char[] key,int length) {
		System.out.print(key);
		System.out.println();
	}
}
