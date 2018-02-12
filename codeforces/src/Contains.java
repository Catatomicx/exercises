
public class Contains {
//problem 14, page 541 in the pdf, 512 in the book
//The problem seemed interesting at first since 1) "contains" is already in the standard library 
//	(i don't know about arrays specifically, but strings at least)
// 2) I hadn't done a problem like this before
// 3) My issue with this problem is more that it ended up being easy, and my solution feels lame.
	public static void main(String[] args) {
		int[] array1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};
		int[] array2 = {1, 2, 1};
		System.out.println(contains(array1, array2));
	}

	public static boolean contains(int[] ar1, int[] ar2) {
		int goal = ar2.length;
		int progress = 0;
		int i = 0;
		for(int element : ar1) {
			if(element == ar2[i]) {
				progress++;
				i++;
				if(progress == goal)
					return true;
			}
			else {
				progress = 0;
				i = 0;
			}
		}
			return false;
	}
}
