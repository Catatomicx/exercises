import java.util.Scanner;

public class Tram {

	public static void main(String[] args) {
		capacity();
	}

	
	public static void capacity() {
		Scanner sc = new Scanner(System.in);
		int stops = sc.nextInt();
		sc.nextLine();
		int cap = 0;
		int occupancy = 0;
		
		for(int i = 0; i < stops; i++) {
			int exit = sc.nextInt();
			int enter = sc.nextInt();
			occupancy = occupancy - exit + enter;
			if(occupancy > cap)
				cap = occupancy;
			sc.nextLine();
		}
		System.out.println(cap);
	}
}
