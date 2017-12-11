package jdiTestSite.enums;

public enum OddNumb {
	ONE("1"), 
	THREE("3"), 
	FIVE("5"), 
	SEVEN("7");

	final public String number;

	OddNumb(String number) {
		this.number = number;
	}
	
	public Integer addEven(OddNumb even){
		return Integer.valueOf(number) + Integer.valueOf(even.number);
	}
}
