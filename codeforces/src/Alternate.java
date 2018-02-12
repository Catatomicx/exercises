import java.util.ArrayList;
//Page 736 in book, 765 in pdf view
//Exercise 2
//Seemed simple, but once I started thinking about how I would solve it, I realized that
//1) I didn't quite have the tools I wanted to solve this in what I think is an elegant manner
//(I'll explain on the phone)
//2)I still get feeling my solution here is not the best, and probably even bad.
public class Alternate {

	public ArrayList<Integer> newList(ArrayList<Integer> first, ArrayList<Integer> second) {
		ArrayList<Integer> newL = new ArrayList<Integer>();
		ArrayList<Integer> smallerList = identifySmallerList(first, second);
		for(int i = 0; i < smallerList.size(); i++) {
			newL.add(first.get(i));
			newL.add(second.get(i));
		}
		ArrayList<Integer> largerList = identifyLargerList(first, second);
		for(int i = smallerList.size(); i < largerList.size(); i++)
			newL.add(largerList.get(i));
		return newL;
	}
	
	public ArrayList<Integer> identifySmallerList(ArrayList<Integer> first, ArrayList<Integer> second) {
		if(first.size() < second.size())
			return first;
		else
			return second;
	}
	
	public ArrayList<Integer> identifyLargerList(ArrayList<Integer> first, ArrayList<Integer> second) {
		if(first.size() > second.size())
			return first;
		else
			return second;
	}
}
