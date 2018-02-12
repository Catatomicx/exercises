import java.util.Scanner;

public class NextRound {

	public static void main(String[] args) {
		numPasses();
	}

	private static void numPasses() {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		
		int nScore = 0;
		
		int[] scores = new int[k];
		for(int i = 0; i < k; i++) {
			int token = sc.nextInt();
			scores[i] = token;
			if(i == n - 1)
				nScore = token;
		}
		
		int passes = 0;
		for(int score: scores) {
			if(score >= nScore && score > 0)
				passes++;
		}
		
		System.out.println(passes);
	}
}
