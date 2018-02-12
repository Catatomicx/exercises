package pairing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matchmaker {
	List<Male> males = new ArrayList<Male>();
	List<Female> females = new ArrayList<Female>();
	
	public static void  main(String[] args) {
		new Matchmaker().playMatchmaker();
	}
	
	public void playMatchmaker() {
		getData();
		match();
		printMatches();
	}
	
	public void printMatches() {
		for(Male male : males)
			System.out.println(male);
		
		for(Female female : females)
			System.out.println(female);
	}
	
	private void getData() {
		Scanner keyboard = new Scanner(System.in);
		readMales(keyboard);
		readFemales(keyboard);
		keyboard.close();
	}
	/*
	 *   assign each person to be free.
  while (some man M with a nonempty preference list is free) {
      W = first woman on M’s list.
      if (some man P is engaged to W) {
          assign P to be free.
      }
      assign M and W to be engaged to each other.
      for (each successor Q of M who is on W’s list) {
          delete W from Q’s preference list.
          delete Q from W’s preference list.
} }
	 */
	public void match() {
		Male m;
		while((m = getQualifiedMale()) != null) {
			System.out.println(m + " is qualified");
			m.engage();	
		}
	}
	
	private Male getQualifiedMale() {
		for(Male m : males) {
			if(m.isQualified())
				return m;
		}
		return null;
	}

	public void readMales(Scanner keyboard) {
		String line = null;
		while(!(line = keyboard.nextLine()).isEmpty()) {
			int colonPosition = line.indexOf(":");
			Male m = new Male(extractName(line, colonPosition));
			males.add(m);
			Scanner lineScanner = new Scanner(line.substring(colonPosition + 1, line.length()));
			while(lineScanner.hasNextInt()) {
				int id = lineScanner.nextInt();
				m.addPreference(getFemale(id));
			}
			lineScanner.close();
		}
	}
	
	private Female getFemale(int id) {
		if(id >= females.size()) {
			for(int i = females.size(); i < id; i++)
				females.add(new Female(i));
		}
		return females.get(id - 1);
	}
	
	private Male getMale(int index) {
		Male m = males.get(index);
		if(m == null)
			m = new Male(index);
		return m;
	}

	private String extractName(String line,int colonPosition) {
		return line.substring(0, colonPosition);
	}

	public void readFemales(Scanner keyboard) {
		int counter = 1;
		while(keyboard.hasNextLine()) {
			String line = keyboard.nextLine();
			if(line.isEmpty())
				return;
			int colonPosition = line.indexOf(":");
			Female f = getFemale(counter);
			f.setName(extractName(line, colonPosition));
			Scanner lineScanner = new Scanner(line.substring(colonPosition + 1, line.length()));
			while(lineScanner.hasNextInt()) {
				f.addPreference(getMale(lineScanner.nextInt() - 1));
			}
			lineScanner.close();
			counter++;
		}
	}	
}
