import java.util.Scanner;

public class Exercises {
	
    public static void main(String[] args) {
    		theatreSquare();
    }
    
    public static void theatreSquare() {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a = sc.nextInt();
        
        long vertical = m / a;
        long horizontal = n / a;
        
        
        if(m % a != 0) vertical++;
        if(n % a != 0) horizontal++;
        	
        long flagstones = vertical * horizontal;
        System.out.println(flagstones);
    }
}
