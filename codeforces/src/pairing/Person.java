package pairing;

import java.util.List;

public class Person {
	String name;
	int id;
	Person mate = null;
	MatePreferences preferences = new MatePreferences();
	
	public Person(String name) {
		this.name = name;
	}
	
	public String toString() {
		return getClass().getName() + " " + name + " mate: " + (mate == null ? "null" : mate.getName());
	}
	
	private String getName() {
		return name;
	}

	public Person(int index) {
		this.id = index;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void addPreference(Person preference) {
		preferences.addPreference(preference);
	}
	
	public boolean isFree() {
		return mate == null;
	}
	
	public boolean hasPreferences() {
		return !preferences.isEmpty();
	}
	
	public Person getFirstPreference() {
		return preferences.getFirstPreference();
	}
	
	public boolean isEngaged() {
		return !isFree();
	}
	
	public void disengage() {
		mate = null;
	}

	/*
    if (some man P is engaged to W) {
        assign P to be free.
    }
    assign M and W to be engaged to each other.
    for (each successor Q of M who is on W’s list) {
        delete W from Q’s preference list.
        delete Q from W’s preference list.
	  }
*/
	public void engage(Male male) {
		if(mate != null)
			mate.disengage();
		mate = male;
		for(Person q : getSuccessors(male)) {
			q.drop(this);
			drop(q);
		}
	}
	
	public List<Person> getSuccessors(Person p) {
		return preferences.getSuccessors(p);
	}
	
	public void drop(Person preference) {
		preferences.remove(preference);
	}
	
	
	
}
