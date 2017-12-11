package jdiTestSite.enums;

public enum EvenNumb {
	TWO("2"), 
	FOUR("4"), 
	SIX("6"), 
	EIGHT("8");

	final public String number;

	EvenNumb(String number) {
		this.number = number;
	}
	
	public Integer addOdd(OddNumb odd){
		return Integer.valueOf(number) + Integer.valueOf(odd.number);
	}
}
