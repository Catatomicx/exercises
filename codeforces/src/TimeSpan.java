//Most of this class was provided in the book, found it online to copy+paste
//since copy+pasting from the book formats poorly
//Half the methods are added from exercises

public class TimeSpan {
    private int hours;
    private int minutes;

    // Constructs a time span with the given interval.
    // pre: hours >= 0 && minutes >= 0
    public TimeSpan(int hours, int minutes) {
        this.hours = 0;
        this.minutes = 0;
        add(hours, minutes);
    }
    
    // Adds the given interval to this time span.
    // pre: hours >= 0 && minutes >= 0
    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;
        
        // convert each 60 minutes into one hour
        this.hours += this.minutes / 60;
        this.minutes = this.minutes % 60;
    }
    
    public void subtract(int hours, int minutes) {
        this.hours -= hours;
        this.minutes -= minutes;
        
        // convert each 60 minutes into one hour
        this.hours -= this.minutes / 60;
        this.minutes = this.minutes % 60;
    }
    
    public void add(TimeSpan span) {
        add(span.hours, span.minutes);
    }
    
    public void subtract(TimeSpan span) {
        subtract(span.hours, span.minutes);
    }
    
    public void scale(int factor) {
        this.hours = this.minutes * factor / 60 + factor * this.hours;
        this.minutes = this.minutes * factor % 60;
    }

    // Returns whether o is a TimeSpan representing the same
    // number of hours and minutes as this TimeSpan object.
    public boolean equals(Object o) {
        if (o instanceof TimeSpan) {
            TimeSpan other = (TimeSpan) o;
            return hours == other.hours && 
                   minutes == other.minutes;
        } else {   // not a TimeSpan object
            return false;
        }
    }

    // Returns a String for this time span such as "6h15m".
    public String toString() {
        return hours + "h" + minutes + "m";
    }
}