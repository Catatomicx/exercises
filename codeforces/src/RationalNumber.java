
public class RationalNumber {
	
	private int numerator;
	
	private int denominator;
	
	public RationalNumber(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public RationalNumber() {
		this.numerator = 0;
		this.denominator = 1;
	}

	public static void main(String[] args) {
		RationalNumber number = new RationalNumber();
		System.out.println(number.toString());
	}
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	public String toString() {
		return getNumerator() + "/" + getDenominator();
	}

}
