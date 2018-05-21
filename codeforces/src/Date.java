
public class Date {

	private int year;
	private int month;
	private int day;
	
	
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void addDays(int days) {
		for(int i = 0; i < days; i++)
			addDay();
	}
	
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void addDay() {
		if(month % 2 == 1 && day < 31)
			day++;
		else if(month % 2 == 0 && month != 2 && day < 30)
			day++;
		else if(month == 2 && !isLeapYear() && day < 28)
			day++;
		else if(month == 2 && isLeapYear() && day < 29)
			day++;
		else
			nextMonth();
	}
	
	public void nextMonth() {
		if(month == 12) {
			month = 1;
			day = 1;
			year++;
		}
		else
			month++;
	}
	
	public void addWeeks(int weeks) {
		addDays(weeks * 7);
	}
	
	public int daysTo(Date other) {
		int day = this.getDay();
		int month = this.getMonth();
		int year = this.getYear();
		
		int daysTo = 0;
		while(other.isLater(this)) {
			this.addDay();
			daysTo++;
		}
		
		this.setDate(year, month, day);
		return daysTo;
	}
	
	public boolean isLater(Date other) {
		if(this.getYear() > other.getYear())
			return true;
		else if(this.getYear() < other.getYear())
			return false;
		else if(this.getMonth() > other.getMonth())
			return true;
		else if(this.getMonth() < other.getMonth())
			return false;
		else if(this.getDay() > other.getDay())
			return true;
		else
			return false;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean isLeapYear() {
		if(year % 100 == 0 && year % 400 != 0)
			return false;
		
		if(year % 4 == 0)
			return true;
		else
			return false;
	}
	
	public String toString() {
		String day;
		String month;
		
		if(this.getDay() < 10)
			day = "0" + this.getDay();
		else
			day = "" + this.getDay();
		
		if(this.getMonth() < 10)
			month = "0" + this.getMonth();
		else
			month = "" + this.getMonth();
			
		return this.getYear() + "/" + month + "/" + day;
	}
}
