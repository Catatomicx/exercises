package distance;

import java.util.ArrayList;
import java.util.List;

public class Word {
	String value;
	List<Word> neighbors = new ArrayList<Word>();
	boolean visited = false;
	
	public Word (String word) {
		value = word;		
	}
	
	public String toString() {
		return value;
				
	}

	public char charAt(int i) {
		return value.charAt(i);
	}
	
	public int getLength() {
		return value.length();
	}
	
	public void addNeighbor(Word word) {
		neighbors.add(word);
	}

	public boolean isNeighbor(Word word) {
		if(this.getLength() != word.getLength())
			return false;
		
		int charDifferences = 0;
		for(int i = 0; i < this.getLength(); i++) {
			if(this.charAt(i) != word.charAt(i))
				charDifferences++;
		}
		
		return (charDifferences == 1);
	}
	//cat
	//cot
	//dot
	//dog
	public int distance(Word word2) {
		int shortestDistance = -1;
		int temp = -1;
		if(hasTarget(word2))
			return 1;
		visited = true;
		for(Word neighbor : neighbors) {
			temp = neighbor.moves(word2, 1);
				if(temp < shortestDistance || (shortestDistance == -1 && temp != -1))
					shortestDistance = temp;
		}
		return shortestDistance;
	}
	
	public int moves(Word target, int distance) {
		if(hasTarget(target))
			return distance;
		visited = true;
		for(Word neighbor : neighbors) {
			if(!neighbor.visited)
				return neighbor.moves(target, distance);
		}
		return -1;
	}
	
	public boolean hasTarget(Word target) {
		if(neighbors.contains(target))
			return true;
		return false;
	}
}
