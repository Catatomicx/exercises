package pairing;


import java.util.ArrayList;
import java.util.List;

public class MatePreferences {

	ArrayList<Person> preferences = new ArrayList<Person>();
	
	public void addPreference(Person preference) {
		preferences.add(preference);
	}

	public boolean isEmpty() {
		return preferences.isEmpty();
	}

	public List<Person> getSuccessors(Person p) {
		int index = preferences.indexOf(p);
		ArrayList<Person> copy = new ArrayList<Person>();
		for(int i = index + 1; i < preferences.size(); i++)
			copy.add(preferences.get(i));
		return copy;
	}

	public Person getFirstPreference() {
		return preferences.get(0);
	}

	public void remove(Person preference) {
		preferences.remove(preference);		
	}

}
