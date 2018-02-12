
public class Neet {

	public static void main(String[] args) {
		   int[] first = new int[2];
		   first[0] = 3;
		   first[1] = 7;
		   int[] second = new int[2];
		   second[0] = 3;
		   second[1] = 7;
		   // print the array elements
		   System.out.println(first);
		   System.out.println(second);
		   // see if the elements are the same
		   if (first == second) {
		       System.out.println("They contain the same elements.");
		   } else {
		       System.out.println("The elements are different.");
		   }
	}

}
