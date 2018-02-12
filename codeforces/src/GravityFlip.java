import java.util.Scanner;

public class GravityFlip {

	public static void main(String[] args) {
		flip();
	}

	
	public static void flip() {
		Scanner sc = new Scanner(System.in);
		int col = sc.nextInt();
		sc.nextLine();
		
		int[] box = new int[col];
		for(int i = 0; i < col; i++)
			box[i] = sc.nextInt();
		
		for(int i = 0; i < col - 1; i++) {
			for(int j = col - 1; j > i; j--) {
				int left = box[i];
				int right = box[j];
				int difference = left - right;
				if(difference > 0) {
					box[i] = left - difference;
					box[j] = right + difference;
			}
		}
	}
		
		for(int column : box)
			System.out.print(column + " ");
	}
}
