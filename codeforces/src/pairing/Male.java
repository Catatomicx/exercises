package pairing;

public class Male extends Person{
	
	public Male(String name) {
		super(name);
	}

	public Male(int index) {
		super(index);
	}

	public boolean isQualified() {
		boolean b = isFree() && hasPreferences();
		return b;
	}

	public void engage() {
		mate = getFirstPreference();
		mate.engage(this);
	}
	
}
