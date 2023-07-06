package project;

public abstract class Card {
	private static int counter = 0;
	private int cardNumber;
	private String userName;
	
	public Card(String name) {
		setUserName(name);
		setCardNumber(counter);
		counter++;
	}
	
	
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void print(){
		System.out.println("Username: " + getUserName());
		System.out.println("Card Number: " + getCardNumber());
	}
	
	
}
